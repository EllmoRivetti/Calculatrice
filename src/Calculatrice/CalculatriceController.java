package Calculatrice;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatriceController {

	@FXML
	private TextField displayField;

	@FXML
	private TextField currentCalculus;

	private CalculatriceModel model;

	String calculusType = "+";

	boolean resultDisplayed = false;
	boolean first = true;
	boolean wasOperator = false;


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
		wasOperator = false;
		//model.setCurrentCalculus(nb);
	}

	@FXML
	private void operationClick(Event e) {
		if(!wasOperator) {
			if(first) {
				model.setTotalResult(Double.parseDouble(model.getDisplayValue()));
				first = false;
			}

			String s = ((Button)e.getSource()).getText();

			if(resultDisplayed) {
				resultDisplayed = false;
				model.setCurrentCalculus(s);
			}else {
				model.setCurrentCalculus(model.getDisplayValue()+s);
			}

			model.resetDisplayValue();
			calculusType = s;
			wasOperator = true;
		}
	}

	@FXML
	private void displayResult(Event e) {
		try {
			if(model.getDisplayValue() != "") {
				double res = 0;

				switch(calculusType) {
				case "+":
					res = model.doPlus();
					break;
				case "-":
					res = model.doMinus();
					break;
				case "/":
					res = model.doDivide();

					break;
				case "x":
					res = model.doMultiply();
					break;
				default:
					break;
				}
				model.setTotalResult(res);
				model.setCurrentCalculus(model.getDisplayValue());
				model.resetDisplayValue();
				model.setDisplayValue(Double.toString(model.getTotalResult()));
				resultDisplayed = true;
			}
		}catch(DivideByZeroException err) {
			model.resetDisplayValue();
		}
	}

	@FXML
	private void clear() {
		model.resetCurrentCalculus();
		model.resetDisplayValue();
		model.setTotalResult(0);
		first = true;
	}

	@FXML
	private void deleteCurrentDisplay() {
		model.resetDisplayValue();
	}

	@FXML
	private void negate() {
		model.negate();
	}

	@FXML
	private void removeLastNb() {
		model.removeLastNumber();
	}

	@FXML
	private void square() {
		model.setTotalResult(model.doSquare());
		model.setCurrentCalculus(model.getDisplayValue()+"²");
		model.resetDisplayValue();
		model.setDisplayValue(Double.toString(model.getTotalResult()));
		resultDisplayed = true;
	}

	@FXML
	private void inverse() {
		try {
			model.setTotalResult(model.doInverse());
			model.setCurrentCalculus("1/("+model.getDisplayValue()+")");
			model.resetDisplayValue();
			model.setDisplayValue(Double.toString(model.getTotalResult()));
			resultDisplayed = true;
		}catch(DivideByZeroException e) {

		}

	}
	@FXML
	private void squareRoot() {
		model.setTotalResult(model.doSquareRoot());
		model.setCurrentCalculus("√("+model.getDisplayValue()+")");
		model.resetDisplayValue();
		model.setDisplayValue(Double.toString(model.getTotalResult()));
		resultDisplayed = true;

	}

	/*******Style function*******/


	@FXML
	private void hoverButtonEnter(Event e) {
		Button b = (Button)e.getSource();
		b.setStyle("-fx-background-color:#e0e0e0;"
				+ "-fx-border-color:grey;"
				+ "-fx-border-width:1;");
	}

	@FXML
	private void resetButtonStyle(Event e) {
		Button b = (Button)e.getSource();
		b.setStyle("");
	}

	@FXML
	private void clickButtonCommon(Event e) {
		Button b = (Button)e.getSource();
		b.setStyle("-fx-background-color:#cadbf7;"
				+ "-fx-border-color:grey;"
				+ "-fx-border-width:1;");
	}

}
