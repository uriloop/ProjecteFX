package uri.elpuig.projectefx.model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

public class AboutBored {

    @FXML
    TextArea textArea;
    @FXML
    MenuItem quit;
    @FXML
    Button back,contact;


    public MenuItem getQuit() {
        return quit;
    }

    public void setQuit(MenuItem quit) {
        this.quit = quit;
    }

    public Button getBack() {
        return back;
    }

    public void setBack(Button back) {
        this.back = back;
    }

    public Button getContact() {
        return contact;
    }

    public void setContact(Button contact) {
        this.contact = contact;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public TextArea getTextArea() {
        return textArea;
    }
}
