public class Product
{
    //成员变量
    private String code;
    private String description;
    private double price;

    //成员方法
    public String getDescription()
    {
        return description;
    }

    public double getPrice()
    {
        return price;
    }

    public String getCode()
    {
        return getCode();
    }

    public boolean equals(object Object)
    {
        Product compare=(Procuct)Object;
        if(this.code == compare.code && this.description == compare.description && this.price == compare.price)
            return true;
        else
            return false;
    }

    public String toString()
    {
        return code+"_"+description+"_"+price;
    }

    //构造方法
    public Product(String initialCode, String initialDescription, double initialPrice)
    {
        code=initialCode;
        description=initialDescription;
        price=initialPrice;
    }
}