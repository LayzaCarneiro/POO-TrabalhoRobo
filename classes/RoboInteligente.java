package classes;

import exception.MovimentoInvalidoException;

public class RoboInteligente extends Robo {
  protected int x, y;
  protected int nextMove;

  public RoboInteligente(String color) {
    super(color);
    this.x = 4;
    this.y = 0;
    this.nextMove = 0;
  }

  public void mover(int movement) throws MovimentoInvalidoException{
    if(movement == 1){
      if(this.x - 1 <= 0){
        qtdMovInv++;
        nextMove = 2;
        throw new MovimentoInvalidoException();
      }
      qtdMov++;
      this.x--;
    }
    else if(movement == 2){
      if(this.x + 1 >= 5){
        qtdMovInv++;
        nextMove = 1;
        throw new MovimentoInvalidoException();
      }
      qtdMov++;
      this.x++;
    }
    else if(movement == 3){
      if(this.y + 1 >= 5) {
        qtdMovInv++;
        nextMove = 4;
        throw new MovimentoInvalidoException();
      }
      qtdMov++;
      this.y++;
    }
    else if(movement == 4){
      if(this.y - 1 <= 0){
        qtdMovInv++;
        nextMove = 3;
        throw new MovimentoInvalidoException();
      }
      qtdMov++;
      this.y--;
    }
  }

  public boolean AlimentoEncontrado(int alimentoX, int alimentoY){
    if(this.x == alimentoX && this.y == alimentoY){
      return true;
    }
    return false;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getNextMove() {
    return nextMove;
  }

  public void setNextMove(int nextMove) {
    this.nextMove = nextMove;
  }
}
