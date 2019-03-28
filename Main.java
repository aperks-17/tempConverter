package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	Label cLabel;
	Label fLabel;
	TextField cField;
	TextField fField;
	Button cButton;
	Button fButton;

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();// Ctrl +Shift + o to import
			Scene scene = new Scene(root, 500, 50);// dimensions -width x height
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			cLabel = new Label("Celsius");
			fLabel = new Label("Fahrenheit");
			cField = new TextField();
			fField = new TextField();
			cButton = new Button("Convert to Celsius");
			fButton = new Button("Convert to Fahrenheit");

			root.add(cLabel, 0, 0);
			root.add(fLabel, 0, 1);
			root.add(cField, 1, 0);
			root.add(fField, 1, 1);
			root.add(cButton, 2, 1);
			root.add(fButton, 2, 0);

			fButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					double c=Double.parseDouble(cField.getText());
					double f=c*1.8+32;
					fField.setText(f+"");
				}
			});

			cButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					double f=Double.parseDouble(fField.getText());
					double c=(f-32)/1.8;
					cField.setText(c+"");
				}
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
