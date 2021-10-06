package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.compiere.model.MWarehouse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "warehouse")
@JsonInclude(value = Include.NON_NULL)
public class Warehouse extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer warehouseId;

	public Warehouse(int id, String name) {
		setId(id);
		setName(name);
	}

	public Warehouse(MWarehouse entity) {
		super(entity, entity.getName(), entity.getDescription(), entity.getValue());

		this.setWarehouseId(entity.get_ID()); // PS: id fields are ignored in BaseMetadata.
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

}
