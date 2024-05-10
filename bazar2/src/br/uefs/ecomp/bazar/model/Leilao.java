package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;

public abstract class Leilao {

    // Constantes para representar os estados de um leilao qualquer:
    static final int CADASTRADO = 0;
    static final int INICIADO = 1;
    static final int ENCERRADO = 2;

    private double precoMinimo;
    private double incrementoMinimo;
    private int status;
    private Produto produto;
    private Usuario vendedor;
    private Venda venda;
    private Lance ultimoLance;
    private Date momentoInicio;

    //estrutura para armazenar os participantes do leilao 
    private ArrayList<Usuario> participantes = new ArrayList<>();

    public Leilao(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto) {
        this.precoMinimo = lPrecoMinimo;
        this.incrementoMinimo = lIncrementoMinimo;
        this.vendedor = lVendedor;
        this.produto = lProduto;
        this.status = CADASTRADO;
    }
    
//    public Leilao(Date momentoInicio)
//    {
//        this.momentoInicio = momentoInicio;
//    }

    public Usuario getVendedor() {
        return this.vendedor;
    }

    public Produto getProduto() {
        return this.produto;
    }

    // define o status do leil�o como iniciado, "reseta" o ultimo lance e define esse como leil�o ativo do vendedor
    public void iniciar() {
        this.status = INICIADO;
        this.ultimoLance = null;
        this.momentoInicio = new Date();
        vendedor.setLeilaoAtivo(this);
    }

    // define o status como encerrado e gera uma venda.
    public void encerrar() {
        this.status = ENCERRADO;
        // verifica se existe uma venda e se um lance j� foi dado
        if (this.venda == null && this.ultimoLance != null) {
            this.venda = new Venda(this.ultimoLance, this);
            // modfica o status do produto
            this.produto.setVendido();
        }
    }

    public int getStatus() {
        return status;
    }

    // adiciona um participante na lista de participantes do leil�o
    public void cadastrarParticipante(Usuario usuario) {
        participantes.add(usuario);
    }

    // um usu�rio d� um lance com base no pre�o minimo e no incremento
    public void darLanceMinimo(Usuario usuario) {
        Lance lance = new Lance(usuario, this.precoMinimo + this.incrementoMinimo);
        //atualiza��o do ultimo lance do leil�o
        this.ultimoLance = lance;
        this.precoMinimo = lance.getValor();
    }

    // um lance com um valor especifico decidido pelo usu�rio e verifica suas condi��es de valida��o, returnando falso caso n�o seja aceit�vel
    public boolean darLance(Usuario usuario, double preco) {
        Lance lance = new Lance(usuario, preco);

        //compara��o dos dados do lance criado e os parametros do leil�o
        if (lance.getValor() >= (this.precoMinimo + this.incrementoMinimo)) {
            //atualiza��o do ultimo lance do leil�o
            this.ultimoLance = lance;
            this.precoMinimo = lance.getValor() + this.incrementoMinimo;
            return true;
        } else {
            return false;
        }
    }

    public Venda getVenda() {
        return this.venda;
    }

    // retorna o ultimo lance do leil�o;
    public Lance getUltimoLance() {
        return this.ultimoLance;
    }

    public Date getInicio() {
        return momentoInicio;
    }
}
