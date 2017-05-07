package br.com.rocketmotos.util;

import java.util.ArrayList;

import br.com.rocketmotos.dao.ClienteDAO;
import br.com.rocketmotos.dao.MarcaMotoDAO;
import br.com.rocketmotos.dao.ModeloMotoDAO;
import br.com.rocketmotos.entidade.EntidadeCliente;
import br.com.rocketmotos.entidade.EntidadeClientePF;
import br.com.rocketmotos.entidade.EntidadeMarcaMoto;
import br.com.rocketmotos.entidade.EntidadeModeloMoto;



public class Teste {

	public static void main(String[] args) {
		
//		Double valor = 130.00;
//		EntidadeClientePJ clientePJ = new EntidadeClientePJ();
//		Double valorDesconto = clientePJ.getDesconto();
//		valor = valor + (valor * valorDesconto);

		EntidadeCliente eClientePF = new EntidadeCliente();
		eClientePF.setDocumento("99999999988");
		eClientePF.setNome("Cliente teste");
		eClientePF.setEndereco("Av. Tapajós");
		eClientePF.setTelefone("8199995588");
		eClientePF.setTipoCliente(Constantes.Pessoa_PF);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		//clienteDAO.incluir(eClientePF);
		
//		MarcaMotoDAO marcaMotoDao = new MarcaMotoDAO();
//		marcaMotoDao.incluir(eMarcaMoto);
		//marcaMotoDao.alterar(eMarcaMoto);
		//marcaMotoDao.excluir(eMarcaMoto);
		
		//ModeloMotoDAO modeloMotoDao = new ModeloMotoDAO();
		//modeloMotoDao.incluir(eModeloMoto);
		//modeloMotoDao.alterar(eModeloMoto);
		//modeloMotoDao.excluir(eModeloMoto);
		
		ArrayList<EntidadeCliente> alCliente = new ArrayList<EntidadeCliente>();
//		clienteDAO.alterar(eClientePF);
//		alCliente = clienteDAO.consultarPorDocumento("12345678989");
		alCliente = clienteDAO.consultarTodos();
//		ArrayList<EntidadeModeloMoto> alModeloMoto = modeloMotoDao.listarTodos();
//		ArrayList<EntidadeModeloMoto> alModeloMoto = modeloMotoDao.consultarPorCilindrada(eModeloMoto.getCilindrada());
//		ArrayList<EntidadeMarcaMoto> alMarcaMoto = marcaMotoDao.listarTodos();
		
		for (EntidadeCliente ec : alCliente) {
			
			System.out.println(ec.toString());
			
		}
	}
}
