package by.example.simulationoop.config;

import by.example.simulationoop.entity.MapSimulation;

/**
 * Рендерер ответственен за визуализацию состояния поля.
 *
 * Этот интерфейс представляет собой рендерер, который ответственен за визуализацию состояния поля.
 */
public interface Renderer {
  void render(MapSimulation map);
}