package by.example.simulationoop;

import by.example.simulationoop.config.Renderer;
import by.example.simulationoop.entity.MapSimulation;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    MapSimulation map = new MapSimulation(20, 20);
    for (int i = 0; i < 10; i++) {
      map.addRandomEntity();
      map.addRandomGrass();
    }

    Renderer renderer = new Renderer();
    if (map != null && renderer != null) {
      Simulation simulation = new Simulation(map, renderer);
      simulation.startSimulation();
    }
  }
}
