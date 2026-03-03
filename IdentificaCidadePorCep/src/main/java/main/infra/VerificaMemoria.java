package main.infra;

public class VerificaMemoria {
	public void verificaMemoria() {
		Runtime runtime = Runtime.getRuntime();

		long memoriaUsada = runtime.totalMemory() - runtime.freeMemory();
		long memoriaTotal = runtime.totalMemory();
		long memoriaMaxima = runtime.maxMemory();

		System.out.println("Memória usada: " + memoriaUsada / (1024 * 1024) + " MB");
		System.out.println("Memória total alocada: " + memoriaTotal / (1024 * 1024) + " MB");
		System.out.println("Memória máxima disponível: " + memoriaMaxima / (1024 * 1024) + " MB");
	}

}
