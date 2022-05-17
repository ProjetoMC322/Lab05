package pt.c40task.l05wumpus;

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
}
