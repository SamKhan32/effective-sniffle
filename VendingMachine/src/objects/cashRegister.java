package objects;

public class cashRegister {
	private int quarters = 100;
	private double cashRecieved = 0.0;

	public cashRegister() {
		
	}
	public int getQuarters() {
		return quarters *4;
	}
	public void setQuarters(int quarters) {
		this.quarters = quarters/4 + quarters%4;
	}
	public double calculateChange(double productCost) {
		double change = 0;
		
		if(    quarters * 4 < productCost       ) {
			System.out.println("Not enough quarters to return change. Please contact maintence"); 
		} else {
			change = cashRecieved - productCost;
		}
		
		return change;
	}
	public double getCashRecieved() {
		return cashRecieved;
	}
	public void setCashRecieved(double cashRecieved) {
		this.cashRecieved = cashRecieved;
	}
	
}
