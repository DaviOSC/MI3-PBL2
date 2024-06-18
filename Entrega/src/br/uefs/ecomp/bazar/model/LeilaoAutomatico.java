package br.uefs.ecomp.bazar.model;
import java.util.Date;

public class LeilaoAutomatico extends Leilao
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
    
    //verifica se é para encerrar o leilão
    public void checaFim()
    {
        if(this.getTermino().compareTo(new Date()) <= 0 && this.getStatus() == Leilao.INICIADO)
        {
            encerrar();
        }            
    }
    
    //verifica se é para iniciar o leilão  
    public void checaInicio()
    {
        if(this.getInicio().compareTo(new Date()) <= 0 && this.getStatus() == Leilao.CADASTRADO)
        {
            iniciar();
        }
    }

}
