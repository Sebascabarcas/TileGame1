/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.entities.creatures;

import java.awt.Graphics;

import dev.tilegame1.Handler;
import dev.tilegame1.gfx.Animation;
import dev.tilegame1.gfx.Assets;
import dev.tilegame1.input.KeyManager;
import dev.tilegame1.pokemons.Loader;
import dev.tilegame1.pokemons.Pokemon;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player extends Creature {

	//Animations
        private Pokemon[] pokemon;
        private Loader loader;
        private Animation animDown, animUp, animLeft, animRight;
        private int lastMov;
        private int last;
        public static BufferedImage[] quieto;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
                bounds.x = 7;
        bounds.y = 33;
        bounds.width = 23;
        bounds.height = 5;
            /*try {
                pokemon= loader.readPokemon();
            } catch (Exception ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }*/
                //Animations
                animDown = new Animation(120, Assets.player_down);
                animUp =new Animation(120, Assets.player_up);
                animLeft = new Animation(120, Assets.player_left);
                animRight = new Animation(120, Assets.player_right);
                
                this.quieto = new BufferedImage[4];
                
                this.quieto[0] = Assets.player_down[0];
                this.quieto[1] = Assets.player_up[0];
                this.quieto[2] = Assets.player_left[0];
                this.quieto[3] = Assets.player_right[0];
     
                
	}

	@Override
	public void tick() {
            //Animation
           if (handler.getKeyManager().isDown() == true) {
                  animDown.tick();       
           }
            
            if (handler.getKeyManager().isUp() == true) {
               animUp.tick();  
            
            }
            if (handler.getKeyManager().isLeft() == true) {
              animLeft.tick();
          
            }
            if (handler.getKeyManager().isRight() == true) {
                animRight.tick();
             
            }
       
            //Movement
            
            getInput();
            move();
            handler.getGameCamera().centerOnEntity(this);
	}
        
        private void getInput(){
          xMove = 0;
          yMove = 0;
          
            if (handler.getKeyManager().up) {
                yMove = -speed;
            }
            if (handler.getKeyManager().down) {
                yMove = speed;
            }
            if (handler.getKeyManager().left) {
                xMove = -speed;
            }
            if (handler.getKeyManager().right) {
                xMove = speed;
            }
        }
        
        public Pokemon getPokemon(){
            try {
                pokemon= loader.readPokemon();
            } catch (Exception ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            return pokemon[1];
        }

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
             
              
	}
     
     private BufferedImage getCurrentAnimationFrame(){
         if (xMove < 0 ) {
             this.last = 2;
             return animLeft.getCurrentFrame();
         }
         if(xMove > 0 ){
             this.last = 3;
            return animRight.getCurrentFrame();
         }
         if(yMove < 0){
             this.last = 1;
            return animUp.getCurrentFrame();
         }
            
         if(yMove>0 ){
             this.last = 0;
          return animDown.getCurrentFrame();
         }
       
         return this.quieto[this.last];
     }
}