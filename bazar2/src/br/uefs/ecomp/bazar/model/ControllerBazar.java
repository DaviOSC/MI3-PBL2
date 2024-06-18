package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.UsuarioDiferenteVendedorException;
import br.uefs.ecomp.bazar.model.exception.LanceLeilaoFechadoException;
import br.uefs.ecomp.bazar.model.exception.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ControllerBazar implements Serializable
{
    private static final long serialVersionUID = 1L;
    // atributo referente ao usuario logado no sistema
    private transient Usuario usuarioLogado;
    
    //Estrutura que armazena os usuarios cadastrados; facilitando posteriormente a busca
    HashMap<String, Usuario> usuarios = new HashMap<>();
    // Estrutura criada para armazenar os leil�es
    ArrayList<Leilao> leiloes = new ArrayList<>();
         
    // retorna a quantidade de itens no hashmap que armazena os usu�rios
    public int quantidadeUsuarios()
    {
        checaEstados();
        return usuarios.size();
    }
    
    //cria um novo usu�rio e adiciona na hashmap de armazenamento.
    public Usuario cadastrarUsuario(String uLogin, String uNome, String uSenha, String uCpf, String uEndereco, String uTelefone) throws UsuarioNaoCadastrouException
    {
        checaEstados();
        Usuario usuario = new Usuario(uLogin, uNome, uSenha, uCpf, uEndereco, uTelefone);
        if(usuarios.containsKey(uLogin))
        {
            throw new UsuarioNaoCadastrouException("Usuário já existente");
        }
        if(uSenha.equals(""))
        {
            throw new UsuarioNaoCadastrouException("Senha inválida");
        }
        if(uLogin.equals(""))
        {
            throw new UsuarioNaoCadastrouException("Login inválido");
        }
        usuarios.put(uLogin, usuario);
        return usuario;    
    }
        
    // retorna a lista de leil�es
    public ArrayList getListaLeiloes()
    {
        checaEstados();
        return leiloes;
    }
    
    // realiza o login de um usuario selecionado
    public Usuario fazerLogin(String login, String senha) throws LoginFalhouException
    {
        checaEstados();
        Usuario usuario = usuarios.get(login);

        if (usuario != null && usuario.getSenha().equals(senha))
        {
            this.usuarioLogado = usuario;
            return usuario; 
        }
        else if (usuario != null && !usuario.getSenha().equals(senha))
        {
            throw new LoginFalhouException("Senha incorreta");
        }
        else
        {
            throw new LoginFalhouException("Usuario não encontrado");
        }
    }
    
    // Cria um novo produto, ao chamar o metodo do usuario logado cadastrar
    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada) throws ProdutoNaoCadastrouException
    {
        checaEstados();
        Produto produto = usuarioLogado.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
        return produto;
         
    }
    // listagem dos produtos cadastrados do usuario logado
    public Iterator<Produto> listarProdutosCadastrados()
    {
        checaEstados();
        return usuarioLogado.listarProdutosCadastrados();
    }
    // chama o metodo cadastra leil�o do usuario logado, que retorna o leil�o criado, e o adiciona na lista de leil�es
    public Leilao cadastrarLeilaoManual(Produto produto, double precoMinimo, double incrementoMinimo) throws LeilaoNaoCadastrouException
    {
        checaEstados();
        Leilao leilao = this.usuarioLogado.cadastrarLeilaoManual(precoMinimo, incrementoMinimo, produto);
        leiloes.add(leilao);
        return leilao;
    }
    public Leilao cadastrarLeilaoAutomatico(Produto produto, double precoMinimo, double incrementoMinimo, Date momentoInicio, Date momentoFim) throws LeilaoNaoCadastrouException
    {
        checaEstados();
        Leilao leilao = this.usuarioLogado.cadastrarLeilaoAutomatico(precoMinimo, incrementoMinimo, produto, momentoInicio, momentoFim);
        leiloes.add(leilao);
        return leilao;
    }
    
    public Leilao cadastrarLeilaoAutomaticoFechado(Produto produto, double precoMinimo, double incrementoMinimo, Date momentoInicio, Date momentoFim) throws LeilaoNaoCadastrouException
    {
        checaEstados();
        Leilao leilao = this.usuarioLogado.cadastrarLeilaoAutomaticoFechado(precoMinimo, incrementoMinimo, produto, momentoInicio, momentoFim);
        leiloes.add(leilao);
        return leilao;
    }
    
    
    // inicia um leil�o selecionado como parametro
    public void iniciarLeilao(Leilao leilao) throws UsuarioDiferenteVendedorException
    {
        checaEstados();
        if(leilao.getVendedor().equals(usuarioLogado))
            {
                leilao.iniciar();
            }
            else
            {
                throw new UsuarioDiferenteVendedorException("Você não é o vendedor desse leilão.");
            }
        leilao.iniciar();
    }
    // listagem dos leil�es que est�o com o status iniciado
    public Iterator<Leilao> listarLeiloesIniciados()
    {
        checaEstados();
        ArrayList<Leilao> leiloesIniciados = new ArrayList<>();
        // enquanto tiverem itens na lista, o iterator percorre a estrutora

        for (Leilao leilao : leiloes) {
            // se o atributo status do objeto leil�o for correspondente ao atributo INICIADO da classe leil�o
            if (leilao.getStatus() == Leilao.INICIADO)
            {
                // addiciona na lista apenas os leil�es que est�o iniciados de acordo com seu status
                leiloesIniciados.add(leilao);
            } 
        }
        leiloesIniciados.sort(Comparator.comparing(Leilao::getInicio));

        return leiloesIniciados.iterator();   
    }
    public Iterator abrirEnvelopesLeilaoAutomaticoFechado() throws LeilaoNaoEncerradoException
    {
        checaEstados();
        Leilao leilao = usuarioLogado.getLeilaoAtivo();
        if(leilao instanceof LeilaoAutomaticoFechado)
        {
            if(leilao.getStatus() == Leilao.ENCERRADO)
            {
                ((LeilaoAutomaticoFechado)leilao).ordenaLista();
                return leilao.getListaLances().iterator();
            }
            else
            {
                throw new LeilaoNaoEncerradoException("Leilao ainda nao foi encerrado.");
            }
        }
        return null;
        
    }
    // adiciona o usuario logado como participante do leil�o
    public void participarLeilao(Leilao leilao) throws UsuarioJaParticipaException
    {
        checaEstados();
        usuarioLogado.participarLeilao(leilao);
    }
    // chama o metodo dar lance minimo do usu�rio logado
    public void darLanceMinimo() throws LanceInvalidoException, LeilaoNaoParticipaException, LanceLeilaoFechadoException
   {
        checaEstados();
        usuarioLogado.darLanceMinimo();
    }
    // chama o metodo dar lance do usu�rio logado, passando o valor do lance
    public boolean darLance(double valor) throws LanceInvalidoException, LeilaoNaoParticipaException
    {
        checaEstados();
        return usuarioLogado.darLance(valor);
    }  
    
    // chama o metodo de encerrar o leil�o ativo do usuario logado no sistema
    public Venda encerrarLeilao()
    {
        checaEstados();
        return usuarioLogado.encerrarLeilaoAtivo();
    }
    
    public Date listarMomentoAtual()
    {      
        checaEstados();
        return new Date();
    }
    public Iterator listarParticipantesLeilao(Leilao leilao)
    {
        checaEstados();
        return leilao.getListaParticipantes();
    }
    
    public Iterator listarLances(Leilao leilao)
    {
        checaEstados();
        return leilao.getListaLances().iterator();
    }
    
    public void checaEstados()
    {
       for (Leilao leilao :leiloes)
       {
           if (leilao instanceof LeilaoAutomatico)
           {
               ((LeilaoAutomatico) leilao).checaInicio();
               ((LeilaoAutomatico) leilao).checaFim();            
           }
       }
    }
    
    public Iterator<Leilao> buscarLeiloesTempo(Date momentoA, Date momentoB)
    {
        checaEstados();
        ArrayList<Leilao> leiloesNoIntervalo = new ArrayList<>();
        
        //ordena os leilões de acordo com o tempo de inicio
        Comparator<Leilao> comparador = Comparator.comparing(Leilao::getInicio,Comparator.nullsLast(Comparator.naturalOrder()));
        Collections.sort(leiloes, comparador);
        
        //busca o index do primeiro leilão no intervalo
        int indexA = buscarPosicaoInicial(leiloes, momentoA);
        //busca o index ultimo
        int indexB = buscarPosicaoFinal(leiloes, momentoB);

        for (int i = indexA; i <= indexB; i++)
        {
            Leilao leilao = leiloes.get(i);
            if(leilao.getInicio() != null)
                leiloesNoIntervalo.add(leilao);
        }
        return leiloesNoIntervalo.iterator();
    }
    
    //algoritmo de busca binária
    private int buscarPosicaoInicial(ArrayList<Leilao> leiloes, Date momentoA)
    {
        int esquerda = 0;
        int direita = leiloes.size() - 1;
        while (esquerda <= direita)
        {
            int meio = (esquerda + direita) / 2;
            Leilao leilao = leiloes.get(meio);
            if (leilao.getInicio() != null && leilao.getInicio().compareTo(momentoA) >= 0)
            {
                direita = meio - 1;
            }
            else
            {
                esquerda = meio + 1;
            }
        }
        return esquerda;
    }

    private int buscarPosicaoFinal(ArrayList<Leilao> leiloes, Date momentoB) 
    {
        int esquerda = 0;
        int direita = leiloes.size() - 1;
        while (esquerda <= direita)
        {
            int meio = (esquerda + direita) / 2;
            Leilao leilao = leiloes.get(meio);
            if (leilao.getInicio() != null && leilao.getInicio().compareTo(momentoB) <= 0)
            {
                esquerda = meio + 1;
            }
            else
            {
                direita = meio - 1;
            }
        }
        return direita;
    }
    
    public void selecionarLeilao(Leilao leilao)
    {
        usuarioLogado.setLeilaoAtivo(leilao);
    }
}
