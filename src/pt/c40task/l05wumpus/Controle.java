package pt.c40task.l05wumpus;

public class Controle {
	public static int gameOver = 0;
	Heroi heroi;
	Caverna caverna;
	
	Controle(Heroi heroi, Caverna caverna){
		this.heroi = heroi;
		this.caverna = caverna;
	}
	
	public void leArquivo(String movimento) {
		for(int i = 0; i < movimento.length(); i++) {
			if (gameOver == 0) {
				if (movimento.substring(i, i+1).equalsIgnoreCase("w") ||
					movimento.substring(i, i+1).equalsIgnoreCase("a") ||	
					movimento.substring(i, i+1).equalsIgnoreCase("s") ||
					movimento.substring(i, i+1).equalsIgnoreCase("d") ) {
						heroi.move(caverna, movimento.substring(i, i + 1));
				}
				if (movimento.substring(i, i+1).equalsIgnoreCase("k")) {
					heroi.equipaFlecha();
				}
				if (movimento.substring(i, i+1).equalsIgnoreCase("c")) {
					heroi.captura(caverna);
				}
				if (movimento.substring(i, i+1).equalsIgnoreCase("q")) {
					gameOver = 1;
				}
			} else {
				AppWumpus.acabaJogo();
			}
		}
		AppWumpus.acabaJogo();
	}
	
}
