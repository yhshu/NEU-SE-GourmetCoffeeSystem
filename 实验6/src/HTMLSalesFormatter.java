import java.util.Iterator;

public class HTMLSalesFormatter implements SalesFormatter {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static HTMLSalesFormatter singletonInstance = null;

    public static HTMLSalesFormatter getSingletonInstance() {
        if(singletonInstance == null) {
            singletonInstance = new HTMLSalesFormatter();
        }

        return singletonInstance;
    }

    private HTMLSalesFormatter() {
    }

    public String formatSales(Sales var1) {
        String var2 = "<html>" + NEW_LINE + "  <body>" + NEW_LINE + "    <center><h2>Orders</h2></center>" + NEW_LINE;
        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            Order var4 = (Order)var3.next();
            var2 = var2 + "    <hr>" + NEW_LINE + "    <h4>Total = " + var4.getTotalCost() + "</h4>" + NEW_LINE;

            OrderItem var6;
            for(Iterator var5 = var4.iterator(); var5.hasNext(); var2 = var2 + "      <p>" + NEW_LINE + "        <b>code:</b> " + var6.getProduct().getCode() + "<br>" + NEW_LINE + "        <b>quantity:</b> " + var6.getQuantity() + "<br>" + NEW_LINE + "        <b>price:</b> " + var6.getProduct().getPrice() + NEW_LINE + "      </p>" + NEW_LINE) {
                var6 = (OrderItem)var5.next();
            }
        }

        var2 = var2 + "  </body>" + NEW_LINE + "</html>";
        return var2;
    }
}
