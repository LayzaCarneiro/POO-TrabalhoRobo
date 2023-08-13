package principal;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import classes.Alimento;
import classes.Matriz;
import classes.Robo;
import exception.MovimentoInvalidoException;

public class Principal2 {
  public static void main(String[] args) throws InterruptedException{
    Scanner entrada = new Scanner(System.in);

    System.out.println("\nOlá, seja bem-vindo ao nosso jogo. O objetivo é fazer os robôs encontrarem o alimento." +
                        "\nOs robôs estão na posição (0,0). Espere até um deles encontrar o alimento e veja quem foi o vencedor!");
    System.out.print("\nEscolha a cor do robô 1: vermelho // verde // amarelo // roxo // ciano >>  ");
    String cor1 = entrada.nextLine();
    System.out.print("Escoha a cor do robô 2: vermelho // verde // amarelo // roxo // ciano >>  ");
    String cor2 = entrada.nextLine();
    Robo robo1 = new Robo(cor1);
    Robo robo2 = new Robo(cor2);

    if ((!cor1.equals("vermelho")) && (!cor1.equals("verde")) && (!cor1.equals("amarelo")) && (!cor1.equals("ciano")) && (!cor1.equals("roxo"))){
      System.out.println("\nATENÇÃO. Execute o programa novamente. \nA cor escolhida para o ROBÔ 1 deve estar entre: vermelho // verde // amarelo // roxo // ciano\n");
      System.exit(0);
    }
    if ((!cor2.equals("vermelho")) && (!cor2.equals("verde")) && (!cor2.equals("amarelo")) && (!cor2.equals("ciano")) && (!cor2.equals("roxo"))){
      System.out.println("\nATENÇÃO. Execute o programa novamente. \nA cor escolhida para o ROBÔ 2 deve estar entre: vermelho // verde // amarelo // roxo // ciano\n");
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
    Random random = new Random();
    String vencedor = "";

    while(true){
      tela.telaRandom(robo1.getX(), robo1.getY(), cor1, cor2, robo2.getX(), robo2.getY(), alimento.getAlimentoX(), alimento.getAlimentoY());
      try{
        TimeUnit.SECONDS.sleep(1);
        System.out.print("\nPróximo movimento do robô " + robo1.getColor() + ": ");
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
        int numero1 = random.nextInt(3) + 1;
        robo1.mover(numero1);
        tela.telaRandom(robo1.getX(), robo1.getY(), cor1, cor2, robo2.getX(), robo2.getY(), alimento.getAlimentoX(), alimento.getAlimentoY());
        TimeUnit.SECONDS.sleep(1);
      } catch(MovimentoInvalidoException exc){
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("O movimento executado pelo robô " + robo1.getColor() + " foi inválido.");
      } if(robo1.AlimentoEncontrado(alimentoX, alimentoY)){
        vencedor = robo1.getColor();
        break;
      } try{
        System.out.print("\nPróximo movimento do robô " + robo2.getColor() + ": ");
        System.out.println();
        TimeUnit.SECONDS.sleep((long) 0.5);
        int numero2 = random.nextInt(3) + 1;
        robo2.mover(numero2);
      } catch(MovimentoInvalidoException exc){
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("O movimento executado pelo robô " + robo2.getColor() + " foi inválido.");
      } if(robo2.AlimentoEncontrado(alimentoX, alimentoY)){
        vencedor = robo2.getColor();
        break;
      }
    }

    tela.telaRandom(robo1.getX(), robo1.getY(), cor1, cor2, robo2.getX(), robo2.getY(), alimento.getAlimentoX(), alimento.getAlimentoY());
    System.out.println();
    TimeUnit.SECONDS.sleep(2);

    System.out.println("AEEEE. O robô " + vencedor + " conseguiu pegar o alimento ;)");
    System.out.println("O robô " + robo1.getColor() + " executou " + robo1.getQtdMov() + " movimentos válidos e " + robo1.getQtdMovInv() + " movimentos inválidos.");
    System.out.println("O robô " + robo2.getColor() + " executou " + robo2.getQtdMov() + " movimentos válidos e " + robo2.getQtdMovInv() + " movimentos inválidos.");
    System.out.println();

    entrada.close();
  }
}
