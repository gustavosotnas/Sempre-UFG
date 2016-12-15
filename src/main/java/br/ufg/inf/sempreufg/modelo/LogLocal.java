package br.ufg.inf.sempreufg.modelo;

import br.ufg.inf.sempreufg.enums.ComandoSQL;
import br.ufg.inf.sempreufg.enums.MensagemClienteValores;
import br.ufg.inf.sempreufg.enums.MensagemValores;
import br.ufg.inf.sempreufg.enums.ParametrosLogging;
import br.ufg.inf.sempreufg.interfaces.LogConfigItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogLocal implements LogConfigItem
{
    private ParametroLog destinoLog = new ParametroLog();
    private ParametroLog diretorioLog= new ParametroLog();;
    private ParametroLog nomeArquivo= new ParametroLog();;
    private ParametroLog tempoDeVidaLog= new ParametroLog();;
    private ParametroLog tamanhoMaximoLog= new ParametroLog();;

    public LogLocal()
    {
    	destinoLog.setSigla( ParametrosLogging.LOG_DESTINATION.name());
    	diretorioLog.setSigla(ParametrosLogging.LOG_DIRECTORY.name());
    	nomeArquivo.setSigla(ParametrosLogging.LOG_FILENAME.name());
    	tempoDeVidaLog.setSigla(ParametrosLogging.LOG_DURATION.name());
    }
    
    public ArrayList<ParametroLog> getParametros()
    {
    	ArrayList<ParametroLog> parametros = new ArrayList<ParametroLog>();
    	
    	parametros.add(destinoLog);
    	parametros.add(diretorioLog);
    	parametros.add(nomeArquivo);
    	parametros.add(tempoDeVidaLog);
    	parametros.add(tamanhoMaximoLog);
    	
    	return parametros;
   }
    
    public void setParametro( ParametroLog parametro)
    {
    	if( parametro.getSigla().equals("LOG_DESTINATION")) {
    		destinoLog = parametro;
    	}
    	else if ( parametro.getSigla().equals("LOG_DIRECTORY"))
    		diretorioLog = parametro;
    	else if ( parametro.getSigla().equals("LOG_FILENAME"))
    		nomeArquivo = parametro;
    	else if ( parametro.getSigla().equals("LOG_DURATION"))
    		tempoDeVidaLog = parametro;
    }
 
    @Override
    public void configurarParametros(ArrayList<ParametroLog> parametros) 
    {
    	Iterator<ParametroLog> iterador = parametros.iterator();

    	while(iterador.hasNext() )
    	{
    		ParametroLog param = iterador.next();

    		setParametro( param );
    	}
    }

    public ParametroLog getDestinoLog() {
        return destinoLog;
    }

    public ParametroLog getDiretorioLog() {
        return diretorioLog;
    }

    public ParametroLog getNomeArquivo() {
        return nomeArquivo;
    }

    public ParametroLog getTempoDeVidaLog() {
        return tempoDeVidaLog;
    }

    public ParametroLog getTamanhoMaximoLog() {
        return tamanhoMaximoLog;
    }
}
