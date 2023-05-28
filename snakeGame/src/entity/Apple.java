package entity;
import java.awt.Color; 
import main.Main;
import main.SnakeGame;
import java.util.HashMap;
public class Apple extends Entity{
public boolean isTouched = false;

private SnakeGame snakeGame;
//HashMap<String, int> snakeDim = new HashMap<String,int>();
public Apple(SnakeGame snakeGame) {
	col = new Color(255,0,0);
	randomize();
	this.snakeGame = snakeGame;
	 
}

public void isTouched() {
	//write up collision
	for(int i =0; i< snakeGame.fullSnake.length; i++) {
		int snakeX = snakeGame.fullSnake[i].x;
		int snakeY = snakeGame.fullSnake[i].y;
		//System.out.println("isTouched Running");
		if((snakeX >= x && snakeX <= x+20) && (snakeY >=y && snakeY <=y+20)) {
			System.out.println("TOUCHED");
			snakeGame.fullSnake = main.SnakeRemaking.growth(snakeGame.fullSnake);
			randomize();
		}
	}
}

private void randomize() {
	this.x  = (int)(Math.random() * SnakeGame.screenWidth-20)+ (20);
	this.y =(int)(Math.random() * SnakeGame.screenHeight-20)+ (20);
	
}

public void update() {
	// int pixel = snakeGame.getGreen(x,y);
	
	isTouched();
	
}

}
