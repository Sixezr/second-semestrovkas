package ru.kpfu.itis.knives;

import ru.kpfu.itis.knives.exceptions.ServerException;
import ru.kpfu.itis.knives.listeners.StartGameListener;
import ru.kpfu.itis.knives.listeners.StartMoveListener;
import ru.kpfu.itis.knives.listeners.TerritoryChoiceListener;
import ru.kpfu.itis.knives.server.KnivesServer;

public class Main {

    public static void main(String[] args) {
        try {
            KnivesServer knivesServer = new KnivesServer();
            knivesServer.registerListener(new StartGameListener());
            knivesServer.registerListener(new StartMoveListener());
            knivesServer.registerListener(new TerritoryChoiceListener());

            knivesServer.startServer();
        } catch (ServerException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
