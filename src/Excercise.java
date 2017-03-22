/**
 * Created by spl254 on 3/22/2017.
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

    /**
     * Created by spl254 on 3/20/2017.
     */
    public class Excercise extends Application {
        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Account Type");

            //Label
            Label unameLable = new Label("Username");
            Label pwLable = new Label("Password");
            Label accLabel = new Label("Select your account type");

            //TextField
            TextField unameTxtField = new TextField();
            PasswordField pwTxtField = new PasswordField();

            //combobox
            ObservableList<String> options = FXCollections.observableArrayList("Administrator", "Staff", "Faculty", "Student");
            ComboBox acTypeComboBox = new ComboBox(options);

            //button
            Button signInButton = new Button("Sign In");
            signInButton.setOnAction(e->{
                String displayStr = "";
                Font welcomeFont = new Font("Wingdings", 40);

                if(unameTxtField.getText().equals("csc200") && pwTxtField.getText().equals("123")) {
                    //check account type
                    String acType = (String)acTypeComboBox.getValue();
                    if (acType.equals("Student")) {
                        displayStr = "Welcome " + acType;
                    } else {
                        displayStr = "Incorrect Account Type!";
                    }

                } else { //pass authentication
                    displayStr = "Fail Authentication!";
                }
                Label welcomeLabel = new Label(displayStr);
                welcomeLabel.setFont(welcomeFont);
                Scene welcomeScene = new Scene(welcomeLabel);
                Stage welcomeStage = new Stage();
                welcomeStage.setScene(welcomeScene);
                welcomeStage.show();

            });

            VBox flowPane = new VBox();
            flowPane.getChildren().addAll(unameLable,unameTxtField,pwLable,pwTxtField,accLabel,acTypeComboBox,signInButton);
            Scene scene = new Scene(flowPane, 500,500);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String [] args) {
            launch(args);
        }

    }
