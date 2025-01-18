package by.example.simulationoop.entity;

import by.example.simulationoop.simulation.MapSimulation;

/**
 * Хищник, наследуется от Creature.
 * В дополнение к полям класса Creature, имеет силу атаки.
 */
public class Predator extends Creature {//хищник
  private int attackPower;// Сила атаки хищника

  public Predator(int speed, int hp, int attackPower) {
    super(speed, hp);
    this.attackPower = attackPower;
  }

  public int getAttackPower() {
    return attackPower;
  }

  @Override
  public void makeMove(MapSimulation map) {
    super.makeMove(map); // вызываем метод родительского класса
  }

  // Метод для атаки травоядного
  public void attack(Creature prey) {
    System.out.println(this + " attacks " + prey.getClass().getSimpleName() + " for " + attackPower + " damage.");
    prey.takeDamage(attackPower); // Применяем урон к жертве
  }
}
