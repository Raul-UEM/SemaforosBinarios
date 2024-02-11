package Generador;
import java.util.concurrent.Semaphore;

public class GeneradorRecursos {
    Semaphore semaforoGenerador;

    public GeneradorRecursos(int totalUnidades) {
        this.semaforoGenerador = new Semaphore(totalUnidades, true); // Inicializamos el semáforo con k unidades disponibles
    }

    public void generarRecurso() {
        try {
            semaforoGenerador.acquire(); // Adquirir un permiso
            // Lógica para generar el recurso
            System.out.println("Recurso generado por el proceso " + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void liberarRecurso() {
        semaforoGenerador.release(); // Liberar el recurso
        System.out.println("Recurso liberado por el proceso " + Thread.currentThread().getId());
    }
}
