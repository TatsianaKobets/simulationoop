package by.example.simulationoop;

import by.example.simulationoop.config.Renderer;
import by.example.simulationoop.simulation.MapSimulation;
import by.example.simulationoop.simulation.Simulation;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    MapSimulation map = new MapSimulation(20, 20);
    // Добавляем случайные объекты на карту
    for (int i = 0; i < 10; i++) {
      map.addRandomHerbivore();
      map.addRandomPredator();
      map.addRandomGrass();
      map.addRandomTree(); // добавляем случайное дерево
      map.addRandomRock(); // добавляем случайный камень
    }

    Renderer renderer = new Renderer();
    if (map != null && renderer != null) {
      Simulation simulation = new Simulation(map, renderer);
      simulation.startSimulation();
    }
  }
}
