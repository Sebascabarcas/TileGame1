/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.entities.creatures;

import dev.tilegame1.Handler;
import dev.tilegame1.Music.Music;
import dev.tilegame1.entities.Entity;
import dev.tilegame1.states.BattleState;
import static dev.tilegame1.states.BattleState.currenthp;
import dev.tilegame1.states.MenuState;
import dev.tilegame1.states.State;
import dev.tilegame1.tiles.Tile;
import java.util.Random;

public abstract class Creature extends Entity {
	
        public static final int DEFAULT_HEALTH = 10;    
        public static final float DEFAULT_SPEED = 2.0f;
        public static final int DEFAULT_CREATURE_WIDTH = 28,
                                DEFAULT_CREATURE_HEIGHT = 35;
        
	protected int health;
        protected float speed;
        protected float xMove, yMove;
      
        private Random random;
        private int ran;
        private BattleState battleState;
        private MenuState menuState;
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
                speed = DEFAULT_SPEED;
                xMove = 0;
                yMove = 0;
                ran = 2;
                random = new Random();
             
	}
public void move(){
                if (!checkEntityCollisions(xMove, 0f)) 
		moveX();
                if (!checkEntityCollisions(0f, yMove))
		moveY(); 
                
                //System.out.println(handler.getWorld().getTile((int)xMove,(int)yMove).getBattle());
                 
	}
	
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width -1;
			}
                        if (Entrarbatalla() == 1 && random.nextInt(70) == ran){
                             if (BattleState.currenthp>0) {
                                State.setState(handler.getGame().battleState);
                                  BattleState.inBattle=true;
                                  Music.TOWN.stop();
                                  Music.MENU.play();
                            }
                                  
                    }
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
			 if (Entrarbatalla() == 1 && random.nextInt(70) == ran){
                       
                                   if (BattleState.currenthp>0) {
                                State.setState(handler.getGame().battleState);
                                  BattleState.inBattle=true;
                                  Music.TOWN.stop();
                                  Music.MENU.play();
                            }
                    }
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
                         if (Entrarbatalla() == 1 && random.nextInt(70) == ran){
                       
                                   if (BattleState.currenthp>0) {
                                State.setState(handler.getGame().battleState);
                                  BattleState.inBattle=true;
                                  Music.TOWN.stop();
                                  Music.MENU.play();
                            }
                    }
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
                     if (Entrarbatalla() == 1 && random.nextInt(70) == ran){
                   
                                   if (BattleState.currenthp>0) {
                                State.setState(handler.getGame().battleState);
                                  BattleState.inBattle=true;
                                  Music.TOWN.stop();
                                  Music.MENU.play();
                            }else 
                                       System.out.println(currenthp);
                    }

			
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}

      //GETTERS SETTERS
    public float getxMove() {
        return xMove;
    }
    public int Entrarbatalla(){
        int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
        int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
     if (handler.getWorld().getTile((int) ((x + bounds.x) / Tile.TILEWIDTH),ty).getBattle() == true){
                        return 1;
                    }
//     if (handler.getWorld().getTile((int) ((x + bounds.x) / Tile.TILEWIDTH),ty).getBattle() == true){
//                       return 1;
//                    }
     if (handler.getWorld().getTile(tx,(int) ((y + bounds.y) / Tile.TILEHEIGHT)).getBattle() == true){
                        return 1;
                    }
     return 0;
    }
    
    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
	
}
