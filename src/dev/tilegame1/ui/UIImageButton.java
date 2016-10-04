/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.ui;

import dev.tilegame1.states.State;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author SebastianCabarcas
 */
public class UIImageButton extends UIObject {

	private BufferedImage[] images;
	private ClickListener clicker;
      
	
	public UIImageButton(int x, int y, int width, int height, BufferedImage[] images, String state, ClickListener clicker) {
		super(x, y, width, height, state);
		this.images = images;
		this.clicker = clicker;
                this.state = state;
	}

   

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		if(hovering){
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
                        g.drawRect(bounds.x, bounds.y, bounds.width+5, bounds.height+5);
                }else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}
        
        public void setState(String state){
           this.state = state;
        }

}
