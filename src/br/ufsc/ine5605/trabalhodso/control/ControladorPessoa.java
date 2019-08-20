/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.control;

/**
 *
 * @author 11193319943
 */
import br.ufsc.ine5605.trabalhodso.view.TelaPessoaGrafica;
import br.ufsc.ine5605.trabalhodso.view.TelaPessoa;
import java.util.ArrayList;
import br.ufsc.ine5605.trabalhodso.exceptions.PessoaInexistenteException;
import br.ufsc.ine5605.trabalhodso.exceptions.PessoaJaCadastradaException;
import br.ufsc.ine5605.trabalhodso.mapeadores.MapeadorTecnico;
import br.ufsc.ine5605.trabalhodso.mapeadores.MapeadorUsuario;
import br.ufsc.ine5605.trabalhodso.model.Tecnico;
import br.ufsc.ine5605.trabalhodso.model.Usuario;
import br.ufsc.ine5605.trabalhodso.view.ConteudoTelaTecnico;
import br.ufsc.ine5605.trabalhodso.view.ConteudoTelaUsuario;
import br.ufsc.ine5605.trabalhodso.view.TelaCadastro;
import br.ufsc.ine5605.trabalhodso.view.TelaCadastroTecnico;
import br.ufsc.ine5605.trabalhodso.view.TelaCadastroUsu;
import br.ufsc.ine5605.trabalhodso.view.TelaCadastroUsuario;
import br.ufsc.ine5605.trabalhodso.view.TelaExclusaoTec;
import br.ufsc.ine5605.trabalhodso.view.TelaExclusaoUsu;

public class ControladorPessoa {
    
    
    private static ControladorPessoa instancia;
    
    private TelaPessoa telaPessoa;
    private TelaPessoaGrafica telaPessoaGrafica;
    private TelaCadastroTecnico telaCadastroTecnico;
    private TelaCadastroUsuario telaCadastroUsuario;
    private TelaCadastro telaCadastro;
    private TelaCadastroUsu telaCadastroUsu;
    private TelaExclusaoTec telaExclusaoTec;
    private TelaExclusaoUsu telaExclusaoUsu;
    private MapeadorUsuario mapeadorUsuario;
    private MapeadorTecnico mapeadorTecnico; 
    
    

    private ControladorPessoa() {
        this.telaPessoa = new TelaPessoa();
        this.telaPessoaGrafica = new TelaPessoaGrafica();
        this.telaCadastroUsuario = new TelaCadastroUsuario();
        this.telaCadastroTecnico = new TelaCadastroTecnico();
        this.telaCadastro = new TelaCadastro();
        this.telaCadastroUsu = new TelaCadastroUsu();
        this.telaExclusaoTec = new TelaExclusaoTec();
        this.telaExclusaoUsu = new TelaExclusaoUsu();
        mapeadorTecnico = new MapeadorTecnico();
        mapeadorUsuario = new MapeadorUsuario();
    }
    
    public static ControladorPessoa getInstancia(){
        if (instancia == null){
            instancia = new ControladorPessoa();
        }
        return instancia;
    }

    public void mostraMenuPessoa() {
        telaPessoaGrafica.mostraMenuPessoa();
    }
    public void mostrarTelaCadastroTecnico() {
        telaCadastroTecnico.mostraCadastroTecnico();
    }
    public void mostrarTelaCadastroUsuario() {
        telaCadastroUsuario.mostraCadastroUsuario();
    }
    public void mostraMenuPrincipal(){
        ControladorPrincipal.getInstancia().iniciaSistema();
    }
    
    public void incluirTecnico(ConteudoTelaTecnico conteudoTelaTecnico) throws PessoaJaCadastradaException {
        for (Tecnico tecnico : mapeadorTecnico.getList()) {
            if (tecnico.getCpf() == conteudoTelaTecnico.cpf) {
                throw new PessoaJaCadastradaException();
            }
        }
        Tecnico tecnico = desempacota(conteudoTelaTecnico);
        mapeadorTecnico.put(tecnico);

    }

    public void incluirUsuario(ConteudoTelaUsuario conteudoTelaUsuario) throws PessoaJaCadastradaException {
        for (Usuario usuario : mapeadorUsuario.getList()) {
            if (usuario.getCpf() == conteudoTelaUsuario.cpf) {
                throw new PessoaJaCadastradaException();
            }
        }
        Usuario usuario = desempacota(conteudoTelaUsuario);
        mapeadorUsuario.put(usuario);

    }

    public void excluirTecnico(long cpf) throws PessoaInexistenteException {
        Tecnico tecnico = buscaTecnicoPeloCpf(cpf);
        if (tecnico == null) {
            throw new PessoaInexistenteException();
        }
        mapeadorTecnico.remove(tecnico);
    }

    public void excluirUsuario(long cpf) throws PessoaInexistenteException {
        Usuario usuario = buscaUsuarioPeloCpf(cpf);
        if (usuario == null) {
            throw new PessoaInexistenteException();
        }
        mapeadorUsuario.remove(usuario);
    }

    public void listarTecnicos() {
        ArrayList<ConteudoTelaTecnico> listagemTecnicos = new ArrayList<>();

        for (Tecnico tecnico : mapeadorTecnico.getList()) {
            listagemTecnicos.add(empacota(tecnico));
        }

        telaPessoa.mostraListaTecnicos(listagemTecnicos);

    }

    public void listarUsuarios() {
        ArrayList<ConteudoTelaUsuario> listagemUsuarios = new ArrayList<>();

        for (Usuario usuario : mapeadorUsuario.getList()) {
            listagemUsuarios.add(empacota(usuario));
        }

        telaPessoa.mostraListaUsuarios(listagemUsuarios);
    }

    public Tecnico buscaTecnicoPeloCpf(long cpf) {
        try {
        for (Tecnico tecnico : mapeadorTecnico.getList()) {
            if (tecnico.getCpf() == cpf) {
                return tecnico;

            }

        }
        }
        catch (NullPointerException ex){
                System.out.println("tecnico nao encontrado");
                
        }
        return null;
    }

    public Usuario buscaUsuarioPeloCpf(long cpf) {
        for (Usuario usuario : mapeadorUsuario.getList()) {
            if (usuario.getCpf() == cpf) {
                return usuario;

            }
        }
        return null;
    }

    public Tecnico desempacota(ConteudoTelaTecnico conteudoTelaTecnico) {
        return new Tecnico(conteudoTelaTecnico.nome, conteudoTelaTecnico.cpf, conteudoTelaTecnico.telefone);
    }

    private ConteudoTelaTecnico empacota(Tecnico tecnico) {
        return new ConteudoTelaTecnico(tecnico.getNome(), tecnico.getCpf(), tecnico.getTelefone());
    }

    private Usuario desempacota(ConteudoTelaUsuario conteudoTelaUsuario) {
        return new Usuario(conteudoTelaUsuario.nome, conteudoTelaUsuario.cpf, conteudoTelaUsuario.telefone, conteudoTelaUsuario.numContrato);
    }

    private ConteudoTelaUsuario empacota(Usuario usuario) {
        return new ConteudoTelaUsuario(usuario.getNome(), usuario.getCpf(), usuario.getTelefone(), usuario.getNumContrato());
    }

    public void mostrarTelaCadastro() {
        telaCadastro.mostrarTela();
    }

    public void mostrarTelaCadastroUsu() {
        telaCadastroUsu.mostrarTela();
    }

    public void mostrarTelaExclusaoTec() {
        telaExclusaoTec.mostrarTela();
    }
    public void mostrarTelaExclusaoUsu() {
        telaExclusaoUsu.mostrarTela();
    }

    
}
