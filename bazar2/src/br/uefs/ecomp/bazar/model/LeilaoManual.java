package br.uefs.ecomp.bazar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class LeilaoManual extends Leilao implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public LeilaoManual(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto)
    {
        super(lPrecoMinimo, lIncrementoMinimo, lVendedor, lProduto);
    }
 
    @Override
    public void iniciar()
    {
        this.setStatus(Leilao.INICIADO);
        getListaLances().clear();
        getVendedor().setLeilaoAtivo(this);
        this.setInicio(new Date());    
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
        this.setFim(new Date());
    }
    
    
        
}
