package by.example.simulationoop.simulation;

import by.example.simulationoop.entity.Creature;
import by.example.simulationoop.entity.EntitySimulation;
import by.example.simulationoop.entity.Grass;
import by.example.simulationoop.entity.Herbivore;
import by.example.simulationoop.entity.Predator;
import by.example.simulationoop.entity.Rock;
import by.example.simulationoop.entity.Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Карта, содержит в себе коллекцию для хранения существ и их расположения.
 * <p>
 * Этот класс представляет собой карту, на которой будут располагаться существа и объекты. Мы
 * используем список для хранения сущностей, а также сохраняем размеры карты.
 */
public class MapSimulation {

  private List<EntitySimulation> entities;
  private int width;
  private int height;
  private Random random;

  public MapSimulation(int width, int height) {
    this.width = width;
    this.height = height;
    this.entities = new ArrayList<>();
    this.random = new Random();
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

  public void addRandomHerbivore() {
    int x = random.nextInt(width);
    int y = random.nextInt(height);
    Creature creature = new Herbivore(1, 10); // создаем новый экземпляр Herbivore
    creature.setX(x);
    creature.setY(y);
    entities.add(creature);
  }
  public void addRandomPredator() {
    int x = random.nextInt(width);
    int y = random.nextInt(height);
    Creature creature = new Predator(1, 10, 10); // создаем новый экземпляр Herbivore
    creature.setX(x);
    creature.setY(y);
    entities.add(creature);
  }

  public void addRandomGrass() {
    int x = random.nextInt(width);
    int y = random.nextInt(height);
    Grass grass = new Grass();
    grass.setX(x);
    grass.setY(y);
    entities.add(grass);
  }
  public void addRandomTree() {
    int x = random.nextInt(width);
    int y = random.nextInt(height);
    Tree tree = new Tree();
    tree.setX(x);
    tree.setY(y);
    entities.add(tree);
  }

  public void addRandomRock() {
    int x = random.nextInt(width);
    int y = random.nextInt(height);
    Rock rock = new Rock();
    rock.setX(x);
    rock.setY(y);
    entities.add(rock);
  }
}