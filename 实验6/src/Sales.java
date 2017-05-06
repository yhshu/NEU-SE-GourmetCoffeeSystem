import java.util.ArrayList;
import java.util.Iterator;

public class Sales implements Iterable<Order> {
    private ArrayList<Order> orders = new ArrayList();

    public Sales() {
    }

    public void addOrder(Order var1) {
        this.orders.add(var1);
    }

    public Iterator<Order> iterator() {
        return this.orders.iterator();
    }

    public int getNumberOfOrders() {
        return this.orders.size();
    }
}
