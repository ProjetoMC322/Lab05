package pt.c40task.l05wumpus;

public class Heroi extends Componente {
	private int quantFlecha = 1;
	private int preparado = 0;
	private int temOuro = 0;
	private static int temFedor = 0;
	private static int temBrisa = 0;
	
	Heroi(int x, int y, char tipo) {
		super(x, y, tipo);
	}
	
	public void add(Caverna caverna) {
		caverna.associaSala(this, x, y);
	}
	
	public void move(Caverna cave, String movimento) {
		if (movimento.equalsIgnoreCase("w")) {
			cave.moveHeroi(this.x, this.y, this.x - 1, this.y, this);
			if(this.x > 0) {
				this.x--;
			}
		}
		if (movimento.equalsIgnoreCase("a")) {
			cave.moveHeroi(this.x, this.y, this.x, this.y - 1, this);
			if(this.y > 0) {
				this.y--;
			}
		}
		if (movimento.equalsIgnoreCase("s")) {
			cave.moveHeroi(this.x, this.y, this.x + 1, this.y, this);
			if(this.x < 3) {
				this.x++;
			}
		}
		if (movimento.equalsIgnoreCase("d")) {
			cave.moveHeroi(this.x, this.y, this.x, this.y + 1, this);
			if(this.y < 3) {
				this.y++;
			}
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
		if(this.preparado == 1) {
			this.preparado = 0;
			Pontuacao.adicionaPontos(-100);
		}
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
	
	public static void achouBrisa(int x) {
		temBrisa = x;
	}
	
	public static int getBrisa() {
		return temBrisa;
	}
	
	public static void achouFedor(int x) {
		temFedor = x;
	}
	
	public static int getFedor() {
		return temFedor;
	}
}
