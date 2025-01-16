package by.example.simulationoop.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Карта, содержит в себе коллекцию для хранения существ и их расположения.
 *
 * Этот класс представляет собой карту, на которой будут располагаться существа и объекты.
 * Мы используем список для хранения сущностей, а также сохраняем размеры карты.
 */
public class MapSimulation {
  private List<EntitySimulation> entities;
  private int width;
  private int height;

  public MapSimulation(int width, int height) {
    this.width = width;
    this.height = height;
    this.entities = new ArrayList<>();
  }

  public void addEntity(EntitySimulation entity) {
    entities.add(entity);
  }

  public List<EntitySimulation> getEntities() {
    return entities;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}