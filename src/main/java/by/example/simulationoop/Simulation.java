package by.example.simulationoop;

import by.example.simulationoop.config.Action;
import by.example.simulationoop.config.Renderer;
import by.example.simulationoop.entity.MapSimulation;
import java.util.ArrayList;
import java.util.List;

/**
 * Главный класс приложения, включает в себя:
 * Карта
 * Счётчик ходов
 * Рендерер поля
 * Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу
 *
 * Этот класс представляет собой главный класс приложения, который включает в себя карту, счётчик ходов, рендерер поля и список действий.
 * Мы можем добавлять действия перед стартом симуляции и на каждом ходу.
 */
public class Simulation {
  private MapSimulation map;
  private int turnCounter;
  private Renderer renderer;
  private List<Action> initActions;
  private List<Action> turnActions;

  public Simulation(MapSimulation map, Renderer renderer) {
    this.map = map;
    this.renderer = renderer;
    this.turnCounter = 0;
    this.initActions = new ArrayList<>();
    this.turnActions = new ArrayList<>();
  }

  public void nextTurn() {
    // Выполнить действия перед стартом симуляции
    for (Action action : initActions) {
      action.execute(map);
    }

    // Выполнить действия на каждом ходу
    for (Action action : turnActions) {
      action.execute(map);
    }

    // Увеличить счётчик ходов
    turnCounter++;

    // Отрисовать поле
    renderer.render(map);
  }

  public void startSimulation() {
    while (true) {
      nextTurn();
    }
  }

  public void pauseSimulation() {
    // TODO: реализовать паузу симуляции
  }

  public void addInitAction(Action action) {
    initActions.add(action);
  }

  public void addTurnAction(Action action) {
    turnActions.add(action);
  }
}
