package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import br.uefs.ecomp.bazar.model.exception.LeilaoNaoParticipaException;
import br.uefs.ecomp.bazar.model.exception.UsuarioJaParticipaException;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public abstract class Leilao implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    // Constantes para representar os estados de um leilao qualquer:
    public static final int CADASTRADO = 0;
    public static final int INICIADO = 1;
    public static final int ENCERRADO = 2;

    private double precoMinimo;
    private double incrementoMinimo;
    private int status;
    private Produto produto;
    private Usuario vendedor;
    private Venda venda;
    private Date momentoInicio;
    private Date momentoFim;

    //estrutura para armazenar os participantes do leilao 
    private ArrayList<Lance> lances = new ArrayList();
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
    public void cadastrarParticipante(Usuario usuario) throws UsuarioJaParticipaException {
        if(participantes.contains(usuario))
        {
            throw new UsuarioJaParticipaException("Usuário já participa do leilão.");
        }
        else
        {
            participantes.add(usuario);
        }
    }

    // um usu�rio d� um lance com base no pre�o minimo e no incremento
    public void darLanceMinimo(Usuario usuario) throws LanceInvalidoException, LeilaoNaoParticipaException
    {
        if(!(participantes.contains(usuario)))
        {
            throw new LeilaoNaoParticipaException("Usuario não participa desse leilão");
        }
        else if(this.getStatus() == Leilao.INICIADO)
        {
            Lance lance = new Lance(usuario, this.precoMinimo + this.incrementoMinimo);
            lances.add(lance);
            this.precoMinimo = lance.getValor();
        }
        else
        {
            throw new LanceInvalidoException("Leilao nao esta ativo ainda.");
        }
        
    }

    // um lance com um valor especifico decidido pelo usu�rio e verifica suas condi��es de valida��o, returnando falso caso n�o seja aceit�vel
    public boolean darLance(Usuario usuario, double preco) throws LanceInvalidoException, LeilaoNaoParticipaException
    {
        if(!(participantes.contains(usuario)))
        {
            throw new LeilaoNaoParticipaException("Usuario não participa desse leilão");
        }
        else if(this.getStatus() == Leilao.CADASTRADO || this.getStatus() == Leilao.ENCERRADO)
        {
            throw new LanceInvalidoException("Leilao nao esta ativo ainda.");            
        }
        else
        {
            Lance lance = new Lance(usuario, preco);
            if(lance.getValor() < this.precoMinimo + this.incrementoMinimo)
            {
                //throw new LanceInvalidoException("Lance deve ser maior o preco minimo mais o incremento minimo.");
                return false;
            }
            else
            {
                lances.add(lance);
                this.precoMinimo = lance.getValor() + this.incrementoMinimo;
                return true;
            }
        }
    }

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
        System.out.print("GetUltimoMANUAL");
        if(lances.isEmpty())
        {
            return null;
        }
        else
        {
            return (Lance)lances.get(lances.size()-1);
        }
    }
    
    public void setFim(Date date)
    {
        this.momentoFim = date;
    }
    public void setInicio(Date date)
    {
        this.momentoInicio = date;
    }
    public Date getInicio()
    {
        return momentoInicio;
    }
    public Date getTermino()
    {
        return momentoFim;
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
    public ArrayList<Lance> getListaLances()
    {
        return lances;
    }
    public Iterator getListaParticipantes()
    {
        participantes.sort(Comparator.comparing(Usuario::getNome));
        return participantes.iterator();
    }
    public ArrayList<Usuario> getParticipantes()
    {
        return participantes;
    }
    @Override
    public String toString()
    {
        return this.vendedor + ", " + this.produto.getDescricaoResumida();
    }
}
