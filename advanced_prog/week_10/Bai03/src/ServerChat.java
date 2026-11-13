import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class ServerChat {
    private static HttpServer server;
    private static final int PORT = 2808;
    private static final LoggerUtil logger = new LoggerUtil();
    private static final AtomicInteger clientCount = new AtomicInteger(0);
    private static final CopyOnWriteArrayList<String> chatHistory = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        try {
            server = HttpServer.create(new InetSocketAddress(PORT), 0);
        } catch (Exception e) { e.printStackTrace(); }
        server.createContext("/join", new JoinHandler());
        server.createContext("/submit", new SubmitHandler());
        server.createContext("/messages", new MessagesHandler());

        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Server running at " + PORT + "...");
    }

    private static void sendResponse(HttpExchange exchange, int rCode, String response) throws IOException {
        byte[] bytes = response.getBytes();
        exchange.sendResponseHeaders(rCode, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
    private static boolean invalidMethod(String method, HttpExchange exchange) throws IOException {
        if (!method.equalsIgnoreCase(exchange.getRequestMethod())) {
            sendResponse(exchange, 405, "Method not allowed");
            logger.log("WARN", "Method not allowed");
            return true;
        }
        return false;
    }

    static class JoinHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (invalidMethod("POST", exchange)) return;

            int newId = clientCount.incrementAndGet();
            String response = "{\"clientId\": " + newId + "}";
            sendResponse(exchange, 200, response);
            logger.log("POST", "New client connected");
        }
    }

    static class SubmitHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (invalidMethod("POST", exchange)) return;

            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody());
            BufferedReader br = new BufferedReader(isr);
            StringBuilder body = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                body.append(line);
            }
            String message = body.toString();
            chatHistory.add(message);
            sendResponse(exchange, 200, "{\"status\": \"OK\"}");
            logger.log("POST", "New message: " + message);
        }
    }

    static class MessagesHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (invalidMethod("GET", exchange)) return;
            String allMessages = String.join("\n", chatHistory);
            sendResponse(exchange, 200, allMessages);
        }
    }
}
