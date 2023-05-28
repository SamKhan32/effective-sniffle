package main;

import entity.Snake;

public class SnakeRemaking {
 
 public static Snake[] snakeRemake(Snake[] arr) {
	 Snake[] newArr = new Snake[arr.length];
	 newArr[0] = arr[arr.length-1];
	 for(int i =1, a =0; i< arr.length; i++, a++) {
		 newArr[i] = arr[a];
	 }
	 
	 return newArr;
	 
 }
 public static Snake[] growth(Snake[]arr) {
	 Snake[] newArr = new Snake[arr.length+1];
	 
	 
	 for(int i =0; i< arr.length;i++) {
		 newArr[i] =arr[i];
	 }
	 newArr[newArr.length-1] = new Snake(main.SnakeGame.keyH, false);
	
	return newArr;
	 
 }
}
