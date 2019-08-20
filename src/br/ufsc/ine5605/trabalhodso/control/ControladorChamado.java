/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalhodso.control;

import br.ufsc.ine5605.trabalhodso.exceptions.ChamadoInexistenteException;
import br.ufsc.ine5605.trabalhodso.exceptions.ChamadoInvalidoException;
import br.ufsc.ine5605.trabalhodso.mapeadores.MapeadorChamado;
import br.ufsc.ine5605.trabalhodso.mapeadores.MapeadorChamadoEncerrado;
import br.ufsc.ine5605.trabalhodso.model.Chamado;
import br.ufsc.ine5605.trabalhodso.model.Prioridade;
import br.ufsc.ine5605.trabalhodso.model.Problema;
import br.ufsc.ine5605.trabalhodso.model.Status;
import static br.ufsc.ine5605.trabalhodso.model.Status.ENCERRADO;
import static br.ufsc.ine5605.trabalhodso.model.Status.SEMSOLUCAO;
import br.ufsc.ine5605.trabalhodso.model.TipoDeProblema;
import static br.ufsc.ine5605.trabalhodso.model.TipoDeProblema.BANCODEDADOS;
import static br.ufsc.ine5605.trabalhodso.model.TipoDeProblema.COMUNICACAODEREDE;
import static br.ufsc.ine5605.trabalhodso.model.TipoDeProblema.DESEMPENHO;
import br.ufsc.ine5605.trabalhodso.view.ConteudoTelaChamado;
import java.util.ArrayList;
import br.ufsc.ine5605.trabalhodso.model.Usuario;
import br.ufsc.ine5605.trabalhodso.view.TelaCadastroChamado;
import br.ufsc.ine5605.trabalhodso.view.TelaCadastroChamadoComunicacao;
import br.ufsc.ine5605.trabalhodso.view.TelaCadastroChamadoDesempenho;
import br.ufsc.ine5605.trabalhodso.view.TelaChamado;
import br.ufsc.ine5605.trabalhodso.view.TelaChamadoG;
import br.ufsc.ine5605.trabalhodso.view.TelaEscolheProblema;
import br.ufsc.ine5605.trabalhodso.view.TelaExcluirChamado;
import br.ufsc.ine5605.trabalhodso.view.TelaListarChamados;
import br.ufsc.ine5605.trabalhodso.view.TelaListarChamadosEncerrados;
import br.ufsc.ine5605.trabalhodso.view.TelaListarRAcompanhamento;
import br.ufsc.ine5605.trabalhodso.view.TelaRegistroAcompanhamento;
import br.ufsc.ine5605.trabalhodso.view.TelaSetStatusChamado;

/**
 *
 * @author 11193319943
 */
public class ControladorChamado {
    private TelaChamado telaChamado;
    private TelaChamadoG telaChamadoG;
    private TelaCadastroChamado telaCadastroChamado;
    private TelaCadastroChamadoDesempenho telaCadastroChamadoDesempenho;
    private TelaCadastroChamadoComunicacao telaCadastroChamadoComunicacao;
    private static ControladorChamado instancia;
    private MapeadorChamado mapeadorChamado;
    private MapeadorChamadoEncerrado mapeadorChamadosEncerrados;
    private TelaListarRAcompanhamento telaListarRAcompanhamento;
    private TelaRegistroAcompanhamento telaRegistroAcompanhamento;
    private TelaExcluirChamado telaExcluirChamado;
    private TelaListarChamados telaListarChamados;
    private TelaListarChamadosEncerrados telaListarChamadosEncerrados;
    private TelaSetStatusChamado telaSetStatusChamado;
    private TelaEscolheProblema telaEscolheProblema;
    

    private ControladorChamado() {
        mapeadorChamado = new MapeadorChamado();
        telaChamado = new TelaChamado();
        mapeadorChamadosEncerrados = new MapeadorChamadoEncerrado();
        telaCadastroChamado = new TelaCadastroChamado();
        telaCadastroChamadoDesempenho = new TelaCadastroChamadoDesempenho();
        telaCadastroChamadoComunicacao = new TelaCadastroChamadoComunicacao();
        telaChamadoG= new TelaChamadoG();
        telaSetStatusChamado = new TelaSetStatusChamado();
        telaExcluirChamado = new TelaExcluirChamado();
        telaRegistroAcompanhamento = new TelaRegistroAcompanhamento();
        telaEscolheProblema = new TelaEscolheProblema();
    }
    public static ControladorChamado getInstancia(){
        if (instancia == null){
            instancia = new ControladorChamado();
        }
        return instancia;
    }

    public void mostraMenuChamado() {
        telaChamadoG.mostraMenuChamado();
    }

    public void listarChamados() {
        
        ArrayList<ConteudoTelaChamado> listaChamados = new ArrayList<>();
        
        for (Chamado chamado : mapeadorChamado.getList()) {
            listaChamados.add(empacota(chamado));
        }
        telaChamado.imprimeChamado(listaChamados);
    }

    public void listarChamadosEncerrados() {
        ArrayList<ConteudoTelaChamado> listaChamadosEncerrados = new ArrayList<>();
        
        for (Chamado chamado : mapeadorChamadosEncerrados.getList()) {
            listaChamadosEncerrados.add(empacota(chamado));
        }
        telaChamado.imprimeChamado(listaChamadosEncerrados);
    }
    
    public void setStatusChamado (String titulo, Status status) throws ChamadoInexistenteException {
        
        Chamado chamado = buscaChamadoPorTitulo(titulo);
        if(chamado == null) {
            throw new ChamadoInexistenteException(); 
        }
        
        
        if(status.equals(SEMSOLUCAO) || status.equals(ENCERRADO)) {
            mapeadorChamadosEncerrados.put(chamado);
            mapeadorChamado.remove(chamado);

        }
    }
    
    public void pesquisarChamadosAntigos (TipoDeProblema tipoDeProblema) {
        ArrayList<ConteudoTelaChamado> listaChamadosEncerrados = new ArrayList<>();
        
        for (Chamado chamado : mapeadorChamadosEncerrados.getList()) {
            if (chamado.getProblema().getTipoDeProblema().equals(tipoDeProblema)) {
                    listaChamadosEncerrados.add(empacota(chamado));
            }
        }
        
        telaChamado.imprimeChamado(listaChamadosEncerrados);
    }
    
    public void excluirChamado (String titulo) throws ChamadoInvalidoException {
        for (Chamado chamado : mapeadorChamado.getList()) {
           if(chamado.getTitulo().equals(titulo))
               mapeadorChamado.remove(chamado);
    }
    }
    public void incluirChamado (ConteudoTelaChamado conteudoTelaChamado) throws ChamadoInvalidoException {
        
        Chamado chamado = desempacota(conteudoTelaChamado);
            if (chamado == null)
                throw new ChamadoInvalidoException();
            mapeadorChamado.put(chamado);
    }
    
    
    
    public Chamado desempacota (ConteudoTelaChamado conteudoTelaChamado) {
        return new Chamado (conteudoTelaChamado.date, conteudoTelaChamado.titulo, conteudoTelaChamado.descricao, conteudoTelaChamado.tecnico, conteudoTelaChamado.prioridade, conteudoTelaChamado.problema, conteudoTelaChamado.status, conteudoTelaChamado.usuario);
    }
    
    public ConteudoTelaChamado empacota (Chamado chamado){
        return new ConteudoTelaChamado (chamado.getDate(), chamado.getTitulo(), chamado.getDescricao(), chamado.getTecnico(), chamado.getPrioridade(), chamado.getProblema(), chamado.getStatus(), chamado.getUsuario());
    }

    private Chamado buscaChamadoPorTitulo(String titulo) {
        for (Chamado chamado : mapeadorChamado.getList()) {
            if (chamado.getTitulo().equals(titulo))
                return chamado;
        }
        return null;
    }

    public Prioridade escolheOpcaoPrioridade(int opcao) {
  
        switch(opcao){
            case 1 : 
                return Prioridade.MUITOBAIXO;
            case 2 : 
                return Prioridade.BAIXO;
            case 3 :     
                return Prioridade.NORMAL;
            case 4 :
                return Prioridade.ALTO;
            case 5 : 
                return Prioridade.MUITOALTO;
            default: 
                telaChamado.imprimeMensagemDeErro();
                mostraMenuChamado();
                
                
        }
        return Prioridade.NORMAL; 
    }       

    
    

    public Problema cadastraProblema(int opcao) {
        
        switch(opcao) {
            case 1 : 
                return cadastraProblemaBancoDeDados();
            case 2 :
                return cadastraProblemaComunicacaoDeRede();
            case 3 :
                return cadastraProblemaDesempenho();
            default :
                telaChamado.imprimeMensagemDeErro();
                mostraMenuChamado();
        }
        
        return null;
    }

    public Problema cadastraProblemaBancoDeDados() {
       return telaChamado.mostraTelaCadastroProblemaBancoDedados();
    }

    public Problema cadastraProblemaComunicacaoDeRede() {
        return telaChamado.mostraTelaCadastroProblemaComunicacao();
    }

    public Problema cadastraProblemaDesempenho() {
        return telaChamado.mostraTelaCadastroProblemaDesempenho();
    }

    public Status escolheOpcaoStatus(int opcao) {
        if (opcao == 1)
            return Status.INICIADO;
        else if(opcao == 2)
            return Status.EMATENDIMENTO;
        else if(opcao == 3)
            return Status.AGUARDANDORESPOSTA;
        else if(opcao == 4)
            return Status.ENCERRADO;
        else if(opcao == 5)
            return Status.SEMSOLUCAO;
        return Status.AGUARDANDORESPOSTA;
    }

    public TipoDeProblema selecionaProblema(int opcao) {
        
        switch(opcao) {
            case 1 : 
                return TipoDeProblema.BANCODEDADOS;
            case 2 :
                return TipoDeProblema.COMUNICACAODEREDE;
            case 3 :
                return TipoDeProblema.DESEMPENHO;
            default : 
                telaChamado.imprimeMensagemDeErro();
                mostraMenuChamado();    
        }
        
                return TipoDeProblema.NAOESPECIFICADO;
    }

    public void registraAcompanhamento(String data, String assunto, String tecnico) {
        
    }

    public void pesquisaChamadoAntigos(int opcaoProblema) {
        ArrayList<ConteudoTelaChamado> listaChamados = new ArrayList<>(); 
        
        switch(opcaoProblema) {
            
            case 1 : 
                for (Chamado chamado :mapeadorChamadosEncerrados.getList())
                    if(chamado.getProblema().getTipoDeProblema().equals(BANCODEDADOS))
                        listaChamados.add(empacota(chamado));
                        
                    telaChamado.imprimeChamado(listaChamados);
            case 2 :
                for (Chamado chamado : mapeadorChamadosEncerrados.getList())
                    if(chamado.getProblema().getTipoDeProblema().equals(COMUNICACAODEREDE))
                        listaChamados.add(empacota(chamado));
                        
                    telaChamado.imprimeChamado(listaChamados);
                
            case 3 :
                for (Chamado chamado : mapeadorChamadosEncerrados.getList())
                    if(chamado.getProblema().getTipoDeProblema().equals(DESEMPENHO))
                        listaChamados.add(empacota(chamado));
                        
                    telaChamado.imprimeChamado(listaChamados);
            default : 
                telaChamado.imprimeMensagemDeErro();
                mostraMenuChamado();
                
                
        }
    }
    
    public Chamado encontraChamadoPeloTitulo(String titulo) throws ChamadoInexistenteException {
    Chamado c = null;    
        for (Chamado chamado : mapeadorChamado.getList())
            if(chamado.getTitulo().equals(titulo))
                c = chamado;
            else {throw new ChamadoInexistenteException();}
        return c;
    }

    public void listarRegistroAcompanhamento() {
        for (Chamado chamado : mapeadorChamado.getList()) {
            telaChamado.imprimeRegistroAcompanhamento(chamado);
        }
    }
    public Usuario buscaUsuario (long cpf) {
        Usuario usuario = ControladorPrincipal.getInstancia().getControladorPessoa().buscaUsuarioPeloCpf(cpf);
        return usuario;
    }

    public void mostrarTelaCadastroChamado() {
        telaCadastroChamado.mostrarTela();
    }

    public void mostrarTelaExclusaoChamado() {
        telaExcluirChamado.mostrarTela();
    }

    public void mostrarTelaListarChamados() {
        telaListarChamados.mostrarTela();
    }

    public void mostrarTelaListarChamadosEncerrados() {
        telaListarChamadosEncerrados.mostrarTela();
    }

    public void mostrarTelaSetStatusChamado() {
        telaSetStatusChamado.mostrarTela();
    }

    public void mostrarTelaRegistroAcompanhamento() {
        telaRegistroAcompanhamento.mostrarTela();
    }

    public void mostrarTelaListarRegistroAcompanhamento() {
        telaListarRAcompanhamento.mostrarTela();
    }

    public void mostraTelaEscolheProblema() {
        telaEscolheProblema.mostrarTela();
    }

    public void mostrarTelaCadastroChamadoDesempenho() {
        telaCadastroChamadoDesempenho.mostrarTela();
    }
    
    public void mostrarTelaCadastroChamadoComunicacao() {
        telaCadastroChamadoComunicacao.mostrarTela();
    }
}

