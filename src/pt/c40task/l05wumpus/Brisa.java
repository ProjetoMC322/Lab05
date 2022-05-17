package pt.c40task.l05wumpus;

public class Brisa extends Componente{
	public void add(Caverna caverna) {
		caverna.associaSala(this, x, y);
	}
}
