public class OrderItem
{
    //成员变量
    private int quantity;//数量
    private Product product;

    //成员方法
    public int getQuantity()
    {
        return quantity;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setQuantity(int newquantity)
    {
        this.quantity = newquantity;
    }

    public double getValue()
    {
        return quantity*(product.price);
    }
    public String toString()
    {
        return quantity+" "+product.code+" "+product.price;
    }

    //构造方法
    public OrderItem(Product initialProduct,int initialQuantity)
    {
        product=initialProduct;
        quantity=initialQuantity;
    }
}