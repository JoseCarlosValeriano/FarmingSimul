import java.nio.Buffer;

public class Consumidor extends Thread{

    private final int consumer;
    private Monitor buffer;

    public Consumidor(Monitor buffer, int consumer) {
        this.buffer = buffer;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try{

            for(int i = 0; i < Productor.getPlantasCreciendo(); i++){
                sleep(5000);
                String ProductoComprado = buffer.Comprar();
                int randomClient = ((int) (Math.random() * consumer));
                System.out.println("El cliente nº " + randomClient + " ha consumido la verdura: " + ProductoComprado);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
