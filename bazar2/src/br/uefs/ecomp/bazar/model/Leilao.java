package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

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
    private Date momentoInicio;
    private Date momentoFim;

    //estrutura para armazenar os participantes do leilao 
    private ArrayList lances = new ArrayList();
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

    public abstract void iniciar();

    // define o status como encerrado e gera uma venda.
    public abstract void encerrar(); 

    public int getStatus() {
        return status;
    }

    // adiciona um participante na lista de participantes do leil�o
    public void cadastrarParticipante(Usuario usuario) {
        participantes.add(usuario);
    }

    // um usu�rio d� um lance com base no pre�o minimo e no incremento
    public abstract void darLanceMinimo(Usuario usuario);

    // um lance com um valor especifico decidido pelo usu�rio e verifica suas condi��es de valida��o, returnando falso caso n�o seja aceit�vel
    public abstract boolean darLance(Usuario usuario, double preco);

    public Venda getVenda() {
        return this.venda;
    }
    
    public void setVenda(Venda venda)
    {
        this.venda = venda;
    }

    // retorna o ultimo lance do leil�o;
    public Lance getUltimoLance()
    {
        return (Lance)lances.get(lances.size()-1);
    }
    
    public void setFim(Date date)
    {
        this.momentoFim = date;
    }
    public void setInicio(Date date)
    {
        this.momentoInicio = date;
    }
    public Date getInicio() {
        return momentoInicio;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public double getPrecoMinimo()
    {
        return this.precoMinimo;
    }
    
    public void setPrecoMinimo(double precoMinimo)
    {
        this.precoMinimo = precoMinimo;
    }
    
    public double getIncrementoMinimo()
    {
        return this.incrementoMinimo;
    }
    
    public void setIncrementoMinimo(double incrementoMinimo)
    {
        this.incrementoMinimo = incrementoMinimo;
    }
    public ArrayList getListaLances()
    {
        return lances;
    }
    public Iterator getListaParticipantes()
    {
        participantes.sort(Comparator.comparing(Usuario::getNome));
        return participantes.iterator();
    }
}
