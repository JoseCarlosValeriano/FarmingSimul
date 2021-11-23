import java.util.ArrayList;

// Monitor es una construcción de sincronización que permite que los subprocesos tengan exclusión mutua
// y la capacidad de esperar (bloquear) para que una determinada condición se haga realidad.
public class Monitor {

    // Creamos una Array de String los Vegetales
    public static String[] Vegetales = {"lettuce", "cabbage", "onion", "spinach", "potato", "celery",
            "asparagus", "radish", "broccoli", "artichoke", "tomato",
            "cucumber", "eggplant", "carrot", "green bean"};

    // Constructor
    public Monitor(String[] vegetales) {
        Vegetales = vegetales;
    }
    //Getter
    public static String getVegetales(int access) {
        return Vegetales[access];
    }
    // ArrayList para almacenar las plantas producidas
    public static ArrayList<String> plantasCrecidas = new ArrayList<>();

    // Los atributos para los metodos SYNCHRONIZED
    private int top = 0;

    private Productor[] buff = null;
    private Consumidor buff2[] = null;
    private boolean full = false;
    private boolean empty = true;

    public Monitor(int capacity){
        this.buff = new Productor[capacity];
    }

    public synchronized void Producir(Productor buff) throws InterruptedException{
        while(full){
            wait();
        }

        buff = buff;
        top += 1;
        empty = false;
        full = top >= buff.length;
        notifyAll();
    }

    public synchronized void Comprar(Consumidor buff2) throws InterruptedException{
        while(full){
            wait();
        }

        buff = buff;
        top += 1;
        empty = false;
        full = top >= buff.length;
        notifyAll();
    }
}
