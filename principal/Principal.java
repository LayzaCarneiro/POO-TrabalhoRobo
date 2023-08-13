package principal;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import classes.Alimento;
import classes.Matriz;
import classes.Robo;
import exception.MovimentoInvalidoException;

public class Principal {
  public static void main(String[] args) throws InterruptedException{
    Scanner entrada = new Scanner(System.in);

    System.out.println("\nOlá, seja bem-vindo ao nosso jogo. O objetivo é fazer o robô encontrar o alimento." +
                        "\nO seu robô está na posição (0,0). Mova-o até encontrar o alimento!");
    System.out.print("\nInforme a cor que deseja para o robô: vermelho // verde // amarelo // roxo // ciano >>  ");
    String cor = entrada.nextLine();
    Robo robo = new Robo(cor);

    if ((!cor.equals("vermelho")) && (!cor.equals("verde")) && (!cor.equals("amarelo")) && (!cor.equals("ciano")) && (!cor.equals("roxo"))){
      System.out.println("\nATENÇÃO. Execute o programa novamente. \nA cor escolhida deve estar entre: vermelho // verde // amarelo // roxo // ciano\n");
      System.exit(0);
    }

    System.out.print("\nInforme a posição do alimento: " + "\nCoordenada X = ");
    int alimentoX = entrada.nextInt();
    System.out.print("Coordenada Y = ");
    int alimentoY = entrada.nextInt();
    Alimento alimento = new Alimento(alimentoX, alimentoY);

    if ((alimentoX < 0 || alimentoX > 5) || (alimentoY < 0 || alimentoY > 5)){
      System.out.println();
      System.out.println("ATENÇÃO. Execute o programa novamente. As coordenadas do alimento devem estar entre 0 e 4.\n");
      System.exit(0);
    }

    Matriz tela = new Matriz();
    String movimento;

    TimeUnit.SECONDS.sleep(1);
    System.out.println("\nPara movimentar o robô digite: \n- 1 ou 'up' para movimentar para cima \n- 2 ou 'down' para movimentar para baixo \n- 3 ou 'right' para movimentar para direita \n- 4 ou 'left' para movimentar para a esquerda");
    TimeUnit.SECONDS.sleep(3);
    while(true){
      tela.tela(robo.getX(), robo.getY(), cor, alimento.getAlimentoX(), alimento.getAlimentoY());
      try{
        System.out.print("\nMovimento a ser executado: ");
        movimento = entrada.nextLine();
        if(movimento.matches("-?\\d+")) {
          int movimentoInt = Integer.parseInt(movimento);
          robo.mover(movimentoInt);
        }
        else robo.mover(movimento);
      } catch(MovimentoInvalidoException exc){
        System.out.println();
        System.out.println(exc);

      } if(robo.AlimentoEncontrado(alimentoX, alimentoY)){
        break;
      }
    }
    tela.tela(robo.getX(), robo.getY(), cor, alimento.getAlimentoX(), alimento.getAlimentoY());
    System.out.println();
    System.out.println("Você conseguiu! O robô " + robo.getColor() + " pegou o alimento ;)");
    System.out.println();

    entrada.close();
  }
}
