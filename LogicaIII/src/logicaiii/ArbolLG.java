/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaiii;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author andres.castro3
 */
public class ArbolLG {
   private NodoLG raiz;
/**
 * Método constructor árbol n-ario representado en lista generalizada
 **/
    public ArbolLG() {
        this.raiz=null;
    }
    
   /**
    * Método que obtiene la raíz del árbol
    **/
    public NodoLG getRaiz() {
        return raiz;
    }
    
    /**
     * Método que asigna la raíz al árbol
     **/
    public void setRaiz(NodoLG raiz) {
        this.raiz = raiz;
    }

    /**
     * Método que construye el árbol N-ario en lista generalizada a partir de la hilera 
     **/
    public void construyeArbol(String hilera){
        int i,n;
        Stack pila=new Stack();
        NodoLG primero1,ultimo1,x;
        primero1=new NodoLG(null);
        ultimo1=primero1;
        this.raiz=primero1;
        primero1.setDato(hilera.charAt(1));
        n=hilera.length();
        if(n==3){            
            return;
        }
        i=3;
        while(i<=n-3){
            x=new NodoLG(null);
            ultimo1.setLiga(x);
            ultimo1=x;
            if(hilera.charAt(i+1)=='('){
                ultimo1.setSw(1);
                pila.push(ultimo1);
                x=new NodoLG(hilera.charAt(i));
                ultimo1.setDato(x);
                ultimo1=x;
                i=i+2;
            }else{
                ultimo1.setDato(hilera.charAt(i));
                if(hilera.charAt(i+1)==')'){
                    i=i+1;
                    while((i<n-1) && (hilera.charAt(i)==')') && !pila.empty()){
                        ultimo1=(NodoLG)pila.pop();
                        i++;
                    }
                    if(hilera.charAt(i)==','){
                        i++;
                    }
                    }else{
                     i=i+2;
                    }

                }
            }


    }
    
    /**
     * Método que reconstruye la hilera entrada recorriendo el árbol
     **/
    public String imprimirArbol(int band, NodoLG r){
        NodoLG p, primero, q;
        String arbol="";
        if(r==null){
            arbol+=("Una cosa , es una cosa y otra cosa, es otra cosa");
            return arbol;
        }
        primero=null;
        if(band==0){
            arbol += ("("+ r.getDato());
            if(r.getLiga()==null){
                arbol+= ")";
                return arbol;
            }
            arbol+="(";
            primero=r;
        }
        p=r.getLiga();
        while(p!=null){
            if(p.getSw()==0){
                arbol+= (p.getDato());
            }else{
                    q=(NodoLG)p.getDato();
                    arbol+=(q.getDato()+"(");
                    arbol+= imprimirArbol(1,(NodoLG)p.getDato());
                    }
            if(p.getLiga()!= null){
                arbol+=(",");    
            }
            p=p.getLiga();

        }
        arbol+=(")");
        if(primero==r){
            arbol+=(")");
        }
        return arbol;
    } 
    
    /**
     * Método que imprime el árbol representado en lista generalizada
     **/
    public void escribirArbol(NodoLG r){
        NodoLG p,q,w;
        Object h, i;
        Stack pila=new Stack();
        p=r.getLiga();
        Queue<Object> cola=new LinkedList();
        w=r;
        h=w.getDato();
        while(p!=null){
            if(p.getSw()==1){      
                q=(NodoLG) p.getDato();
                System.out.println(h+" \033[33mes padre de \033[30m"+q.getDato());                
                pila.push(q);
            }else{
                System.out.println(h+" \033[33mes padre de \033[30m"+p.getDato());
            }
            p=p.getLiga();
            if(p==null && !pila.empty()){
                p=(NodoLG) pila.pop();
                h=p.getDato();
                p=p.getLiga();
            }            

        }        
    }
}
