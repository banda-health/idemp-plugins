package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "warehouse")
public class Warehouse extends BaseObject {

	private static final long serialVersionUID = 1L;

	public Warehouse(int id, String name) {
		super(id, name);
	}
}
