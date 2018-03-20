public class main {

    public static void main(String arg[]){
        BeerHouse bh = new BeerHouse();
        BeerConsumer bc1 = new BeerConsumer("bc1",bh);
        BeerConsumer bc2 = new BeerConsumer("bc2",bh);
        BeerConsumer bc3 = new BeerConsumer("bc3",bh);
        BeerProducer bp1 = new BeerProducer("bp1",bh);
        BeerProducer bp2 = new BeerProducer("bp2",bh);


        bp1.start();
        bp2.start();
        bc1.start();
        bc2.start();
        bc3.start();

    }
}
