package br.com.crud.teste;

import java.util.Date;
import java.util.Scanner;

import br.com.crud.dao.PedidoDAO;
import br.com.crud.models.Pedido;

public class TestePedido {

	public static void main(String[] args) {

		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = new Pedido();
		
		
		int id1=0, id2=0, op = 0;
		Scanner s = new Scanner(System.in);

		do {
			System.out.println("Escolha uma das op��es: ");
			System.out.println(
					"1 - CADASTRAR PEDIDO\n2 - ATUALIZAR PEDIDO\n3 - REMOVER PEDIDO \n4 - LISTAR PEDIDOS CADASTRADOS");
			op = Integer.parseInt(s.nextLine());

			if (((op <= 0) || (op > 5)))
				System.out.println("Op��o inv�lida!");

		} while ((op <= 0) || (op > 5));

		if (op == 1) {
		
				
				System.out.println("-------------  CADASTRAR PEDIDO ------------");
				System.out.print("Digite o ID do cliente que deseja atrelar ao pedido:");
				pedido.setIdCliente(id1 = Integer.parseInt(s.nextLine()));
				pedido.setDataPedido(new Date());
				
				pedidoDAO.save(pedido);
				
				System.out.println("Pedido cadastrado com sucesso!");

		} else if(op == 2) {
			
			System.out.println("-------------  ATUALIZAR PEDIDO ------------");
			
			
			pedido.setDataPedido(new Date());
			System.out.print("Digite o ID do Cliente  atrelado ao pedido: ");
			pedido.setIdCliente(id1 = Integer.parseInt(s.nextLine()));
			System.out.print("Digite o ID do Pedido:");
			pedido.setIdPedido(id2 = Integer.parseInt(s.nextLine()));
			
			pedidoDAO.update(pedido);
			
			System.out.println("Pedido atualizado com sucesso!");		
			
			
		}else if (op==3) {
			
			System.out.println("-------------  REMOVER PEDIDO ------------");
			
			System.out.print("Digite o ID do pedido que voc� deseja remover: ");
			pedido.setIdPedido(id1 = Integer.parseInt(s.nextLine()));
			pedidoDAO.removeByID(id1);
			System.out.println("Pedido removido com sucesso!");
			
		}else {
			
			System.out.println("------------ PEDIDOS CADASTRADOS ----------");
			System.out.println();
			
			for (Pedido p : pedidoDAO.getPedidos()) {

				System.out.println("N. PEDIDO: " + p.getIdPedido() + " \nDATA DO PEDIDO: " + p.getDataPedido()
						+ "\nID CLIENTE: " + p.getCliente().getIdCliente() + "\nCLIENTE: " + p.getCliente().getNome()
						+ "\nCPF: " + p.getCliente().getCpf() + "\nTELEFONE: " + p.getCliente().getTelefone()
						+ "\nEMAIL: " + p.getCliente().getEmail());

				System.out.println("------------------------------------------------------");
			}
			
			System.out.println("Estes s�o todos os pedidos cadastrados no banco de dados. Obrigado!");
			
		}
		
		

	}

}
