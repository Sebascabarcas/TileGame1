/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1;

import dev.tilegame1.entities.creatures.Creature;
import dev.tilegame1.entities.creatures.Player;
import dev.tilegame1.gfx.GameCamera;
import dev.tilegame1.input.KeyManager;
import dev.tilegame1.input.MouseManager;
import dev.tilegame1.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	private Creature creature;
        private Player player;
	public Handler(Game game){
		this.game = game;
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
        public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
        
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
        public Creature getCreature(){
        return creature;
        }
        
        public Player getPlayer(){
        return player;
        }

}

