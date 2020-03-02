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
public class NodoDoble {
    private Object dato;
    private NodoDoble ld;
    private NodoDoble li;

    /**
     * Método Constructor del nodo doble
     **/
    public NodoDoble(Object dato) {
        this.dato = dato;
        this.ld = null;
        this.li = null;
    }    

    /**
     * Método que obtiene el dato del nodo doble
     **/
    public Object getDato() {
        return dato;
    }

    /**
     * Método que asigna el dato al nodo doble
     **/
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * Método que obtiene la liga derecha del nodo doble
     **/
    public NodoDoble getLd() {
        return ld;
    }

    /**
     * Método que asigna la liga derecha al nodo doble
     **/
    public void setLd(NodoDoble ld) {
        this.ld = ld;
    }

    /**
     * Método que obtiene la liga izquierda del nodo doble
     **/
    public NodoDoble getLi() {
        return li;
    }

    /**
     * Método que asigna la liga izquierda al nodo doble
     **/
    public void setLi(NodoDoble li) {
        this.li = li;
    }
}
