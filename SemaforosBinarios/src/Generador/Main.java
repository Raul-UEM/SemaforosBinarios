package Generador;

public class Main {
    public static void main(String[] args) {
        int totalUnidades = 3; // Define el número total de unidades de recurso (k)
        GeneradorRecursos generador = new GeneradorRecursos(totalUnidades);

        // Crea varios procesos para generar y consumir recursos
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    generador.generarRecurso();
                    // Lógica adicional si es necesario antes de liberar el recurso
                    LiberadorRecursos liberador = new LiberadorRecursos(generador.semaforoGenerador);
                    liberador.liberarRecurso();
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    ConsumidorRecursos consumidor = new ConsumidorRecursos(generador.semaforoGenerador);
                    consumidor.consumirRecurso();
                }
            }).start();
        }
    }
}

