package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import java.io.Serializable;
import java.util.Date;

public class LeilaoAutomaticoFechado extends LeilaoAutomatico implements Serializable
{
    public LeilaoAutomaticoFechado(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto, Date horarioInicio, Date horarioFim)
    {
        super(lPrecoMinimo, lIncrementoMinimo, lVendedor, lProduto, horarioInicio,  horarioFim);
    }
    
    @Override
    public boolean darLance(Usuario usuario, double preco) throws LanceInvalidoException
    {
        for(Lance lance : super.getListaLances())
        {
            if(lance.getParticipante().equals(usuario))
            {
                throw new LanceInvalidoException("Participante ja deu seu lance.");
            }
        }

        if(this.getStatus() == Leilao.CADASTRADO || this.getStatus() == Leilao.ENCERRADO)
        {
            throw new LanceInvalidoException("Leilao nao esta ativo ainda.");            
        }
        else
        {
            Lance lance = new Lance(usuario, preco);
            if(lance.getValor() < getPrecoMinimo() + getIncrementoMinimo())
            {
                return false;
            }
            else
            {
                getListaLances().add(lance);
                return true;
            }
        }
    }
    @Override
    public void darLanceMinimo(Usuario usuario) throws LanceInvalidoException
    {      
        for(Lance lance : super.getListaLances())
        {
            if(lance.getParticipante().equals(usuario))
            {
                throw new LanceInvalidoException("Participante ja deu seu lance.");
            }
        }
        if(this.getStatus() == Leilao.INICIADO)
        {
            Lance lance = new Lance(usuario, getPrecoMinimo() + getIncrementoMinimo());
            getListaLances().add(lance);
            
        }
        else
        {
            throw new LanceInvalidoException("Leilao nao esta ativo ainda.");
        }
    }
}
