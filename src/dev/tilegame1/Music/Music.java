/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.Music;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author SebastianCabarcas
 */
import java.applet.Applet;
import java.applet.AudioClip;

public class Music {
	public static final AudioClip TOWN = Applet.newAudioClip(Music.class.getResource("/res/sounds/bt2.wav"));
	public static final AudioClip BATALLA= Applet.newAudioClip(Music.class.getResource("/res/sounds/bb4.wav"));
	public static final AudioClip MENU = Applet.newAudioClip(Music.class.getResource("/res/sounds/bb3.wav"));
	//public static final AudioClip GANAR = Applet.newAudioClip(Music.class.getResource("/res/sounds/BT6.wav"));
	//public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));
	//public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("back.wav"));
}
