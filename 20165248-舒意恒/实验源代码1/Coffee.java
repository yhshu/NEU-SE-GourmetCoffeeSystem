public class Coffee extends Product
{
    //成员变量
    private String origin;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;

    //成员方法
    public String getOrigin()
    {
        return origin;
    }

    public String getRoast()
    {
        return roast;
    }

    public String getFlavor()
    {
        return flavor;
    }

    public String getAroma()
    {
        return aroma;
    }

    public String getAcidity()
    {
        return acidity;
    }

    public String getBody()
    {
        return body;
    }

    String toString()
    {
        return code+"_"+description+"_"+price+"_"+origin+"_"+roast+"_"+flavor+"_"+aroma+"_"+acidity+"_"+body;
    }
    //构造方法
    public Coffee(String initialCode, String initialDescription, double initialPrice, String initialOrigin, String initialRoast, String initialFlavor,String initialAroma, String initialAcidity, String initialBody)
    {
        code=initialCode;
        description=initialDescription;
        price=initialPrice;
        origin=initialOrigin;
        roast=initialRoast;
        flavor=initialFlavor;
        aroma=initialAroma;
        acidity=initialAcidity;
        body=initialBody;
    }

}