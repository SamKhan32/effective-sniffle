package entity;
import java.awt.Color; 

import main.SnakeGame;
import java.awt.Graphics2D;

public class Entity {

public int x = 100;
public int y = 100;
//public String direction = "right";
public Color col = new Color(0,0,255);
public int size = 10;
public void draw(Graphics2D g2, SnakeGame sg) {
	g2.setColor(col);

	g2.fillRect(x, y , size*SnakeGame.scale, size*SnakeGame.scale);
}
public void grow() {
	size+=10;
}
}
