package pt.c40task.l05wumpus;

public class Caverna {
	Sala caverna[][] = new Sala[4][4];
	
	public void conecta(Componente c) {
		c.add(this);
	}
	
	public void associaSala(Componente c, int x, int y) {
		caverna[x][y].adicionaComponente(c);
	}
}
