package pt.c40task.l05wumpus;

public class Fedor extends Componente{
	Fedor(int x, int y, char tipo) {
		super(x, y, tipo);
		// TODO Auto-generated constructor stub
	}

	public void add(Caverna caverna) {
		caverna.associaSala(this, x, y);
	}
}
