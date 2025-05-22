package com.example.praxe;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
    private final int id;
    private final Button button;
    private boolean matched = false;
    private boolean flipped = false;

    private final Image frontImage;
    private final Image backImage;

    public Card(int id, String imagePath) {
        this.id = id;
        this.button = new Button();
        this.button.setPrefSize(200, 200);

        this.frontImage = new Image(getClass().getResourceAsStream("/Image/"+imagePath));
        this.backImage = new Image(getClass().getResourceAsStream("/Image/Component12.png"));
        flipback();
    }

    public int getId() {
        return id;
    }

    public Button getButton() {
        return button;
    }

    public void flip() {
        ImageView view = new ImageView(frontImage);
        view.setFitWidth(100);
       // view.setFitHeight(100);
        view.setPreserveRatio(true);
        button.setGraphic(view);
    }
    public void flipback(){
        ImageView view = new ImageView(backImage);
        view.setFitWidth(100);
        view.setFitHeight(100);
        view.setPreserveRatio(true);
        button.setGraphic(view);
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public Image getFrontImage() {
        return frontImage;
    }

    public Image getBackImage() {
        return backImage;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }
}
