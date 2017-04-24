import java.util.ArrayList;
import java.util.Iterator;

public class Catalog implements Iterable<Product>
{
    //成员变量
    private ArrayList<Product>products;

    //成员方法
    public void addProduct(Product product)
    {
        products.add(product);
    }

    public Iterator<Product> iterator()
    {
        Iterator<Product>it= (Iterator<Product>) this;
        return it;
    }

    public Product getProduct(String code)
    {
        for(:products)
        {
            Product compare=(Product) Product_it;
            if(compare.getCode() == code)
                return compare;
        }
        return null;
    }

    public int getNumberOfProducts()
    {
        int sum=0;
        for(Product_it:products)
        {
            if(Product_it!=null)
                sum++;
        }
        return sum;
    }

    //构造方法
    public Catalog()
    {
        for(Product it:products)
            it=null;
    }

}