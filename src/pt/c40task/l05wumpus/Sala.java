package pt.c40task.l05wumpus;
import java.util.Random;

public class Sala {
	int x, y,  revelada = 0;
	Componente componentes[] = new Componente[4];
	public void adicionaComponente(Componente novo) {
		if (novo instanceof Wumpus || novo instanceof Buraco || novo instanceof Ouro) {
			if (componentes[0] instanceof Wumpus || componentes[0] instanceof Buraco || componentes[0] instanceof Ouro) {
				System.out.println("Erro: não se pode colocar dois componentes primários na mesma sala!");
			}
			for(int i = componentes.length; i > 0; i--) {
				componentes[i] = componentes[i - 1];
			}
			componentes[0] = novo;
		}
		if (novo instanceof Brisa) {
			for(int i = 0; i < componentes.length; i++) {
				if (componentes[i] instanceof Brisa) {
					return;
				}
				componentes[componentes.length] = novo;
			}
		}
		if (novo instanceof Fedor) {
			for(int i = 0; i < componentes.length; i++) {
				if (componentes[i] instanceof Fedor) {
					return;
				}
				componentes[componentes.length] = novo;
			}
		}
	}
	
	public void capOuro() {
		if (this.componentes[0] instanceof Ouro) {
			Componente auxiliar;
			for (int i = componentes.length; i > 0; i--) {
				auxiliar = componentes[i];
				componentes[i - 1] = auxiliar;
			}
			componentes[componentes.length] = null;
			Pontuacao.adicionaPontos(1000);
		}
	}
	
	public void tiraHeroi() {
		for(int i = 0; i<componentes.length; i++) {
			if(componentes[i] instanceof Heroi) {
				Pontuacao.adicionaPontos(-15);
				for(int j = i+1; j<componentes.length; j++) {
					componentes[j-1] = componentes[j];
				}
				componentes[componentes.length] = null;
			}
		}
	}//end void

	public void adicionaHeroi(Heroi p) {
		this.revelada = 1;
		if(componentes.length > 1 && componentes[0] instanceof Buraco) {
			Pontuacao.adicionaPontos(-1000);
			Controle.gameOver = 1;
		}
		if(componentes.length > 1 && componentes[0] instanceof Wumpus) {
			if(p.getPreparado() == 1) {
				Random rand = new Random();
				int num = rand.nextInt(1);
				if(num == 0) {
					Pontuacao.adicionaPontos(-1000);
					Controle.gameOver = 1;
				}else {
					Pontuacao.adicionaPontos(500);
					System.out.println("Parabéns guerreiro! Wumpus foi derrotado!");
					for(int i = 1; i<componentes.length; i++) {
						componentes[i-1] = componentes[i];
					}
				}
			}else {
				Pontuacao.adicionaPontos(-1000);
				Controle.gameOver = 1;
			}
		}
		componentes[componentes.length] = p;
		p.tiraFlecha();
	}
	
	
	
}
