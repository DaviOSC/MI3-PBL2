package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

public class ControllerBazar
{
    // atributo referente ao usuario logado no sistema
    private Usuario usuarioLogado;
    
    //Estrutura que armazena os usuarios cadastrados; facilitando posteriormente a busca
    private HashMap<String, Usuario> mapaUsuarios = new HashMap<>();
    // Estrutura criada para armazenar os leilões
    ArrayListModficada leiloes = new ArrayListModficada<>();
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
    
    // retorna a quantidade de itens no hashmap que armazena os usuários
    public int quantidadeUsuarios()
    {
        return mapaUsuarios.size();
    }
    
    //cria um novo usuário e adiciona na hashmap de armazenamento.
    public Usuario cadastrarUsuario(String uLogin, String uNome, String uSenha, String uCpf, String uEndereco, String uTelefone)
    {
       Usuario usuario = new Usuario(uLogin, uNome, uSenha, uCpf, uEndereco, uTelefone);
       mapaUsuarios.put(uLogin, usuario);
       return usuario;
    }
    
    
    // retorna a lista de leilões
    public ArrayListModficada getListaLeiloes()
    {
        return leiloes;
    }
    
    // realiza o login de um usuario selecionado
    public Usuario fazerLogin(String login, String senha)
    {
        // recupera um usuario a partir de seu login
        Usuario usuario = mapaUsuarios.get(login);
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
        }
        // caso não consiga executar o login
        return null;
    }
    
    // Cria um novo produto, ao chamar o metodo do usuario logado cadastrar
    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada)
    {
        Produto produto = usuarioLogado.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
        return produto;  

    }
    // listagem dos produtos cadastrados do usuario logado
    public Iterator<Produto> listarProdutosCadastrados()
    {
        return usuarioLogado.listarProdutosCadastrados();
    }
    // chama o metodo cadastra leilão do usuario logado, que retorna o leilão criado, e o adiciona na lista de leilões
    public Leilao cadastrarLeilao(Produto produto, double precoMinimo, double incrementoMinimo)
    {
        Leilao leilao = this.usuarioLogado.cadastrarLeilao(precoMinimo, incrementoMinimo, produto);
        leiloes.add(leilao);
        return leilao;
    }
    // inicia um leilão selecionado como parametro
    public void iniciarLeilao(Leilao leilao)
    {
        leilao.iniciar();
    }
    // listagem dos leilões que estão com o status iniciado
    public Iterator listarLeiloesIniciados()
    {

        ArrayList leiloesIniciados = new ArrayList<>();

        Iterator<Leilao> iterator = leiloes.iterator();
        
        // enquanto tiverem itens na lista, o iterator percorre a estrutora
        while (iterator.hasNext())
        {
            Leilao leilao = iterator.next();
            
            // se o atributo status do objeto leilão for correspondente ao atributo INICIADO da classe leilão
            if (leilao.getStatus() == Leilao.INICIADO)
            {
                // addiciona na lista apenas os leilões que estão iniciados de acordo com seu status
                leiloesIniciados.add(leilao);
            }
        }
        // retorna um iterator da lista de leilões iniciados
        return leiloesIniciados.iterator();
    }
    // adiciona o usuario logado como participante do leilão
    public void participarLeilao(Leilao leilao)
    {
        usuarioLogado.participarLeilao(leilao);
    }
    // chama o metodo dar lance minimo do usuário logado
    public void darLanceMinimo()
    {
        usuarioLogado.darLanceMinimo();
    }
    // chama o metodo dar lance do usuário logado, passando o valor do lance
    public void darLance(double valor)
    {
        usuarioLogado.darLance(valor);
    }
    // chama o metodo de encerrar o leilão ativo do usuario logado no sistema
    public Venda encerrarLeilao()
    {
        return usuarioLogado.encerrarLeilaoAtivo();
    }
    
}
