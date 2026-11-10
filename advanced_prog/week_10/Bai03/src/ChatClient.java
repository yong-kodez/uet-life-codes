import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ChatClient {
    private static final String BASE_URL = "http://localhost:8080";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static String clientId = "";
    private static int lastMessageCount = 0;

    public static void main(String[] args) throws Exception {
        // Bước 1: Gửi yêu cầu đăng ký /join để nhận clientId
        HttpRequest joinReq = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/join"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> joinRes = client.send(joinReq, HttpResponse.BodyHandlers.ofString());
        // Trích xuất số ID từ chuỗi: {"clientId": 1}
        clientId = joinRes.body().replaceAll("[^0-9]", "");
        System.out.println("Tham gia thanh cong! ID cua ban la: " + clientId);

        // Bước 2: Tạo luồng chạy ngầm để Polling tin nhắn định kỳ
        Thread pollingThread = new Thread(() -> {
            while (true) {
                try {
                    fetchNewMessages();
                    Thread.sleep(1000); // Polling moi 1 giay
                } catch (InterruptedException e) {
                    break;
                } catch (Exception ignored) {}
            }
        });
        pollingThread.setDaemon(true); // Tự tắt khi ứng dụng tắt
        pollingThread.start();

        // Bước 3: Luồng chính nhận input của người dùng và gửi tin nhắn
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tin nhan va nhan Enter de gui (go 'exit' de thoat):");
        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            if ("exit".equalsIgnoreCase(text.trim())) {
                break;
            }
            if (!text.trim().isEmpty()) {
                sendMessage("[Client " + clientId + "]: " + text);
            }
        }
    }

    // Gửi tin nhắn qua POST /submit
    private static void sendMessage(String fullMessage) {
        try {
            HttpRequest submitReq = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/submit"))
                    .POST(HttpRequest.BodyPublishers.ofString(fullMessage))
                    .build();
            client.send(submitReq, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.err.println("Loi gui tin nhan: " + e.getMessage());
        }
    }

    // Lấy tin nhắn qua GET /messages và chỉ in những tin nhắn mới
    private static void fetchNewMessages() throws Exception {
        HttpRequest listReq = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/messages"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(listReq, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        if (body != null && !body.isBlank()) {
            String[] lines = body.split("\n");
            if (lines.length > lastMessageCount) {
                for (int i = lastMessageCount; i < lines.length; i++) {
                    System.out.println(lines[i]);
                }
                lastMessageCount = lines.length;
            }
        }
    }
}
