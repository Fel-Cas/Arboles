/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaiii;

/**
 *
 * @author andres.castro3
 */
public class NodoLG {
    private Object dato;
    private NodoLG liga;
    private int sw;
    
    /**
     * Método Constructor del Nodo Lista Generalizada
     **/
    public NodoLG(Object dato){
        this.dato= dato;
        this.liga=null;
        this.sw=0;
    }

    /**
     * Método que obtiene el dato del nodo lista generalizada
     **/
    public Object getDato() {
        return dato;
    }

    /**
     * Método que asigna valor al dato del nodo lista generalizada
     **/
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * Método que obtiene la liga del nodo lista generalizada
     **/
    public NodoLG getLiga() {
        return liga;
    }

    /**
     * Método que asigna la Liga del nodo lista generalizada
     **/
    public void setLiga(NodoLG liga) {
        this.liga = liga;
    }

    /**
     * Método que obtiene el switch del nodo lista generalizada
     **/
    public int getSw() {
        return sw;
    }

    /**
     * Método que asigna el switch al nodo lista generalizada
     **/
    public void setSw(int sw) {
        this.sw = sw;
    }
}
