/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.entities.statics;

import dev.tilegame1.Handler;
import dev.tilegame1.gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author SebastianCabarcas
 */
public class Gym extends StaticEntity{
    
    private Rectangle rectangle;
    private Graphics g;
    
    public Gym (Handler handler, float x, float y){
        super(handler, x, y, 230, 197);
            
        bounds.x = 0;
        bounds.y = 80;
        bounds.width = width + 5;
        bounds.height = height - 80;
        
    }
  
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.gym, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
    
}
