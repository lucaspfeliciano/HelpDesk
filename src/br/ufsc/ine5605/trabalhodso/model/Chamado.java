/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 04431899944
 */
public class Chamado implements Serializable {
    private String date;
    private String titulo;
    private String descricao;
    private Tecnico tecnico;
    private Prioridade prioridade;//
    private Problema problema;
    private Status status;
    private Usuario usuario;
    ArrayList <RegistroAcompanhamento> registroAcompanhamento = new ArrayList();

    public Chamado(String date, String titulo, String descricao, Tecnico tecnico, Prioridade prioridade, Problema problema, Status status, Usuario usuario) {
        this.date = date;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tecnico = tecnico;
        this.prioridade = prioridade;
        this.problema = problema;
        this.status = status;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public void addRegistroAcompanhamento(RegistroAcompanhamento a) {
        registroAcompanhamento.add(a);
    }

    public ArrayList<RegistroAcompanhamento> getRegistroAcompanhamento() {
        return registroAcompanhamento;
    }

    public void setRegistroAcompanhamento(ArrayList<RegistroAcompanhamento> registroAcompanhamento) {
        this.registroAcompanhamento = registroAcompanhamento;
    }
    
    
}
