import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AgeCalculator extends Application {
    public void start(Stage stage) {
        Label title = new Label("Age Calculator");
        TextField birthYear = new TextField();
        birthYear.setPromptText("Enter birth year");
        Button button = new Button("Calculate Age");
        Label result = new Label();
        button.setOnAction(e -> {
            int year = Integer.parseInt(birthYear.getText());
            int currentYear = 2026;
            int age = currentYear - year;
            result.setText("Your age is: " + age);
        });
        VBox box = new VBox(15);
        box.getChildren().addAll(title, birthYear, button, result);
        Scene scene = new Scene(box, 300, 250);
        stage.setTitle("Age Calculator");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}