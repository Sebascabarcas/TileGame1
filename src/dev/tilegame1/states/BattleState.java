  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.states;

import dev.tilegame1.Handler;
import dev.tilegame1.gfx.Assets;
import dev.tilegame1.gfx.ImageLoader;
import dev.tilegame1.pokemons.Pokemon;
import dev.tilegame1.ui.ClickListener;
import dev.tilegame1.ui.UIImageButton;
import dev.tilegame1.ui.UIManager;
import dev.tilegame1.ui.UIObject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     //  private Pokemon pokemon;
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
               
                    ui2Manager.addObject(new UIImageButton(460,420,128,64, Assets.run, "battle",new ClickListener(){


                        @Override
                        public void onClick() {
    //                      handler.getMouseManager().setUIManager(null);
                          State.setState(handler.getGame().gameState);


                        }
                    }));
                    
                    ui2Manager.addObject(new UIImageButton(460,367,128,60, Assets.bag,"battle", new ClickListener(){

                        @Override
                        public void onClick() {
    //                      handler.getMouseManager().setUIManager(null);
                         // State.setState(handler.getGame().);


                        }
                    }));
                     ui2Manager.addObject(new UIImageButton(330,430,128,54, Assets.pokemones, "battle",new ClickListener(){

                        @Override
                        public void onClick() {
    //                      handler.getMouseManager().setUIManager(null);



                        }
                    }));
                      ui2Manager.addObject(new UIImageButton(330,367,128,50, Assets.fight, "battle",new ClickListener(){

                        @Override
                        public void onClick() {
    //                      handler.getMouseManager().setUIManager(null);
                          state = "moves";
                          reset = false;
                          

                        }
                    }));
                     ui2Manager.addObject(new UIImageButton(330,367,50,200, Assets.Blankspace, "moves",new ClickListener(){

                         @Override
                          public void onClick() {
                          state ="battle";
                          reset= false;
                           
                        }
                    }));
                    
                    ui2Manager.addObject(new UIImageButton(34,370,150,35, Assets.Blankspace, "moves",new ClickListener(){

                         @Override
                          public void onClick() {
                        //  state ="battle";
                          reset= false;
                           
                        }
                    }));
                   
                    ui2Manager.addObject(new UIImageButton(34,420,150,35, Assets.Blankspace, "moves",new ClickListener(){

                         @Override
                          public void onClick() {
                        //  state ="battle";
                          reset= false;
                           
                        }
                    }));
                    ui2Manager.addObject(new UIImageButton(200,370,140,35, Assets.Blankspace, "moves",new ClickListener(){

                         @Override
                          public void onClick() {
                        //  state ="battle";
                          reset= false;
                           
                        }
                    }));
                    ui2Manager.addObject(new UIImageButton(200,420,140,35, Assets.Blankspace, "moves",new ClickListener(){

                         @Override
                          public void onClick() {
                         // state ="battle";
                          reset= false;
                           
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
                Font fuente=new Font("Mistral", Font.BOLD, 35);
                g.setFont(fuente);
                g.drawString("--", 28, 48);
                g.drawString("--", 185, 48);
                g.drawString("--", 380, 265);
                g.drawString("--", 540, 265);
                g.drawString("--", 550, 325);
                g.drawString("/", 518, 325);
                g.drawString("--", 490, 325);
                g.drawImage(Assets.pokemonsfront[0],340,30, 200, 200, null);
                g.drawImage(Assets.pokemonsback[0],70,200, 200, 200, null);
                
               if(reset == false){
                resetComponents();
                setAllObjectsBounds();              
                reset = true;
               }
                
                
               
               if (state=="moves") {
                g.drawImage(Assets.moves, 0, 350, 600, 150, null);
                //g.drawString(state, 200, 400);
               // Font fuente=new Font("Mistral", Font.BOLD, 35);
                g.setFont(fuente);
                g.drawString("--", 50, 450);
                g.drawString("--", 50, 400);
                g.drawString("--", 250, 400);
                g.drawString("--", 250, 450);
                g.drawString("12", 500, 413);
                g.drawString("12", 550, 413);
                g.drawString("--", 480, 460);


            }
               ui2Manager.render(g);
	}
	
}
