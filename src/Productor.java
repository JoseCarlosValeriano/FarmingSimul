public class Productor extends Thread {

    // Atributos
    private final int productor;
    private final int limitePlantacion;
    private static int plantasCreciendo;
    public long length;

    //Constructor
    public Productor(int productor, int limitePlantacion, int plantasCreciendo) {
        this.productor = productor;
        this.limitePlantacion = limitePlantacion;
        this.plantasCreciendo = plantasCreciendo;
    }

    // Getter
    public static int getPlantasCreciendo() {
        return plantasCreciendo;
    }

    @Override
    public void run() {
        try {
            if (this.plantasCreciendo > this.limitePlantacion) {
                throw new Error("Se ha excedido el límite de plantas disponibles.");
            } else {
                for (int i = 0; i < this.plantasCreciendo; i++) {
                    sleep(2000);
                    int randomAccess = ((int) (Math.random() * 15));
                    int TIEMPOCRECIMIENTO = (int) (Math.random() * 900);
                    int productorRandom = ((int) (Math.random() * this.productor));
                    sleep(TIEMPOCRECIMIENTO);
                    System.out.println("La planta: " + Monitor.getVegetales(randomAccess) + "ha sido cosechada por el productor nº " +
                            productorRandom + " y ha crecido con un tiempo de: " + TIEMPOCRECIMIENTO + " minutos");
                    Monitor.plantasCrecidas.add(Monitor.getVegetales(randomAccess));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}