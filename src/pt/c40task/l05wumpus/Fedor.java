package pt.c40task.l05wumpus;

public class Fedor extends Componente{
	public void add(Caverna caverna) {
		caverna.associaSala(this, x, y);
	}
}
