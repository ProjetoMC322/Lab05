package pt.c40task.l05wumpus;

public class Pontuacao {
	private static String nome = "Alcebiades";
	private static int pontos = 0;
	
	public static int getPontos() {
		return pontos;
	}
	
	public static void adicionaPontos(int x) {
		pontos += x;
	}	
	
	public static String getNome() {
		return nome;
	}
	
	public static void setNome(String nome_novo) {
		nome = nome_novo;
	}
}
