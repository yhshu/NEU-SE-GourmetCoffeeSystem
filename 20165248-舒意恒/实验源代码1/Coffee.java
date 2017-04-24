public class Coffee extends Product
{
    //成员变量
    private String origin;
    private String roast;
    private String favor;
    private String aroma;
    private String acidity;
    private String body;

    //成员方法
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