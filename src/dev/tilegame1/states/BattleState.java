/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.states;

import dev.tilegame1.Handler;
import dev.tilegame1.gfx.Assets;
import dev.tilegame1.gfx.ImageLoader;
import dev.tilegame1.ui.ClickListener;
import dev.tilegame1.ui.UIImageButton;
import dev.tilegame1.ui.UIManager;
import dev.tilegame1.ui.UIObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author SebastianCabarcas
 */
public class BattleState extends State {
       private UIManager ui2Manager;
       int sw=0;
       private String state;
       private Boolean reset;
       private Boolean attack;
	public BattleState (final Handler handler){
		super(handler);
                state ="battle";
                reset = false;
                
                ui2Manager = new UIManager(handler);
                ui2Manager = handler.getMouseManager().getUIManager();
               
	}

         public void setAllObjectsBounds(){
        
            if (ui2Manager != null) {
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
         
         public void resetComponents(){
             
                             ui2Manager = handler.getMouseManager().getUIManager();

               
            if(ui2Manager != null){ 
                
                 System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                
                    ui2Manager.addObject(new UIImageButton(460,420,128,64, Assets.run, "battle",new ClickListener(){


                        @Override
                        public void onClick() {
    //                      handler.getMouseManager().setUIManager(null);
                          State.setState(handler.getGame().gameState);


                        }
                    }));
                      System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    ui2Manager.addObject(new UIImageButton(460,367,128,60, Assets.bag,"battle", new ClickListener(){

                        @Override
                        public void onClick() {
    //                      handler.getMouseManager().setUIManager(null);
                         // State.setState(handler.getGame().);


                        }
                    }));
                     ui2Manager.addObject(new UIImageButton(330,420,128,64, Assets.pokemones, "battle",new ClickListener(){

                        @Override
                        public void onClick() {
    //                      handler.getMouseManager().setUIManager(null);



                        }
                    }));
                      ui2Manager.addObject(new UIImageButton(330,367,128,64, Assets.fight, "battle",new ClickListener(){

                        @Override
                        public void onClick() {
    //                      handler.getMouseManager().setUIManager(null);
                          state = "moves";
                          reset = false;

                        }
                    }));
                      ui2Manager.addObject(new UIImageButton(0,367,128,64, Assets.moves, "moves",new ClickListener(){

                        @Override
                        public void onClick() {
    //                      handler.getMouseManager().setUIManager(null);
                           
                        }
                    }));
                      
            }
         
         }
	@Override
	public void tick() {
		         ui2Manager.tick();
                         
                
	}

	@Override
	public void render(Graphics g) {
         
		g.drawImage(Assets.batalla, 0, 0,600,500, null);
               
               if(reset == false){
                resetComponents();
                setAllObjectsBounds();              
                reset = true;
               }
               ui2Manager.render(g);
	}
	
}
