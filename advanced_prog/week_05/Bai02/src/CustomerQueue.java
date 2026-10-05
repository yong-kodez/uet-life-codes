import java.util.LinkedList;

public class CustomerQueue {
    private LinkedList<Customer> queue;

    public CustomerQueue() {
        this.queue = new LinkedList<>();
    }

    public LinkedList<Customer> getQueue() { return this.queue; }

    public void addCustomer(Customer c) {
        this.queue.add(c);
    }

    public Customer getCustomer() {
        return this.queue.poll();
    }

    public boolean hasNext() { return !this.queue.isEmpty(); }
}
