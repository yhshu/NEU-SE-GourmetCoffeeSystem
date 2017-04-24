import java.util.ArrayList;
import java.util.Iterator;

public class Order
{
    //成员变量
    private ArrayList<OrderItem>items;

    //成员方法
	public void addItem(OrderItem orderItem)
    {
        items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem)
    {
        items.remove(orderItem);
    }

    public Iterator<OrderItem> iterator()
    {
        Iterator<OrderItem>it= (Iterator<OrderItem>) this;
        return it;
    }

    public OrderItem getItem(Product product)
    {
        for(OrderItem it:items)
        {
            if(it.getProduct()==product)
                return it;
        }
        return null;
    }

    public int getNumberOfItems()
    {
        int sum=0;
        for(OrderItem it:items)
        {
            if(it!=null)
                sum++;
        }
        return sum;
    }

    public double getTotalCost()
    {
        for(OrderItem it:items)
        {
            
        }
    }

    //构造方法
    public Order()
    {
        for(OrderItem it:items)
        {
            it=null;
        }
    }
}
