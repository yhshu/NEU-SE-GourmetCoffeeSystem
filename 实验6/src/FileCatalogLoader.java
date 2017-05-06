import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader {
    private static final String COFFEE_PREFIX = "Coffee";
    private static final String COFFEE_BREWER_PREFIX = "Brewer";
    private static final String PRODUCT_PREFIX = "Product";
    private static final String DELIM = "_";

    public FileCatalogLoader() {
    }

    public Catalog loadCatalog(String var1) throws FileNotFoundException, IOException, DataFormatException {
        Catalog var2 = new Catalog();
        BufferedReader var3 = new BufferedReader(new FileReader(var1));

        for(String var4 = var3.readLine(); var4 != null; var4 = var3.readLine()) {
            Object var5 = null;
            if(var4.startsWith("Brewer")) {
                var5 = this.readCoffeeBrewer(var4);
            } else if(var4.startsWith("Coffee")) {
                var5 = this.readCoffee(var4);
            } else {
                if(!var4.startsWith("Product")) {
                    throw new DataFormatException(var4);
                }

                var5 = this.readProduct(var4);
            }

            var2.addProduct((Product)var5);
        }

        var3.close();
        return var2;
    }

    private Product readProduct(String var1) throws DataFormatException {
        StringTokenizer var2 = new StringTokenizer(var1, "_");
        if(var2.countTokens() != 4) {
            throw new DataFormatException(var1);
        } else {
            try {
                String var3 = var2.nextToken();
                return new Product(var2.nextToken(), var2.nextToken(), Double.parseDouble(var2.nextToken()));
            } catch (NumberFormatException var4) {
                throw new DataFormatException(var1);
            }
        }
    }

    private Coffee readCoffee(String var1) throws DataFormatException {
        StringTokenizer var2 = new StringTokenizer(var1, "_");
        if(var2.countTokens() != 10) {
            throw new DataFormatException(var1);
        } else {
            try {
                String var3 = var2.nextToken();
                return new Coffee(var2.nextToken(), var2.nextToken(), Double.parseDouble(var2.nextToken()), var2.nextToken(), var2.nextToken(), var2.nextToken(), var2.nextToken(), var2.nextToken(), var2.nextToken());
            } catch (NumberFormatException var4) {
                throw new DataFormatException(var1);
            }
        }
    }

    private CoffeeBrewer readCoffeeBrewer(String var1) throws DataFormatException {
        StringTokenizer var2 = new StringTokenizer(var1, "_");
        if(var2.countTokens() != 7) {
            throw new DataFormatException(var1);
        } else {
            try {
                String var3 = var2.nextToken();
                return new CoffeeBrewer(var2.nextToken(), var2.nextToken(), Double.parseDouble(var2.nextToken()), var2.nextToken(), var2.nextToken(), Integer.parseInt(var2.nextToken()));
            } catch (NumberFormatException var4) {
                throw new DataFormatException(var1);
            }
        }
    }
}
