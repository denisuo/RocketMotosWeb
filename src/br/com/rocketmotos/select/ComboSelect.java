package br.com.rocketmotos.select;

import java.util.ArrayList;

import br.com.rocketmotos.dao.DAOCategoriaProduto;
import br.com.rocketmotos.dao.DAOMarcaMoto;
import br.com.rocketmotos.dao.DAOModeloMoto;
import br.com.rocketmotos.dao.DAOServico;
import br.com.rocketmotos.entidade.EntidadeCategoriaProduto;
import br.com.rocketmotos.entidade.EntidadeMarcaMoto;
import br.com.rocketmotos.entidade.EntidadeModeloMoto;
import br.com.rocketmotos.entidade.EntidadeServico;

public class ComboSelect implements IntfComboSelect {
	
	private static ComboSelect aComboSelect = new ComboSelect();
	
	public static ComboSelect getInstancia(){
		if(aComboSelect != null){
			aComboSelect = new ComboSelect();
		}
		return aComboSelect;
	} 
	
	public ComboSelect() {
	}

	@Override
	public String getSelectHtmlCategoriaProduto(String cdCategoriaProduto) {
		StringBuffer str = new StringBuffer();
		ArrayList<EntidadeCategoriaProduto> alCategoriaProduto = DAOCategoriaProduto.consultarTodos(); 
		
		str.append("<select id='cdCategoriaProduto' name='cdCategoriaProduto' class='form-control'>");
		
		for (EntidadeCategoriaProduto eCategoriaProduto : alCategoriaProduto) {
			
			//caso seja passado o codigo da categoria, ele fica marcado como selecionado
			if(cdCategoriaProduto.equals(eCategoriaProduto.getCodigo()+"")){
				str.append("<option selected value='" + eCategoriaProduto.getCodigo() +"'>" + eCategoriaProduto.getCodigo() + " - " + eCategoriaProduto.getNome() + "</option>");
			} else {
				str.append("<option value='" + eCategoriaProduto.getCodigo() +"'>" + eCategoriaProduto.getCodigo() + " - " + eCategoriaProduto.getNome() + "</option>");	
			}
		}
		
		str.append("</select>");
		
		return str.toString();
	}

	@Override
	public String getSelectHtmlServico(String cdServico) {
		StringBuffer str = new StringBuffer();
		ArrayList<EntidadeServico> alServico = DAOServico.consultarTodos(); 
		
		str.append("<select id='cdServico' name='cdServico' class='form-control'>");
		
		for (EntidadeServico eServico : alServico) {
			
			//caso seja passado o codigo do serviço, ele fica marcado como selecionado
			if(cdServico.equals(eServico.getCodigoServico()+"")){
				str.append("<option selected value='" + eServico.getCodigoServico() +"'>" + eServico.getCodigoServico() + " - " + eServico.getNome() + "</option>");
			} else {
				str.append("<option value='" + eServico.getCodigoServico() +"'>"+ eServico.getCodigoServico() + " - " + eServico.getNome() + "</option>");	
			}
		}
		
		str.append("</select>");
		
		return str.toString();
	}

	@Override
	public String getSelectHtmlMarcaMoto(String cdMarcaMoto) {
		StringBuffer str = new StringBuffer();
		ArrayList<EntidadeMarcaMoto> alMarcaMoto = DAOMarcaMoto.consultarTodos(); 
		
		str.append("<select id='cdMarcaMoto' name='cdMarcaMoto' class='form-control'>");
		
		for (EntidadeMarcaMoto eMarcaMoto : alMarcaMoto) {
			
			//caso seja passado o codigo da marca da moto, ele fica marcado como selecionado
			if(cdMarcaMoto.equals(eMarcaMoto.getCodigo()+"")){
				str.append("<option selected value='" + eMarcaMoto.getCodigo() +"'>" + eMarcaMoto.getCodigo() + " - " + eMarcaMoto.getNome() + "</option>");
			} else {
				str.append("<option value='" + eMarcaMoto.getCodigo() +"'>" + eMarcaMoto.getCodigo() + " - " + eMarcaMoto.getNome() + "</option>");	
			}
		}
		
		str.append("</select>");
		
		return str.toString();
	}

	@Override
	public String getSelectHtmlModeloMoto(String cdModeloMoto) {
		StringBuffer str = new StringBuffer();
		ArrayList<EntidadeModeloMoto> alModeloMoto = DAOModeloMoto.consultarTodos(); 
		
		str.append("<select id='cdModeloMoto' name='cdModeloMoto' class='form-control'>");
		
		for (EntidadeModeloMoto eModeloMoto : alModeloMoto) {
			
			//caso seja passado o codigo da marca da moto, ele fica marcado como selecionado
			if(cdModeloMoto.equals(eModeloMoto.getCodigoModeloMoto()+"")){
				str.append("<option selected value='" + eModeloMoto.getCodigoModeloMoto() +"'>" + eModeloMoto.getNome() + " " + eModeloMoto.getCilindrada() + "</option>");
			} else {
				str.append("<option value='" + eModeloMoto.getCodigoModeloMoto() +"'>" + eModeloMoto.getNome() + " " + eModeloMoto.getCilindrada() + "</option>");	
			}
		}
		
		str.append("</select>");
		
		return str.toString();
	}

}
