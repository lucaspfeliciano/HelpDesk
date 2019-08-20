/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.view;

import java.util.ArrayList;
import java.util.Date;
import br.ufsc.ine5605.trabalhodso.model.Prioridade;
import br.ufsc.ine5605.trabalhodso.model.Problema;
import br.ufsc.ine5605.trabalhodso.model.Status;
import br.ufsc.ine5605.trabalhodso.model.Tecnico;
import br.ufsc.ine5605.trabalhodso.model.RegistroAcompanhamento;
import br.ufsc.ine5605.trabalhodso.model.Usuario;

/**
 *
 * @author 11193319943
 */
public class ConteudoTelaChamado {
    public String date;//
    public String titulo;//
    public String descricao;//
    public Tecnico tecnico;//
    public Prioridade prioridade;//
    public Problema problema;
    public Status status;//
    public Usuario usuario;//

    public ConteudoTelaChamado(String date, String titulo, String descricao, Tecnico tecnico, Prioridade prioridade, Problema problema, Status status, Usuario usuario) {
        this.date = date;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tecnico = tecnico;
        this.prioridade = prioridade;
        this.problema = problema;
        this.status = status;
        this.usuario = usuario;
    }
    
    public ConteudoTelaChamado() {
        date = "";
        this.titulo = "";
        descricao = "";
        tecnico = null;
        prioridade = Prioridade.NORMAL;
        problema = null;
        status = Status.INICIADO;
    }
}
