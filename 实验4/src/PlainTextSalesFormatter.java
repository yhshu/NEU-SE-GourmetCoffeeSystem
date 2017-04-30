public class PlainTextSalesFormatter implements SalesFormatter//单实例模式
{
    //唯一的成员变量
    private static PlainTextSalesFormatter singletonInstance=new PlainTextSalesFormatter();

    //成员方法
    public static PlainTextSalesFormatter getSingletonInstance()
    {
        return singletonInstance;
    }


    public String formatSales(Sales sales)
    {
        Integer orderNum=0;
        String ret="";

        for(Order order_it:sales)
        {
            ret+="------------------------\n";
            ret=ret+"Order "+ (++orderNum).toString()+"\n\n";
            for(OrderItem orderItem_it:order_it)
            {
                ret+= orderItem_it.getQuantity()+" "+orderItem_it.getProduct().getCode()+" "+orderItem_it.getProduct().getPrice()+"\n";
            }
            ret+="\nTotal = ";
            ret+=String.valueOf(order_it.getTotalCost())+"\n";
        }
        return ret;
    }

    //私有的构造方法
    private PlainTextSalesFormatter() {}
}
