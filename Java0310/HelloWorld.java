import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application{
	
	public static void main(String[] args){
		launch(args); //method in Application
	}

	// start method for JavaFX is like main method for a class
	//At runtime, JavaFX automatically creates the stage or window object, 
	//and passes a reference to that object as a parameter to start. 
	public void start(Stage mainStage){	
			//Line 20 22 23: instantiating objects and/or set properties for them
		//title
		mainStage.setTitle("Hello World Program");

		//button
		Button btn = new Button(); // 1.create a BUTTON instance
		btn.setText("Print Hello World!"); // 2.set the text of the button
			//Lambda Expression: -> .
		btn.setOnAction((ActionEvent event) -> System.out.println("Hello World!"));  // 3. set the button on Action of...(calling a setter method to set the behavior for clicking the button)

		//layout
		StackPane root = new StackPane(); //1.creating a LAYOUT instance
		root.getChildren().add(btn); // 2.add the previous button into the layout

		//scene and Stage
		Scene scene = new Scene(root, 300, 300); // 1.creating a new SCENE instance
		mainStage.setScene(scene); // 2.set the scene object to the Stage
		mainStage.show();// 3. show the stage
	}

	// creating a method that stands for the behavior for clicking the button
	/*private class CustomEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			System.out.println("Hello World!");
		}
	}*/
}