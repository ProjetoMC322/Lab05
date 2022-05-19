package pt.c40task.l05wumpus;

public class Wumpus extends Componente{
	Wumpus(int x, int y, char tipo) {
		super(x, y, tipo);
		// TODO Auto-generated constructor stub
	}

	public void add(Caverna caverna) {
		caverna.associaSala(this, x, y);
		caverna.associaSala(new Fedor(x, y + 1, 'f'), x, y + 1);
		caverna.associaSala(new Fedor(x, y - 1, 'f'), x, y - 1);
		caverna.associaSala(new Fedor(x + 1, y, 'f'), x + 1, y);
		caverna.associaSala(new Fedor(x - 1, y, 'f'), x - 1, y);
	}
}
