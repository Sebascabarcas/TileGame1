/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right;
        private int lastbuttom;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
                
                
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
                lastbuttom = e.getKeyCode();
            
	}

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean[] getKeys() {
        return keys;
    }
    

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
                
	}

	@Override
	public void keyTyped(KeyEvent e) {
        }
    
        
        public int lastMov(KeyEvent e){
        lastbuttom = e.getKeyCode();
        return lastbuttom;
        }
    
        	
}

