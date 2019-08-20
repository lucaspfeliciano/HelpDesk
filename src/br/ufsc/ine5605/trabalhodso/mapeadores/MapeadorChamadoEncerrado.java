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



public class MapeadorChamadoEncerrado {
    private HashMap<String, Chamado> cacheChamadosEncerrados; 
    private final String filename = "chamadosEncerrados.dat";
    
    public MapeadorChamadoEncerrado(){
        cacheChamadosEncerrados = new HashMap<>();
        load();
    }
    
    public Chamado get(long tituloChamado) {
        return cacheChamadosEncerrados.get(tituloChamado);
    }
    
    
    public void put (Chamado chamado) {
        cacheChamadosEncerrados.put(chamado.getTitulo(), chamado);
        persist();
    }
    
 
    
    public void remove(Chamado chamado) {
        cacheChamadosEncerrados.remove(chamado.getTitulo());
        persist();
    }
    
    
    public void persist(){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cacheChamadosEncerrados);
            
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
            
            this.cacheChamadosEncerrados = (HashMap<String, Chamado>) oi.readObject();
            
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
        return new ArrayList(cacheChamadosEncerrados.values());
    }    
    
}

