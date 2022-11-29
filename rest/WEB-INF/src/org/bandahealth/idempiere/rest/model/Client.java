package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MClient_BH;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client")
public class Client extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private List<Org> orgs = new ArrayList<>();

	public Client(int id, String name) {
		setName(name);
		setId(id);
	}

	public Client(MClient_BH model) {
		super(model, model.getName(), null, null);
	}

	@XmlElement
	public List<Org> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<Org> orgs) {
		this.orgs = orgs;
	}
}
