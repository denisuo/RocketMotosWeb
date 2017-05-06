package br.com.rocketmotos.util;

import java.util.ArrayList;

import br.com.rocketmotos.dao.MarcaMotoDAO;
import br.com.rocketmotos.dao.ModeloMotoDAO;
import br.com.rocketmotos.entidade.EntidadeMarcaMoto;
import br.com.rocketmotos.entidade.EntidadeModeloMoto;



public class Teste {

	public static void main(String[] args) {
		
//		Double valor = 130.00;
//		
//		EntidadeClientePJ clientePJ = new EntidadeClientePJ();
//		Double valorDesconto = clientePJ.getDesconto();
//		
//		valor = valor + (valor * valorDesconto);

//		MarcaMotoDAO marcaMotoDao = new MarcaMotoDAO();
//		marcaMotoDao.incluir(eMarcaMoto);
		//marcaMotoDao.alterar(eMarcaMoto);
		//marcaMotoDao.excluir(eMarcaMoto);
		
		EntidadeModeloMoto eModeloMoto = new EntidadeModeloMoto();
		eModeloMoto.setCodigoModeloMoto(2);
		eModeloMoto.setNome("YBR");
		eModeloMoto.setCodigoMarcaMoto(1);
		eModeloMoto.setCilindrada("125");
		
		ModeloMotoDAO modeloMotoDao = new ModeloMotoDAO();
		//modeloMotoDao.incluir(eModeloMoto);
		//modeloMotoDao.alterar(eModeloMoto);
		//modeloMotoDao.excluir(eModeloMoto);
		
		ArrayList<EntidadeModeloMoto> alModeloMoto = modeloMotoDao.listarTodos();
//		ArrayList<EntidadeModeloMoto> alModeloMoto = modeloMotoDao.consultarPorCilindrada(eModeloMoto.getCilindrada());
//		ArrayList<EntidadeMarcaMoto> alMarcaMoto = marcaMotoDao.listarTodos();
		
		for (EntidadeModeloMoto em : alModeloMoto) {
			
			System.out.println(em.toString());
			
		}
	}
}
