package Generador;

import java.util.concurrent.Semaphore;

public class ConsumidorRecursos {
    private Semaphore semaforoConsumidor;

    public ConsumidorRecursos(Semaphore semaforoGenerador) {
        this.semaforoConsumidor = semaforoGenerador;
    }

    public void consumirRecurso() {
        try {
            semaforoConsumidor.acquire(); // Adquirir un permiso
            // Lógica para consumir el recurso
            System.out.println("Recurso consumido por el proceso " + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforoConsumidor.release(); // Liberar el permiso
        }
    }
}
