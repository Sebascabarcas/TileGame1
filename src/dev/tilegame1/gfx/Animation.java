/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.gfx;

import dev.tilegame1.input.KeyManager;
import java.awt.image.BufferedImage;

/**
 *
 * @author SebastianCabarcas
 */
public class Animation {
	
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
        private KeyManager keyManager; 
	
	public Animation(int speed, BufferedImage[] frames){
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
                keyManager = new KeyManager();
	}
	
	public void tick(){
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
           
                 if(timer > speed){
			index++;
			timer = 0;
			if(index >= frames.length)
				index = 0;
		}
                 
            
		
	}
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}

}
