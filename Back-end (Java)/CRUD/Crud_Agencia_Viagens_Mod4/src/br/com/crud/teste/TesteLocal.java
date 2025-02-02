package br.com.crud.teste;

import java.util.Scanner;

import br.com.crud.dao.LocalDAO;
import br.com.crud.models.Local;

public class TesteLocal {

	public static void main(String[] args) {


		LocalDAO localDAO = new LocalDAO();
		Local local = new Local();
		
		String descricao;
		double preco;
		int id1=0, id2=0, op = 0;
		Scanner s = new Scanner(System.in);

		do {
			System.out.println("Escolha uma das op��es: ");
			System.out.println(
					"1 - CADASTRAR LOCAL AO PEDIDO\n2 - ATUALIZAR LOCAL\n3 - REMOVER LOCAL\n4 - LISTAR LOCAIS CADASTRADOS");
			op = Integer.parseInt(s.nextLine());

			if (((op <= 0) || (op > 5)))
				System.out.println("Op��o inv�lida!");

		} while ((op <= 0) || (op > 5));

		if (op == 1) {
		
				System.out.println("-------------  CADASTRAR LOCAL AO PEDIDO ------------");
				
				System.out.print("Digite a descri��o do local (Nome da cidade e estado):");
				local.setDescricao(descricao = s.nextLine());
				System.out.print("Digite o pre�o da passagem para atrelar ao local: ");
				local.setPreco(preco = Double.parseDouble(s.nextLine()));
				System.out.print("Digite o ID do Pedido que deseja atrelar a este local:");
				local.setIdPedido(id2 = Integer.parseInt(s.nextLine()));
				
				localDAO.save(local);
				
				System.out.println("Local cadastrado com sucesso!");

		} else if(op == 2) {
			
			System.out.println("-------------  ATUALIZAR LOCAL ------------");
			
			System.out.print("Digite o ID do local a ser atualizado: ");
			local.setIdLocal(id1 = Integer.parseInt(s.nextLine()));
			System.out.print("Digite a descri��o do local  (Nome da cidade e estado): ");
			local.setDescricao(descricao = s.nextLine());
			System.out.print("Digite o pre�o da passagem para atrelar ao local: ");
			local.setPreco(preco = Double.parseDouble(s.nextLine()));
			System.out.print("Digite o ID do Pedido que deseja atrelar a este local:");
			local.setIdPedido(id2 = Integer.parseInt(s.nextLine()));
			
			localDAO.update(local);
			
			System.out.println("Local atualizado com sucesso!");		
			
			
		}else if (op==3) {
			
			System.out.println("-------------  REMOVER LOCAL ------------");
			
			System.out.print("Digite o ID do pedido que voc� deseja remover: ");
			local.setIdPedido(id1 = Integer.parseInt(s.nextLine()));
			localDAO.removeByID(id1);
			System.out.println("Local removido com sucesso!");
			
		}else {
			
			System.out.println("---------------- LOCAIS CADASTRADOS -----------------");
			System.out.println();
			
			for (Local l : localDAO.getLocais()) {

				System.out.println("ID LOCAL: "+l.getIdLocal()+"\nDESCRI��O DO LOCAL: "+l.getDescricao()+"\nPRE�O: R$ "+l.getPreco()+     
						"\nN. PEDIDO: " + l.getPedido().getIdPedido() + " \nDATA DO PEDIDO: " + l.getPedido().getDataPedido()
						+ "\nID CLIENTE: " + l.getPedido().getCliente().getIdCliente() + "\nCLIENTE: " + l.getPedido().getCliente().getNome()
						+ "\nCPF: " + l.getPedido().getCliente().getCpf() + "\nTELEFONE: " + l.getPedido().getCliente().getTelefone()
						+ "\nEMAIL: " + l.getPedido().getCliente().getEmail());

				System.out.println("------------------------------------------------------");
			}
			
			System.out.println("Estes s�o todos os locais cadastrados no banco de dados. Obrigado!");
			
		}
		
		
		
	}

}
