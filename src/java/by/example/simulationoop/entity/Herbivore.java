package java.by.example.simulationoop.entity;

/**
 * Травоядное, наследуется от Creature. Стремятся найти ресурс (траву), может потратить свой ход на
 * движение в сторону травы, либо на её поглощение.
 */
public class Herbivore extends Creature {//травоядное

  public Herbivore(int speed, int hp) {
    super(speed, hp);
  }

  @Override
  public void makeMove() {
  }

}
