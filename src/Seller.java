public class Seller extends Dealer implements Deal,GoodsStream
{
    Seller(String n)
    {
        name = n;
    }
    private Goods receivedGoods;
    @Override
    public void operateOrder(Dealer customer,Goods goods)
    {
        if(customer instanceof Customer == false)
        {
            System.out.println("错误：customer参数类型不是Customer。");
            System.exit(1);
        }
        System.out.println(name+"收到了来自"+((Customer)customer).getName()+"的订单："+goods.get());
        try
        {
            System.out.println("订单处理");
            Thread.sleep(1000);
            System.out.println("订单处理完毕。");
        }
        catch (InterruptedException e)
        {
            System.out.println("订单处理中断，退出。");
            System.exit(1);
        }
        operateGoods(customer,goods);
        messageTransmit(customer,("您的订单："+goods.get()+"已到达，请确认签收。"),goods);
        return;
    }

    @Override
    public void operateGoods(Dealer customer,Goods goods)
    {
        if(customer instanceof Customer == false)
        {
            System.out.println("错误：customer参数类型不是Customer。");
            System.exit(1);
        }
        ((Customer) customer).operateGoods(this,goods);
        System.out.println("货物已发送完毕。");
        return;
    }

    @Override
    public void messageTransmit(Dealer customer,String msg,Goods goods)
    {
        if(customer instanceof Customer == false)
        {
            System.out.println("错误：customer参数类型不是Customer。");
            System.exit(1);

        }
        ((Customer)customer).messageTransmit(this,"订单已到达。",goods);
        locateGoods((Customer)customer,goods);
    }

    @Override
    public void locateGoods(Dealer customer,Goods goods)
    {
        if(customer instanceof Customer == false)
        {
            System.out.println("错误：customer参数类型不是Customer。");
            System.exit(1);

        }

        ((Customer)customer).locateGoods(this,goods);
    }
}

