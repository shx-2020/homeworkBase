public class Customer extends Dealer implements Deal,GoodsStream
{
    private Goods goodsReceived;
    private String msgReceived;

    Customer(String n)
    {
        name = n;
    }

    @Override
    public void operateOrder(Dealer seller,Goods goods)
    {
        if(seller instanceof Seller ==false)
        {
            System.out.println("错误：seller参数类型不是Seller。1");
            System.exit(1);
        }
        System.out.println(name+"向"+seller.getName()+"订购了"+goods.get());
        try
        {
            System.out.println("订单发送中");
            Thread.sleep(1000);
            ((Seller) seller).operateOrder(this,goods);
        }
        catch (InterruptedException e)
        {
            System.out.println("订单发送中断，退出。");
            System.exit(1);
        }
        return;
    }

    @Override
    public void operateGoods(Dealer seller,Goods goods)
    {
        if(seller instanceof Seller ==false)
        {
            System.out.println("错误：seller参数类型不是Seller。2");
            System.exit(1);
        }
        System.out.println(name+"附件的物流中心收到了"+goods.get());
        return;
    }

    @Override
    public void messageTransmit(Dealer seller,String msg,Goods goods)
    {
        if(seller instanceof Seller ==false)
        {
            System.out.println("错误：seller参数类型不是Seller。3");
            System.exit(1);
        }
        msgReceived = msg;
        System.out.println(name+"收到了信息");
        readMsg();
        return;
    }

    public void readMsg()
    {
        System.out.println("收到信息如下：");
        System.out.println(msgReceived);
        System.out.println("并附带货物位置（已省略）");
    }

    @Override
    public void locateGoods(Dealer seller, Goods goods)
    {
        if(seller instanceof Seller == false)
        {
            System.out.println("错误：seller参数类型不是Seller。4");
            System.exit(1);

        }
        System.out.println(name+"收到了来自商家"+seller.getName()+"的定位。");
        receiveGoods(goods);
    }

    public void receiveGoods(Goods goods)
    {
        goodsReceived = goods;
    }
}
