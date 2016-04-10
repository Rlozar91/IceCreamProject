package Ice;

public class Calculator {

	private double iceCreamPrice = 1.50;
	private double syrupPrice = 0.75;
	private double nutsPrice = 0.50;
	private double cherriesPrice = 0.50;
	private double price;
	private double tax = 0.06;
	private double taxCost;
	private double totalPrice;

	boolean vanilla;
	boolean chocolate;
	boolean strawberry;
	boolean chocolateSyrup;
	boolean caramelSyrup;
	boolean nuts;
	boolean cherries;

	public boolean isCaramelSyrup() {
		return caramelSyrup;
	}

	public void setCaramelSyrup(boolean caramelSyrup) {
		this.caramelSyrup = caramelSyrup;
	}

	public boolean isVanilla() {
		return vanilla;
	}

	public void setVanilla(boolean vanilla) {
		this.vanilla = vanilla;
	}

	public boolean isChocolate() {
		return chocolate;
	}

	public void setChocolate(boolean chocolate) {
		this.chocolate = chocolate;
	}

	public boolean isStrawberry() {
		return strawberry;
	}

	public void setStrawberry(boolean strawberry) {
		this.strawberry = strawberry;
	}

	public boolean isChocolateSyrup() {
		return chocolateSyrup;
	}

	public void setChocolateSyrup(boolean chocolateSyrup) {
		this.chocolateSyrup = chocolateSyrup;
	}

	public boolean isNuts() {
		return nuts;
	}

	public void setNuts(boolean nuts) {
		this.nuts = nuts;
	}

	public boolean isCherries() {
		return cherries;
	}

	public void setCherries(boolean cherries) {
		this.cherries = cherries;
	}

	public void calculate() {
		if (vanilla == true || chocolate == true || strawberry == true) {
			price += iceCreamPrice;
		}
		if (chocolateSyrup == true || caramelSyrup == true) {
			price += syrupPrice;
		}
		if (nuts == true) {
			price += nutsPrice;
		}
		if (cherries == true) {
			price += cherriesPrice;
		}

	}

	public void calculateTotalPrice() {
		taxCost = price * tax;
		totalPrice = price + taxCost;
	}

	public double getPrice() {
		return price;
	}

	public double getTaxCost() {
		return taxCost;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

}
