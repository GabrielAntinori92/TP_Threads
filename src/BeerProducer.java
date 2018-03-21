import java.util.ArrayList;
import java.util.List;


public class BeerProducer extends Thread {
    private String name;
    private BeerHouse beerhouse;
    private List<String> beerlist;

    public BeerProducer(String name, BeerHouse beerhouse){
        this.name = name;
        this.beerhouse = beerhouse;
        this.beerlist = new ArrayList<>();
    }


    public void run(){
        while(Boolean.TRUE){
            try{
                for(int i = 0; i<5; i++){
                    this.beerlist.add("beer " + i);
                }
                this.beerhouse.produce(beerlist);
                this.beerlist.clear();
                sleep(2000);
            }catch (InterruptedException e){}

        }
    }

}
