import java.util.Stack;

public class MessageHistory {
    private Stack<Message> history;

    public MessageHistory() {
        this.history = new Stack<>();
    }

    public void addMessage(Message m) {
        this.history.push(m);
    }

    public void undo() {
        if (!this.history.isEmpty()) this.history.pop();
        else System.out.println("[!] Warning: No more content to undo");
    }

    public String viewLast() {
        return this.history.peek().getContent();
    }
}
