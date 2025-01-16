package by.example.simulationoop.config;

import by.example.simulationoop.entity.Creature;
import by.example.simulationoop.entity.EntitySimulation;
import by.example.simulationoop.entity.Grass;
import by.example.simulationoop.entity.Herbivore;
import by.example.simulationoop.entity.MapSimulation;
import by.example.simulationoop.entity.Predator;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import java.io.IOException;

/**
 * Рендерер ответственен за визуализацию состояния поля.
 * <p>
 * Этот интерфейс представляет собой рендерер, который ответственен за визуализацию состояния поля.
 */
public class Renderer {

  private Screen screen;

  public Renderer() throws IOException {
    DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
    screen = terminalFactory.createScreen();
    screen.startScreen();
  }

  public void render(MapSimulation map) throws IOException {
    if (map != null) {
      TextGraphics graphics = screen.newTextGraphics();
      for (int i = 0; i < map.getHeight(); i++) {
        for (int j = 0; j < map.getWidth(); j++) {
          boolean entityFound = false;
          for (EntitySimulation entity : map.getEntities()) {
            if (entity.getX() == j && entity.getY() == i) {
              if (entity instanceof Grass) {
                graphics.putString(j, i, "G"); // выводим траву
              } else if (entity instanceof Creature) {
                graphics.putString(j, i, "E"); // выводим животное
                if (entity instanceof Herbivore) {
                  graphics.putString(j, i, "H"); // выводим травоядное
                } else if (entity instanceof Predator) {
                  graphics.putString(j, i, "P"); // выводим хищника
                }
              }
              entityFound = true;
              break;
            }
          }
          if (!entityFound) {
            graphics.setForegroundColor(TextColor.ANSI.DEFAULT);
            graphics.putString(j, i, "."); // выводим пустую клетку
          }
        }
      }
      screen.refresh();
    }
  }
}