public class HTMLSalesFormatter implements SalesFormatter//单实例模式
{
    //唯一的成员变量
    private static HTMLSalesFormatter singletonInstance=new HTMLSalesFormatter();

    //成员方法
    public static HTMLSalesFormatter getSingletonInstance()
    {
        return singletonInstance;
    }

    public String formatSales(Sales sales)
    {
        String ret="";
        ret+="<html>\n" + "\t<body>\n" + "\t\t<center><h2>Orders</h2></center>\n";
        for(Order order_it:sales)
        {
            ret+="\t\t<hr>\n\t\t<h4>Total = "+String.valueOf(order_it.getTotalCost())+"</h4>\n";
            for(OrderItem orderItem_it:order_it)
            {
                ret+="\t\t<p>\n";
                ret+="\t\t\t<b>code:</b> "+orderItem_it.getProduct().getCode()+"<br>\n";
                ret+="\t\t\t<b>quantity:</b> "+orderItem_it.getQuantity()+"<br>\n";
                ret+="\t\t\t<b>price:</b> "+orderItem_it.getProduct().getPrice()+"<br>\n";
                ret+="\t\t</p>\n";
            }
        }
        ret+="\t</body>\n</html>";
        return ret;
    }

    //私有的构造方法
    private HTMLSalesFormatter(){}
}
