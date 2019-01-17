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
	private Text currentCalculus;
	
	double leftValue, rightValue;
	
	double sum = 0;
	String calculusType = "+";
	
	private final static String buttonHoverColor = "#e0e0e0";
	

	@FXML
	private void writeNumberValue(Event e) {
		String value = ((Button)e.getSource()).getText();
		switch (calculusType) 
		{ 
		case "+": 
			sum += Double.parseDouble(value);
			break; 
		case "-": 
			sum -= Double.parseDouble(value);
			break; 
		case "/":
			sum /= Double.parseDouble(value);
			break; 
		case "x": 
			sum *= Double.parseDouble(value);
			break; 
		default: 
			break;
		}
		displayField.setText(displayField.getText()+value);
		currentCalculus.setText(currentCalculus.getText() + value);
	}
	
	@FXML
	private void writeAnswer() {
		displayField.setText(Double.toString(sum));
	}
	
	@FXML
	private void doCalculus(Event e) {
		calculusType = ((Button)e.getSource()).getText();
		writeAnswer();
		displayField.setText("");
		currentCalculus.setText(currentCalculus.getText() + calculusType);
	}
	
	@FXML
	private void clear() {
		calculusType = "+";
		sum = 0;
		currentCalculus.setText("");
		displayField.setText("");
	}
	
	@FXML
	private void hoverButtonEnter(Event e) {
		Button b = (Button)e.getSource();
		b.setStyle("-fx-background-color:"+buttonHoverColor+";");
	}
	
	@FXML
	private void hoverButtonExit(Event e) {
		Button b = (Button)e.getSource();
		b.setStyle("-fx-background-color:fafafa;");
	}

}
