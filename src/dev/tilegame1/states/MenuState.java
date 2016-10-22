/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.states;

import java.awt.Graphics;

import dev.tilegame1.Handler;
import dev.tilegame1.Music.Music;
import dev.tilegame1.gfx.Assets;
import dev.tilegame1.ui.ClickListener;
import dev.tilegame1.ui.UIImageButton;
import dev.tilegame1.ui.UIManager;
import dev.tilegame1.ui.UIObject;

public class MenuState extends State {

    private UIManager uiManager;
    private String state;
    private Boolean booleano;

    public MenuState(final Handler handler) {
        super(handler);
        state = "menuState";
        booleano = false;
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        Music.BATALLA.play();
        
       
    }

    public void resetComponents() {
         // uiManager = handler.getMouseManager().getUIManager();
       
        
          uiManager.addObject(new UIImageButton(5, 250,170, 70, Assets.Blankspace, "menuState", new ClickListener() {

            @Override
            public void onClick() {
                booleano=false;
//                      handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().selectState);
                //Music.BATALLA.stop();
               // Music.TOWN.play();
              // state="menustate1";
                

            }
        }));
          
      
    }

    public void setAllObjectsBounds() {

        if (uiManager != null) {
            if (handler.getMouseManager().getUIManager().getObjects() != null) {
                for (UIObject o : handler.getMouseManager().getUIManager().getObjects()) {

                    if (o != null) {

                        if (!o.getState().equals(state)) {
                            o.setX(0);
                            o.setY(0);
                            o.setWidth(0);
                            o.setHeight(0);
                            o.getBounds().height = 1;
                            o.getBounds().width = 1;

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
      // handler.getGame().getDisplay().getFrame().setIconImage(Assets.menu);
       if (booleano == false) {
            resetComponents();
            setAllObjectsBounds();

            booleano = true;
        }
           g.drawImage(Assets.menu, 0,0,600, 500, null);  
       

    //g.drawImage(Assets.dirt, 0,0,600, 500, null);
      
        
        
        
        uiManager.render(g);
    }

}
