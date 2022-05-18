package pt.c40task.l05wumpus;

public class Controle {
	public static int gameOver = 0;
	Heroi heroi;
	Caverna caverna;
	Toolkit tk;
	
	Controle(Heroi heroi, Caverna caverna, Toolkit tk){
		this.heroi = heroi;
		this.caverna = caverna;
		this.tk = tk;
	}
	
	public void leArquivo(String movimento) {
		for(int i = 0; i < movimento.length(); i++) {
			if (gameOver == 0) {
				if (movimento.substring(i, i+1).equalsIgnoreCase("w") ||
					movimento.substring(i, i+1).equalsIgnoreCase("a") ||	
					movimento.substring(i, i+1).equalsIgnoreCase("s") ||
					movimento.substring(i, i+1).equalsIgnoreCase("d") ) {
						heroi.move(caverna, movimento.substring(i, i + 1)); 
						caverna.mostraJogo(this.tk, heroi.getPosicaoHeroi()[0], heroi.getPosicaoHeroi()[1], gameOver);
						if (gameOver != 0){
							break;
						};
				}
				if (movimento.substring(i, i+1).equalsIgnoreCase("k")) {
					heroi.equipaFlecha();
					caverna.mostraJogo(this.tk, heroi.getPosicaoHeroi()[0], heroi.getPosicaoHeroi()[1], gameOver);
				}
				if (movimento.substring(i, i+1).equalsIgnoreCase("c")) {
					heroi.captura(caverna);
					caverna.mostraJogo(this.tk, heroi.getPosicaoHeroi()[0], heroi.getPosicaoHeroi()[1], gameOver);
				}
				if (movimento.substring(i, i+1).equalsIgnoreCase("q")) {
					gameOver = 2;
					caverna.mostraJogo(this.tk, heroi.getPosicaoHeroi()[0], heroi.getPosicaoHeroi()[1], gameOver);
					break;
				}
			}else{
				break;
			}
		}
		//termina no teclado
	}	
}
