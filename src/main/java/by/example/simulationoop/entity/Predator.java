package by.example.simulationoop.entity;

/**
 * Хищник, наследуется от Creature.
 * В дополнение к полям класса Creature, имеет силу атаки.
 */
public class Predator extends Creature {//хищник
  private int attackPower;

  public Predator(int speed, int hp, int attackPower) {
    super(speed, hp);
    this.attackPower = attackPower;
  }

  public int getAttackPower() {
    return attackPower;
  }

  @Override
  public void makeMove() {

  }

  public void attack(Herbivore herbivore) {
    herbivore.setHp(herbivore.getHp() - attackPower);
    if (herbivore.getHp() <= 0) {

    }
  }
}
