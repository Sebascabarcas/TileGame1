/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.states;

import java.awt.Graphics;

import dev.tilegame1.Handler;
import java.awt.Color;

public class MenuState extends State {

	public MenuState(Handler handler){
		super(handler);
	}

	@Override
	public void tick() {
		if(handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
	}
	
}