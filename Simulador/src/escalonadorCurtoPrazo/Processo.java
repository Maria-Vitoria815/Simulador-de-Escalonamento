package escalonadorCurtoPrazo;

public class Processo {
	
	 private String nome;
	 private int tempoChegada;
	 private int tempoExecucao;
	 private int tempoInicio;
	 private int tempoEspera;
	 private int tempoRetorno;
	 
	 
	 
	public Processo() {
		super();
	}
	

	public Processo(String nome, int tempoChegada, int tempoExecucao) {
	   this.nome = nome;
	   this.tempoChegada = tempoChegada;
	   this.tempoExecucao = tempoExecucao;
	   this.tempoInicio = -1; // Inicialmente não iniciado
	   this.tempoEspera = 0;
	   this.tempoRetorno = 0;
	    }


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getTempoChegada() {
		return tempoChegada;
	}


	public void setTempoChegada(int tempoChegada) {
		this.tempoChegada = tempoChegada;
	}


	public int getTempoExecucao() {
		return tempoExecucao;
	}


	public void setTempoExecucao(int tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}


	public int getTempoInicio() {
		return tempoInicio;
	}


	public void setTempoInicio(int tempoInicio) {
		this.tempoInicio = tempoInicio;
	}


	public int getTempoEspera() {
		return tempoEspera;
	}


	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}


	public int getTempoRetorno() {
		return tempoRetorno;
	}


	public void setTempoRetorno(int tempoRetorno) {
		this.tempoRetorno = tempoRetorno;
	}

	
	
}


