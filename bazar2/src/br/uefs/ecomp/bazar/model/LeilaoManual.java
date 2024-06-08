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
    public boolean encerrar()
    {
        this.setStatus(Leilao.ENCERRADO);
        if(getProduto().isVendido())
        {
            return false;
        }
        else if(this.getVenda() == null && !getListaLances().isEmpty())
        {
            setVenda(new Venda(getUltimoLance(), this));
            getProduto().setVendido();
            return true;
        }
        this.setFim(new Date());
        return false;
    }
    
    
        
}
