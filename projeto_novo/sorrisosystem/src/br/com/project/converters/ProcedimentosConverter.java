package br.com.project.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.framework.hibernate.session.HibernateUtil;
import br.com.project.model.classes.Procedimentos;


@FacesConverter(forClass = Procedimentos.class)
public class ProcedimentosConverter  implements Converter, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigo) {
		if (codigo != null && !codigo.isEmpty()){
			return (Procedimentos) HibernateUtil.getCurrentSession().get(Procedimentos.class, new Long(codigo));
		}
		return codigo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		if (objeto != null){
			Procedimentos p = (Procedimentos) objeto;
			return p.getProcedimento_id() != null && p.getProcedimento_id() > 0 ? p.getProcedimento_id().toString() : null;
		}
		return null;
	}

}
