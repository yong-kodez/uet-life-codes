import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ClientChat {
    private static final String BASE_URL = "http://localhost:2808";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static String id = "";
    private static int currentCount = 0;

    public static void main(String[] args) throws Exception {
        HttpRequest joinRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/join"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> joinResponse = client.send(joinRequest, HttpResponse.BodyHandlers.ofString());
        id = joinResponse.body().replaceAll("[^0-9]", "");
        System.out.println("Success joined! Your id is: " + id);
        System.out.println("Exit by '/exit'");

        Thread pollingThread = new Thread(() -> {
            while (true) {
                try {
                    fetchNewMessages();
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    break;
                } catch (Exception e) {}
           } 
        });
        pollingThread.setDaemon(true);
        pollingThread.start();
        
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String text = sc.nextLine();
            if ("/exit".equalsIgnoreCase(text.trim())) break;
            if (!text.trim().isEmpty()) {
                sendMessage("[Client #" + id + "]: " + text);
            }
        }
    }

    private static void sendMessage(String message) throws Exception {
        HttpRequest submitRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/submit"))
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .build();
        client.send(submitRequest, HttpResponse.BodyHandlers.ofString());
    }

    private static void fetchNewMessages() throws Exception {
        HttpRequest listRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/messages"))
                .GET()
                .build();

        String body = "";
        HttpResponse<String> response = client.send(listRequest, HttpResponse.BodyHandlers.ofString());
        body = response.body();

        if (body != null && !body.isBlank()) {
            String[] lines = body.split("\n");
            if (lines.length > currentCount) {
                for (int i = currentCount; i < lines.length; i++) {
                    System.out.println(lines[i]);
                }
                currentCount = lines.length;
            }
        }
    }
}
