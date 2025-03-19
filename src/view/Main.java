package view;

import java.util.concurrent.Semaphore;

import controller.Cruzamento;

public class Main {

	public static void main(String[]args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		String sentido[] = {"Oeste para leste", "Leste para oeste", "Norte para sul", "Sul para norte"};
		
		for(int i = 1; i <5; i++) {
			Cruzamento C = new Cruzamento(sentido[i - 1], semaforo);
			C.start();
		}
	}
}
