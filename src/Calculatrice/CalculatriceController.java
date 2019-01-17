package Calculatrice;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class CalculatriceController {

	@FXML
	private TextField displayField;

	@FXML
	private TextField currentCalculus;

	private CalculatriceModel model;

	double sum = 0;

	String calculusType = "+";
	
	boolean resultDisplayed = false;
	boolean first = true;

	private final static String buttonHoverColor = "#e0e0e0";

	@FXML
	public void initialize() {
		model = new CalculatriceModel();
		displayField.textProperty().bind(model.getNewValueProperty());
		currentCalculus.textProperty().bind(model.getCurrentCalculusProperty());
	}


	@FXML
	private void writeNumberValue(Event e) {
		if(resultDisplayed) {
			clear();
			resultDisplayed=false;
		}
		String nb = ((Button)e.getSource()).getText();
		model.setDisplayValue(nb);
		model.setCurrentCalculus(nb);
	}

	@FXML
	private void operationClick(Event e) {
		if(first) {
			model.setTotalResult(Double.parseDouble(model.getDisplayValue()));
			first = false;
		}
		
		if(resultDisplayed) {
			resultDisplayed = false;
		}
		String s = ((Button)e.getSource()).getText();
		model.setCurrentCalculus(s);
		model.resetDisplayValue();
		calculusType = s;
	}

	@FXML
	private void displayResult(Event e) {
		if(model.getDisplayValue() != "") {
			double res = 0;
			
			switch(calculusType) {
			case "+":
				res = doPlus();
				break;
			case "-":
				res = doMinus();
				break;
			case "/":
				res = doDivide();
				break;
			case "x":
				res = doMultiply();
				break;
			default:
				break;
			}
			model.setTotalResult(res);
			model.resetDisplayValue();
			model.setDisplayValue(Double.toString(model.getTotalResult()));
			resultDisplayed = true;
		}
	}

	@FXML
	private void clear() {
		model.resetCurrentCalculus();
		model.resetDisplayValue();
		model.setTotalResult(0);
		first = true;
	}

	/*******Operation function*******/

	private double doPlus() {
		return Double.parseDouble(model.getDisplayValue()) + model.getTotalResult();
	}
	
	private double doMinus() {
		return model.getTotalResult() - Double.parseDouble(model.getDisplayValue());
	}
	
	private double doDivide() {
		if(model.getDisplayValue() == "0")
			model.resetDisplayValue();
		return model.getTotalResult() / Double.parseDouble(model.getDisplayValue());
	}
	
	private double doMultiply() {
		return Double.parseDouble(model.getDisplayValue()) * model.getTotalResult();
	}


	/*******Style function*******/


	@FXML
	private void hoverButtonEnter(Event e) {
		Button b = (Button)e.getSource();
		b.setStyle("-fx-background-color:"+buttonHoverColor+";"
				+ "-fx-border-color:grey;"
				+ "-fx-border-width:1;");
	}

	@FXML
	private void hoverButtonExit(Event e) {
		Button b = (Button)e.getSource();
		b.setStyle("");
	}

}
