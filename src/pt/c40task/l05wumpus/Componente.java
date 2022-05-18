package pt.c40task.l05wumpus;

public abstract class Componente {
	int x, y;
	char tipo;
	
	Componente(int x, int y, char tipo){
		this.x = x;
		this.y = y;
		this.tipo = tipo;
	}
	
	public void getChar(){
		return this.tipo;
	}
	
	public void add(Caverna caverna) {
		return ;
	}
}
