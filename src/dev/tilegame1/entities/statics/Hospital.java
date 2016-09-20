/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.entities.statics;

import dev.tilegame1.Handler;
import dev.tilegame1.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author SebastianCabarcas
 */
public class Hospital extends StaticEntity{
    
    public Hospital (Handler handler, float x, float y){
        super(handler, x, y, 170, 137);
            
        bounds.x = 0;
        bounds.y = 60;
        bounds.width = width + 5;
        bounds.height = height - 60;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.hospital, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
    
}