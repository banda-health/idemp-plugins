package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.compiere.model.MWarehouse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "storeroom")
@JsonInclude(value = Include.NON_NULL)
public class Storeroom extends BaseEntity {

	public Storeroom() {
	}

	public Storeroom(MWarehouse entity) {
		super(entity, entity.getName(), entity.getDescription(), entity.getValue());
	}
}
