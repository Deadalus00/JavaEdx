import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TemperatureConverterGUI extends Application{
 
	public void start(Stage stage){

		//button
		Button convertButton = new Button();
		convertButton.setText("Convert");

		//layout
		ComboBox<String> pickScaleFrom = new ComboBox();
		ComboBox<String> pickScaleTo = new ComboBox();
			
			//ComboBox "from"
		pickScaleFrom.getItems().add("Fahrenheit");
		pickScaleFrom.getItems().add("Celsius");
		// or ~.~.addAll("Fahrenheit","Celsius");
			
			//ComboBox "To"
		pickScaleTo.getItems().add("Fahrenheit");
		pickScaleTo.getItems().add("Celsius");
		// or ~.~.addAll("Fahrenheit","Celsius");

			//Default Choices for ComboBoxes
		pickScaleFrom.getSelectionModel().selectFirst();
		pickScaleTo.getSelectionModel().selectLast();

			//Label it with text next to ComboBoxes
		Label from = new Label("From: ");
		Label to = new Label("To: ");

			//creating textfield for input value and result
		TextField userInput = new TextField();
		Label inputValue = new Label("Input value: ");
		Label result = new Label();

		convertButton.setOnAction(event -> {
			String temperatureString = userInput.getCharacters().toString();
			try{
				double temperature = Double.parseDouble(temperatureString);
				String scaleFrom = pickScaleFrom.getValue();
				String scaleTo = pickScaleTo.getValue();
				double convertedResult = convert(scaleFrom, scaleTo, temperature);
				result.setText(String.format("Conversion result: %.2f", convertedResult));
			} catch (NumberFormatException e) {
				//creating a jumpout Alert window if any Exception or Error.
				Alert a = new Alert(Alert.AlertType.ERROR);
				a.setTitle("Error");
				a.setHeaderText("Invalid Temperature");
				a.setContentText("That is not a valid temperature.");
				a.showAndWait();
			}
		});

	//nodes for insertion to the scene
		//Horizontal Layout for First row: the input label and text field
		HBox input = new HBox();
		input.setAlignment(Pos.CENTER);
		input.getChildren().add(inputValue);
		input.getChildren().add(userInput);
			//or use ~.~.addAll(inputValue, userInput);

		//Horizontal Layout for Second Row: From and To scales label and choice boxes
		HBox scales = new HBox();
		scales.setAlignment(Pos.CENTER);
		scales.setSpacing(10);
		scales.getChildren().add(from);
		scales.getChildren().add(pickScaleFrom);
		scales.getChildren().add(to);
		scales.getChildren().add(pickScaleTo);
			// or use: ~.~.addAll(from, pickScaleFrom, to, pickScaleTo);
		
		//Vertical layout arrangement:
		//From top to bottom: input area, scales area, convert button area, result area.
			//VBox as a root shows that a layout can contain another layout
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);
		root.getChildren().add(input);
		root.getChildren().add(scales);
		root.getChildren().add(convertButton);
		root.getChildren().add(result);
			// or use: scales.getChildren().addAll(from, pickScaleFrom, to, pickScaleTo);

		// to put the layout root in to the scene
		Scene scene = new Scene(root, 400, 400);
		stage.setTitle("Temperature Converter");
		stage.setScene(scene);
		stage.show();

	}

	private double convert(String from, String to, double value){
		double converted = 0;
		if (from.equals(to)){
			converted = value;
		} else if (from.charAt(0) == 'F'){
			converted = (value - 32) * (5.0/9);
		} else {
			converted = value * (9.0 / 5) + 32;
		}
		return converted;
	}
}