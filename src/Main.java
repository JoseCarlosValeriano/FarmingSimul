public class Main {

    public static void main(String[] args) {

        Monitor monitor = new Monitor(6);

        Productor primeraPlanta = new Productor(monitor, 2, 5000, 10);
        Consumidor mujer = new Consumidor(monitor, 10);

        //primeraPlanta.setPriority(Thread.MAX_PRIORITY);
        primeraPlanta.start();
        mujer.start();

        //Funcionando

    }
}