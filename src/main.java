public class main {
    private static BeerHouse bh;
    private static final int CANT_CONSUMERS = 7;
    private static BeerConsumer [] consumers;
    private static BeerProducer bp1;

    public static void main(String arg[]){
        bh = new BeerHouse();
        consumers = new BeerConsumer[CANT_CONSUMERS];
        bp1 = new BeerProducer("bp1",bh);

        bp1.start();

        for(int i = 0; i<7; i++){
            consumers[i] = new BeerConsumer("bc"+i,bh);
            consumers[i].start();
        }



    }
}
