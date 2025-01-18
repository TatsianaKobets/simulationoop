package by.example.simulationoop.simulation;

import by.example.simulationoop.config.Renderer;
import by.example.simulationoop.entity.Creature;
import by.example.simulationoop.entity.EntitySimulation;
import java.io.IOException;

/**
 * Главный класс приложения, включает в себя: Карта Счётчик ходов Рендерер поля Actions - список
 * действий, исполняемых перед стартом симуляции или на каждом ходу
 * <p>
 * Этот класс представляет собой главный класс приложения, который включает в себя карту, счётчик
 * ходов, рендерер поля и список действий. Мы можем добавлять действия перед стартом симуляции и на
 * каждом ходу.
 */
public class Simulation {

  private MapSimulation map;
  private Renderer renderer;

  public Simulation(MapSimulation map, Renderer renderer) {
    this.map = map;
    this.renderer = renderer;
  }

  public void startSimulation() throws IOException {
    while (true) {
      // Обновляем позиции существ
      for (EntitySimulation entity : map.getEntities()) {
        if (entity instanceof Creature) {
          ((Creature) entity).makeMove(map);
        }
      }

      renderer.render(map);
      try {
        Thread.sleep(1000); // Пауза между кадрами
      } catch (InterruptedException e) {
        System.out.println("Ошибка паузы");
      }
    }
  }
}