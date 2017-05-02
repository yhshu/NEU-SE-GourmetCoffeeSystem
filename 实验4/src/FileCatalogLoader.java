import oracle.jrockit.jfr.ProducerDescriptor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader
{
    //成员方法
    private Product readProduct(String line) throws DataFormatException
    {
        StringTokenizer tokenizer=new StringTokenizer(line,"_");//字符标记器
        if (tokenizer.countTokens() != 4)
        {
            throw new DataFormatException(line);
        }
        else
        {
            try
            {
                String prefix = tokenizer.nextToken();//前缀
                return new Product(tokenizer.nextToken(), tokenizer.nextToken(), Double.parseDouble(tokenizer.nextToken()));
            }
            catch (NumberFormatException nfe)//数字格式异常
            {
                throw new DataFormatException(line);
            }
        }
    }

    private Coffee readCoffee(String line) throws DataFormatException
    {
        StringTokenizer tokenizer=new StringTokenizer(line,"_");//字符标记器
        if (tokenizer.countTokens() != 10)
        {
            throw new DataFormatException(line);
        }
        else
        {
            try
            {
                String prefix = tokenizer.nextToken();//前缀
                return new Coffee
                (
                        tokenizer.nextToken(),
                        tokenizer.nextToken(),
                        Double.parseDouble(tokenizer.nextToken()),
                        tokenizer.nextToken(),
                        tokenizer.nextToken(),
                        tokenizer.nextToken(),
                        tokenizer.nextToken(),
                        tokenizer.nextToken(),
                        tokenizer.nextToken()
                );
            }
            catch (NumberFormatException nfe)
            {
                throw new DataFormatException(line);
            }
        }
    }

    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException
    {
        StringTokenizer tokenizer=new StringTokenizer(line,"_");//字符标记器
        if (tokenizer.countTokens() != 7)
        {
            throw new DataFormatException(line);
        }
        else
        {
            try
            {
                String prefix = tokenizer.nextToken();//前缀
                return new CoffeeBrewer
                (
                        tokenizer.nextToken(),
                        tokenizer.nextToken(),
                        Double.parseDouble(tokenizer.nextToken()),
                        tokenizer.nextToken(),
                        tokenizer.nextToken(),
                        Integer.parseInt(tokenizer.nextToken())
                );
            }
            catch (NumberFormatException nfe)
            {
                throw new DataFormatException(line);
            }
        }
    }


    public Catalog loadCatalog(String filename) throws FileNotFoundException, IOException, DataFormatException
    {
        Catalog catalog = new Catalog();//函数要返回的Catalog对象
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while (line != null)//读取多行
        {
            Product product = null;
            if (line.startsWith("Product"))
            {
                product = readProduct(line);
            }
            else if (line.startsWith("Coffee"))
            {
                product = readCoffee(line);
            }
            else if (line.startsWith("Brewer"))
            {
                product = readCoffeeBrewer(line);
            }
            else
            {
                throw new DataFormatException(line);//数据格式异常
            }
            catalog.addProduct(product);
            line = reader.readLine();
        }
        return catalog;
    }
}
