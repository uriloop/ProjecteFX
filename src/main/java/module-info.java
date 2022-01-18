module uri.elpuig.projectefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens uri.elpuig.projectefx to javafx.fxml;
    exports uri.elpuig.projectefx;
}