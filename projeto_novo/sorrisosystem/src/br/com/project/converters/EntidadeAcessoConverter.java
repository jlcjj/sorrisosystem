package br.com.project.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.framework.hibernate.session.HibernateUtil;
import br.com.project.model.classes.EntidadeAcesso;




@FacesConverter(forClass = EntidadeAcesso.class)
public class EntidadeAcessoConverter  implements Converter, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigo) {
		if (codigo != null && !codigo.isEmpty()){
			return (EntidadeAcesso) HibernateUtil.getCurrentSession().get(EntidadeAcesso.class, new Long(codigo));
		}
		return codigo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		if (objeto != null){
			EntidadeAcesso ea = (EntidadeAcesso) objeto;
			return ea.getEnt_acesso_id() != null && ea.getEnt_acesso_id() > 0 ? ea.getEnt_acesso_id().toString() : null;
		}
		return null;
	}

}
