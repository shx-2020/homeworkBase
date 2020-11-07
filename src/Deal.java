public interface Deal
{

    void operateGoods(Dealer dealer,Goods goods);
    void operateOrder(Dealer dealer,Goods goods);
    void messageTransmit(Dealer dealer,String msg,Goods goods);
}
