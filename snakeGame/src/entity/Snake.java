package entity;
import java.awt.Color; 

import main.KeyHandler;
import main.SnakeGame;
import main.SnakeRemaking;
import main.Main;
public class Snake extends Entity{
private int length = 1;
private int speed = 1;
private boolean badHit = false;
private KeyHandler keyH;
public String prevDir = "";
private boolean isHead = false;
	public Snake(KeyHandler keyH, boolean isHead) {
		col = new Color(0,255,0);
		this.keyH = keyH;
		this.isHead = isHead;
		
	}
	
	public void update(SnakeGame sg,String direction) { // I think this update method is incorrect. The last snake - let's make this isBottom = true, should be the one being moved infront of fullsnake[0]; but how do we access [0]? and then we do snakeRemake() 
	
	
	//	prevDir = direction;
		// this causes weird step like movements
		if(direction.compareTo("right") == 0) {
			x = 20 + sg.fullSnake[    0    ].x;
			y = sg.fullSnake[    0    ].y;
			
}
		else if(direction.compareTo("left") ==0) {
			x = -20 + sg.fullSnake[    0    ].x;
			y = sg.fullSnake[    0    ].y;		}
		else if(direction.compareTo("up") ==0) {
			y = -20 + sg.fullSnake[    0    ].y;
			x = sg.fullSnake[0].x;
			
		}
		else if(direction.compareTo("down") ==0) {
			y = 20 + sg.fullSnake[0].y;
			x = sg.fullSnake[0].x;
		}
	//	System.out.println(direction);
		sg.fullSnake = SnakeRemaking.snakeRemake(sg.fullSnake);
		touchingWall(sg);
	//	sg.fullSnake[0].direction = prevDir;
		}

	private void touchingWall(SnakeGame sg) {
		// TODO Auto-generated method stub
		if(sg.fullSnake[0].x <0 || ( sg.fullSnake[0].y> main.SnakeGame.screenHeight) || sg.fullSnake[0].x > main.SnakeGame.screenWidth || sg.fullSnake[0].y <0) {
			System.out.println("Out of Bounds");
			System.exit(0);
		}
		
	}
	
	
	
	
	
}
