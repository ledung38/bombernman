package uet.oop.bomberman.entities.enemiesG.AI;

import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.enemiesG.Enemy;
import uet.oop.bomberman.entities.enemiesG.Kondoria;
import uet.oop.bomberman.entities.enemiesG.Oneal;
import uet.oop.bomberman.entities.playerG.Bomber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static uet.oop.bomberman.entities.enemiesG.Kondoria.timeDirection;
import static uet.oop.bomberman.entities.enemiesG.Oneal.timeDirectionO;
import static uet.oop.bomberman.entities.enemiesG.Kondoria.checkbomb;
import static uet.oop.bomberman.entities.enemiesG.Kondoria.checkTimeBomb;
import static uet.oop.bomberman.entities.enemiesG.Oneal.*;

public class AIHigh extends AI {
    List<Bomb> bombs = new ArrayList<Bomb>();

    Bomber _bomber;
    Enemy _e;

    public AIHigh(Bomber bomber, Enemy e) {
        _bomber = bomber;
        _e = e;
        bombs = bomber.getBombs();
    }

    public int checkBombss() {
        for (Bomb bomb : bombs) {
            if (getTile(bomb.getX()) == getTile(_e.getX())) {
                checkTimeBombO = timeDirectionO;
                checkbombO = true;
                if (getTile(_e.getY()) - 1 == getTile(bomb.getY()) ) return 4;
                if (getTile(_e.getY()) + 1 == getTile(bomb.getY()) ) return 3;
            }
            if (getTile(bomb.getY()) == getTile(_e.getY())) {
                checkTimeBombO = timeDirectionO;
                checkbombO = true;
                if (getTile(_e.getX()) - 1 == getTile(bomb.getX()) ) return 2;
                if (getTile(_e.getX()) + 1 == getTile(bomb.getX()) ) return 1;
            }
        }
        return 10;
    }

    @Override
    public int calculateDirection() {
        for (Bomb bomb : bombs) {
            if (getTile(bomb.getX()) == getTile(_e.getX())) {
                checkTimeBomb = timeDirection;
                checkbomb = true;
                if (getTile(_e.getY()) - 1 == getTile(bomb.getY()) ) return 4;
                if (getTile(_e.getY()) + 1 == getTile(bomb.getY()) ) return 3;
            }
            if (getTile(bomb.getY()) == getTile(_e.getY())) {
                checkTimeBomb = timeDirection;
                checkbomb = true;
                if (getTile(_e.getX()) - 1 == getTile(bomb.getX()) ) return 2;
                if (getTile(_e.getX()) + 1 == getTile(bomb.getX()) ) return 1;
            }
        }
        if (!_bomber.isAlive()) {
            return random.nextInt(4) + 1;
        }

        Random random1 = new Random();
        int r = random1.nextInt(2) + 1;


        if (r == 1) {
            if(dicrectionRow() != -1) {
                return dicrectionRow();
            }
            return dicrectionCol();
        } else {
            if(dicrectionCol() != -1) {
                return dicrectionCol();
            }
            return dicrectionRow();
        }

        /**
         if (r == 1) {
         if (_bomber.getX() < _e.getX() ) return 1; //left
         if (_bomber.getX() > _e.getX() ) return 2; //right
         if (_bomber.getY() < _e.getY() ) return 3; //up
         if (_bomber.getY() > _e.getY()) return 4; // down
         } else {
         if (_bomber.getY() < _e.getY() ) return 3; //up
         if (_bomber.getY() > _e.getY() ) return 4; // down
         if (_bomber.getX() < _e.getX() ) return 1; //left
         if (_bomber.getX() > _e.getX() ) return 2; //right
         }
         */
    }
    public int dicrectionRow() {
        if (_bomber.getX() - 8 < _e.getX() ) return 1; //left
        if (_bomber.getX() - 8 > _e.getX() ) return 2; //right
        return -1;
    }
    public int dicrectionCol(){
        if (_bomber.getY() < _e.getY() ) return 3;
        if (_bomber.getY() > _e.getY() ) return 4;
        return -1;
    }

}
