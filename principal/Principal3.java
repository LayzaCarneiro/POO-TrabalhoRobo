package principal;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import classes.Alimento;
import classes.Matriz;
import classes.Robo;
import classes.RoboInteligente;

import java.util.Random;

import exception.MovimentoInvalidoException;


public class Principal3 {
  public static void main(String[] args) throws InterruptedException, MovimentoInvalidoException{
    Scanner entrada = new Scanner(System.in);

    System.out.println("\nOlá, seja bem-vindo ao nosso jogo. O objetivo é fazer os robôs encontrarem o alimento." +
                        "\nEles estão na posição (0,0). Espere até os dois encontrarem o alimento!");
    System.out.print("\nEscolha a cor do robô normal: vermelho // verde // amarelo // roxo // ciano >>  ");
    String cor = entrada.nextLine();
    System.out.print("Escolha a cor do robô inteligente: vermelho // verde // amarelo // roxo // ciano >>  ");
    String corI = entrada.nextLine();
    Robo roboNormal = new Robo(cor);
    Robo roboInteligente = new RoboInteligente(corI);

    if ((!cor.equals("vermelho")) && (!cor.equals("verde")) && (!cor.equals("amarelo")) && (!cor.equals("ciano")) && (!cor.equals("roxo"))){
      System.out.println("\nATENÇÃO. Execute o programa novamente. \nA cor escolhida para o ROBÔ NORMAL deve estar entre: vermelho // verde // amarelo // roxo // ciano\n");
      System.exit(0);
    }
    if ((!corI.equals("vermelho")) && (!corI.equals("verde")) && (!corI.equals("amarelo")) && (!corI.equals("ciano")) && (!corI.equals("roxo"))){
      System.out.println("\nATENÇÃO. Execute o programa novamente. \nA cor escolhida para o ROBÔ INTELIGENTE deve estar entre: vermelho // verde // amarelo // roxo // ciano\n");
      System.exit(0);
    }

    System.out.print("\nInforme a posição do alimento: " + "\nCoordenada X = ");
    int alimentoX = entrada.nextInt();
    System.out.print("Coordenada Y = ");
    int alimentoY = entrada.nextInt();
    Alimento alimento = new Alimento(alimentoX, alimentoY);

    if ((alimentoX < 0 || alimentoX > 5) || (alimentoY < 0 || alimentoY > 5)){
      System.out.println("\nATENÇÃO. Execute o programa novamente. As coordenadas do alimento devem estar entre 0 e 4.\n");
      System.exit(0);
    }

    Matriz tela = new Matriz();
    Random random = new Random();
    Boolean erro;
    Boolean inteligente = false;
    Boolean normal = false;

    tela.telaRandom(roboInteligente.getX(), roboInteligente.getY(), corI, cor, roboNormal.getX(), roboNormal.getY(), alimento.getAlimentoX(), alimento.getAlimentoY());
    while(inteligente == false || normal == false){
      if(roboInteligente.AlimentoEncontrado(alimentoX, alimentoY)) {inteligente = true;}
      if(roboNormal.AlimentoEncontrado(alimentoX, alimentoY)) {normal = true;}
      try{
        erro = false;
        if(inteligente == false){
          TimeUnit.SECONDS.sleep(1);
          System.out.print("\nMovimento a ser executado pelo robô inteligente: ");
          TimeUnit.SECONDS.sleep(1);
          int numero = random.nextInt(1, 4);
          roboInteligente.mover(numero);
          tela.telaRandom(roboInteligente.getX(), roboInteligente.getY(), corI, cor, roboNormal.getX(), roboNormal.getY(), alimento.getAlimentoX(), alimento.getAlimentoY());
        }
      } catch(MovimentoInvalidoException exc){
        erro = true;
        System.out.println();
        System.out.println(exc);
      } try {
        if(normal == false){
          TimeUnit.SECONDS.sleep(1);
          System.out.print("\nMovimento a ser executado pelo robô normal: ");
          TimeUnit.SECONDS.sleep(1);
          int numero2 = random.nextInt(1, 4);
          roboNormal.mover(numero2);
          tela.telaRandom(roboInteligente.getX(), roboInteligente.getY(), corI, cor, roboNormal.getX(), roboNormal.getY(), alimento.getAlimentoX(), alimento.getAlimentoY());
        }
      } catch(MovimentoInvalidoException exc){
        System.out.println();
        System.out.println(exc);
      } if(erro == true){
        TimeUnit.SECONDS.sleep(1);
        System.out.print("\nMovimento a ser executado pelo robô inteligente: ");
        roboInteligente.mover(roboInteligente.getNextMove());
        TimeUnit.SECONDS.sleep(1);
        tela.telaRandom(roboInteligente.getX(), roboInteligente.getY(), corI, cor, roboNormal.getX(), roboNormal.getY(), alimento.getAlimentoX(), alimento.getAlimentoY());
        try{
          if(normal == false){
            TimeUnit.SECONDS.sleep(1);
            System.out.print("\nMovimento a ser executado pelo robô normal: ");
            TimeUnit.SECONDS.sleep(1);
            int numero2 = random.nextInt(1,4);
            roboNormal.mover(numero2);
            tela.telaRandom(roboInteligente.getX(), roboInteligente.getY(), corI, cor, roboNormal.getX(), roboNormal.getY(), alimento.getAlimentoX(), alimento.getAlimentoY());
          }
        } catch(MovimentoInvalidoException exc){
          System.out.println();
          System.out.println(exc);
        }
      }
    }

    tela.telaRandom(roboInteligente.getX(), roboInteligente.getY(), corI, cor, roboNormal.getX(), roboNormal.getY(), alimento.getAlimentoX(), alimento.getAlimentoY());
    System.out.println();
    TimeUnit.SECONDS.sleep(2);

    System.out.println("AEEEE. Os robôs conseguiram encontrar o alimento ;)");
    System.out.println("O robô " + roboInteligente.getColor() + " executou " + roboInteligente.getQtdMov() + " movimentos válidos e " + roboInteligente.getQtdMovInv() + " movimentos inválidos.");
    System.out.println("O robô " + roboNormal.getColor() + " executou " + roboNormal.getQtdMov() + " movimentos válidos e " + roboNormal.getQtdMovInv() + " movimentos inválidos.");
    System.out.println();

    entrada.close();
  }
}
