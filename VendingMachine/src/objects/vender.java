package objects;



public class vender {
	private String [][] inventory;
	
	
	
		public vender() {
			
			
		}
		public void setInventory(String[][] inventory) {
			this.inventory = inventory;
		}
		
		
		public double checkPrice(int productNumber){
			return Double.parseDouble( inventory[productNumber][2]);
		}
		public boolean checkAvailability(int i) {
			
	
			return (Integer.parseInt(inventory[i][1]) > 0);
		}
		
		
}
