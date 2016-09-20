/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.states;

import java.awt.Graphics;

import dev.tilegame1.Handler;
import dev.tilegame1.entities.creatures.Player;
import dev.tilegame1.entities.statics.Tree;
import dev.tilegame1.worlds.World;

public class GameState extends State {
	
	
        private World world;
        
	
	public GameState(Handler handler){
		super(handler);
                world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
               
                
              //  game.getGameCamera().move(100, 300);
                        
	}
	
	@Override
	public void tick() {
	    world.tick();
           
            //game.getGameCamera().move(1, 1);
                
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
               
              
                //Tile.tiles[2].render(g, 0, 0);
	}

}