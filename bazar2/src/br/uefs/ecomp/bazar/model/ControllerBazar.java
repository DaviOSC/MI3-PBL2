package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import br.uefs.ecomp.bazar.util.Iterador;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ControllerBazar implements Serializable
{
    // atributo referente ao usuario logado no sistema
    private transient Usuario usuarioLogado;
    
    //Estrutura que armazena os usuarios cadastrados; facilitando posteriormente a busca
    HashMapModficado<String, Usuario> usuarios = new HashMapModficado<>();
    // Estrutura criada para armazenar os leil�es
    ArrayList<Leilao> leiloes = new ArrayList<>();
  
    public class HashMapModficado<String, T> 
    {
        
        private HashMap<String, T> hashmap;
        
        public HashMapModficado()
        {
            this.hashmap = new HashMap();
        }
        
        public void inserir(String key, T value)
        {
            hashmap.put(key, value);
        }

        public T recupera(String key)
        {
            return hashmap.get(key);
        }

        public void remover(String key)
        {
            hashmap.remove(key);
        }

        public boolean containsKey(String key)
        {
            return hashmap.containsKey(key);
        }

        public boolean containsValue(T value)
        {
            return hashmap.containsValue(value);
        }

        public int tamanho()
        {
            return hashmap.size();
        }

        public boolean isEmpty()
        {
            return hashmap.isEmpty();
        }

        public void clear()
        {
            hashmap.clear();
        }
    }
    
    
    
    // Classe criada para se adequar aos testes
    public class ArrayListModficada<T>
    {
        //possui como atributo uma array list que armazena objetos
        private ArrayList<T> arrayList;

        public ArrayListModficada()
        {
            this.arrayList = new ArrayList<>();
        }

       //metodos da nova classe que retornam metodos da arraylist
        public int tamanho()
        {
            return arrayList.size();
        }

        
        public T recupera(int indice)
        {
            return arrayList.get(indice);
        }
        
        public void add(T elemento)
        {
            arrayList.add(elemento);
        }

        public void remove(int indice)
        {
            arrayList.remove(indice);
        }
        
        public Iterator iterator()
        {
            return arrayList.iterator();
        }
    }
    
    // retorna a quantidade de itens no hashmap que armazena os usu�rios
    public int quantidadeUsuarios()
    {
        checkStates();
        return usuarios.tamanho();
    }
    
    //cria um novo usu�rio e adiciona na hashmap de armazenamento.
    public Usuario cadastrarUsuario(String uLogin, String uNome, String uSenha, String uCpf, String uEndereco, String uTelefone) throws UsuarioNaoCadastrouException
    {
        checkStates();
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
        usuarios.inserir(uLogin, usuario);
        return usuario;    
    }
    
    
    // retorna a lista de leil�es
    public ArrayList getListaLeiloes()
    {
        checkStates();
        return leiloes;
    }
    
    // realiza o login de um usuario selecionado
    public Usuario fazerLogin(String login, String senha) throws LoginFalhouException
    {
        checkStates();
        // recupera um usuario a partir de seu login
        Usuario usuario = usuarios.recupera(login);
        // se, de acordo com o login, ele existir
        if (usuario != null)
        {
            // compara a senha inserida no login com o atributo senha do objeto usuario;
            if (usuario.getSenha().equals(senha))
            {
                // atualiza o usuario logado no sistema
                this.usuarioLogado = usuario;
                return usuario;
            }
            else
            {
                throw new LoginFalhouException("Senha incorreta");
            }
        }
        else
        {
            throw new LoginFalhouException("Usuario não encontrado");
        }
    }
    
    // Cria um novo produto, ao chamar o metodo do usuario logado cadastrar
    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada) throws ProdutoNaoCadastrouException
    {
        checkStates();
        try
        {
            Produto produto = usuarioLogado.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
            return produto; 
        }
        catch(ProdutoNaoCadastrouException e)
        {
            throw e;
        }
 
    }
    // listagem dos produtos cadastrados do usuario logado
    public Iterador<Produto> listarProdutosCadastrados()
    {
        checkStates();
        Iterador iterador = new Iterador(usuarioLogado.listarProdutosCadastrados());
        return iterador;
    }
    // chama o metodo cadastra leil�o do usuario logado, que retorna o leil�o criado, e o adiciona na lista de leil�es
    public Leilao cadastrarLeilaoManual(Produto produto, double precoMinimo, double incrementoMinimo) throws LeilaoNaoCadastrouException
    {
        checkStates();
        try
        {
            Leilao leilao = this.usuarioLogado.cadastrarLeilaoManual(precoMinimo, incrementoMinimo, produto);
            leiloes.add(leilao);
            return leilao;
        }
        catch(LeilaoNaoCadastrouException e)
        {
            throw e;
        }
    }
    public Leilao cadastrarLeilaoAutomatico(Produto produto, double precoMinimo, double incrementoMinimo, Date momentoInicio, Date momentoFim) throws LeilaoNaoCadastrouException
    {
        checkStates();
        try
        {    
            Leilao leilao = this.usuarioLogado.cadastrarLeilaoAutomatico(precoMinimo, incrementoMinimo, produto, momentoInicio, momentoFim);
            leiloes.add(leilao);
            return leilao;
        }
        catch(LeilaoNaoCadastrouException e)
        {
            throw e;
        }
    }
    
    public Leilao cadastrarLeilaoAutomaticoFechado(Produto produto, double precoMinimo, double incrementoMinimo, Date momentoInicio, Date momentoFim) throws LeilaoNaoCadastrouException
    {
        checkStates();
        try
        {    
            Leilao leilao = this.usuarioLogado.cadastrarLeilaoAutomaticoFechado(precoMinimo, incrementoMinimo, produto, momentoInicio, momentoFim);
            leiloes.add(leilao);
            return leilao;
        }
        catch(LeilaoNaoCadastrouException e)
        {
            throw e;
        }
    }
    
    public void cadastrarLeilao(Leilao leilao)
    {
        checkStates();
        leiloes.add(leilao);
    }
    
    // inicia um leil�o selecionado como parametro
    public void iniciarLeilao(Leilao leilao)
    {
        checkStates();
        leilao.iniciar();
    }
    // listagem dos leil�es que est�o com o status iniciado
    public Iterator<Leilao> listarLeiloesIniciados()
    {
        checkStates();
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
        checkStates();
        Leilao leilao =usuarioLogado.getLeilaoAtivo();
        if(leilao instanceof LeilaoAutomaticoFechado)
        {
            if(leilao.getStatus() == Leilao.ENCERRADO)
            {
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
    public void participarLeilao(Leilao leilao)
    {
        checkStates();
        usuarioLogado.participarLeilao(leilao);
    }
    // chama o metodo dar lance minimo do usu�rio logado
    public void darLanceMinimo() throws LanceInvalidoException
    {
        checkStates();
        try
        {
            usuarioLogado.darLanceMinimo();
        }
        catch(LanceInvalidoException e)
        {
            throw e;
        }
    }
    // chama o metodo dar lance do usu�rio logado, passando o valor do lance
    public boolean darLance(double valor) throws LanceInvalidoException
    {
        checkStates();
        try
        {
            return usuarioLogado.darLance(valor);
        }
        catch(LanceInvalidoException e)
        {
            throw e;
        }   
    }
    
    public void darLanceLeilaoAutomaticoFechado(double valor)throws LanceInvalidoException
    {
        checkStates();
        usuarioLogado.darLance(valor);
        //usuarioLogado.darLanceAutomaticoFechado(valor);
    }
    
    
    // chama o metodo de encerrar o leil�o ativo do usuario logado no sistema
    public Venda encerrarLeilao()
    {
        checkStates();
        return usuarioLogado.encerrarLeilaoAtivo();
    }
    
    public Date listarMomentoAtual()
    {      
        checkStates();
        return new Date();
    }
    public Iterator listarParticipantesLeilao(Leilao leilao)
    {
        checkStates();
        return leilao.getListaParticipantes();
    }
    
    public Iterator listarLances(Leilao leilao)
    {
        checkStates();
        return leilao.getListaLances().iterator();
    }
    
    public Iterator buscarLeiloesTempo(Date momentoA, Date momentoB)
    {
        checkStates();
        ArrayList<Leilao> leiloesNoIntervalo = new ArrayList<>();
        Collections.sort(leiloes, Comparator.comparing(Leilao::getInicio));
        
        for(Leilao leilao : leiloes)
        {
            if(leilao.getInicio().compareTo(momentoA) > 0 && leilao.getInicio().compareTo(momentoB) < 0)
            {
                leiloesNoIntervalo.add(leilao);
            }
        }
        
        return leiloesNoIntervalo.iterator();
    }
    
    public void checkStates()
    {
       for (Leilao leilao :leiloes)
       {
           if (leilao instanceof LeilaoAutomatico)
           {
               ((LeilaoAutomatico) leilao).checkForStart();
               ((LeilaoAutomatico) leilao).checkForEnd();
               
           }
       }
    }
}
