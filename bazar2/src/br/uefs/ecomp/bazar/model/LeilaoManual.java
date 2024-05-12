package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;
import java.util.Date;

public class LeilaoManual extends Leilao
{
    
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
    
    public Lance getUltimoLance()
    {
        Lance lance = (Lance)getListaLances().get(getListaLances().size()-1);
        return lance;
    }
    
    @Override
    public void darLanceMinimo(Usuario usuario)
    {
        Lance lance = new Lance(usuario, getPrecoMinimo() + getIncrementoMinimo());
        getListaLances().add(lance);
        setPrecoMinimo(lance.getValor());
    }
    
    @Override
    public boolean darLance(Usuario usuario, double preco)
    {
        Lance lance = new Lance(usuario, preco);
        if (lance.getValor() >= (getPrecoMinimo() + getIncrementoMinimo()))
        {
            getListaLances().add(lance);
            setPrecoMinimo(lance.getValor() + getIncrementoMinimo());
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
