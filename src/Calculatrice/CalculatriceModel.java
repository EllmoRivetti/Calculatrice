package Calculatrice;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class CalculatriceModel {

	
	private double totalResult;
	private StringProperty displayValue;
	
	private StringProperty currentCalculus;
	
	public CalculatriceModel() {
		setTotalResult(0);
		
		displayValue = new SimpleStringProperty();
		resetDisplayValue();
		currentCalculus = new SimpleStringProperty();
		resetCurrentCalculus();
	}
	
	public void setTotalResult(double d) {
		this.totalResult = d;
	}
	
	public double getTotalResult() {
		return this.totalResult;
	}
	
	public void setDisplayValue(String s) {
		this.displayValue.set(this.displayValue.get()+s);
	}
	
	public void resetDisplayValue() {
		this.displayValue.set("");
	}
	
	public String getDisplayValue() {
		return this.displayValue.get();
	}
	
	public StringProperty getNewValueProperty() {
		return this.displayValue;
	}
	
	public void setCurrentCalculus(String s) {
		this.currentCalculus.set(this.currentCalculus.get()+s);
	}
	
	public void resetCurrentCalculus() {
		this.currentCalculus.set("");
	}
	
	public String getCurrentCalculus() {
		return this.currentCalculus.get();
	}
	
	public StringProperty getCurrentCalculusProperty() {
		return this.currentCalculus;
	}
	
	
	public void negate() {
		if(this.getDisplayValue().contains("-")) {
			String s = this.getDisplayValue().replace("-", "");
			this.displayValue.set(s);
		}else {
			String s = "-"+this.getDisplayValue();
			this.displayValue.set(s);
		}
	}
	
	public void removeLastNumber() {
		try {
			String s = this.getDisplayValue().substring(0, this.displayValue.get().length()-1);
			this.displayValue.set(s);
		}catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	/*******Operation function*******/

	public double doPlus() {
		return Double.parseDouble(getDisplayValue()) + getTotalResult();
	}

	public double doMinus() {
		return  getTotalResult() - Double.parseDouble( getDisplayValue());
	}

	public double doDivide() throws DivideByZeroException {
		System.out.println( getDisplayValue());
		if(getDisplayValue().equals("0"))
			 throw new DivideByZeroException();
		else
			return  getTotalResult() / Double.parseDouble( getDisplayValue());
	}

	public double doMultiply() {
		return Double.parseDouble( getDisplayValue()) *  getTotalResult();
	}
	
	public double doSquare() {
		return Double.parseDouble( getDisplayValue()) * Double.parseDouble( getDisplayValue());
	}
	
	public double doInverse() throws DivideByZeroException {
		System.out.println( getDisplayValue());
		if(getDisplayValue().equals("0"))
			 throw new DivideByZeroException();
		else
		return 1 / Double.parseDouble(getDisplayValue());
	}
	
	public double doSquareRoot() {
		return Math.sqrt(Double.parseDouble( getDisplayValue()) * Double.parseDouble( getDisplayValue()));
	}
	
	
}
