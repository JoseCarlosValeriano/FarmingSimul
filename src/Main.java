public class Main {

    public static void main(String[] args) {

        Productor primeraPlanta = new Productor(2, 5000, 20);
        Consumidor mujer = new Consumidor(2);

        primeraPlanta.setPriority(Thread.MAX_PRIORITY);
        primeraPlanta.start();
        mujer.start();

        //Funcionando

    }
}