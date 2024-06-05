package br.uefs.ecomp.bazar.model;

import java.io.Serializable;
import java.util.Date;

public class LeilaoAutomatico extends Leilao implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public LeilaoAutomatico(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto, Date horarioInicio, Date horarioFim)
    {
        super(lPrecoMinimo, lIncrementoMinimo, lVendedor, lProduto);
        super.setInicio(horarioInicio);
        super.setFim(horarioFim);
    }
    
    @Override
    public void iniciar()
    {
        this.setStatus(Leilao.INICIADO);
        getListaLances().clear();
        getVendedor().setLeilaoAtivo(this); 
    }
    
    @Override
    public void encerrar()
    {
        this.setStatus(Leilao.ENCERRADO);
        if(this.getVenda() == null && !getListaLances().isEmpty())
        {
            setVenda(new Venda(getUltimoLance(), this));
            getProduto().setVendido();
        }
    }
    
        
    public void checkForEnd()
    {
        if(this.getTermino().compareTo(new Date()) <= 0 && this.getStatus() == Leilao.INICIADO)
        {
            encerrar();
        }
                
    }
    
    public void checkForStart()
    {
        if(this.getInicio().compareTo(new Date()) <= 0 && this.getStatus() == Leilao.CADASTRADO)
        {
            iniciar();
        }
    }

}
