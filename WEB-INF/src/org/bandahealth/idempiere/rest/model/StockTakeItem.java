package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "stockTakeItem")
@JsonInclude(value = Include.NON_NULL)
public class StockTakeItem extends BaseEntity{

	private static final long serialVersionUID = 1L;
	

	public StockTakeItem() {}
	
	public StockTakeItem(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String description, String name) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);
	}
}