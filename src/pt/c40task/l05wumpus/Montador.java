package pt.c40task.l05wumpus;

public class Montador {
	private int n_ouro = 0, n_wumpus = 0, n_heroi = 0, n_buracos = 0;
	private Caverna caverna = new Caverna();
	public Caverna montaCaverna(String cave[][]) {
		for (int i = 0; l < cave.length; i++) {
	         for (int j = 0; c < cave[i].length; j++) {
	        	 if(cave[i].charAt(j) == 'O') {
	        		 n_ouro++;
	        		 caverna.conecta(new Ouro(Integer.parseInt(cave[i].substring(0,1)), Integer.parseInt(cave[i].substring(1,2)), 'O'), Integer.parseInt(cave[i].substring(0,1)), Integer.parseInt(cave[i].substring(1,2)));
	        	 }
	        	 else if(cave[i].charAt(j) == 'B') {
	        		 n_buracos++;
	        		 caverna.conecta(new Buraco(Integer.parseInt(cave[i].substring(0,1)), Integer.parseInt(cave[i].substring(1,2)), 'B'), Integer.parseInt(cave[i].substring(0,1)), Integer.parseInt(cave[i].substring(1,2)));
	        	}
	        	 else if(cave[i].charAt(j) == 'W') {
	        		 n_wumpus++;
	        		 caverna.conecta(new Wumpus(Integer.parseInt(cave[i].substring(0,1)), Integer.parseInt(cave[i].substring(1,2)), 'W'), Integer.parseInt(cave[i].substring(0,1)), Integer.parseInt(cave[i].substring(1,2)));
	        	}
	        	 else if(cave[i].charAt(j) == 'P') {
	        		 n_heroi++;
	        		 //faz condição de se em 1,1 ; devolve null
	        		 //caverna.conecta(new Componente(Integer.parseInt(cave[i].substring(0,1)), Integer.parseInt(cave[i].substring(1,2)), 'O'))
	        	 }
	         }     
	    }
		if(n_ouro == 1 && n_heroi == 1 && n_wumpus == 1 && n_buracos> 1 && n_buracos < 4) {
			return caverna;
		}else {
			return null;
		}
	}
}
