/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.states;

import java.awt.Graphics;

import dev.tilegame1.Handler;
import dev.tilegame1.gfx.Assets;
import dev.tilegame1.ui.ClickListener;
import dev.tilegame1.ui.UIImageButton;
import dev.tilegame1.ui.UIManager;
import dev.tilegame1.ui.UIObject;

public class MenuState extends State {

        private UIManager uiManager;
        private String state;
        private Boolean booleano;
	public MenuState(final Handler handler){
		super(handler);
                state ="menuState";
                booleano = false;
                uiManager = new UIManager(handler);
                handler.getMouseManager().setUIManager(uiManager);
                
                uiManager.addObject(new UIImageButton(200,200,128,64, Assets.btn_start, "menuState", new ClickListener(){

                    @Override
                    public void onClick() {
//                      handler.getMouseManager().setUIManager(null);
                      State.setState(handler.getGame().gameState);
                      
                    }
                }));
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
	public void tick() {
		uiManager.tick();
        }

	@Override
	public void render(Graphics g) {
		
                if(booleano == false){
                 resetComponents();
                 setAllObjectsBounds();
                 
                 booleano = true;
               }
                uiManager.render(g);
	}
	
}