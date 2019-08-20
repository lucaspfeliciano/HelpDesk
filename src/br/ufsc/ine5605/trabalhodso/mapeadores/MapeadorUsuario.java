/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.mapeadores;

import br.ufsc.ine5605.trabalhodso.model.Usuario;
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
public class MapeadorUsuario {
    
    private HashMap<Long, Usuario> cacheUsuarios; 
    private final String filename = "usuarios.dat";
    
    public MapeadorUsuario(){
        cacheUsuarios = new HashMap<>();
        load();
    }
    
    public Usuario get(long cpfUsuario) {
        return cacheUsuarios.get(cpfUsuario);
    }
    
    public void put (Usuario usuario) {
        cacheUsuarios.put(usuario.getCpf(), usuario);
        persist();
    }
    public void remove(Usuario usuario) {
        cacheUsuarios.remove(usuario.getCpf());
        persist();
    }
    
    public void persist(){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cacheUsuarios);
            
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
            
            this.cacheUsuarios = (HashMap<Long, Usuario>) oi.readObject();
            
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
    public ArrayList<Usuario> getList() {
        return new ArrayList(cacheUsuarios.values());
    }    
}
