package br.com.project.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.framework.hibernate.session.HibernateUtil;
import br.com.project.model.classes.Agendamentos;
import br.com.project.model.classes.Clientes;


@FacesConverter(forClass = Agendamentos.class)
public class AgendamentoConverter  implements Converter, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigo) {
		if (codigo != null && !codigo.isEmpty()){
			return (Agendamentos) HibernateUtil.getCurrentSession().get(Agendamentos.class, new Long(codigo));
		}
		return codigo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		if (objeto != null){
			Agendamentos a = (Agendamentos) objeto;
			return a.getAgendamento_id() != null && a.getAgendamento_id() > 0 ? a.getAgendamento_id().toString() : null;
		}
		return null;
	}

}
