package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.compiere.model.MWarehouse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "warehouse")
@JsonInclude(value = Include.NON_NULL)
public class Warehouse extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	public Warehouse() {
	}

	public Warehouse(MWarehouse entity) {
		super(entity, entity.getName(), entity.getDescription(), entity.getValue());
	}
}