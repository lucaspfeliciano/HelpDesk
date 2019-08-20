/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.mapeadores;

import br.ufsc.ine5605.trabalhodso.model.Tecnico;
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
public class MapeadorTecnico {
    private HashMap<Long, Tecnico> cacheTecnicos; 
    private final String filename = "tecnicos.dat";
    
    public MapeadorTecnico(){
        cacheTecnicos = new HashMap<>();
        load();
    }
    
    public Tecnico get(long cpfTecnico) {
        return cacheTecnicos.get(cpfTecnico);
    }
    
    public void put (Tecnico tecnico) {
        cacheTecnicos.put(tecnico.getCpf(), tecnico);
        persist();
    }
    public void remove(Tecnico tecnico) {
        cacheTecnicos.remove(tecnico.getCpf());
        persist();
    }
    
    public void persist(){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cacheTecnicos);
            
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
            
            this.cacheTecnicos = (HashMap<Long, Tecnico>) oi.readObject();
            
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
    public ArrayList<Tecnico> getList() {
        return new ArrayList(cacheTecnicos.values());
    }    
}
