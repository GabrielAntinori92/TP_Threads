import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BeerHouse {

    private List<String> beerlist;
    private int stock;
    private Random dado;

    public BeerHouse(){
        this.beerlist = new ArrayList<>();
        this.stock = 0;
        this.dado = new Random();
    }


    public synchronized void produce(String beer){

        while(this.stock > 0)
        {
            try{
                System.out.println("Producer espera para producir " + beer);
                wait();
            }catch (InterruptedException e){}
        }
        this.beerlist.add(beer);
        this.stock = this.beerlist.size();
        notify();
    }

    public synchronized void consume(BeerConsumer beerconsumer){
        while(this.stock <= 0)
        {
            try{
                System.out.println("Consumidor esperando " + beerconsumer.getName());
                wait();
            }catch(InterruptedException e){}

        }

        int beerindex = dado.nextInt(stock);
        System.out.println(beerconsumer.getName() + "consumio: " + beerlist.get(beerindex));

        this.beerlist.remove(beerindex);
        this.stock = this.beerlist.size();


        notifyAll();
    }
}
