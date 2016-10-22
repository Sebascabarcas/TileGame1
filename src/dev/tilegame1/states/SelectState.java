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
import java.awt.Font;

public class SelectState extends State {

    private UIManager ui3Manager;
    private String state;
    private Boolean reset;
    public static int pokemonmine;

    public SelectState(final Handler handler) {
        super(handler);
        state = "selectState";
       reset = false;
        ui3Manager = new UIManager(handler);
        ui3Manager = handler.getMouseManager().getUIManager();
        
        //Music.BATALLA.play();
        
    
      
    }

    public void resetComponents() {
        ui3Manager = handler.getMouseManager().getUIManager();
             ui3Manager.addObject(new UIImageButton(75, 120,170, 300, Assets.Blankspace, "selectState", new ClickListener() {

            @Override
            public void onClick() {
                reset=false;
                pokemonmine=4;
//            handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
                Music.BATALLA.stop();
                Music.TOWN.play();
                
                

            }
        }));
        ui3Manager.addObject(new UIImageButton(225, 180,170, 220, Assets.Blankspace, "selectState", new ClickListener() {

            @Override
            public void onClick() {
                reset=false;
                pokemonmine=7;
//                      handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
                Music.BATALLA.stop();
                Music.TOWN.play();
                

            }
        }));
        ui3Manager.addObject(new UIImageButton(390, 200,170, 175, Assets.Blankspace, "selectState", new ClickListener() {

            @Override
            public void onClick() {
                reset=false;
                pokemonmine=1;
//                      handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
                Music.BATALLA.stop();
                Music.TOWN.play();
                

            }
        }));
    }

    public void setAllObjectsBounds() {

        if (ui3Manager != null) {
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
        ui3Manager.tick();
    }

    @Override
    public void render(Graphics g) {
      // handler.getGame().getDisplay().getFrame().setIconImage(Assets.menu);
       
       //    g.drawImage(Assets.menu, 0,0,600, 500, null);  
        

    //g.drawImage(Assets.dirt, 0,0,600, 500, null);
        Font fuente = new Font("Agency FB", Font.BOLD, 26);
        g.setFont(fuente);
            
        g.drawImage(Assets.escoger, 0, 0,600,500, null);
        
        if (reset== false) {
            resetComponents();
            setAllObjectsBounds();

            reset = true;
        }
        
        g.drawString("CHARMANDER", 110, 150);
        g.drawString("SQUIRTLE", 280, 210);
        g.drawString("BULBASAUR", 400, 230);
        
         Font fente = new Font("Agency FB", Font.BOLD, 49);
        g.setFont(fente);
        g.drawString("SELECT YOUR POKEMON", 115, 50);
       
        ui3Manager.render(g);
    }

}
