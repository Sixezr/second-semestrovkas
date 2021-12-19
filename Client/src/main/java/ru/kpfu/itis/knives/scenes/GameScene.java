package ru.kpfu.itis.knives.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ru.kpfu.itis.knives.App;
import ru.kpfu.itis.knives.view.GameFieldCanvas;
import ru.kpfu.itis.knives.view.HeadMenuBar;
import ru.kpfu.itis.knives.view.ProgressHBox;

public class GameScene extends Scene {
    // UI
    private final BorderPane mainPane;
    private final ProgressHBox progressHBox;
    private final Label statusLabel;
    private final GameFieldCanvas gameFieldCanvas;
    private final VBox messagesVBox;
    private final Label messageLabel;

    // Init
    public GameScene(BorderPane pane) {
        super(pane, App.getMainStage().getWidth(), App.getMainStage().getHeight());
        mainPane = pane;
        mainPane.setTop(new HeadMenuBar());
        progressHBox = new ProgressHBox("Игра началась");
        mainPane.setBottom(progressHBox);

        VBox contentVBox = new VBox();
        contentVBox.setSpacing(64);
        contentVBox.setAlignment(Pos.CENTER);

        statusLabel = new Label("Игра началась");
        statusLabel.setFont(Font.font(30));

        HBox contentHBox = new HBox();
        contentHBox.setAlignment(Pos.CENTER);
        contentHBox.setSpacing(200);

        gameFieldCanvas = new GameFieldCanvas();

        // TODO: add knife animation
        messagesVBox = new VBox();
        messagesVBox.setAlignment(Pos.CENTER);
        messagesVBox.setSpacing(80);

        messageLabel = new Label("Ваш ход");
        messageLabel.setFont(Font.font(36));

        messagesVBox.getChildren().addAll(messageLabel);
        contentVBox.getChildren().addAll(statusLabel, gameFieldCanvas);
        contentHBox.getChildren().addAll(contentVBox, messagesVBox);

        mainPane.setCenter(contentHBox);

        initListeners();
    }

    // Private
    private void initListeners() {
        gameFieldCanvas.setOnMouseClicked(event -> {
            System.out.println(event.getX() + " " + event.getY());
            gameFieldCanvas.drawPoint(event.getX(), event.getY(), Color.AQUA);
        });
    }
}