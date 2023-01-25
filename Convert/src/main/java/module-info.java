module convert.convert {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.jsoup;


    opens convert.convert to javafx.fxml;
    exports convert.convert;
    exports convert.convert.controllers;
    opens convert.convert.controllers to javafx.fxml;
    exports convert.convert.services;
    opens convert.convert.services to javafx.fxml;
}