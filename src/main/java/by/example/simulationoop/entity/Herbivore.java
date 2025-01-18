package by.example.simulationoop.entity;

import by.example.simulationoop.simulation.MapSimulation;

/**
 * Травоядное, наследуется от Creature. Стремятся найти ресурс (траву), может потратить свой ход на
 * движение в сторону травы, либо на её поглощение.
 */
public class Herbivore extends Creature {//травоядное
  private int eatingDuration; // Длительность поедания
  private int eatingCounter; // Счетчик для отслеживания времени поедания
  private int immobileCounter; // Счетчик для отслеживания времени бездействия
  private static final int IMMOBILE_DURATION = 10; // Длительность бездействия перед смертью
private static final int EATING_DURATION = 3; // Длительность поедания
  public Herbivore(int speed, int hp) {
    super(speed, hp);
    this.eatingDuration = EATING_DURATION; // Будет есть 3 "кадра"
    this.eatingCounter = 0; // Изначально не ест
    this.immobileCounter = 0; // Изначально не двигается
  }

  @Override
  public void makeMove(MapSimulation map) {
    if(immobileCounter > 0) {
      // Если травоядное не двигается, уменьшаем счетчик
      immobileCounter--;
      System.out.println(this + " стоит на месте, осталось " + immobileCounter + " кадров.");
      if (immobileCounter == 0) {
        // Если время бездействия закончилось, умираем
        System.out.println(this + " умерло.");
        map.removeEntity(this); // Удаление из карты
      }
      return; // Пропускаем движение
    }
    if (eatingCounter > 0) {
      // Если травоядное ест, уменьшаем счетчик
      eatingCounter--;
      return; // Пропускаем движение, пока ест
    }

    // Уменьшаем силу на 3 за каждое перемещение, если не едим
    setHp(getHp() - 3);
    System.out.println(this + " пошевелился и потерял силы " + getHp());

    // Проверяем, не достигло ли здоровье нуля
    if (getHp() <= 0) {
      // Начинаем отсчет времени бездействия
      immobileCounter = IMMOBILE_DURATION;
      System.out.println(this + " не осталось сил и теперь бездействует.");
      return; // Прекращаем выполнение метода
    }

    // Проверяем, есть ли трава на текущей позиции
    for (EntitySimulation entity : map.getEntities()) {
      if (entity instanceof Grass && entity.getX() == this.getX() && entity.getY() == this.getY()) {
        // Если находим траву, начинаем есть
        eatingCounter = eatingDuration; // Устанавливаем время поедания
        increaseStrength(); // Увеличиваем силу
        return; // Прекращаем выполнение метода
      }
    }
    super.makeMove(map); // вызываем метод родительского класса
  }
  private void increaseStrength() {
    // Увеличиваем силу травоядного (предположим, что сила - это hp для простоты)
    setHp(getHp() + 10);
    System.out.println(this + " съел траву и увеличил силу, теперь " + getHp());
  }
}
