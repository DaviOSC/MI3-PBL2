package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import br.uefs.ecomp.bazar.util.Iterador;

public class ControllerBazar
{
    // atributo referente ao usuario logado no sistema
    private Usuario usuarioLogado;
    
    //Estrutura que armazena os usuarios cadastrados; facilitando posteriormente a busca
    HashMapModficado<String, Usuario> usuarios = new HashMapModficado<>();
    // Estrutura criada para armazenar os leil�es
    ArrayListModficada leiloes = new ArrayListModficada<>();
    
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
        return usuarios.tamanho();
    }
    
    //cria um novo usu�rio e adiciona na hashmap de armazenamento.
    public Usuario cadastrarUsuario(String uLogin, String uNome, String uSenha, String uCpf, String uEndereco, String uTelefone)
    {
       Usuario usuario = new Usuario(uLogin, uNome, uSenha, uCpf, uEndereco, uTelefone);
       usuarios.inserir(uLogin, usuario);
       return usuario;
    }
    
    
    // retorna a lista de leil�es
    public ArrayListModficada getListaLeiloes()
    {
        return leiloes;
    }
    
    // realiza o login de um usuario selecionado
    public Usuario fazerLogin(String login, String senha)
    {
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
        }
        // caso n�o consiga executar o login
        return null;
    }
    
    // Cria um novo produto, ao chamar o metodo do usuario logado cadastrar
    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada)
    {
        Produto produto = usuarioLogado.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
        return produto;  

    }
    // listagem dos produtos cadastrados do usuario logado
    public Iterador<Produto> listarProdutosCadastrados()
    {
        Iterador iterador = new Iterador(usuarioLogado.listarProdutosCadastrados());
        return iterador;
    }
    // chama o metodo cadastra leil�o do usuario logado, que retorna o leil�o criado, e o adiciona na lista de leil�es
    public Leilao cadastrarLeilaoManual(Produto produto, double precoMinimo, double incrementoMinimo)
    {
        Leilao leilao = this.usuarioLogado.cadastrarLeilao(precoMinimo, incrementoMinimo, produto);
        leiloes.add(leilao);
        return leilao;
    }
    
    public void cadastrarLeilao(Leilao leilao)
    {
        leiloes.add(leilao);
    }
    // inicia um leil�o selecionado como parametro
    public void iniciarLeilao(Leilao leilao)
    {
        leilao.iniciar();
    }
    // listagem dos leil�es que est�o com o status iniciado
        public Iterador listarLeiloesIniciados()
        {
            ArrayList leiloesIniciados = new ArrayList<>();

            Iterador<Leilao> iterador = new Iterador(leiloes.iterator());

            // enquanto tiverem itens na lista, o iterator percorre a estrutora
            while (iterador.temProximo())
            {
                Leilao leilao = iterador.next();

                // se o atributo status do objeto leil�o for correspondente ao atributo INICIADO da classe leil�o
                if (leilao.getStatus() == Leilao.INICIADO)
                {
                    // addiciona na lista apenas os leil�es que est�o iniciados de acordo com seu status
                    leiloesIniciados.add(leilao);
                } 
            }

             for (int i = 0; i < leiloesIniciados.size() - 1; i++) {
                for (int j = 0; j < leiloesIniciados.size() - 1 - i; j++) {
                    Leilao leilaoPrimeiro = (Leilao)leiloesIniciados.get(j);
                    Leilao leilaoProximo = (Leilao)leiloesIniciados.get(j + 1);
                    if (leilaoPrimeiro.getInicio().compareTo(leilaoProximo.getInicio()) > 0) {
                        leiloesIniciados.set(j, leilaoProximo);
                        leiloesIniciados.set(j + 1, leilaoPrimeiro);
                    }
                }
            }

            iterador = new Iterador(leiloesIniciados.iterator());
            return iterador;
        }
    // adiciona o usuario logado como participante do leil�o
    public void participarLeilao(Leilao leilao)
    {
        usuarioLogado.participarLeilao(leilao);
    }
    // chama o metodo dar lance minimo do usu�rio logado
    public void darLanceMinimo()
    {
        usuarioLogado.darLanceMinimo();
    }
    // chama o metodo dar lance do usu�rio logado, passando o valor do lance
    public void darLance(double valor)
    {
        usuarioLogado.darLance(valor);
    }
    // chama o metodo de encerrar o leil�o ativo do usuario logado no sistema
    public Venda encerrarLeilao()
    {
        return usuarioLogado.encerrarLeilaoAtivo();
    }
    
}
