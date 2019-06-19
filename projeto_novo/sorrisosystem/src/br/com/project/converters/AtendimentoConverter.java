package br.com.project.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.framework.hibernate.session.HibernateUtil;
import br.com.project.model.classes.Agendamentos;
import br.com.project.model.classes.Atendimento;


@FacesConverter(forClass = Atendimento.class)
public class AtendimentoConverter  implements Converter, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigo) {
		if (codigo != null && !codigo.isEmpty()){
			return (Atendimento) HibernateUtil.getCurrentSession().get(Agendamentos.class, new Long(codigo));
		}
		return codigo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		if (objeto != null){
			Atendimento a = (Atendimento) objeto;
			return a.getAtendimento_id() != null && a.getAtendimento_id() > 0 ? a.getAtendimento_id().toString() : null;
		}
		return null;
	}

}
