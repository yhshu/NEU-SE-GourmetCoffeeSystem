public class Product
{
    //成员变量
    protected String code;
    protected String description;
    protected double price;

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
        return code;
    }

    public boolean equals(Object object)
    {
        if(object==null)
            return false;
        if(this.getClass()==object.getClass())
        {
            Product compare=(Product)object;
            if(this.getCode().equals(compare.getCode()))
                return true;
            else
                return false;
        }
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

    public Product() {}
}