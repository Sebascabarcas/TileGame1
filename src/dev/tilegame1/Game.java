/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*Cara e verga rada*/
package dev.tilegame1;

import dev.tilegame1.Music.Music;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.tilegame1.display.Display;
import dev.tilegame1.entities.creatures.Creature;
import dev.tilegame1.gfx.Assets;
import dev.tilegame1.gfx.GameCamera;
import dev.tilegame1.input.KeyManager;
import dev.tilegame1.input.MouseManager;
import dev.tilegame1.states.BattleState;
import dev.tilegame1.states.GameState;
import dev.tilegame1.states.MenuState;
import dev.tilegame1.states.State;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	public State menuState;
        public State battleState;
	
	//Input
	private KeyManager keyManager;
        private MouseManager mouseManager;
        
        //Camera
        private GameCamera gameCamera;
	
        //Handler
        private Handler handler;
        
        //Music
        private Music music;
        
        //
        private Creature creature;
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
                mouseManager = new MouseManager();

	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
                display.getFrame().addMouseListener(mouseManager);
                display.getFrame().addMouseMotionListener(mouseManager);
                display.getCanvas().addMouseListener(mouseManager);
                display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
	       
                handler = new Handler(this);
                gameCamera = new GameCamera(handler,0,0 );
                
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
                battleState = new BattleState(handler);
		State.setState(menuState);
                
	}
	
	private void tick(){
		keyManager.tick();
		if(State.getState() != null)
			State.getState().tick();
	     
              
           
        }
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		if(State.getState() != null)
			State.getState().render(g);
                
           
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
        public MouseManager getMouseManager(){
        return mouseManager;
        }
        public GameCamera getGameCamera(){
            return gameCamera;
        }
        
        public int getWidth(){
          return width;
        }
        
        public int getHeight(){
          return height;
        }
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
       
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

