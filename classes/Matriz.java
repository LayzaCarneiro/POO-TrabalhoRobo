package classes;

public class Matriz {
    private String[][] position = new String[5][5];

    public Matriz(){
      matrizBase();
    }

    public void matrizBase(){
      for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
          position[i][j] = "-";
        }
      }
    }

    public void tela(int roboX, int roboY, String color, int alimentoX, int alimentoY){
      System.out.println();
      for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
          if(i == roboX && j == roboY){
            if (color.equals("vermelho")){
              System.out.print("\u001B[31m$ \u001B[0m");
            }
            else if (color.equals("verde")){
              System.out.print("\u001B[32m$ \u001B[0m");
            }
            else if (color.equals("amarelo")){
              System.out.print("\u001B[33m$ \u001B[0m");
            }
            else if (color.equals("roxo")){
              System.out.print("\u001B[35m$ \u001B[0m");
            }
            else if (color.equals("ciano")){
              System.out.print("\u001B[36m$ \u001B[0m");
            }
          }
          else if(i == alimentoX && j == alimentoY){
            System.out.print("0 ");
          }
          else{
            System.out.print("- ");
          }
        }
        System.out.println();
      }
    }

    public void telaRandom(int roboX, int roboY, String color1, String color2, int robo2X, int robo2Y, int alimentoX, int alimentoY){
      System.out.println();
      for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
          if (i == robo2X && i == roboX && j == robo2Y && j == roboY){
            System.out.print("$# ");
          }

          else if(i == roboX && j == roboY){
            if (color1.equals("vermelho")){
              System.out.print("\u001B[31m$  \u001B[0m");
            }
            else if (color1.equals("verde")){
              System.out.print("\u001B[32m$  \u001B[0m");
            }
            else if (color1.equals("amarelo")){
              System.out.print("\u001B[33m$  \u001B[0m");
            }
            else if (color1.equals("roxo")){
              System.out.print("\u001B[35m$  \u001B[0m");
            }
            else if (color1.equals("ciano")){
              System.out.print("\u001B[36m$  \u001B[0m");
            }
          }

          else if (i == robo2X && j == robo2Y){
            if (color2.equals("vermelho")){
              System.out.print("\u001B[31m#  \u001B[0m");
            }
            else if (color2.equals("verde")){
              System.out.print("\u001B[32m#  \u001B[0m");
            }
            else if (color2.equals("amarelo")){
              System.out.print("\u001B[33m#  \u001B[0m");
            }
            else if (color2.equals("roxo")){
              System.out.print("\u001B[35m#  \u001B[0m");
            }
            else if (color2.equals("ciano")){
              System.out.print("\u001B[36m#  \u001B[0m");
            }
          }
          else if(i == alimentoX && j == alimentoY){
            System.out.print("0  ");
          }
          else{
            System.out.print("-  ");
          }
        }
        System.out.println();
      }
      System.out.println();
    }
}
