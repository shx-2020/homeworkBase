public class Goods
{
    Goods(String name,String unit,int number)
    {
        this.unit=unit;
        this.number=number;
        this.name=name;
    }
    private String name,unit;
    private int number;

    public int getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }

    public String getUnit()
    {
        return unit;
    }
    public String get()
    {
        return number+unit+name;
    }
}
