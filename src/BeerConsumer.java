
public class BeerConsumer extends Thread {
    private String name;
    private BeerHouse beerhouse;

    public BeerConsumer(String name,BeerHouse beerhouse){
        this.name = name;
        this.beerhouse = beerhouse;
    }

    public void run(){
        for(int i = 0; i<10; i++){
            beerhouse.consume(this);
            try{
                sleep(3000);
            }catch(InterruptedException e){}

        }


    }

}
