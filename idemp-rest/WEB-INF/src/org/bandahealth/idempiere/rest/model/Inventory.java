package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.compiere.util.Env;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "inventory")
@JsonInclude(value = Include.NON_NULL)
public class Inventory extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private int productId;
	private int warehouseId;
	private String productName;
	private String expirationDate;
	private int quantity;
	private int shelfLife;
	private int attributeSetInstanceId;
	private String updateReasonUuid;
	private String attributeSetInstanceUuid;
	private Product product;

	public Inventory() {
	}

	public Inventory(int productId, int warehouseId, String productName, String expiration, int quantity, int shelfLife,
			int attributeSetInstanceId, int clientId, int orgId, String created, int createdBy, String description) {
		super(clientId, orgId, null, true, created, createdBy, null, description);

		this.productId = productId;
		this.warehouseId = warehouseId;
		this.productName = productName;
		this.expirationDate = expiration;
		this.quantity = quantity;
		this.shelfLife = shelfLife;
		this.attributeSetInstanceId = attributeSetInstanceId;
		this.updateReasonUuid = updateReasonUuid;
	}
	
	
	public Inventory(MInventoryLine_BH instance) {

		this.productId = instance.getM_Product_ID();
		this.warehouseId = (int) instance.getCtx().get(Env.M_WAREHOUSE_ID);
		this.productName = instance.getProduct().getName();
		this.expirationDate = instance.getBH_Expiration().toString();
		this.attributeSetInstanceId = instance.getM_AttributeSetInstance_ID();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public String getProductName() {
		return productName;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getShelfLife() {
		return shelfLife;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setShlfLife(int shlfLife) {
		this.shelfLife = shlfLife;
	}

	public int getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(int attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public String getAttributeSetInstanceUuid() {
		return attributeSetInstanceUuid;
	}

	public void setAttributeSetInstanceUuid(String attributeSetInstanceUuid) {
		this.attributeSetInstanceUuid = attributeSetInstanceUuid;
	}
	
	public void setUpdateReasonUuid(String updateReason) {
		this.updateReasonUuid = updateReason;
	}
	
	public String getUpdateReasonUuid() {
		return updateReasonUuid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}