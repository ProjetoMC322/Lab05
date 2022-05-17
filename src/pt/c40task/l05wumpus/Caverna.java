package pt.c40task.l05wumpus;

public class Caverna {
	Sala caverna[][] = new Sala[4][4];
	
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

	
}
