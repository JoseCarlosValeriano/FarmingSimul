
// Monitor es una construcción de sincronización que permite que los subprocesos tengan exclusión mutua
// y la capacidad de esperar (bloquear) para que una determinada condición se haga realidad.
public class Monitor {

    // ArrayList para almacenar las plantas producidas
    // Los atributos para los metodos SYNCHRONIZED
    private int top = 0;
    private String buff[];
    private boolean full = false;
    private boolean empty = true;

    // Constructor
    public Monitor(int vegetales) {
        this.buff = new String[vegetales];
    }

    public synchronized void Producir(String Producto) throws InterruptedException{
        while (full) {
            wait();
        }
        buff[top] = Producto;
        top = top + 1;
        empty = false;
        full = top >= buff.length;
        notifyAll();
    }

    public synchronized String Comprar() throws InterruptedException{
        while (empty) {
            wait();
        }
        top = top - 1;
        String Producto_comprado = buff[top];
        full = false;
        empty = top <= 0;
        notifyAll();
        return Producto_comprado;

    }
}
