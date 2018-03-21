import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BeerHouse {

    private List<String> beerlist;
    private int stock;
    private final int STOCKMAX = 100;
    private Random dado;

    public BeerHouse(){
        this.beerlist = new ArrayList<>();
        this.stock = 0;
        this.dado = new Random();
    }


    public synchronized void produce(List<String> beers){

        while(!reponerStock())
        {
            try{
                System.out.println("Productor esperando");
                wait();
            }catch (InterruptedException e){}
        }
        for(String beer : beers){
            if(this.beerlist.size() < this.STOCKMAX){
                this.beerlist.add(beer);
            }

        }

        this.stock = this.beerlist.size();
        System.out.format("cantidad de cerveza en beer house: %d\n",stock);
        notifyAll();
        if(this.stock == 100){
            Thread.interrupted();
        }
    }

    public synchronized void consume(BeerConsumer beerconsumer){
        while(!isDisponible())
        {
            try{
                System.out.println("Consumidor esperando");
                wait();
                if(this.stock < 0){
                    Thread.interrupted();
                }
            }catch(InterruptedException e){}

        }

        int beerindex = dado.nextInt(stock);
        System.out.println(beerconsumer.getName() + " consumio: " + beerlist.get(beerindex));

        this.beerlist.remove(beerindex);
        this.stock = this.beerlist.size();

        System.out.format("Stock: %d\n",this.stock);
        notifyAll();
    }

    public boolean isDisponible(){
        return (this.stock > 0);
    }

    public boolean reponerStock(){
        return (this.stock < this.STOCKMAX);
    }
}
