  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.states;

import dev.tilegame1.Handler;
import dev.tilegame1.Music.Music;
import dev.tilegame1.gfx.Assets;
import dev.tilegame1.gfx.ImageLoader;
import dev.tilegame1.pokemons.Loader;
import dev.tilegame1.pokemons.Pokemon;
import dev.tilegame1.pokemons.PokemonMov;
import dev.tilegame1.ui.ClickListener;
import dev.tilegame1.ui.UIImageButton;
import dev.tilegame1.ui.UIManager;
import dev.tilegame1.ui.UIObject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SebastianCabarcas
 */
public class BattleState extends State {

    private UIManager ui2Manager;
    int sw = 0;
    private int rwild;
    private int atte;
    private int attmine;
    private float xpgain;
    private float xpmax;
    private float currentxp;
    public static float currenthp = 1;
    private float currentenemyhp;
    private float totalenemyhp;
    private float totalhp;
    private String[] s1, s2, s3, s4;
    private Random random;
    private String state;
    private Boolean reset;
    private float[] damage;
    private float[] basepowmine;
    private float[] basepowenemy;
    private float[] damageEnemy;
    private float y;
    private Pokemon[] pokemonList;
    private PokemonMov[] pokemonListM;
    //private Boolean read;
    private Boolean readMine;
    private Boolean readEnemy;
    private Boolean readM;
    private Boolean load;
    private Boolean deadE;
    private Boolean deadMine;
    private Boolean takexp;
    private Boolean curar;
    private Boolean levelup;
    private Boolean attackMine;
    private Boolean attackEnemy;
    public static Boolean healmine;
    public static Boolean inBattle;
    //private Pokemon pokemonbueno;
    private Loader loader;

    public BattleState(final Handler handler) {
        super(handler);
        //double y = 1.234f;
        random = new Random();
        loader = new Loader();
        damage = new float[4];
        damageEnemy = new float[4];
        basepowmine = new float[4];
        basepowenemy = new float[4];
        // pokemon = new Pokemon(handler.getPlayer().getPokemon());
        state = "battle";
        inBattle = true;
        deadMine = false;
        healmine = false;
        deadE = false;
        reset = false;
        load = true;
        levelup = true;
        takexp = true;
        curar = false;
        takexp = true;
        readM = false;
        attackMine = false;
        attackEnemy = false;
        currentxp = 0;
        xpmax = 6;
        readMine = false;
        readEnemy = false;
        ui2Manager = new UIManager(handler);
        ui2Manager = handler.getMouseManager().getUIManager();

    }

    public void setAllObjectsBounds() {

        if (ui2Manager != null) {
            if (handler.getMouseManager().getUIManager().getObjects() != null) {
                for (UIObject o : handler.getMouseManager().getUIManager().getObjects()) {

                    if (o != null) {

                        if (!o.getState().equals(state)) {
                            o.setX(0);
                            o.setY(0);
                            o.setWidth(0);
                            o.setHeight(0);
                            o.getBounds().height = 1;
                            o.getBounds().width = 1;

                        }
                    }
                }
            }
        }

    }

    public void resetComponents() {

        ui2Manager = handler.getMouseManager().getUIManager();

        if (ui2Manager != null) {

            ui2Manager.addObject(new UIImageButton(460, 420, 128, 64, Assets.run, "battle", new ClickListener() {

                @Override
                public void onClick() {
                    //                      handler.getMouseManager().setUIManager(null);
                    State.setState(handler.getGame().gameState);

                    Music.MENU.stop();
                    //Music.BATALLA.stop();

                    Music.TOWN.play();

                    readEnemy = false;
                    readMine = true;
                    System.out.println(deadMine);
                    System.out.println(deadE);
                    System.out.println(attackMine);
                    System.out.println(attackEnemy);
                }
            }));

            ui2Manager.addObject(new UIImageButton(460, 367, 128, 60, Assets.bag, "battle", new ClickListener() {

                @Override
                public void onClick() {
                    //                      handler.getMouseManager().setUIManager(null);
                    // State.setState(handler.getGame().);

                }
            }));
            ui2Manager.addObject(new UIImageButton(330, 430, 128, 54, Assets.pokemones, "battle", new ClickListener() {

                @Override
                public void onClick() {
                    //                      handler.getMouseManager().setUIManager(null);

                }
            }));
            ui2Manager.addObject(new UIImageButton(330, 367, 128, 50, Assets.fight, "battle", new ClickListener() {

                @Override
                public void onClick() {
                    //                      handler.getMouseManager().setUIManager(null);
                    state = "moves";

                    reset = false;

                }
            }));
            ui2Manager.addObject(new UIImageButton(330, 367, 50, 200, Assets.Blankspace, "moves", new ClickListener() {

                @Override
                public void onClick() {
                    state = "battle";
                    reset = false;

                }
            }));

            ui2Manager.addObject(new UIImageButton(34, 370, 150, 35, Assets.Blankspace, "moves", new ClickListener() {

                @Override
                public void onClick() {
                    //state ="battle";
                    state = "text4";
                    reset = false;

//                   
                    attmine = 0;
                    System.out.println(((int) damage[0]));
                    if ((int) damage[0] == 0 && basepowmine[0] > 0) {
                        damage[0] = (random.nextInt(pokemonList[SelectState.pokemonmine].getLevel()) + 1);
                        currentenemyhp = currentenemyhp - damage[0] * 2;
                        damage[0] = 0;
                    } else {
                        currentenemyhp = currentenemyhp - damage[0] * 2;
                        System.out.println(damage[0] + "oli");
                    }
                    pokemonList[SelectState.pokemonmine].setHp((int) currenthp);
                    pokemonList[rwild].setHp((int) currentenemyhp);
                    attackMine = true;
                    attackEnemy = true;
                    /*if (currenthp<=0) {
                     currenthp=0;  
                     state="text3";
                     deadMine=true;
                     }
                     currentenemyhp = currentenemyhp - damage[0]*2;
                     System.out.println(currentenemyhp);
                     System.out.println(currenthp);
                     pokemonList[1].setHp((int) currenthp);
                     pokemonList[rwild].setHp((int) currentenemyhp);
                     if (currentenemyhp <= 0) {
                     state = "text1";
                     deadE=true;
                   

                     }*/
                }
            }));

            ui2Manager.addObject(new UIImageButton(34, 420, 150, 35, Assets.Blankspace, "moves", new ClickListener() {

                @Override
                public void onClick() {
                    state = "text4";
                    reset = false;
                    attmine = 2;
                    if ((int) damage[2] == 0 && basepowenemy[2] > 0) {
                        damage[2] = (random.nextInt(pokemonList[SelectState.pokemonmine].getLevel()) + pokemonList[SelectState.pokemonmine].getLevel()/2);
                        currentenemyhp = currentenemyhp - damage[2];
                        damage[2] = 0;
                    } else {
                        currentenemyhp = currentenemyhp - damage[2];
                    }
                    pokemonList[SelectState.pokemonmine].setHp((int) currenthp);
                    pokemonList[rwild].setHp((int) currentenemyhp);
                    attackMine = true;
                    attackEnemy = true;

                }
            }));
            ui2Manager.addObject(new UIImageButton(200, 370, 140, 35, Assets.Blankspace, "moves", new ClickListener() {

                @Override
                public void onClick() {
                    //  state ="battle";

                    state = "text4";
                    reset = false;

//                    if (damageEnemy[0] > damageEnemy[1]) {
//                        currenthp = currenthp - damageEnemy[0];
//
//                    } else {
//                        currenthp = currenthp - damageEnemy[1];
//                    }
                    attmine = 1;
                    if ((int) damage[1] == 0 && basepowenemy[1] > 0) {
                        damage[1] = (random.nextInt(pokemonList[SelectState.pokemonmine].getLevel()) + 1);
                        currentenemyhp = currentenemyhp - damage[1];
                        damage[1] = 0;
                    } else {
                        currentenemyhp = currentenemyhp - damage[1];
                    }
                    pokemonList[SelectState.pokemonmine].setHp((int) currenthp);
                    pokemonList[rwild].setHp((int) currentenemyhp);
                    attackMine = true;
                    attackEnemy = true;

                }
            }));
            ui2Manager.addObject(new UIImageButton(200, 420, 140, 35, Assets.Blankspace, "moves", new ClickListener() {

                @Override
                public void onClick() {
                    // state ="battle";
                    reset = false;

                }
            }));
            ui2Manager.addObject(new UIImageButton(34, 350, 300, 200, Assets.Blankspace, "text1", new ClickListener() {

                @Override
                public void onClick() {
                    // state ="battle";
                    reset = false;
                    takexp = true;
                    state = "text2";
                }
            }));
            ui2Manager.addObject(new UIImageButton(34, 350, 300, 200, Assets.Blankspace, "text2", new ClickListener() {

                @Override
                public void onClick() {
                    // state ="battle";
                    reset = false;

                    takexp = true;
                    levelup = false;
                    if (currentxp > xpmax) {
                        state = "text6";
                    } else {
                        State.setState(handler.getGame().gameState);
                        state = "battle";
                        deadE = false;
                    }

                    Music.MENU.stop();
                    Music.TOWN.play();
                }
            }));
            ui2Manager.addObject(new UIImageButton(34, 350, 300, 200, Assets.Blankspace, "text3", new ClickListener() {

                @Override
                public void onClick() {
                    // state ="battle";
                    reset = false;

                    //takexp=true;
                    State.setState(handler.getGame().gameState);
                    
                    pokemonList[SelectState.pokemonmine].setHp((int) totalhp);

                    totalhp = pokemonList[SelectState.pokemonmine].getHp();
                    currenthp = pokemonList[SelectState.pokemonmine].getHp();
                    readEnemy = false;
                    attackEnemy = false;
                    System.out.println("oli" + currenthp);
                    //readMine= false;
                    state = "battle";
                    
                    System.out.println(currenthp);
                    System.out.println(readMine);
                    System.out.println(readEnemy);
                    System.out.println(deadMine);
                    System.out.println(deadE);
                    System.out.println(attackMine);
                    System.out.println(attackEnemy);
                    Music.MENU.stop();
                    Music.TOWN.play();
                   healmine=true;
                }
            }));
            ui2Manager.addObject(new UIImageButton(34, 350, 300, 200, Assets.Blankspace, "text4", new ClickListener() {

                @Override
                public void onClick() {
                    state = "battle";
                    reset = false;
                    // deadMine = false;
                    //takexp=true;
                    attackMine = false;
                    state = "text5";

                    if (currenthp <= 0) {
                        currenthp = 0;
                        state = "text3";
                        deadMine = true;
                    }
                    if (currentenemyhp <= 0) {

                        state = "text1";
                        deadE = true;
                        //    xpgain = ((pokemonList[rwild].getLevel()));
                        //   currentxp = currentxp + xpgain;

                    }

                    //Music.MENU.stop();
                    // Music.BATALLA.play();
                }
            }));
            ui2Manager.addObject(new UIImageButton(34, 350, 300, 200, Assets.Blankspace, "text5", new ClickListener() {

                @Override
                public void onClick() {
                    // state ="battle";
                    reset = false;
                    // deadMine = false;
                    //takexp=true;
                    attackEnemy = false;
                    state = "battle";
                    System.out.println(currenthp);
                    s4 = pokemonList[rwild].getMoves().split(",");
                    if (damageEnemy[0] > damageEnemy[1]) {
                        if ((int) damage[0] == 0 && basepowenemy[0] > 0) {
                            damageEnemy[0] = (random.nextInt(pokemonList[rwild].getLevel()) + pokemonList[rwild].getLevel()/2);
                        }
                        currenthp = currenthp - damageEnemy[0];

                    } else {
                        if ((int) damage[1] == 0 && basepowenemy[1] > 0) {
                             damageEnemy[1] = (random.nextInt(pokemonList[rwild].getLevel()) + pokemonList[rwild].getLevel()/2);
                        }
                        currenthp = currenthp - damageEnemy[1];
                    }
                    if (currenthp <= 0) {
                        currenthp = 0;
                        state = "text3";
                        attackEnemy = true;

                    }

                    //Music.MENU.stop();
                    // Music.BATALLA.play();
                }
            }));

            ui2Manager.addObject(new UIImageButton(34, 350, 300, 200, Assets.Blankspace, "text6", new ClickListener() {

                @Override
                public void onClick() {
                    // state ="battle";

                    s3 = pokemonList[SelectState.pokemonmine].getMoves().split(",");
                    reset = false;

                    attackEnemy = false;
                    if (pokemonList[SelectState.pokemonmine].getLevel() == Integer.parseInt(s3[4])) {

                        state = "text7";
                    } else {
                        State.setState(handler.getGame().gameState);
                        state = "battle";
                        deadE = false;
                    }
                   // takexp =true;

                    Music.MENU.stop();
                    Music.TOWN.play();
                }
            }));
            ui2Manager.addObject(new UIImageButton(34, 350, 300, 200, Assets.Blankspace, "text7", new ClickListener() {

                @Override
                public void onClick() {
                    // state ="battle";
                    reset = false;
                    deadE = false;
                    attackEnemy = false;
                    System.out.println(deadMine);
                    System.out.println(deadE);
                    System.out.println(attackMine);
                    System.out.println(attackEnemy);
                    // takexp =true;
                    State.setState(handler.getGame().gameState);
                    state = "battle";
                    Music.MENU.stop();
                    Music.TOWN.play();
                }
            }));

        }

    }

    @Override
    public void tick() {
        ui2Manager.tick();

    }

    @Override
    public void render(Graphics g) {

        if (reset == false) {
            resetComponents();
            setAllObjectsBounds();
            reset = true;
        }
        if (load == true) {
            try {
                pokemonList = loader.readPokemon();
                pokemonListM = loader.readMov();
                load = false;
            } catch (Exception ex) {
                Logger.getLogger(BattleState.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (inBattle == true) {
            rwild = ((random.nextInt(151)) + 1);
            pokemonList[rwild].setLevel(pokemonList[SelectState.pokemonmine].getLevel());
            inBattle = false;
        }
        Font fuente = new Font("Lucida Console", Font.BOLD, 20);
        g.setFont(fuente);

        if (curar == true) {
            pokemonList[SelectState.pokemonmine].setHp((((2 * pokemonList[SelectState.pokemonmine].getbHp() * pokemonList[SelectState.pokemonmine].getLevel()) / 100) + pokemonList[SelectState.pokemonmine].getLevel() + 10));
            // System.out.println("oli"+currenthp);

        }
        if (currentxp > xpmax && levelup == false) {
            pokemonList[SelectState.pokemonmine].Levelup();
            pokemonList[SelectState.pokemonmine].updateStats();
            xpmax = xpmax + 7;
            readMine = false;
            levelup = true;
            totalhp = pokemonList[SelectState.pokemonmine].getHp();
        }
        if (readMine == false) {//&& attackEnemy==false) {
            //System.out.println("oli");
            //System.out.println(currenthp);

            totalhp = pokemonList[SelectState.pokemonmine].getHp();
            currenthp = pokemonList[SelectState.pokemonmine].getHp();
             //.out.println(currenthp);

            readMine = true;
        }
        if (readEnemy == false && attackMine == false) {
            totalenemyhp = (((2 * pokemonList[rwild].getbHp() * pokemonList[rwild].getLevel()) / 100) + pokemonList[rwild].getLevel() + 10);
            pokemonList[rwild].setHp((int) totalenemyhp);
            currentenemyhp = pokemonList[rwild].getHp();
            //pokemonList[rwild].setLevel(pokemonList[1].getLevel());
            System.out.println(pokemonList[rwild].getHp());
            readM = false;
            readEnemy = true;

        }

        float r = (((currenthp / totalhp)) * 120);

        // System.out.println(r);
        float x = ((currentenemyhp / totalenemyhp) * 120);
        if (currentenemyhp <= 0 && takexp == true) {
            readEnemy = false;
            readM = false;
            xpgain = ((pokemonList[rwild].getLevel()));
            currentxp = currentxp + xpgain;
            takexp = false;
            //System.out.println(currentxp);

        } else {
            if (currenthp <= 0) {
                readM = false;
                // readMine = false;

            }

        }

        //hp =(((2 * this.bHp * this.getLevel()) / 100) + this.getLevel() + 10);
        //  System.out.println(x);
        if (deadMine == false) {
            g.drawImage(Assets.hp, 455, 280, (int) r, 24, null);
            float t = r;
        }

        if (deadE == false) {
            g.drawImage(Assets.hp, 105, 65, (int) x, 24, null);
        }
        if ((deadE == false || deadMine == false) && attackMine == false) {

            g.drawImage(Assets.batalla, 0, 0, 600, 500, null);
        }

        if (state == "text1") {
            g.drawImage(Assets.textinput, 0, 0, 600, 500, null);
            g.drawString("Wild " + pokemonList[rwild].getName(), 40, 410);
            g.drawString("fainted!", 40, 450);
        }
        if (state == "text2") {
            g.drawImage(Assets.textinput, 0, 0, 600, 500, null);
            g.drawString(pokemonList[SelectState.pokemonmine].getName() + " gained ", 40, 410);
            g.drawString(Integer.toString((int) xpgain) + " EXP. Points!", 40, 450);
        }
        if (state == "text3") {
            g.drawImage(Assets.textinput, 0, 0, 600, 500, null);
            g.drawString(pokemonList[SelectState.pokemonmine].getName(), 40, 410);
            g.drawString("Fainted!", 40, 450);
        }
        if (state == "text4") {
            g.drawImage(Assets.textinput, 0, 0, 600, 500, null);
            g.drawString(pokemonList[SelectState.pokemonmine].getName() + " used", 40, 410);
            s1 = pokemonList[SelectState.pokemonmine].getMoves().split(",");
            if (attmine == 0) {
                g.drawString(s1[1], 40, 450);
            } else {
                if (attmine == 1) {
                    g.drawString(s1[3], 40, 450);
                } else {
                    g.drawString(s1[5], 40, 450);
                }
            }
        }
        if (state == "text5") {
            g.drawImage(Assets.textinput, 0, 0, 600, 500, null);
            g.drawString(pokemonList[rwild].getName() + " used", 40, 410);
            s2 = pokemonList[rwild].getMoves().split(",");
            if (atte == 0) {
                g.drawString(s2[1], 40, 450);
            } else {
                if (s2.length > 2) {
                    g.drawString(s2[3], 40, 450);
                }

            }

        }
        if (state == "text6") {
            g.drawImage(Assets.textinput, 0, 0, 600, 500, null);
            g.drawString(pokemonList[SelectState.pokemonmine].getName() + " grew to", 40, 410);
            g.drawString("LvL" + pokemonList[SelectState.pokemonmine].getLevel(), 40, 450);
        }
        if (state == "text7") {
            g.drawImage(Assets.textinput, 0, 0, 600, 500, null);
            g.drawString(pokemonList[SelectState.pokemonmine].getName() + " learned", 40, 410);
            g.drawString(s3[5], 40, 450);
        }
        

        g.drawString(pokemonList[rwild].getName(), 28, 48);
        g.drawString("LvL" + pokemonList[rwild].getLevel() + "", 165, 48);
        g.drawString(pokemonList[SelectState.pokemonmine].getName(), 380, 265);//nombre
        g.drawString("LvL" + pokemonList[SelectState.pokemonmine].getLevel(), 520, 265);//lvl
        g.drawString("" + (int) totalhp, 546, 325);//vida max
        g.drawString("/", 520, 325);
        g.drawString("" + (int) currenthp, 487, 325);//vida act
        g.drawImage(Assets.pokemonsfront[rwild], 340, 30, 200, 200, null);
        g.drawImage(Assets.pokemonsback[SelectState.pokemonmine], 70, 200, 200, 200, null);
        if (deadE == false && deadMine == false && attackMine == false && attackEnemy == false) {
            g.drawString("What Will Do", 40, 410);
            g.drawString(pokemonList[SelectState.pokemonmine].getName() + "?", 40, 450);//nombre   
        }

        if (state == "moves") {
            g.drawImage(Assets.moves, 0, 350, 600, 150, null);
            //g.drawString(state, 200, 400);
            // Font fuente=new Font("Mistral", Font.BOLD, 35);
            s1 = pokemonList[SelectState.pokemonmine].getMoves().split(",");
            s2 = pokemonList[rwild].getMoves().split(",");

            g.drawString(s1[1], 50, 400);
            g.drawString(s1[3], 250, 400);
            if (pokemonList[SelectState.pokemonmine].getLevel() >= 7) {

                g.drawString(s1[5], 50, 450);
            }
            // g.drawString(s1[1], 50, 450);
            if (readM == false) {
                //System.out.println(s2[3]);
                //System.out.println(s2[1]);
                int w = 0;
                for (int i = 1; i < 622; i++) {

                    if (pokemonListM[i].getNameIMov().equals(s1[1])) {
                        damage[0] = (int) ((((2 * pokemonList[SelectState.pokemonmine].getLevel() + 10f) / 250f)) * (pokemonList[SelectState.pokemonmine].getAtt() / pokemonList[SelectState.pokemonmine].getDef()) * (pokemonListM[i].getbPow() + 2));
                        System.out.println(damage[0]);
                        basepowmine[0] = pokemonListM[i].getbPow();
                    }
                    if (pokemonListM[i].getNameIMov().equals(s2[1])) {
                        damageEnemy[0] = (int) ((((2 * pokemonList[rwild].getLevel() + 10f) / 250f)) * (pokemonList[rwild].getAtt() / pokemonList[rwild].getDef()) * (pokemonListM[i].getbPow() + 2));
                        basepowenemy[0] = pokemonListM[i].getbPow();
//  System.out.println(damageEnemy[0]);
                    }

                    if (pokemonListM[i].getNameIMov().equals(s1[3])) {
                        damage[1] = (((2 * pokemonList[SelectState.pokemonmine].getLevel() + 10f) / 250f) * (pokemonList[SelectState.pokemonmine].getAtt() / pokemonList[SelectState.pokemonmine].getDef()) * (pokemonListM[i].getbPow() + 2));
                        basepowmine[1] = pokemonListM[i].getbPow();
                    }
                    if (pokemonList[SelectState.pokemonmine].getLevel() >= Integer.parseInt(s1[4])) {
                        if (pokemonListM[i].getNameIMov().equals(s1[5])) {
                            damage[2] = (((2 * pokemonList[SelectState.pokemonmine].getLevel() + 10f) / 250f) * (pokemonList[SelectState.pokemonmine].getAtt() / pokemonList[SelectState.pokemonmine].getDef()) * (pokemonListM[i].getbPow() + 2));
                            basepowmine[2] = pokemonListM[i].getbPow();
                        }
                    }

                    if (s2.length > 2) {
                        if (pokemonListM[i].getNameIMov().equals(s2[3])) {
                            damageEnemy[1] = (((2 * pokemonList[rwild].getLevel() + 10f) / 250f)) * (pokemonList[rwild].getAtt() / pokemonList[rwild].getDef()) * ((pokemonListM[i].getbPow() + 2));
                            // System.out.println(damageEnemy[1]);
                            w = i;
                            basepowenemy[1] = pokemonListM[i].getbPow();
                        }
                       
                    }

                }
                if (s2.length > 2) {
                    if (damageEnemy[0] > damageEnemy[1]) {
                        atte = 0;

                    } else {
                        atte = 1;

                    }
                } else {

                    atte = 0;
                }
                readM = true;
                //  System.out.println(s2[3]);
             
            }

            g.setFont(fuente);

            g.drawString("--", 50, 450);

            g.drawString("--", 250, 450);
            // g.drawString("12", 500, 413);
            // g.drawString("12", 550, 413);
            g.drawString("--", 480, 460);

        }

        ui2Manager.render(g);
    }

}
