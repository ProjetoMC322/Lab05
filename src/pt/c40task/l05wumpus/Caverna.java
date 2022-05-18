package pt.c40task.l05wumpus;

public class Caverna {
	Sala caverna[][] = new Sala[4][4];
	for(int i = 0; i<4; i++){
		for(int j = 0; j<4; j++){
			sala[i][j] =  new Sala(i, j);
		}
	}
	
	public void conecta(Componente c) {
		c.add(this);
	}
	
	public void associaSala(Componente c, int x, int y) {
		caverna[x][y].adicionaComponente(c);
	}
	
	public void capturaOuro(int x, int y) {
		caverna[x][y].capOuro();
	}
	
	public void moveHeroi(int xa, int ya, int xd, int yd, Heroi p) {
		if((xd > 3)||(yd > 3)||(xd < 0)||(yd < 0)) {
			System.out.println("A célula que você quer acessar é fora da caverna");
			return;
		}
		caverna[xa][ya].tiraHeroi();
		caverna[xd][yd].adicionaHeroi(p);
	}

	public void mostraJogo(Toolkit tk, int xh, int yh, int gameOver){
		if(gameOver == 0){
			for(int i = 0; i<4; i++){
				for(int j = 0; j<4; j++){
					if(i != xh || j != yh){
						System.out.print(sala[i][j].mostraSala(0));
					}else{
						System.out.print(sala[i][j].mostraSala(1));
					}
				
				}
				System.out.println();
			}
			System.out.println("Player: Sting");
			System.out.println("Pontuacao: " + Pontuacao.getPontos());
		}else{
			for(int i = 0; i<4; i++){
				for(int j = 0; j<4; j++){
					System.out.print(sala[i][j].mostraSala(0));
				}
				System.out.println();
			}
		}
		else if(gameOver == -1){
			System.out.println("Player: " + Pontuacao.getNome());
			System.out.println("Pontuacao: " + Pontuacao.getPontos());
			System.out.println("Parabens!!! Voce venceu!!! =D");
		}
		else if(gameOver == 1){
			System.out.println("Player: " + Pontuacao.getNome());
			System.out.println("Pontuacao: " + Pontuacao.getPontos());
			System.out.println("Voce perdeu =(");
		}
		else if(gameOver == 2){
			System.out.println("Player: " + Pontuacao.getNome());
			System.out.println("Pontuacao: " + Pontuacao.getPontos());
			System.out.println("Volte sempre! ;)");
		}
	}

	
}
