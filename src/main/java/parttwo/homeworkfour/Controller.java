package parttwo.homeworkfour;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    public Button sendButton;
    @FXML
    private TextField typeText;

    @FXML
    public TextArea textArea;

    @FXML
    public void initiliaze(){
        typeText.setOnAction(event -> sendMessage());
    }

    public void sendButtonClicked(ActionEvent actionEvent) {
        sendMessage();
    }

    public void sendMessage(){
        textArea.appendText(typeText.getText() + '\n');
        typeText.clear();
    }


}
