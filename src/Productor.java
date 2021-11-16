import java.util.ArrayList;

public class Productor extends Thread{

    private int clientes;
    private int productor;
    private int limitePlantacion;
    private int plantasCreciendo;

    public String[] Vegetales = {"lettuce", "cabbage", "onion", "spinach", "potato", "celery",
            "asparagus", "radish", "broccoli", "artichoke", "tomato",
            "cucumber", "eggplant", "carrot", "green bean"};

    private ArrayList<String> plantasCrecidas = new ArrayList<>();

    public Productor(int clientes, int productor, int limitePlantacion, int plantasCreciendo) {
        this.clientes = clientes;
        this.productor = productor;
        this.limitePlantacion = limitePlantacion;
        this.plantasCreciendo = plantasCreciendo;
    }

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < this.plantasCreciendo; i++){
                int randomAccess = ((int) (Math.random() * 15));
                int TIEMPOCRECIMIENTO = (int)( Math.random() * 900);
                sleep((long) TIEMPOCRECIMIENTO);
                System.out.println("La planta: " + this.Vegetales[randomAccess] + " ha crecido con un tiempo de: " + TIEMPOCRECIMIENTO + " minutos");
                plantasCrecidas.add(this.Vegetales[randomAccess]);
            }
         }catch (Exception e){
            System.out.println(e);
        }
    }
}

