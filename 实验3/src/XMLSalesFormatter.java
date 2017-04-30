public class XMLSalesFormatter implements SalesFormatter//单实例模式
{
    //唯一的成员变量
    private static XMLSalesFormatter singletonInstance=new XMLSalesFormatter();

    //成员方法
    public static XMLSalesFormatter getSingletonInstance()
    {
        return singletonInstance;
    }

    public String formatSales(Sales sales)
    {
        String ret="";
        ret+="<Sales>\n";
        for(Order order_it:sales)
        {
            ret+="\t<Order total=\""+String.valueOf(order_it.getTotalCost())+"\">\n";
            for(OrderItem orderItem_it:order_it)
            {
                ret+="\t\t<OrderItem quantity=\""+String.valueOf(orderItem_it.getQuantity())+"\" price:\""+String.valueOf(orderItem_it.getProduct().getPrice())+"\">"+String.valueOf(orderItem_it.getProduct().getCode())+"</OrderItem>\n";
            }
        }
        ret+="</Sales>";
        return ret;
    }

    //私有的构造方法
    private XMLSalesFormatter(){}
}
