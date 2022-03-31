package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MInventory_BH;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends BaseEntity {

	private Warehouse warehouse;
	private ReferenceList updateReason;
	private List<InventoryLine> inventoryLines = new ArrayList<>();
	private String documentStatus;

	/**
	 * Empty constructor needed for Jackson deserialization
	 */
	public Inventory() {}

	public Inventory(MInventory_BH model) {
		super(model, null, model.getDescription(), null);
		setDocumentStatus(model.getDocStatus());
	}

	public void setUpdateReason(ReferenceList updateReason) {
		this.updateReason = updateReason;
	}

	public ReferenceList getUpdateReason() {
		return updateReason;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setInventoryLines(List<InventoryLine> inventoryLines) {
		this.inventoryLines = inventoryLines;
	}

	public List<InventoryLine> getInventoryLines() {
		return inventoryLines;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}
}
