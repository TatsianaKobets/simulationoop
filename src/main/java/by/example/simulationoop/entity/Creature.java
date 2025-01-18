package by.example.simulationoop.entity;

import by.example.simulationoop.simulation.MapSimulation;

/**
 * Абстрактный класс, наследуется от Entity.
 * Существо, имеет скорость (сколько клеток может пройти за 1 ход), количество HP.
 */
public abstract class Creature extends EntitySimulation { //живое существо
  private int speed;
  private int hp; //Количество здоровья (HP)

  public Creature(int speed, int hp) {
    this.speed = speed;
    this.hp = hp;
  }

  public int getSpeed() {
    return speed;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public void makeMove(MapSimulation map) {
    // Генерируем случайное направление для движения
    int dx = (int) (Math.random() * (2 * speed + 1)) - speed; // от -speed до speed
    int dy = (int) (Math.random() * (2 * speed + 1)) - speed; // от -speed до speed

    // Обновляем координаты
    int newX = getX() + dx;
    int newY = getY() + dy;

    // Проверяем границы карты
    if (newX >= 0 && newX < map.getWidth() && newY >= 0 && newY < map.getHeight()) {
      setX(newX);
      setY(newY);
    }
  }

  public void takeDamage(int damage) {
    this.hp -= damage; // Уменьшаем HP на величину урона
    if (this.hp <= 0) {
      this.die(); // Если HP <= 0, существу следует "умереть"
    }
  }

  private void die() {
    System.out.println(this + " has died."); // Логика смерти существа
  }
}
