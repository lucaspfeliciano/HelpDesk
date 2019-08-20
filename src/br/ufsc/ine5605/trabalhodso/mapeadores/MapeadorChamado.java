/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.mapeadores;
import br.ufsc.ine5605.trabalhodso.model.Chamado;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author 11193319943
 */



/**
 *
 * @author 11193319943
 */
public class MapeadorChamado {
    private HashMap<String, Chamado> cacheChamados; 
    private final String filename = "chamados.dat";
    
    public MapeadorChamado(){
        cacheChamados = new HashMap<>();
        load();
    }
    
    public Chamado get(long tituloChamado) {
        return cacheChamados.get(tituloChamado);
    }
    
    
    public void put (Chamado chamado) {
        cacheChamados.put(chamado.getTitulo(), chamado);
        persist();
    }
    
 
    
    public void remove(Chamado chamado) {
        cacheChamados.remove(chamado.getTitulo());
        persist();
    }
    
    
    public void persist(){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cacheChamados);
            
            oo.flush();
            fout.flush();
            
            oo.close();
            fout.close();
         
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void load() { 
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fin);
            
            this.cacheChamados = (HashMap<String, Chamado>) oi.readObject();
            
            oi.close();
            fin.close();
          
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex){
            System.out.println(ex);
        }
                
    }
    public ArrayList<Chamado> getList() {
        return new ArrayList(cacheChamados.values());
    }    
    
}

