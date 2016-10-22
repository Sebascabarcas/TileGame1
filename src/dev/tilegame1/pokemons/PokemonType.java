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
public class PokemonType {
    private int IdType;
    private String nameType;
    private String InameType;
    private String specialType;
    private String weaknesses;
    private String resistances;
    private String inmunities;
    
   public PokemonType(int Idtype,String nameType, String InameType, String specialType, String weaknesses, String resistances, String inmunities) {
    this.IdType=IdType; 
    this.nameType=nameType;
    this.InameType=InameType;
    this.specialType=specialType;
    this.weaknesses= weaknesses;
    this.resistances=resistances;
    this.inmunities=inmunities;
    
       //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdType() {
        return IdType;
    }

    public void setIdType(int IdType) {
        this.IdType = IdType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getInameType() {
        return InameType;
    }

    public void setInameType(String InameType) {
        this.InameType = InameType;
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses = weaknesses;
    }

    public String getResistances() {
        return resistances;
    }

    public void setResistances(String resistances) {
        this.resistances = resistances;
    }

    public String getInmunities() {
        return inmunities;
    }

    public void setInmunities(String inmunities) {
        this.inmunities = inmunities;
    }
  
}
