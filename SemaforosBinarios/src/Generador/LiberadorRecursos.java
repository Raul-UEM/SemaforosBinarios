package Generador;

import java.util.concurrent.Semaphore;

public class LiberadorRecursos {
    private Semaphore semaforoLiberador;

    public LiberadorRecursos(Semaphore semaforoGenerador) {
        this.semaforoLiberador = semaforoGenerador;
    }

    public void liberarRecurso() {
        semaforoLiberador.release(); // Liberar el recurso
        System.out.println("Recurso liberado por el proceso " + Thread.currentThread().getId());
    }
}
