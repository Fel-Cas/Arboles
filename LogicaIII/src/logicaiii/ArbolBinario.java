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
public class ArbolBinario {
    private NodoDoble raiz;
    /**
     * Este es el constructor del árbol binario
     **/
    public ArbolBinario() {
    }

    /**
     * Método usado para extraer la raíz del árbol
     **/
    public NodoDoble getRaiz() {
        return raiz;
    }
    
    /**
     * Método usado para asignarle la raíz del árbol
     **/
    public void setRaiz(NodoDoble raiz) {
        this.raiz = raiz;
    }
    
    /**
     * Método Usado para convertir el árbol N-Ario representado en Lista Generalizada a Árbol Binario representado
     * en LDL
     **/    
    public void convierteLGABinario(ArbolLG arbol){
        NodoLG p,q;
        NodoDoble x, ultimo;
        Stack pila= new Stack();
        p=arbol.getRaiz();
        x=new NodoDoble(p.getDato());
        raiz=x;
        ultimo=x;
        p=p.getLiga();
        while(p!=null){
            if(p.getSw()==0){
                x= new NodoDoble(p.getDato());                
            }else{
                q=(NodoLG)p.getDato();
                x= new NodoDoble(q.getDato());
                pila.push(x);
                pila.push(q.getLiga());
            }
            ultimo.setLi(x);
            ultimo=x;
            p=p.getLiga();
            while(p!=null){
                if(p.getSw()==0){
                    x= new NodoDoble(p.getDato());
                }else{
                    q=(NodoLG)p.getDato();
                    x=new NodoDoble(q.getDato());
                    pila.push(x);
                    pila.push(q.getLiga());
                }
                ultimo.setLd(x);
                ultimo=x;
                p=p.getLiga();
            }
            if(!pila.empty()){
                p=(NodoLG)pila.pop();
                ultimo=(NodoDoble)pila.pop();
            }
        }
    }
    
    /**
     * Método que calcula el grado del árbol N-ario representado en árbol binario
     **/
    public int gradoNarioEnBinario(NodoDoble r){
        NodoDoble p,q;
        int grado=0, n;
        p=r;
        Stack pila = new Stack();
        if(p==null){
            return 0;
        }
        p=p.getLi();
        while(p!=null){
            grado=grado+1;
            if(p.getLi()!=null){
                pila.push(p);                
            }
            p=p.getLd();            
        }
        while(!pila.empty()){
            n=gradoNarioEnBinario((NodoDoble)pila.pop());
            if(n>grado){
                grado=n;
            }
        }
        return grado;
    }
    
    /**
     * Método que imprime el recorrido Inorden del árbol binario
     **/
    public String inOrden(NodoDoble r){        
       String hilera="";
        if(r!=null){
            hilera= hilera+inOrden((NodoDoble)r.getLi());
            hilera=hilera+ r.getDato();
           hilera=hilera+inOrden((NodoDoble)r.getLd());
        }
       return hilera;        
    }
    
    /**
     * Método que imprime el recorrido posorden del árbol binario
     **/
    public String posOrden(NodoDoble r){        
        String hilera="";
        if(r!=null){
            hilera+=posOrden((NodoDoble)r.getLi());
            hilera+=posOrden((NodoDoble)r.getLd());
            hilera+=r.getDato();
        }
        return hilera;        
    }
    
    /**
     * Método que imprime el recorrido Preorden del árbol binario
     **/
    public String preOrden(NodoDoble r){        
        String hilera="";
        if(r!=null){
            hilera+=r.getDato();
            hilera+=preOrden((NodoDoble)r.getLi());
            hilera+=preOrden((NodoDoble)r.getLd());
        }
        return hilera;
    }
    /**
     * Método que calcula la altura del árbol N-ario representado en Binario
     **/
    public int alturaNarioBinario(NodoDoble r){
        int altura=1,h=0;
        NodoDoble q,p;
        if(r==null)return 0;
        if(r.getLi()==null)return 1;
        p=r.getLi();
        while(p!=null){
            h=0;
            if(p.getLi()!=null){
                h=h+alturaNarioBinario(p);
                if(h>altura){
                    altura=h;
                }                
            }
        p=p.getLd();
        }
    return altura+1;
    }
    
    /**
     * Método que halla el padre N-ario de un dato 
     **/
    public Object padreBinario(NodoDoble r, Object d){
        NodoDoble p,q;
        Object padre=null;
        p=r;
        Stack pila = new Stack();
        if(p==null){
            return padre;
        }
        q=p.getLi();
        while(q!=null){
           if(q.getDato().equals(d)){
               padre=p.getDato();
                return padre;                
            }
           if(q.getLi()!=null){
               pila.push(q.getLd());
               padre=padreBinario(q,d);
           }
            q=q.getLd();
         while(!pila.empty() && padre==null){
            q=(NodoDoble)pila.pop();
        }            
        }
        
        return padre;
    }
    
    /**
     * Método que calcula el número de hojas del árbol N-ario representado en Binario
     **/
    public int hojas(NodoDoble r){
        int h=0;
        NodoDoble p,q;
        p=r;
        Stack pila = new Stack();
        if(p==null){
            return 0;
        }
        if(p.getLi()==null)return 1;
        q=p.getLi();
        while(q!=null){
           if(q.getLi()==null){
              h=h+1;               
            }
           if(q.getLi()!=null){
               pila.push(q);
            }
            q=q.getLd();
             
        }
        while(!pila.empty() && q==null){
            h=h+hojas((NodoDoble)pila.pop());
        }
        
        return h;
        
    }
    
    /**
     * Método que imprime los ancestros de un dato entrado como paŕametro
     **/
    public String ancestros(Object d, String h){
        Object p,q;
        String hilera="";
        Stack pila =new Stack();
        p=this.padreBinario(raiz, d);
        if(p!=null){  
            pila.push(p);
            while(p!=null){
                p=this.padreBinario(raiz, p);
                if(p!=null){
                pila.push(p);
                }
            }
            while(!pila.isEmpty()){
                q=(Object)pila.pop();
                hilera=hilera+q;
            }        
        }
        return hilera+d;
    }
    
    /**
     * Método que imprime el recorrido por niveles del árbol N-ario representando en Binario
     **/
    public String recorreNiveles(){
        Queue<Object> cola=new LinkedList();
        NodoDoble  p=this.raiz;
        int i=1;
        String hilera="";
        hilera= hilera+ p.getDato()+" nivel "+i+"\n";
       p=p.getLi();
       i=i+1;
        while(p!=null){
            hilera= hilera+ p.getDato()+" nivel "+i+"\n";
            if(p.getLi()!=null){
                cola.add(p.getLi());
                cola.add(i+1);
            }
            p=p.getLd();
            while(!cola.isEmpty()&& p==null ){
               p=(NodoDoble)cola.poll();
               i=(int)cola.poll();
            }
        }
        return hilera;
    }
    
    /**
     * Método que busca un dato
     **/
    public NodoDoble buscaDato(Object d, NodoDoble r){
        NodoDoble p,q;
        NodoDoble dato=null;
        p=r;
        Stack pila=new Stack();
        if(p==null){
            return dato;
        }
        if(p.getDato().equals(d)) return p;
        q=p.getLi();
        while(q!=null){
           if(q.getDato().equals(d)){
               dato=q;
               return dato;                
            }
            if(q.getLi()!=null){
               pila.push(q.getLd());
               q=q.getLi();
            }else{
               q=q.getLd();
            }
            
            while(!pila.isEmpty() && q==null){
                q=(NodoDoble)pila.pop();
            }
        }
        
        return dato;
    }
    
    /**
     * Método que calcula el grado de un dato entrado como parámetro
     **/
    public int gradoDeUnDato(Object dato){
        NodoDoble p;
        p=buscaDato(dato,this.raiz);
        if(p==null) return 0;
        if(p.getLi()==null) return 0;
        p=p.getLi();
        int grado=0;
        while(p!=null){
            grado++;
            p=p.getLd();
        }
        return grado;
    }
}
