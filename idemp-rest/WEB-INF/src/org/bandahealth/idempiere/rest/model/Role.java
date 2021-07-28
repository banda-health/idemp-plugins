package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "role")
public class Role extends BaseObject {

	private static final long serialVersionUID = 1L;

	public Role(int id, String name) {
		super(id, name);
	}
}
