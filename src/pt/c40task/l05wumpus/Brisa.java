package pt.c40task.l05wumpus;

public class Brisa extends Componente{
	
	Brisa(int x, int y, char tipo) {
		super(x, y, tipo);
	}

	public void add(Caverna caverna) {
		caverna.associaSala(this, x, y);
	}
}
