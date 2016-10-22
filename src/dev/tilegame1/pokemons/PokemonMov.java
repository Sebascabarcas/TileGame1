/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.pokemons;

/**
 *
 * @author SebastianCabarcas
 */
public class PokemonMov {
    private int Idmove;
    private String nameIMov;
    private String nameMov;
    private String effM;
    private int bPow;
    private String TypeM;
    private String damCat;
    private int accu;
    private int TotalPP;
    private int addeffc;
    private int target;
    private String descrip;
    private String flags;
    private int prio;
    
    public PokemonMov(int Idmove, String nameIMov, String nameMov, String effM, int bPow, String TypeM, String damCat, int accu, int TotalPP, int addeffc, int target, String descrip, String flags, int prio){
    this.Idmove = Idmove;
    this.nameIMov = nameIMov;
    this.nameMov = nameMov;
    this.effM = effM;
    this.bPow = bPow;
    this.TypeM = TypeM;
    this.damCat = damCat;
    this.accu = accu;
    this.TotalPP = TotalPP;
    this.addeffc = addeffc;
    this.target = target; 
    this.descrip = descrip;
    this.flags = flags;
    this.prio = prio;
            }

    

    public int getIdmove() {
        return Idmove;
    }

    public void setIdmove(int Idmove) {
        this.Idmove = Idmove;
    }

    public String getNameIMov() {
        return nameIMov;
    }

    public void setNameIMov(String nameIMov) {
        this.nameIMov = nameIMov;
    }

    public String getNameMov() {
        return nameMov;
    }

    public void setNameMov(String nameMov) {
        this.nameMov = nameMov;
    }

    public String getEffM() {
        return effM;
    }

    public void setEffM(String effM) {
        this.effM = effM;
    }

    public int getbPow() {
        return bPow;
    }

    public void setbPow(int bPow) {
        this.bPow = bPow;
    }

    public String getTypeM() {
        return TypeM;
    }

    public void setTypeM(String TypeM) {
        this.TypeM = TypeM;
    }

    public String getDamCat() {
        return damCat;
    }

    public void setDamCat(String damCat) {
        this.damCat = damCat;
    }

    public int getAccu() {
        return accu;
    }

    public void setAccu(int accu) {
        this.accu = accu;
    }

    public int getTotalPP() {
        return TotalPP;
    }

    public void setTotalPP(int TotalPP) {
        this.TotalPP = TotalPP;
    }

    public int getAddeffc() {
        return addeffc;
    }

    public void setAddeffc(int addeffc) {
        this.addeffc = addeffc;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }
 
    
}
    
    