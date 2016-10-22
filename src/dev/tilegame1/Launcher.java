/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1;


public class Launcher {

	public static void main(String[] args){
		Game game = new Game("Snorloko", 600, 500);
		game.start();
	}
	
}