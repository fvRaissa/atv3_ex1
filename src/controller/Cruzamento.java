package controller;

import java.util.concurrent.Semaphore;

public class Cruzamento extends Thread {
	private String sentido;
	private Semaphore semaforo;
	private int carro;

	public Cruzamento(String sentido, Semaphore semaforo) {
		this.sentido = sentido;
		this.semaforo = semaforo;
		this.carro = (int) threadId();
	}

	public void run() {

		carroAndando();
		try {
			semaforo.acquire();
			carroEsperando();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			cruzamento();
		}

	}

	private void carroAndando() {

		int distanciaPercorrida = 0;
		int tempo = 1000;
		while (distanciaPercorrida < 100) {
			distanciaPercorrida += (int) ((Math.random() * 21) + 10);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + carro + " percorreu " + distanciaPercorrida + "m.");
		}
	}

	private void carroEsperando() {
		System.out.println("#" + carro + " parou no cruzamento");

	}

	private void cruzamento() {
		System.out.println("#" + carro + " cruzou no sentido " + sentido);
	}

}
