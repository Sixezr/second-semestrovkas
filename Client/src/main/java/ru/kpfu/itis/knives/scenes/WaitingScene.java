package ru.kpfu.itis.knives.scenes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import ru.kpfu.itis.knives.App;
import ru.kpfu.itis.knives.view.HeadMenuBar;
import ru.kpfu.itis.knives.view.WaitingVBox;
import ru.kpfu.itis.knives.view.ProgressHBox;

public class WaitingScene extends Scene {
    // UI
    private final BorderPane mainPane;

    // Init
    public WaitingScene(BorderPane pane) {
        super(pane, App.getMainStage().getWidth(), App.getMainStage().getHeight());
        mainPane = pane;
        mainPane.setTop(new HeadMenuBar());
        mainPane.setCenter(new WaitingVBox());
        mainPane.setBottom(new ProgressHBox("Поиск соперника"));
    }
}