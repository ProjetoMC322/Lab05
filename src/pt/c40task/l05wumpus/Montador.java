package pt.c40task.l05wumpus;

public class Montador {
	private int n_ouro = 0, n_wumpus = 0, n_heroi = 0, n_buracos = 0;
	private Caverna caverna;
	Montador(){
		caverna = new Caverna();
	}
	public Caverna montaCaverna(String cave[][]) {
		for (int i = 0; i < cave.length; i++) {
			if(cave[i][2].equals("O")) {
				n_ouro++;
				caverna.conecta(new Ouro(Integer.parseInt(cave[i][0]) -1, Integer.parseInt(cave[i][1]) -1, 'O'));
			}
			else if(cave[i][2].equals("B")) {
				n_buracos++;
				caverna.conecta(new Buraco(Integer.parseInt(cave[i][0]) -1, Integer.parseInt(cave[i][1]) -1, 'B'));
			}else if(cave[i][2].equals("W")) {
				n_wumpus++;
				caverna.conecta(new Wumpus(Integer.parseInt(cave[i][0]) -1, Integer.parseInt(cave[i][1]) -1, 'W'));
			}else if(cave[i][2].equals("P")) {
				n_heroi++;
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
		if(n_ouro == 1 && n_heroi == 1 && n_wumpus == 1 && n_buracos> 1 && n_buracos < 4) {
			return caverna;
		}else {
			return null;
		}
	}
}
