package pt.c40task.l05wumpus;

public class Pontuacao {
	private static int pontos = 0;
	
	public static int getPontos() {
		return pontos;
	}
	
	public static void adicionaPontos(int x) {
		pontos += x;
	}	
}
