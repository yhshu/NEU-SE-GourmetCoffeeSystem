import java.util.ArrayList;

public class Product {
    private String code;
    private String description;
    private double price;

    public Product(String var1, String var2, double var3) {
        this.code = var1;
        this.description = var2;
        this.price = var3;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean equals(Object var1) {
        return var1 instanceof Product && this.getCode().equals(((Product)var1).getCode());
    }

    public String toString() {
        return this.getCode() + "_" + this.getDescription() + "_" + this.getPrice();
    }

    public ArrayList<DataField> getDataFields() {
        ArrayList var1 = new ArrayList();
        var1.add(new DataField("Code", this.getCode()));
        var1.add(new DataField("Description", this.getDescription()));
        var1.add(new DataField("Price", Double.toString(this.getPrice())));
        return var1;
    }
}
