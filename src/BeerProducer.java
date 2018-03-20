import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BeerProducer extends Thread {
    private String name;
    private BeerHouse beerhouse;
    private List<String> beerlist;
    private Random dado;

    public BeerProducer(String name, BeerHouse beerhouse){
        this.name = name;
        this.beerhouse = beerhouse;
        this.beerlist = new ArrayList<>();
        this.beerlist.add("Stella");
        this.beerlist.add("Heineken");
        this.beerlist.add("Corona");
        this.dado = new Random();
    }


    public void run(){
        String beer;
        for(int i = 0; i<10; i++){
            try{
                beer = beerlist.get(dado.nextInt(beerlist.size()));
                beerhouse.produce(beer);
                sleep(2000);
            }catch (InterruptedException e){}

        }
    }

}
