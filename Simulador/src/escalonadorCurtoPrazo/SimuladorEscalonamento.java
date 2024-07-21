package escalonadorCurtoPrazo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SimuladorEscalonamento {
	
	 static int tempoAtual = 0;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Processo> processos = new ArrayList<>();

	        System.out.println("Quantidade de processos: ");
	        int numProcessos = scanner.nextInt();

	        for (int i = 0; i < numProcessos; i++) {
	            System.out.println("Nome do processo " + (i + 1) + ": ");
	            String nome = scanner.next();
	            System.out.println("Tempo de chegada do processo " + (i + 1) + ": ");
	            int chegada = scanner.nextInt();
	            System.out.println("Tempo de execução do processo " + (i + 1) + ": ");
	            int execucao = scanner.nextInt();
	            processos.add(new Processo(nome, chegada, execucao));
	        }
	        

	        System.out.println("Escolha o algoritmo de escalonamento (1 - FCFS, 2 - SJF): ");
	        int escolha = scanner.nextInt();

	        if (escolha == 1) {
	            fcfs(processos);
	        } else if (escolha == 2) {
	            sjf(processos);
	        } else {
	            System.out.println("Opção inválida");
	        }

	        scanner.close();
	    }

	    static void fcfs(ArrayList<Processo> processos) {
	        processos.sort(Comparator.comparingInt(p -> p.getTempoChegada()));
	        for (Processo processo : processos) {
	            if (processo.getTempoChegada() > tempoAtual) {
	                tempoAtual = processo.getTempoChegada();
	            }
	            processo.setTempoInicio(tempoAtual);
	            processo.setTempoEspera(tempoAtual - processo.getTempoChegada());
	            exibirExecucao(processo);
	            tempoAtual += processo.getTempoExecucao();
	            processo.setTempoRetorno(tempoAtual - processo.getTempoChegada());
	        }
	        exibirResultados(processos);
	    }

	    static void sjf(ArrayList<Processo> processos) {
	        processos.sort(Comparator.comparingInt(p -> p.getTempoExecucao()));
	        for (Processo processo : processos) {
	            if (processo.getTempoChegada() > tempoAtual) {
	                tempoAtual = processo.getTempoChegada();
	            }
	            processo.setTempoInicio(tempoAtual);
	            processo.setTempoEspera(tempoAtual - processo.getTempoChegada());
	            exibirExecucao(processo);
	            tempoAtual += processo.getTempoExecucao();
	            processo.setTempoRetorno(tempoAtual - processo.getTempoChegada());
	        }
	        exibirResultados(processos);
	    }

	    static void exibirExecucao(Processo processo) {
	        System.out.println("Executando processo " + processo.getNome());
	        for (int i = 0; i < processo.getTempoExecucao(); i++) {
	            System.out.println("Tempo de execução: " + (i + 1) + "/" + processo.getTempoExecucao());
	            try {
	                Thread.sleep(1000); 
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        System.out.println("Processo " + processo.getNome() + " concluído");
	    }

	    static void exibirResultados(ArrayList<Processo> processos) {
	        double tempoEsperaMedio = 0;
	        double tempoRetornoMedio = 0;
	        double utilizacaoCPU = 0;

	        for (Processo processo : processos) {
	            tempoEsperaMedio += processo.getTempoEspera();
	            tempoRetornoMedio += processo.getTempoRetorno();
	        }

	        tempoEsperaMedio /= processos.size();
	        tempoRetornoMedio /= processos.size();
	        utilizacaoCPU = (tempoRetornoMedio / tempoAtual)*100;

	        System.out.println("Tempo de espera médio: " + tempoEsperaMedio + " segundos");
	        System.out.println("Tempo de retorno médio: " + tempoRetornoMedio + " segundos");
	        System.out.println("Utilização da CPU: " + utilizacaoCPU + "%");
	    }

}
