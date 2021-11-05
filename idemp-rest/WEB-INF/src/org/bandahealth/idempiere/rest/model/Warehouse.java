package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.compiere.model.MWarehouse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "warehouse")
@JsonInclude(value = Include.NON_NULL)
public class Warehouse extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private boolean defaultWarehouse;

	public Warehouse() {
	}

	public Warehouse(MWarehouse entity) {
		super(entity, entity.getName(), entity.getDescription(), entity.getValue());
	}

	public Warehouse(MWarehouse_BH entity) {
		super(entity, entity.getName(), entity.getDescription(), entity.getValue());

		setDefaultWarehouse(entity.isBH_IsDefaultWarehouse());
	}

	public boolean isDefaultWarehouse() {
		return defaultWarehouse;
	}

	public void setDefaultWarehouse(boolean defaultWarehouse) {
		this.defaultWarehouse = defaultWarehouse;
	}
}