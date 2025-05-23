package com.example.praxe;

import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;

public class HelloController {
    @FXML
    private Label vitez;
    @FXML
    private Label hrac1;
    @FXML
    private Label hrac2;
    @FXML
    private Label onlinePlayer;
    @FXML
    private GridPane grid;
    @FXML
    private VBox VBox;


    private ArrayList<Card> cards = new ArrayList<>();
    private Card firstCard = null;
    private Card secondCard = null;
    private boolean canFlip = true;

    private int currentPlayer = 1;
    private int score1 =0;
    private int score2 =0;

    @FXML
    public void initialize() {

        generateCards();
        Collections.shuffle(cards);
        displayCards();
    }

    private void generateCards() {
        cards.add(new Card(1, "Component1.png"));
        cards.add(new Card(2, "Component1(1).png"));
        cards.add(new Card(3, "Component4.png"));
        cards.add(new Card(4, "Component5.png"));
        cards.add(new Card(5, "Component66.png"));
        cards.add(new Card(6, "Component7.png"));
        cards.add(new Card(7, "Component8.png"));
        cards.add(new Card(8, "Component11.png"));
        cards.add(new Card(9, "Component10.png"));
        cards.add(new Card(10, "Component13.png"));
        cards.add(new Card(11, "Component14.png"));
        cards.add(new Card(12, "Component55.png"));

        cards.add(new Card(1, "Component1.png"));
        cards.add(new Card(2, "Component1(1).png"));
        cards.add(new Card(3, "Component4.png"));
        cards.add(new Card(4, "Component5.png"));
        cards.add(new Card(5, "Component66.png"));
        cards.add(new Card(6, "Component7.png"));
        cards.add(new Card(7, "Component8.png"));
        cards.add(new Card(8, "Component11.png"));
        cards.add(new Card(9, "Component10.png"));
        cards.add(new Card(10, "Component13.png"));
        cards.add(new Card(11, "Component14.png"));
        cards.add(new Card(12, "Component55.png"));
    }
    private void displayCards() {
        grid.getChildren().clear();
        VBox.setAlignment(Pos.CENTER);
        VBox.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(5);
        grid.setHgap(5);
        int index = 0;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 6; col++) {
                Card card = cards.get(index++);
                Button btn = card.getButton();
                btn.setOnAction((e -> handleCardClick(card)));
                grid.add(btn, col, row);
             //   grid.getColumnConstraints().add(col, new ColumnConstraints(100, 100, 100));
            }
          //  grid.getRowConstraints().add(row, new RowConstraints(100, 100, 100));
        }

    }

    private void handleCardClick(Card card) {
        if (!canFlip || card.isMatched() || card.isFlipped()){
            return;
        }
        card.flip();

        if (firstCard == null) {
            firstCard = card;
        }else if (secondCard == null) {
            secondCard = card;
            if (firstCard == secondCard){
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e -> {
                    firstCard.flipback();
                    resetTurn();
                    switchPlayer();
                    canFlip = true;
                });
                pause.play();
                return;
            }
            canFlip = false;

            PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
            pause.setOnFinished(e -> Checkcards());
            pause.play();
        }
    }

    public void resetTurn(){
        firstCard = null;
        secondCard = null;
    }

    public void switchPlayer(){
        if (currentPlayer == 1){
            currentPlayer = 2;
        }else{
            currentPlayer = 1;
        }
        onlinePlayer.setText("Hráč: " + currentPlayer + " je na řadě");
    }

    public void Checkcards(){
        if(firstCard.getId() == secondCard.getId()){
            firstCard.setMatched(true);
            secondCard.setMatched(true);
            firstCard = null;
            secondCard = null;
            if(currentPlayer ==1){
                score1++;
                hrac1.setText("Hrač 1: " + score1);
            }else if(currentPlayer ==2){
                score2++;
                hrac2.setText("hráč 2: " + score2);
            }
            if (isGameOver() == true){
                if (score1>score2){
                    vitez.setText("Hráč: "+currentPlayer+" je vítěz");
                } else if (score1==score2) {
                    vitez.setText("Oba hráči jsou vítězové: "+score1+", "+score2);
                }else if(score2>score1){
                    vitez.setText("Hráč: "+currentPlayer+" je vítěz");
                }
            }
        }else{
            firstCard.flipback();
            secondCard.flipback();
            switchPlayer();
        }

        resetTurn();
        canFlip = true;

        System.out.println(score1);
        System.out.println(score2);
    }
    private boolean isGameOver(){
        for (Card card : cards) {
            if (card.isMatched() == false) {
                return false;
            }
        }
        return true;
    }
}