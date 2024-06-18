package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import br.uefs.ecomp.bazar.model.exception.LeilaoNaoParticipaException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LeilaoAutomaticoFechado extends LeilaoAutomatico
{
    private static final long serialVersionUID = 1L;
    //participantes que já deram lance no leilão
    private Set<Usuario> participantesComLance = new HashSet<>();
    
    public LeilaoAutomaticoFechado(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto, Date horarioInicio, Date horarioFim)
    {
        super(lPrecoMinimo, lIncrementoMinimo, lVendedor, lProduto, horarioInicio,  horarioFim);
    }
    
    
    @Override
    public boolean darLance(Usuario usuario, double preco) throws LanceInvalidoException, LeilaoNaoParticipaException
    {

        if(participantesComLance.contains(usuario))
        {
            throw new LanceInvalidoException("Participante ja deu seu lance.");
        }    
        else if(!(getParticipantes().contains(usuario)))//lista de participantes geral
        {
            throw new LeilaoNaoParticipaException("Usuario não participa desse leilão");
        }
        else if(this.getStatus() == Leilao.CADASTRADO || this.getStatus() == Leilao.ENCERRADO)
        {
            throw new LanceInvalidoException("Leilao não está iniciado.");            
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
                participantesComLance.add(usuario);
                return true;
            }
        }
    }
    
    @Override
    public void darLanceMinimo(Usuario usuario) throws LanceInvalidoException, LeilaoNaoParticipaException
    {      
        if(participantesComLance.contains(usuario))
        {
            throw new LanceInvalidoException("Participante ja deu seu lance.");
        } 
        else if(!(getParticipantes().contains(usuario)))
        {
            throw new LeilaoNaoParticipaException("Usuario não participa desse leilão");
        }
        else if(this.getStatus() == Leilao.INICIADO)
        {
            Lance lance = new Lance(usuario, getPrecoMinimo() + getIncrementoMinimo());
            getListaLances().add(lance);
            participantesComLance.add(usuario);
        }
        else
        {
            throw new LanceInvalidoException("Leilao não está iniciado.");
        }
    }
    @Override
    public void encerrar()
    {
        ordenaLista();//ordena do maior lance para o menor
        this.setStatus(Leilao.ENCERRADO);
        if(this.getVenda() == null && !getListaLances().isEmpty())
        {
            setVenda(new Venda(getListaLances().get(0), this));
            getProduto().setVendido();
        }
    }
    
    public void ordenaLista()
    {
        if(!getListaLances().isEmpty())
        {
            Collections.sort(getListaLances(), new Comparator<Lance>() 
                {
                @Override
                public int compare(Lance lance1, Lance lance2) 
                {
                    int valor = Double.compare(lance2.getValor(), lance1.getValor());
                    // ordena, caso ocorra um lance igual, de acordo com o momento do lance
                    if (valor == 0) 
                    {
                        return lance2.getMomento().compareTo(lance1.getMomento());
                    }
                    return valor;
                }
                });
        }

    }
    
}
