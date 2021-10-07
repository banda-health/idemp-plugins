package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "warehouse")
@JsonInclude(value = Include.NON_NULL)
public class Warehouse extends BaseObject {

	private static final long serialVersionUID = 1L;

	public Warehouse(int id, String name) {
		super(id, name);
	}
}