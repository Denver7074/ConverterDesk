package convert.convert.controllers;

import convert.convert.enums.Course;
import convert.convert.services.ServiceValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ValueController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Value;

    @FXML
    private Label ValueResult;

    @FXML
    private Button back;

    @FXML
    private ComboBox<String> comboB1;

    @FXML
    private ComboBox<String> comboB2;

    @FXML
    private Button result;

    @FXML
    void backMenu(ActionEvent event) {

    }

    @FXML
    void toResult(ActionEvent event) {
        result.setOnAction(actionEvent -> {
            if (!Value.getText().isEmpty() && !comboB1.getSelectionModel().isEmpty() && !comboB2.getSelectionModel().isEmpty()){
                String a = ServiceValue.getValue().get(comboB1.getSelectionModel().getSelectedItem()).replace(",",".");
                String b = ServiceValue.getValue().get(comboB2.getSelectionModel().getSelectedItem()).replace(",",".");
                double c = Double.parseDouble(Value.getText());
                double result = Double.parseDouble(a) * c / Double.parseDouble(b);
                String r = String.format("%.4f",result);
                ValueResult.setText(r);
                System.out.println(r);
            }
            else {
                ValueResult.setText("Что-то забыл?");
            }
        });
    }

    @FXML
    void initialize() {
            comboB1.getItems().addAll(ServiceValue.getValue().keySet());
            comboB2.getItems().addAll(ServiceValue.getValue().keySet());
    }
}
