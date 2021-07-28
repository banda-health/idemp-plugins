package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client")
public class Client extends BaseObject {

	private static final long serialVersionUID = 1L;

	private List<Org> orgs = new ArrayList<>();

	public Client(int id, String name) {
		super(id, name);
	}

	@XmlElement
	public List<Org> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<Org> orgs) {
		this.orgs = orgs;
	}
}
