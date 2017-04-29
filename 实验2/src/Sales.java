import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Iterator;

public class Sales implements Iterable<Order>
{
    //成员变量
    private ArrayList<Order>orders;

    //成员方法
    public void addOrder(Order order)
    {
        orders.add(order);
    }

    public Iterator<Order> iterator()
    {
        return this.orders.iterator();
    }

    public int getNumberOfOrders()
    {
        int num=0;
        for(Order it:orders)
        {
            if(it!=null)
                num++;
        }
        return num;
    }

    //构造方法
    public Sales()
    {
        orders=new ArrayList<Order>();
    }
}
