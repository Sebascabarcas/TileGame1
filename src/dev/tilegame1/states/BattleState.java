/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.states;

import dev.tilegame1.Handler;
import dev.tilegame1.gfx.ImageLoader;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author SebastianCabarcas
 */
public class BattleState extends State {
       private BufferedImage bi;
	public BattleState (Handler handler){
		super(handler);
              
	}

	@Override
	public void tick() {
		            System.out.println("aqui toy");

	}

	@Override
	public void render(Graphics g) {
            System.out.println("aqui toy");
		g.setColor(Color.RED);
		g.drawOval(100, 100, 100, 100);
               
	}
	
}
