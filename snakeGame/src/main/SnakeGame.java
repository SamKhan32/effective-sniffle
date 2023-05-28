package main;

import java.awt.Color;  
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.Apple;
import entity.Snake;
public class SnakeGame extends JPanel implements Runnable{
	
	static int originalTileSize = 10;
	public static int scale = 2;
	final static int tileSize = originalTileSize *scale;
	final static int maxScreenCol= 25; //50
	final static int maxScreenRow= 25; //40
	public final static int screenWidth = tileSize * maxScreenCol; // 
	public final static int screenHeight = tileSize * maxScreenRow; // 
	public String direction = "right";
	int centerX = (screenWidth/2) ;
	int centerY = (screenHeight/2) ;
	public static KeyHandler keyH = new KeyHandler();
	public Snake snake = new Snake(keyH,true);
	
	
	public Apple apple = new Apple(this);
	Thread gameThread;
	int FPS = 1;
	int FPS2 = 60; // could we make it so that it updates 60 times a second?
	int amountOfSnakes = 5;
	public Snake[] fullSnake = new Snake[amountOfSnakes];
	
	
	
	//int YtoGoTo = fullSnake[0].y + 10;  // we should have checks before hand to find out direction 
	//int XtoGoTo = fullSnake[0].x + 10; // this would be 
	
	// we could make snake 0 always the head // or just loop through and replace. Or have an invisble head at the front that trails behind
	SnakeGame() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setVisible(true);
		this.setBackground(new Color(125,177,194));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		fullSnake[0] = snake; 
		for(int i =1; i< amountOfSnakes; i++) {
			fullSnake[i] = new Snake(keyH, false);
			fullSnake[i].x = fullSnake[0].x - (20*i);
		}

	}
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	public void run() {
		
		double drawInterval = 1000000000/FPS; // 0.016 repeating second drawTime, or 60 repeats per second
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		while(gameThread != null) {
			//System.out.println("Game running");
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime; 
			if(delta >=1) {
			update(); // we aren't really updating anything but good form?
			repaint(); // the most important feature, this will control how much the characters bob up and down
			delta--;
			}
		
		}
	}

	public void update() {
	if(keyH.rightPressed == true) {
			
			direction = "right";           
		
		}
		if(keyH.downPressed == true) {
			
			direction = "down";
		
		}
		else if(keyH.upPressed == true) {
	
			direction = "up";
			
			
		}
		else if(keyH.leftPressed == true) {
	
			direction = "left";
	
		
		}
		main.SnakeMethods.snakeTouch(this);
	fullSnake[fullSnake.length-1].update(this,direction);
	
	apple.update();
	
		
	}
	

public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	Graphics2D g2 = (Graphics2D)g;
	for(int i =0; i< fullSnake.length; i++) {
	fullSnake[i].draw(g2,this);
	}
	
	apple.draw(g2,this);
	
	
	
	
	g2.dispose();
	
	
}

}
