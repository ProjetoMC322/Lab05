package pt.c40task.l05wumpus;

public class Ouro extends Componente{
	public void add(Caverna caverna) {
		caverna.associaSala(this, x, y);
	}
}
