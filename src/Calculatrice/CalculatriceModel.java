package Calculatrice;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class CalculatriceModel {

	
	private DoubleProperty totalResult;
	private StringProperty displayValue;
	
	private StringProperty currentCalculus;
	
	public CalculatriceModel() {
		totalResult = new SimpleDoubleProperty();
		setTotalResult(0);
		
		displayValue = new SimpleStringProperty();
		resetDisplayValue();
		currentCalculus = new SimpleStringProperty();
		resetCurrentCalculus();
	}
	
	public void setTotalResult(double d) {
		this.totalResult.set(d);
	}
	
	public double getTotalResult() {
		return this.totalResult.get();
	}
	
	public DoubleProperty getTotalResultProperty() {
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
	
	
	
	
}
