package by.example.simulationoop.entity;

/**
 * Корневой абстрактный класс для всех существ и объектов существующих в симуляции.
 */
public class EntitySimulation {
  private int x;
  private int y;

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
}