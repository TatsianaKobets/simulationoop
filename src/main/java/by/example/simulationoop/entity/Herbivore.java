package by.example.simulationoop.entity;

import by.example.simulationoop.simulation.MapSimulation;

/**
 * Травоядное, наследуется от Creature. Стремятся найти ресурс (траву), может потратить свой ход на
 * движение в сторону травы, либо на её поглощение.
 */
public class Herbivore extends Creature {//травоядное

  public Herbivore(int speed, int hp) {
    super(speed, hp);
  }

  @Override
  public void makeMove(MapSimulation map) {
    super.makeMove(map); // вызываем метод родительского класса
  }

}
