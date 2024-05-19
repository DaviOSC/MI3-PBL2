package br.uefs.ecomp.bazar.model;

import java.util.Date;

public class LeilaoAutomatico extends Leilao
{
    
    public LeilaoAutomatico(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto, Date horarioInicio, Date horarioFim)
    {
        super(lPrecoMinimo, lIncrementoMinimo, lVendedor, lProduto);
        super.setFim(horarioFim);
    }
    
    public void iniciar()
    {
        this.setStatus(Leilao.INICIADO);
        getListaLances().clear();
        getVendedor().setLeilaoAtivo(this); 
    }
    
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
        if(this.getFim().compareTo(new Date()) < 0 && this.getStatus() == Leilao.INICIADO)
        {
            encerrar();
        }
                
    }
    
    public void checkForStart()
    {
        if(this.getFim().compareTo(new Date()) < 0 && this.getStatus() == Leilao.CADASTRADO)
        {
            iniciar();
        }
    }

}
