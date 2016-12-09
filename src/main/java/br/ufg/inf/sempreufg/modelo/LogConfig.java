package br.ufg.inf.sempreufg.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by DYEGO-VOSTRO on 28/11/2016.
 */
public class LogConfig
{
    private LogLocal local = new LogLocal();
    private LogGatilhos gatilhos = new LogGatilhos();
    private LogItens itens = new LogItens();
	
	private int logConfig;
    private File arquivoLog;


    
    
    public LogLocal getLocal() {
		return local;
	}

	public void setLocal(LogLocal local) {
		this.local = local;
	}

	public LogGatilhos getGatilhos() {
		return gatilhos;
	}

	public void setGatilhos(LogGatilhos gatilhos) {
		this.gatilhos = gatilhos;
	}

	public LogItens getItens() {
		return itens;
	}

	public void setItens(LogItens itens) {
		this.itens = itens;
	}

	private void gerarArquivoLog() throws IOException
    {
		String line = null;
		FileReader reader = new FileReader(arquivoLog);
    	BufferedReader br = new BufferedReader( reader );
    	StringBuilder fileContent = new StringBuilder();
    	
    	while( (line = br.readLine()) != null )
    	{
    		    		
    		if(line.contains( "client_min_messages"))
    		{
    			System.out.println("Entrei aqui");
    			line = "#client_min_messages = " + local.getNivelMensagemCliente()+ "		# values in order of decreasing detail:";
    			
    			//line = line.replaceFirst("\'(.*?)\'", local.get)
    			fileContent.append( line + System.getProperty("line.separator") );
    		}
    		else {
    			fileContent.append( line + System.getProperty("line.separator") );
    			
    			
    		}
    	}
    	
    	FileWriter fw = new FileWriter(arquivoLog);
    	BufferedWriter out = new BufferedWriter( fw );
    	out.write(fileContent.toString());
    	out.close();
		
    }

    public File getArquivoLog() {
		return arquivoLog;
	}

	public void setArquivoLog(File arquivoLog) {
		this.arquivoLog = arquivoLog;
	}

	public int configurarLog(ArrayList<ParametroLog> listaParamentros)
    {
    	local.configurarParametros(listaParamentros);
    	gatilhos.configurarParametros(listaParamentros);
    	itens.configurarParametros(listaParamentros);
    	
    	
    	return 0;
    }

    public int carregarConfigFile() throws IOException
    {
    	arquivoLog = new File("C:\\Program Files\\PostgreSQL\\9.6\\data\\postgresql.conf" );
    	
    	
    	gerarArquivoLog();
    	return 0;
    }
}
