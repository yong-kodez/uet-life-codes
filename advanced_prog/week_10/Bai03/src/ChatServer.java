import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatServer {
    private static final int PORT = 8080;
    private static final AtomicInteger clientCounter = new AtomicInteger(0);
    // Danh sách lưu tin nhắn dùng chung, đảm bảo Thread-safe
    private static final List<String> messageList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // 1. Endpoint tham gia phòng chat
        server.createContext("/join", new JoinHandler());

        // 2. Endpoint gửi tin nhắn
        server.createContext("/submit", new SubmitHandler());

        // 3. Endpoint lấy danh sách tin nhắn
        server.createContext("/messages", new MessagesHandler());

        // Dùng ThreadPool để xử lý nhiều yêu cầu đồng thời
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("REST API Chat Server dang chay tai port " + PORT + "...");
    }

    // Xử lý POST /join
    static class JoinHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                int newId = clientCounter.incrementAndGet();
                String response = "{\"clientId\": " + newId + "}";
                sendResponse(exchange, 200, response);
            } else {
                sendResponse(exchange, 405, "Method Not Allowed");
            }
        }
    }

    // Xử lý POST /submit
    static class SubmitHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder body = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    body.append(line);
                }

                // Lưu tin nhắn vào kho chung
                String message = body.toString();
                messageList.add(message);
                System.out.println("Log Server: " + message);

                sendResponse(exchange, 200, "{\"status\": \"OK\"}");
            } else {
                sendResponse(exchange, 405, "Method Not Allowed");
            }
        }
    }

    // Xử lý GET /messages
    static class MessagesHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                StringBuilder sb = new StringBuilder();
                synchronized (messageList) {
                    for (String msg : messageList) {
                        sb.append(msg).append("\n");
                    }
                }
                sendResponse(exchange, 200, sb.toString());
            } else {
                sendResponse(exchange, 405, "Method Not Allowed");
            }
        }
    }

    private static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
        exchange.sendResponseHeaders(statusCode, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}
