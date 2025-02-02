package br.com.crud.teste;

import java.util.Scanner;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.models.Cliente;

public class TesteCliente {

	public static void main(String[] args) {

		
		int id=0, op = 0;
		String nome, cpf, telefone, email = null;
		Scanner s = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();

		do {
			System.out.println("Escolha uma das op��es: ");
			System.out.println(
					"1 - CADASTRAR CLIENTE\n2 - ATUALIZAR CLIENTE\n3 - REMOVER CLIENTE \n4 - LISTAR CLIENTES  CADASTRADOS");
			op = Integer.parseInt(s.nextLine());

			if (((op <= 0) || (op > 5)))
				System.out.println("Op��o inv�lida!");

		} while ((op <= 0) || (op > 5));

		if (op == 1) {
			
				Cliente cliente = new Cliente();
				
				System.out.println("-------------  CADASTRAR CLIENTE ------------");
				System.out.print("Digite o nome do cliente:");
				cliente.setNome(nome = s.nextLine());
				System.out.print("Digite o CPF do cliente:");
				cliente.setCpf(cpf = s.nextLine());
				System.out.print("Digite o telefone do cliente: ");
				cliente.setTelefone(telefone = s.nextLine());
				System.out.print("Digite o e-mail do cliente: ");
				cliente.setEmail(telefone = s.nextLine());

				clienteDAO.save(cliente);
				
				System.out.println("Cliente inserido com sucesso!");

		} else if(op == 2) {
			
			Cliente cliente = new Cliente();
			System.out.println("-------------  ATUALIZAR CLIENTE ------------");
			System.out.print("Digite o ID do cliente:");
			cliente.setIdCliente(id = Integer.parseInt(s.nextLine()));
			System.out.print("Digite o nome do cliente:");
			cliente.setNome(nome = s.nextLine());
			System.out.print("Digite o CPF do cliente:");
			cliente.setCpf(cpf = s.nextLine());
			System.out.print("Digite o telefone do cliente: ");
			cliente.setTelefone(telefone = s.nextLine());
			System.out.print("Digite o e-mail do cliente: ");
			cliente.setEmail(email = s.nextLine());
			
			clienteDAO.update(cliente);
			
			System.out.println("Cliente atualizado com sucesso!");
			
			
		}else if (op==3) {
			
			Cliente cliente = new Cliente();
			System.out.println("-------------  REMOVER CLIENTE ------------");
			System.out.print("Digite o ID do cliente que voc� deseja remover: ");
			cliente.setIdCliente(id = Integer.parseInt(s.nextLine()));
			clienteDAO.removeByID(id);
			System.out.println("Cliente removido com sucesso!");
			
		}else {
			
			System.out.println("------------ DADOS DOS CLIENTES CADASTRADOS ----------");
			System.out.println();
			
			for (Cliente c : clienteDAO.getClientes()) {

				System.out.println("ID DO CLIENTE: "+ c.getIdCliente() +"\nNOME: " + c.getNome()+"\nCPF: "+c.getCpf() 
				+ "\nTELEFONE: "+c.getTelefone()+"\nEMAIL: "+c.getEmail());
				
				System.out.println("------------------------------------------------------");

			}
			
			System.out.println("Estes s�o todos os clientes cadastrados no banco de dados. Obrigado!");
			
		}

		
	
		

	}
}
