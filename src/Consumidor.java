public class Consumidor extends Thread{

    private final int consumer;

    public Consumidor(int consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try{

            for(int i = 0; i < Productor.getPlantasCreciendo(); i++){
                sleep(5000);
                int randomClient = ((int) (Math.random() * consumer));
                int randomPlant = ((int) (Math.random() * Monitor.plantasCrecidas.size()));
                System.out.println("El cliente nº " + randomClient + " ha consumido la verdura: " + Monitor.plantasCrecidas.get(randomPlant));
                Monitor.plantasCrecidas.remove(randomPlant);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
