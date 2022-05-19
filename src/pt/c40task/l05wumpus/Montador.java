package pt.c40task.l05wumpus;

public class Montador {
	private int nOuro = 0, nWumpus = 0, nHeroi = 0, nBuracos = 0;
	private Caverna caverna;
	Montador(){
		caverna = new Caverna();
	}
	public Caverna montaCaverna(String cave[][]) {
		for (int i = 0; i < cave.length; i++) {
			if(cave[i][2].equals("O")) {
				nOuro++;
				caverna.conecta(new Ouro(Integer.parseInt(cave[i][0]) -1, Integer.parseInt(cave[i][1]) -1, 'O'));
			}
			else if(cave[i][2].equals("B")) {
				nBuracos++;
				caverna.conecta(new Buraco(Integer.parseInt(cave[i][0]) -1, Integer.parseInt(cave[i][1]) -1, 'B'));
			}else if(cave[i][2].equals("W")) {
				nWumpus++;
				caverna.conecta(new Wumpus(Integer.parseInt(cave[i][0]) -1, Integer.parseInt(cave[i][1]) -1, 'W'));
			}else if(cave[i][2].equals("P")) {
				nHeroi++;
				if(Integer.parseInt(cave[i][0]) != 1) {
					System.out.println("Jogador precisa estar na primeira cela");
					return null;
				}
				if(Integer.parseInt(cave[i][1]) != 1) {
					System.out.println("Jogador precisa estar na primeira cela");
					return null;
				}
				Heroi heroi = new Heroi(Integer.parseInt(cave[i][0]) -1, Integer.parseInt(cave[i][1]) -1, 'P');
				caverna.conecta(heroi);
				AppWumpus.conectaHeroi(heroi);
			}
	    }
		if(nOuro == 1 && nHeroi == 1 && nWumpus == 1 && nBuracos> 1 && nBuracos < 4) {
			return caverna;
		}else {
			return null;
		}
	}
}
