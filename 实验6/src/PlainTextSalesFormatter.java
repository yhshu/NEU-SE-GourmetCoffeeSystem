import java.util.Iterator;

public class PlainTextSalesFormatter implements SalesFormatter {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static PlainTextSalesFormatter singletonInstance = null;

    public static PlainTextSalesFormatter getSingletonInstance() {
        if(singletonInstance == null) {
            singletonInstance = new PlainTextSalesFormatter();
        }

        return singletonInstance;
    }

    private PlainTextSalesFormatter() {
    }

    public String formatSales(Sales var1) {
        String var2 = "";
        int var3 = 0;

        Order var5;
        for(Iterator var4 = var1.iterator(); var4.hasNext(); var2 = var2 + NEW_LINE + "Total = " + var5.getTotalCost() + NEW_LINE) {
            var5 = (Order)var4.next();
            StringBuilder var10000 = (new StringBuilder()).append(var2).append("------------------------").append(NEW_LINE).append("Order ");
            ++var3;
            var2 = var10000.append(var3).append(NEW_LINE).append(NEW_LINE).toString();

            OrderItem var7;
            for(Iterator var6 = var5.iterator(); var6.hasNext(); var2 = var2 + var7.getQuantity() + " " + var7.getProduct().getCode() + " " + var7.getProduct().getPrice() + NEW_LINE) {
                var7 = (OrderItem)var6.next();
            }
        }

        return var2;
    }
}
