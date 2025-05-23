package com.example.praxe;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

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
        this.button.setPrefSize(125, 125);

        this.frontImage = new Image(getClass().getResourceAsStream("/Image/"+imagePath));
        this.backImage = new Image(getClass().getResourceAsStream("/Image/Component12.png"));
        flipback();
    }

    public void flip() {
        ScaleTransition shrink = new ScaleTransition(Duration.millis(125), button);
        shrink.setFromX(1);
        shrink.setToX(0);

        ScaleTransition expand = new ScaleTransition(Duration.millis(125), button);
        expand.setFromX(0);
        expand.setToX(1);

        shrink.setOnFinished(e -> {
            ImageView view = new ImageView(frontImage);
            view.setFitWidth(125);
            view.setFitHeight(125);
            view.setPreserveRatio(true);
            button.setGraphic(view);
        });

        new SequentialTransition(shrink, expand).play();
    }

    public void flipback(){
        ScaleTransition shrink = new ScaleTransition(Duration.millis(125), button);
        shrink.setFromX(1);
        shrink.setToX(0);

        ScaleTransition expand = new ScaleTransition(Duration.millis(125), button);
        expand.setFromX(0);
        expand.setToX(1);

        shrink.setOnFinished(e -> {
            ImageView view = new ImageView(backImage);
            view.setFitWidth(125);
            view.setFitHeight(125);
            view.setPreserveRatio(true);
            button.setGraphic(view);
        });

        new SequentialTransition(shrink, expand).play();
    }

    public int getId() {
        return id;
    }

    public Button getButton() {
        return button;
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
