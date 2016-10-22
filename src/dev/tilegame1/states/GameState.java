/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.states;

import java.awt.Graphics;

import dev.tilegame1.Handler;
import dev.tilegame1.Music.Music;
import dev.tilegame1.entities.creatures.Player;
import dev.tilegame1.entities.statics.Tree;
import dev.tilegame1.pokemons.Loader;
import dev.tilegame1.pokemons.Pokemon;
import dev.tilegame1.tiles.Tile;
import dev.tilegame1.ui.UIManager;
import dev.tilegame1.ui.UIObject;
import dev.tilegame1.worlds.World;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameState extends State {
	
	private UIManager uiManager;
        private Pokemon[] pokemonList;
        private Loader loader;
        private World world;
        private float currenthp;
        private String state;
        private Boolean booleano;
        private Boolean booleano2;
	
	public GameState(Handler handler){
		super(handler);
                state = "newGame";
                world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
                
                loader = new Loader();
                booleano = false;
                booleano2 = false;
                
                
              //  game.getGameCamera().move(100, 300);
                        
	}
	
	@Override
	public void tick() {
	    world.tick();
//         if (handler.getCreature().Entrarbatalla()== 1) {
//             
//             State.setState(handler.getGame().battleState);
//            }
            //game.getGameCamera().move(1, 1);
                
	}
         public void resetComponents(){
         
         
         }
        public void setAllObjectsBounds(){
        
            if (uiManager != null) {
                if (handler.getMouseManager().getUIManager().getObjects() != null){
                    for (UIObject o : handler.getMouseManager().getUIManager().getObjects()) {
                     
                      if (o != null) {
                          
                          if (!o.getState().equals(state)) {
                            o.setX(0);
                            o.setY(0);
                            o.setWidth(0);
                            o.setHeight(0);
                            o.getBounds().height=1;
                            o.getBounds().width=1;
                            
                          }
                        }
                    }   
                }
            }
        
        
        }

	@Override
	public void render(Graphics g) {
		world.render(g);
        
                if (booleano2 == false) {
                    try {
                      pokemonList=  loader.readPokemon();
                    } catch (Exception ex) {
                        Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    booleano2=true;
            }
                
            /*      if ((handler.getWorld().getEntityManager().getPlayer().getX()>310.0 )&&( handler.getWorld().getEntityManager().getPlayer().getX()<332.0) && (handler.getWorld().getEntityManager().getPlayer().getY()>401.0 )&&( handler.getWorld().getEntityManager().getPlayer().getY()<407.0)){
                //currenthp = (((2 * pokemonList[1].getbHp() * pokemonList[1].getLevel()) / 100) + pokemonList[1].getLevel() + 10);
                pokemonList[1].setHp((int)(((2 * pokemonList[1].getbHp() * pokemonList[1].getLevel()) / 100) + pokemonList[1].getLevel() + 10));
                  
            }*/
               if(booleano == false){
                    resetComponents();
                 setAllObjectsBounds();
                 
                 booleano = true;
               }
               
                //System.out.println(handler.getWorld().getTile((int)handler.getWorld().getEntityManager().getPlayer().getX(),(int)handler.getWorld().getEntityManager().getPlayer().getY()).getBattle());
               // System.out.println(handler.getWorld().getTile((int)handler.getCreature().getX(),(int) handler.getCreature().getY()));  
               // State.setState(handler.getGame().battleState);
                //System.out.println(handler.getWorld().getTile(handler.getWorld()., 200));
           
              
                //Tile.tiles[2].render(g, 0, 0);
	}

}