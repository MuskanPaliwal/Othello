package com.mega.games.gamestartingkit.core.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mega.games.gamestartingkit.core.dataLoaders.GameData;
import com.mega.games.gamestartingkit.core.gameObjects.entities.Ball;
import com.mega.games.gamestartingkit.core.gameObjects.baseObjects.GameObject;

import java.util.ArrayList;

public class GameObjectManager {
    private Ball ball;
    private ArrayList<GameObject> objs;

    public void reset(){
        //on reset, clear the object list and just add a ball
        objs.clear();

        ball = new Ball(25, Color.RED);
        ball.setPos(GameData._virtualWidth/2f, GameData._virtualHeight/2f);

        objs.add(ball);
    }

    public ArrayList<GameObject> getObjs() {
        return objs;
    }


    public void update(float dt){
        //Automatically called every frame before draw function
        for(GameObject obj:objs){
            obj.update(dt);
        }
    }

    public void draw(Batch batch){
        //automatically called every frame after update function
        for(GameObject obj:objs){
            obj.draw(batch);
        }
    }

    //set singleton
    private static final GameObjectManager _myInstance = new GameObjectManager();
    public static GameObjectManager getInstance(){
        return _myInstance;
    }
    private GameObjectManager(){
        objs = new ArrayList<>();
    }
}
