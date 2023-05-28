package main;

public class SnakeMethods {
	public static void snakeTouch(SnakeGame sg) {
		//sg = new SnakeGame();
		

		for(int i =1; i<sg.fullSnake.length; i++) {
			if(sg.fullSnake[0].x == sg.fullSnake[i].x && sg.fullSnake[0].y == sg.fullSnake[i].y) {
				System.out.println("YOU LOSE");
				System.exit(0);
				
			}
		}
	}
}
