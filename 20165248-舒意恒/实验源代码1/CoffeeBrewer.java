public class CoffeeBrewer extends Product
{
    //成员变量
    private String model;
    private String waterSupply;
    private int numberOfCups;

    //成员方法

    public String getModel()
    {
        return model;
    }

    public String getWaterSupply()
    {
        return waterSupply;
    }

    public int getNumberOfCups()
    {
        return numberOfCups;
    }

    public String toSring()
    {
        return code+"_"+description+"_"+price+"_"+model+"_"+waterSupply+"_"+numberOfCups;
    }

    //构造方法
	public CoffeeBrewer(String initialCode, String initialDescription, double initialPrice, String initialModel, String initialWaterSupply, int initialNumberOfCups)
    {
        code=initialCode;
        description=initialDescription;
        price=initialPrice;
        model=initialModel;
        waterSupply=initialWaterSupply;
        numberOfCups=initialNumberOfCups;
    }

}