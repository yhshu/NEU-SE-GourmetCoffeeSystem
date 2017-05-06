import java.util.ArrayList;
import java.util.Iterator;

public class Order implements Iterable<OrderItem> {
    private ArrayList<OrderItem> items = new ArrayList();

    public Order() {
    }

    public void addItem(OrderItem var1) {
        this.items.add(var1);
    }

    public void removeItem(OrderItem var1) {
        this.items.remove(var1);
    }

    public Iterator<OrderItem> iterator() {
        return this.items.iterator();
    }

    public OrderItem getItem(Product var1) {
        Iterator var2 = this.items.iterator();

        OrderItem var3;
        do {
            if(!var2.hasNext()) {
                return null;
            }

            var3 = (OrderItem)var2.next();
        } while(!var3.getProduct().equals(var1));

        return var3;
    }

    public int getNumberOfItems() {
        return this.items.size();
    }

    public double getTotalCost() {
        double var1 = 0.0D;

        OrderItem var4;
        for(Iterator var3 = this.items.iterator(); var3.hasNext(); var1 += var4.getValue()) {
            var4 = (OrderItem)var3.next();
        }

        return var1;
    }

    public OrderItem[] getItems() {
        return (OrderItem[])this.items.toArray(new OrderItem[0]);
    }
}
