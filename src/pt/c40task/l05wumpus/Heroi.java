package pt.c40task.l05wumpus;

public class Heroi extends Componente {
	private int quantFlecha = 1;
	private int preparado = 0;
	private int temOuro = 0;
	
	Heroi(int x, int y, char tipo) {
		super(x, y, tipo);
	}
	
	public void move(Caverna cave, String movimento) {
		if (movimento.equalsIgnoreCase("w")) {
			cave.moveHeroi(this.x, this.y, this.x - 1, this.y, this);
		}
		if (movimento.equalsIgnoreCase("a")) {
			cave.moveHeroi(this.x, this.y, this.x, this.y - 1, this);
		}
		if (movimento.equalsIgnoreCase("s")) {
			cave.moveHeroi(this.x, this.y, this.x + 1, this.y, this);
		}
		if (movimento.equalsIgnoreCase("d")) {
			cave.moveHeroi(this.x, this.y, this.x, this.y + 1, this);
		}
	}
	
	public void equipaFlecha() {
		if (this.preparado == 0) {
			if (this.quantFlecha == 1) {
				this.preparado = 1;
				this.quantFlecha --;
			}
		}	
	}
	
	public int getPreparado() {
		return preparado;
	}
	
	public void captura(Caverna cave) {
		cave.capturaOuro(this.x, this.y, this);
	}
	
	public void tiraFlecha() {
		this.preparado = 0;
		Pontuacao.adicionaPontos(-100);
	}
	
	public int[] getPosicaoHeroi() {
		int x[] = new int[2];
		x[0] = this.x;
		x[1] = this.y;
		return x;
	}
	
	public void pegouOuro() {
		this.temOuro = 1;
	}
	
	public int getOuro() {
		return this.temOuro;
	}
}
