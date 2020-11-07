public class Main
{
    public static void main(String[] args)
    {
        Goods computer = new Goods("电脑","台",1);
        Customer you = new Customer("你");
        Seller JD = new Seller("京东");
        you.operateOrder(JD,computer);
        System.out.println(you.getName()+"收到了电脑，开始学习JVAV（误）。");
        return;
    }
}
