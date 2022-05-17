package pt.c40task.l05wumpus;

public class Buraco extends Componente{
	Buraco(int x, int y, char tipo) {
		super(x, y, tipo);
		// TODO Auto-generated constructor stub
	}

	public void add(Caverna caverna) {
		caverna.associaSala(this, x, y);
		
		caverna.associaSala(new Brisa(x, y + 1, 'b'), x, y + 1);
		caverna.associaSala(new Brisa(x, y - 1, 'b'), x, y - 1);
		caverna.associaSala(new Brisa(x + 1, y, 'b'), x + 1, y);
		caverna.associaSala(new Brisa(x - 1, y, 'b'), x - 1, y);
	}
}
