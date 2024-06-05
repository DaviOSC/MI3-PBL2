package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class LeilaoAutomaticoFechado extends LeilaoAutomatico implements Serializable
{
    private static final long serialVersionUID = 1L;
    
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
    @Override
    public Lance getUltimoLance()
    {
        ArrayList<Lance> lances = getListaLances();
        if(lances.isEmpty())
        {
            return null;
        }
        else
        {
            Collections.sort(lances, new Comparator<Lance>() 
            {
            @Override
            public int compare(Lance lance1, Lance lance2) 
            {
                int valor = Double.compare(lance1.getValor(), lance2.getValor());
                if (valor == 0) 
                {
                    return lance1.getMomento().compareTo(lance2.getMomento());
                }
                return valor;
            }
        });
            return (Lance)lances.get(lances.size()-1);
        }
    }
}
