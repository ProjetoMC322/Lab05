package pt.c40task.l05wumpus;
import java.util.Scanner;

public class AppWumpus {
   private static Heroi heroi;
	
   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void conectaHeroi(Heroi p) {
	   heroi = p;
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      String cave[][] = tk.retrieveCave();
      Montador montador = new Montador();
      Caverna caverna = new Caverna();
      caverna = montador.montaCaverna(cave);
      
      Controle controlador = new Controle(heroi, caverna, tk);
      caverna.mostraJogo(tk, 0, 0, 0);
      String movements = tk.retrieveMovements();
      if(movements.equalsIgnoreCase("")) {
    	  System.out.println("Utilizando teclado, entre com o nome do seu jogador:");
    	  Scanner keyboard = new Scanner(System.in);
  		  Pontuacao.setNome(keyboard.nextLine());
  		  System.out.println("Nome gravado! Insira os comandos:");
    	  controlador.leTeclado();
      }else {
    	  controlador.leArquivo(movements);
      }
      tk.stop();
   }

}
