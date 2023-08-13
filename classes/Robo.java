package classes;

import exception.MovimentoInvalidoException;

public class Robo {
  protected int x, y;
  protected String color;
  protected int qtdMov = 0;
  protected int qtdMovInv = 0;
  protected int nextMove;

  public Robo(String color){
    this.color = color;
    this.x = 4;
    this.y = 0;
    this.nextMove = 0;
  }

  public void mover(String movement) throws MovimentoInvalidoException{
    if(movement.equals("up")){
      if(x - 1 < 0) throw new MovimentoInvalidoException();
      x--;
    }
    else if(movement.equals("down")){
      if(x + 1 >= 5) throw new MovimentoInvalidoException();
      x++;
    }
    else if(movement.equals("right")){
      if(y + 1 >= 5) throw new MovimentoInvalidoException();
      y++;
    }
    else if(movement.equals("left")){
      if(y - 1 < 0) throw new MovimentoInvalidoException();
      y--;
    }
  }

  public void mover(int movement) throws MovimentoInvalidoException{
    if(movement == 1){
      if(this.x - 1 < 0){
        qtdMovInv++;
        throw new MovimentoInvalidoException();
      }
      this.x--;
      qtdMov++;
    }
    else if(movement == 2){
      if(this.x + 1 >= 5){
        qtdMovInv++;
        throw new MovimentoInvalidoException();
      }
      this.x++;
      qtdMov++;
    }
    else if(movement == 3){
      if(this.y + 1 >= 5){
        qtdMovInv++;
        throw new MovimentoInvalidoException();
      }
      this.y++;
      qtdMov++;
    }
    else if(movement == 4){
      if(this.y - 1 < 0){
        qtdMovInv++;
        throw new MovimentoInvalidoException();
      }
      this.y--;
      qtdMov++;
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

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getNextMove() {
    return nextMove;
  }

  public int getQtdMov() {
    return qtdMov;
  }

  public int getQtdMovInv() {
    return qtdMovInv;
  }
}
