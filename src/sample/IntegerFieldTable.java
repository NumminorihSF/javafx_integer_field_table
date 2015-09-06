package sample;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class IntegerFieldTable extends javafx.scene.layout.GridPane implements Observer{
    private Model model = new Model();




    public void update(Observable obs, Object obj){
    }

    private void init(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    public IntegerFieldTable() {
        init();
        model.addObserver(this);
    }


    public IntegerFieldTable(int height, int width){
        init();
        model.setHeight(height);
        model.setWidth(width);
        model.addObserver(this);
    }

    public void addObserver(Observer o){
        model.addObserver(o);
    }

    public void removeObserver(Observer o){
        model.deleteObserver(o);
    }

    public int getValue(int i, int j){
        return model.getValue(i, j);
    }

}
