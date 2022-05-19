package pt.c40task.l05wumpus;

public class Caverna {
	
	Sala caverna[][] = new Sala[4][4];
		
	Caverna() {
		for(int i = 0; i<4; i++){
			for(int j = 0; j<4; j++){
				this.caverna[i][j] =  new Sala(i, j);
			}
		}
	}
	
	public void conecta(Componente c) {
		c.add(this);
	}
	
	public void associaSala(Componente c, int x, int y) {
		if((x < 4)&&(y < 4)&&(x >= 0)&&(y >= 0)) {
			caverna[x][y].adicionaComponente(c);
		}
	}
	
	public void capturaOuro(int x, int y, Heroi p) {
		caverna[x][y].capOuro(p);
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
		char jogo[][] = new char[4][4];
		if(gameOver == 0){
			for(int i = 0; i<4; i++){
				for(int j = 0; j<4; j++){
					if(i != xh || j != yh){
						jogo[i][j] = caverna[i][j].mostraSala(0);
						System.out.print(caverna[i][j].mostraSala(0));
					}else{
						jogo[i][j] = caverna[i][j].mostraSala(1);
						System.out.print(caverna[i][j].mostraSala(1));
					}
				}
				System.out.println("");
			}
			System.out.println(Pontuacao.getPontos());
			System.out.println("\n");
			tk.writeBoard(jogo, Pontuacao.getPontos(), 'x', Pontuacao.getNome());
		}else{
			for(int i = 0; i<4; i++){
				for(int j = 0; j<4; j++){
					jogo[i][j] = caverna[i][j].mostraSala(0);
					System.out.print(caverna[i][j].mostraSala(0));
				}
				System.out.println("");
			}
			System.out.println(Pontuacao.getPontos());
			System.out.println("\n");
		}
		if(gameOver == -1){
			tk.writeBoard(jogo, Pontuacao.getPontos(), 'w', Pontuacao.getNome());
			System.out.println("Parabens!!! Voce venceu!!! =D");
		}
		else if(gameOver == 1){
			tk.writeBoard(jogo, Pontuacao.getPontos(), 'n', Pontuacao.getNome());
			System.out.println("Voce perdeu =(");
		}
		else if(gameOver == 2){
			tk.writeBoard(jogo, Pontuacao.getPontos(), 'n', Pontuacao.getNome());
			System.out.println("Volte sempre! ;)");
		}
	}
}

