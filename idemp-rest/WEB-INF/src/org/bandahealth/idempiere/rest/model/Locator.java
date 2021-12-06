package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MLocator;

public class Locator extends BaseMetadata {
	private String value;
	@JsonIgnore
	private int warehouseId;
	private Warehouse warehouse;
	@JsonProperty("isDefault")
	private boolean isDefault;

	/**
	 * Empty constructor needed for deserialization
	 */
	public Locator() {
	}

	public Locator(MLocator model) {
		super(model);

		this.value = model.getValue();
		this.isDefault = model.isDefault();
		this.warehouseId = model.getM_Warehouse_ID();
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean aDefault) {
		isDefault = aDefault;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
}
