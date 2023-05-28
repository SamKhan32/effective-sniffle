package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		SnakeGame game = new SnakeGame();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.add(game);
		window.pack();
		game.startGameThread();
		game.run();
		
		
		
	}

}
