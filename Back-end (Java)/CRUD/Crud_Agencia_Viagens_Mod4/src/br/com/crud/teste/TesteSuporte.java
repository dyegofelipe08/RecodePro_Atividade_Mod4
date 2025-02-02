package br.com.crud.teste;


import java.util.Scanner;

import br.com.crud.dao.SuporteDAO;
import br.com.crud.models.Suporte;

public class TesteSuporte {

	public static void main(String[] args) {

		SuporteDAO suporteDAO = new SuporteDAO();

		Suporte suporte = new Suporte();
			
		int id1=0, id2=0, op = 0;
		String msg = null;
		Scanner s = new Scanner(System.in);

		do {
			System.out.println("Escolha uma das op��es: ");
			System.out.println(
					"1 - INSERIR MENSAGEM\n2 - ATUALIZAR MENSAGEM\n3 - REMOVER MENSAGEM \n4 - LISTAR MENSAGENS INSERIDAS");
			op = Integer.parseInt(s.nextLine());

			if (((op <= 0) || (op > 5)))
				System.out.println("Op��o inv�lida!");

		} while ((op <= 0) || (op > 5));

		if (op == 1) {
		
				
				System.out.println("-------------  INSERIR MENSAGEM------------");
				
				System.out.print("Digite a mensagem:");
				suporte.setMensagem(msg = s.nextLine());
				System.out.print("Digite o ID do cliente que deseja atrelar � mensagem:");
				suporte.setIdCliente(id1 = Integer.parseInt(s.nextLine()));
				
				suporteDAO.save(suporte);
				
				System.out.println("Mensagem inserida com sucesso!");

		} else if(op == 2) {
			
			System.out.println("-------------  ATUALIZAR MENSAGEM ------------");
			
			System.out.print("Digite a mensagem:");
			suporte.setMensagem(msg = s.nextLine());
			System.out.print("Digite o ID do Cliente  atrelado � mensagem: ");
			suporte.setIdCliente(id1 = Integer.parseInt(s.nextLine()));
			System.out.print("Digite o ID da mensagem:");
			suporte.setIdSuporte(id2 = Integer.parseInt(s.nextLine()));
			
			suporteDAO.update(suporte);
			
			System.out.println("Mensagem atualizada com sucesso!");		
			
			
		}else if (op==3) {
			
			System.out.println("-------------  REMOVER MENSAGEM ------------");
			
			System.out.print("Digite o ID da mensagem que voc� deseja remover: ");
			suporte.setIdSuporte(id1 = Integer.parseInt(s.nextLine()));
			suporteDAO.removeByID(id1);
			System.out.println("Mensagem removida com sucesso!");
			
		}else {
			
			System.out.println("------------ MENSAGENS INSERIDAS ----------");
			System.out.println();
			
			for (Suporte s1 : suporteDAO.getSuportes()) {

				System.out.println("ID MENSAGEM: " + s1.getIdSuporte() + "\nMENSAGEM: "+s1.getMensagem() +"\nID CLIENTE: " + s1.getCliente().getIdCliente() + "\nNOME DO CLIENTE: " + s1.getCliente().getNome()
						+ "\nCPF: " + s1.getCliente().getCpf() + "\nTELEFONE: " + s1.getCliente().getTelefone()
						+ "\nEMAIL: " + s1.getCliente().getEmail());
				System.out.println("------------------------------------------------------------");

			}
			
			
			System.out.println("Estes s�o todos os pedidos cadastrados no banco de dados. Obrigado!");
			
		}
		
				

	}

}
