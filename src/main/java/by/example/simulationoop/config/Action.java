package by.example.simulationoop.config;

import by.example.simulationoop.simulation.MapSimulation;

/**
 * Действие, совершаемое над миром.
 *
 * Этот интерфейс представляет собой действие, которое можно выполнить над картой.
 */
public interface Action {
  void execute(MapSimulation map);
}
