package convert.convert.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import convert.convert.enums.Length;
import convert.convert.enums.Mass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MassController implements Initializable {

    public Map<String,Double> map(){
        List<Mass> value = List.of(Mass.values());
        Map<String,Double> listV = new HashMap<>();
        for (Mass v : value){
            listV.put(v.getLustName(),v.getValue());
        }
        return listV;
    }
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField Value;

    @FXML
    private Label ValueResult;

    @FXML
    private ComboBox<String> comboB1;

    @FXML
    private ComboBox<String> comboB2;
    @FXML
    private Button back;
    @FXML
    void backMenu(ActionEvent event) {
        back.setOnAction(actionEvent -> {
            back.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/convert/convert/main.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.showAndWait();
        });
    }
    @FXML
    private Button result;

    @FXML
    void toResult(ActionEvent event) {
        result.setOnAction(actionEvent -> {
            if (!Value.getText().isEmpty() && !comboB1.getSelectionModel().isEmpty() && !comboB2.getSelectionModel().isEmpty()){
                double a = map().get(comboB1.getSelectionModel().getSelectedItem());
                double b = map().get(comboB2.getSelectionModel().getSelectedItem());
                double c = Double.parseDouble(Value.getText());
                double result = b * c / a;
                String r = String.format("%.6f",result);
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
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboB1.getItems().addAll(map().keySet());
        comboB2.getItems().addAll(map().keySet());
    }
}
