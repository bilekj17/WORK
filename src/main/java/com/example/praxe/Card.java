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
        button.setGraphic(new ImageView(frontImage));
    }
    public void flipback(){
        button.setGraphic(new ImageView(backImage));
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
