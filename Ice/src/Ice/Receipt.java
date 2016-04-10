package Ice;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Receipt extends Calculator {

	private String iceCreamString;
	private String scoopsString;
	private String syrupString;
	private String nutsString;
	private String cherriesString;
	private double totalPrice;
	private DecimalFormat formatter;

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getIceCreamString() {
		return iceCreamString;
	}

	public void setIceCreamString(String iceCreamString) {
		this.iceCreamString = iceCreamString;
	}

	public String getScoopsString() {
		return scoopsString;
	}

	public void setScoopsString(String scoopsString) {
		this.scoopsString = scoopsString;
	}

	public String getSyrupString() {
		return syrupString;
	}

	public void setSyrupString(String syrupString) {
		this.syrupString = syrupString;
	}

	public String getNutsString() {
		return nutsString;
	}

	public void setNutsString(String nutsString) {
		this.nutsString = nutsString;
	}

	public String getCherriesString() {
		return cherriesString;
	}

	public void setCherriesString(String cherriesString) {
		this.cherriesString = cherriesString;
	}

	public void saveReceipt() throws FileNotFoundException {
		formatter = new DecimalFormat("$0.00");
		formatter.setRoundingMode(RoundingMode.UP);
		PrintWriter writer = new PrintWriter("order.txt");
		writer.println(iceCreamString);
		writer.println(scoopsString);
		writer.println(syrupString);
		writer.println(nutsString);
		writer.println(cherriesString);
		writer.println("Total: " + formatter.format(totalPrice));
		writer.close();

	}

}
