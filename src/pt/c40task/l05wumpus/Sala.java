package pt.c40task.l05wumpus;
import java.util.Random;

public class Sala {
	int x, y,  revelada = 0, nComponentes;
	Componente componentes[] = new Componente[4];

	Sala (int x, int y){
		this.x = x;
		this.y = y;
		this.nComponentes = 0;
	}

	
	public void adicionaComponente(Componente novo) {
		if (novo instanceof Heroi){
			if(x == 0 && y == 0){
				this.revelada = 1;
				componentes[0]= novo;
				nComponentes++;
			}else{
				System.out.println("Erro: Heroi nao esta na primeira sala!");
			}
		}
		if (novo instanceof Wumpus || novo instanceof Buraco || novo instanceof Ouro) {
			if (componentes[0] instanceof Wumpus || componentes[0] instanceof Buraco || componentes[0] instanceof Ouro) {
				System.out.println("Erro: nao se pode colocar dois componentes primarios na mesma sala!");
			}
			for(int i = nComponentes; i > 0; i--) {
				componentes[i] = componentes[i - 1];
			}
			componentes[0] = novo;
			nComponentes++;
		}
		if (novo instanceof Fedor) {
			for(int i = 0; i < nComponentes; i++) {
				if (componentes[i] instanceof Fedor) {
					return;
				}
				if (componentes[i] instanceof Brisa) {
					componentes[i + 1] = componentes[i];
					componentes[i] = novo;
					nComponentes++;
					return;
				}
			}
			componentes[nComponentes] = novo;
			nComponentes++;
			
		}
		if (novo instanceof Brisa) {
			for(int i = 0; i < nComponentes; i++) {
				if (componentes[i] instanceof Brisa) {
					return;
				}
			}
			componentes[nComponentes] = novo;
			nComponentes++;
		}
	}
	
	public void removeComponente(char x) {
		for(int i = 0; i<nComponentes; i++) {
			if(componentes[i].getChar() == x) {
				for(int j = i; j<nComponentes-1 ; j++) {
					componentes[j] = componentes[j+1];
				}
				break;
			}
		}
		componentes[nComponentes] = null;
		nComponentes--;
	}

	public void capOuro(Heroi p) {
		if (this.componentes[0] instanceof Ouro) {
			removeComponente('O');
			p.pegouOuro();
		}
	}
	
	public void tiraHeroi() {
		for(int i = 0; i<nComponentes; i++) {
			if(componentes[i] instanceof Heroi) {
				Pontuacao.adicionaPontos(-15);
				removeComponente('P');
			}
		}
	}

	public void adicionaHeroi(Heroi p, Caverna cav) {
		this.revelada = 1;
		if(x == 0 && y == 0) {
			if (p.getOuro() == 1) {
				Pontuacao.adicionaPontos(1000);
				Controle.gameOver = -1;
			}
		}
		
		if(nComponentes > 0 && componentes[0] instanceof Buraco) {
			Pontuacao.adicionaPontos(-1000);
			Controle.gameOver = 1;
		}
		if(nComponentes > 0 && componentes[0] instanceof Wumpus) {
			if(p.getPreparado() == 1) {
				Random rand = new Random();
				int num = rand.nextInt(2);
				
				if(num == 0) {
					Pontuacao.adicionaPontos(-1000);
					Controle.gameOver = 1;
				}else {
					Pontuacao.adicionaPontos(500);
					System.out.println();
					System.out.println("Parabens guerreiro! Wumpus foi derrotado!");
					System.out.println();
					removeComponente('W');
					cav.remove('f', this.x+1, this.y);
					cav.remove('f', this.x-1, this.y);
					cav.remove('f', this.x, this.y+1);
					cav.remove('f', this.x, this.y-1);
				}
			}else {
				Pontuacao.adicionaPontos(-1000);
				Controle.gameOver = 1;
			}
		}
		componentes[nComponentes] = p;
		nComponentes++;
		p.tiraFlecha();
	}
	
	public char mostraSala(int heroiNaSala){
		if(this.revelada == 0){
			return '-';
		}
		else if(nComponentes == 0){
			return '#';
		}else if(heroiNaSala == 0){
			return componentes[0].getChar();
		}else{
			Heroi.achouBrisa(0);
			Heroi.achouFedor(0);
			for(int i = 0; i<nComponentes; i++) {
				if(componentes[i] instanceof Brisa) {
					Heroi.achouBrisa(1);
				}
				if(componentes[i] instanceof Fedor) {
					Heroi.achouFedor(1);
				}
			}
			if(componentes[0] instanceof Ouro){
				return 'O';
			}else{
				
				return 'P';
			}
		}
	}
	
}
