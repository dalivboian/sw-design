package br.edu.impacta.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class AgendaApp {
	private static Scanner entrada = new Scanner(System.in);
	private static List<Contato> contatos = new ArrayList<>();
	public static void main(String[] args) {
		boolean sair = false;
		while (!sair) {
			int opcao = apresentarMenuPrincipal();
			switch(opcao) {
			case 1: inserirContato(); break;
			case 2: buscarContato(); break;
			case 3: sair = true; break;
			default: out.println("Erro: op��o inv�lida!");		
			}
		}
		out.println("\nFim do progrma!");
	}
	
	private static int apresentarMenuPrincipal() {
		boolean inteiro = false;
		int opcao = 0;
		while(!inteiro) {
			out.println("\nAGENDA TELEFONICA!");
			out.println("(1) Inserir");
			out.println("(2) Buscar");
			out.println("(3) Sair");
			out.println("Escolha uma op��o: ");
			String s = entrada.nextLine();
			try {
				opcao = Integer.parseInt(s);
				inteiro = true;
			} catch(Exception e) {
				out.println("Erro: op��o deve ser um valor inteiro!");
			}			
		}
		return opcao;
	}
	
	public static void inserirContato() {
		out.println("\nINSERS�O DE NOVO CONTATO:");
		String nome = lerNome();
		String telefone = lerTelefone();
		Contato c = new Contato(nome, telefone);
		if (contatos.contains(c)) {
			out.println("Este contato j� esta cadastrado!");
		}
		else {
			contatos.add(c);
			out.println("Contato Inserido!");
		}
	}
	
	private static String lerNome() {
		boolean valido = false;
		String nome = "";
		while (!valido) {
			out.println("Nome: ");
			nome = entrada.nextLine();
			if (nome.length()==0 || nome.length()>200) {
				out.println("Erro: nome de tamanho inv�lido!");				
			} else { valido = true; }			
		}
		return nome;
	}
	
	private static String lerTelefone() {
		boolean valido = false;
		String telefone = "";
		while (!valido) {
			out.println("Telefone: ");
			telefone = entrada.nextLine();
			if (telefone.length()==0 || telefone.length()>25) {
				out.println("Erro: nome de tamanho inv�lido!");				
			} else { valido = true; }			
		}
		return telefone;
	}
	
	private static void buscarContato() {
		out.println("\nBUSCA DE CONTATOS:");
		String nome = lerNome();
		List<Contato> resultado = new ArrayList<>();
		for (Contato c: contatos) {
			if (nome.equals(c.getNome())) {
				resultado.add(c);
			}
		}
		if (resultado.size() == 0) {
			out.println("N�o h� contato com esse nome!");			
		} else {
			out.println("\nResultado da busca:");
			for (Contato c: resultado) {
				out.println(c);
			}
		}
	}
	
}
