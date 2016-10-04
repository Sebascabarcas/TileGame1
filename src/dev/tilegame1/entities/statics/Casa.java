/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.entities.statics;

import dev.tilegame1.Handler;
import dev.tilegame1.entities.Entity;
import dev.tilegame1.gfx.Assets;
import dev.tilegame1.tiles.Tile;
import java.awt.Graphics;

/**
 *
 * @author SebastianCabarcas
 */

    
    public class Casa extends Entity {

    public Casa(Handler handler, float x, float y, int widht, int height) {
        super(handler, x, y, Tile.TILEWIDTH*3, Tile.TILEHEIGHT*3);
        bounds.x=32;
        bounds.y=35;
        bounds.width=175;
        bounds.height=135;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        
     //   g.drawImage(Assets.casa, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
      
        
    }
}

