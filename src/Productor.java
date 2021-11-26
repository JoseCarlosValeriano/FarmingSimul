public class Productor extends Thread {

    // Atributos
    private final int productor;
    private Monitor buffer;
    private final int limitePlantacion;
    private static int plantasCreciendo;
    private String [] Verduras = {
            "lettuce", "cabbage", "onion", "spinach", "potato", "celery", "asparagus", "radish",
            "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean"};

    //Constructor
    public Productor(Monitor buffer, int productor, int limitePlantacion, int plantasCreciendo) {
        this.buffer = buffer;
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
                    int verdura = (int) (Math.random() * this.Verduras.length);
                    String Producto = Verduras[verdura];
                    int TIEMPOCRECIMIENTO = (int) (Math.random() * 900);
                    int productorRandom = ((int) (Math.random() * this.productor));
                    sleep(TIEMPOCRECIMIENTO);
                    buffer.Producir(Producto);
                    System.out.println("La planta: " + Producto +"  ha sido cosechada por el productor nº " +
                            productorRandom + " y ha crecido con un tiempo de: " + TIEMPOCRECIMIENTO + " minutos");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}