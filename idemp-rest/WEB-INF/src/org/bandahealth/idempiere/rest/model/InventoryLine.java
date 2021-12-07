package org.bandahealth.idempiere.rest.model;


import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement(name = "inventoryLine")
@JsonInclude(value = Include.NON_NULL)
public class InventoryLine extends BaseEntity{

	private static final long serialVersionUID = 1L;
	

}
