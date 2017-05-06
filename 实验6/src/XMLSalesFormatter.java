import java.util.Iterator;

public class XMLSalesFormatter implements SalesFormatter {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static XMLSalesFormatter singletonInstance = null;

    public static XMLSalesFormatter getSingletonInstance() {
        if(singletonInstance == null) {
            singletonInstance = new XMLSalesFormatter();
        }

        return singletonInstance;
    }

    private XMLSalesFormatter() {
    }

    public String formatSales(Sales var1) {
        String var2 = "<Sales>" + NEW_LINE;

        for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 = var2 + "  </Order>" + NEW_LINE) {
            Order var4 = (Order)var3.next();
            var2 = var2 + "  <Order total=\"" + var4.getTotalCost() + "\">" + NEW_LINE;

            OrderItem var6;
            for(Iterator var5 = var4.iterator(); var5.hasNext(); var2 = var2 + "    <OrderItem quantity=\"" + var6.getQuantity() + "\" price=\"" + var6.getProduct().getPrice() + "\">" + var6.getProduct().getCode() + "</OrderItem>" + NEW_LINE) {
                var6 = (OrderItem)var5.next();
            }
        }

        var2 = var2 + "</Sales>";
        return var2;
    }
}
