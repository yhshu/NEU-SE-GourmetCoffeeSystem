public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product var1, int var2) {
        this.product = var1;
        this.quantity = var2;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int var1) {
        this.quantity = var1;
    }

    public double getValue() {
        return this.getProduct().getPrice() * (double)this.getQuantity();
    }

    public String toString() {
        return this.getQuantity() + " " + this.getProduct().getCode() + " " + this.getProduct().getPrice();
    }
}
