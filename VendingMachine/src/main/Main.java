package main;

import java.text.Format;
import java.util.Scanner;

import objects.cashRegister;
import objects.vender;

public class Main {
	static Scanner in = new Scanner(System.in);
	static cashRegister register = new cashRegister();
	static vender vender = new vender();
	public static void main(String[]args) {
	
		String[][] inventory = new String[3][3];
		System.out.print("Time to load up our inventory\nPepsi:");
		inventory[0][1] = String.valueOf(in.nextInt());
		inventory[0][2] = "2.50";
		System.out.print("Time to load up our inventory\nPeanut M&Ms:");
		inventory[1][1] = String.valueOf(in.nextInt());
		inventory[2][2] = "1.50";
		System.out.print("Time to load up our inventory\nLays Potato Chips:");
		inventory[2][1] = String.valueOf(in.nextInt());
		inventory[2][2] = "2.00";
		System.out.println("Now load of some Quarters");
		register.setQuarters(100);
		vender.setInventory(inventory);
	
System.out.print("|############################################|\r\n"
		+ "|#|                           |##############|\r\n"
		+ "|#|  =====  ..--''`  |~~``|   |##|````````|##|\r\n"
		+ "|#|  |   |  \\     |  :    |   |##| Exact  |##|\r\n"
		+ "|#|  |___|   /___ |  | ___|   |##| Change |##|\r\n"
		+ "|#|  /=__\\  ./.__\\   |/,__\\   |##| Only   |##|\r\n"
		+ "|#|  \\__//   \\__//    \\__//   |##|________|##|\r\n"
		+ "|#|===========================|##############|\r\n"
		+ "|#|```````````````````````````|##############|\r\n"
		+ "|#| =.._      +++     //////  |##############|\r\n"
		+ "|#| \\/  \\     | |     \\    \\  |#|`````````|##|\r\n"
		+ "|#|  \\___\\    |_|     /___ /  |#| _______ |##|\r\n"
		+ "|#|  / __\\\\  /|_|\\   // __\\   |#| |1|2|3| |##|\r\n"
		+ "|#|  \\__//-  \\|_//   -\\__//   |#| |4|5|6| |##|\r\n"
		+ "|#|===========================|#| |7|8|9| |##|\r\n"
		+ "|#|```````````````````````````|#| ``````` |##|\r\n"
		+ "|#| ..--    ______   .--._.   |#|[=======]|##|\r\n"
		+ "|#| \\   \\   |    |   |    |   |#|  _   _  |##|\r\n"
		+ "|#|  \\___\\  : ___:   | ___|   |#| ||| ( ) |##|\r\n"
		+ "|#|  / __\\  |/ __\\   // __\\   |#| |||  `  |##|\r\n"
		+ "|#|  \\__//   \\__//  /_\\__//   |#|  ~      |##|\r\n"
		+ "|#|===========================|#|_________|##|\r\n"
		+ "|#|```````````````````````````|##############|\r\n"
		+ "|############################################|\r\n"
		+ "|#|||||||||||||||||||||||||||||####```````###|\r\n"
		+ "|#||||||||||||PUSH|||||||||||||####\\|||||/###|\r\n"
		+ "|############################################|\r\n"
		+ "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////////\r\n"
		+ " |________________________________|%$84|___|");

		start();
		System.out.println("Have a great day!");
	}

	private static void start() {
		
		
		// TODO Auto-generated method stub
		String res ="";
		System.out.println("\nType in an action");
		while(res.equalsIgnoreCase("push") == false) {
			res= in.nextLine();
			System.out.println("RESPONSE = " + res);
			switch(res) {
				case("Select"): 
					while(true) { System.out.println("\n #############################\r\n"
+ " |  =====  ..--''`  |~~``|   |\r\n"
+ " |  |   |  \\     |  :    |   |\r\n"
+ " |  |___|   /___ |  | ___|   |\r\n"
+ " |  /=__\\  ./.__\\   |/,__\\   |\r\n"
+ " |  \\__//   \\__//    \\__//   |\r\n"
+ " |===========================|\r\n"
+ " |```````````````````````````|\r\n"
+ " | =.._      +++     //////  |\r\n"
+ " | \\/  \\     | |     \\    \\  |\r\n"
+ " |  \\___\\    |_|     /___ /  |\r\n"
+ " |  / __\\\\  /|_|\\   // __\\   |\r\n"
+ " |  \\__//-  \\|_//   -\\__//   |\r\n"
+ " |===========================|\r\n"
+ " |```````````````````````````|\r\n"
+ " | ..--    ______   .--._.   |\r\n"
+ " | \\   \\   |    |   |    |   |\r\n"
+ " |  \\___\\  : ___:   | ___|   |\r\n"
+ " |  / __\\  |/ __\\   // __\\   |\r\n"
+ " |  \\__//   \\__//  /_\\__//   |\r\n"
+ " |===========================|\r\nSelect a product");
				int responsdo = Integer.parseInt( in.nextLine());
				if(responsdo <= 9 && responsdo >0) {
					String formattedDecimal = String.format("%.2f", ( vender.checkPrice(responsdo-1)));
					System.out.println("You look closer, the price is $" + (formattedDecimal)+"\nDo you want to look around more?\nY/N");
					if(in.nextLine().equals("N")) {
						System.out.println("How much do you want to put in the machine ($1 amounts and you can do .50) ");
						register.setCashRecieved(	in.nextDouble());
						if(vender.checkAvailability(responsdo-1)) { 
						System.out.println("Your change is $" +String.format( "%.2f",register.calculateChange(vender.checkPrice(responsdo-1))));
						
						break;
					}}
					
				}
					}
				break;
			
			}
		}
		
	}
	
}
