module uri.elpuig.projectefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires com.fasterxml.jackson.databind;

    opens uri.elpuig.projectefx to javafx.fxml;
    exports uri.elpuig.projectefx;
    exports uri.elpuig.projectefx.model;
    opens uri.elpuig.projectefx.model to javafx.fxml;
    exports uri.elpuig.projectefx.control to javafx.fxml;
    opens uri.elpuig.projectefx.control to javafx.fxml;
}