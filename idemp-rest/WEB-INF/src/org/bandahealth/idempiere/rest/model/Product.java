package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MProduct_BH;

@XmlRootElement(name = "product")
@JsonInclude(value = Include.NON_NULL)
public class Product extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Boolean isStocked;
	private Integer reorderLevel;
	private Integer reorderQuantity;
	private BigDecimal buyPrice;
	private BigDecimal sellPrice;
	private String type;
	private String productCategoryUuid;
	private BigDecimal totalQuantity;
	private BigDecimal defaultStockLevel;
	private List<StorageOnHand> storageOnHandList = new ArrayList<>();
	@JsonIgnore
	private Integer attributeSetId;
	private AttributeSet attributeSet;

	public Product() {
	}

	public Product(MProduct_BH entity) {
		super(entity, entity.getName(), entity.getDescription(), entity.getValue());

		setIsStocked(entity.isStocked());
		setReorderLevel(entity.getbh_reorder_level());
		setReorderQuantity(entity.getbh_reorder_quantity());
		setSellPrice(entity.getBH_SellPrice());
		setType(entity.getProductType());
		setAttributeSetId(entity.getM_AttributeSet_ID());
	}

	public Product(String name, String uuid, MProduct_BH entity) {
		this.setName(name);
		this.setUuid(uuid);
		this.sellPrice = entity.getBH_SellPrice();

		setAttributeSetId(entity.getM_AttributeSet_ID());
		setId(entity.get_ID());
		setType(entity.getProductType());
		setIsStocked(entity.isStocked());
	}

	public Product(int clientId, int orgId, String uuid, Boolean isActive, String created, int createdBy, String name,
			String description, String value, BigDecimal sellPrice, Integer reorderLevel, Integer reorderQuantity,
			String productCategoryUuid, MProduct_BH entity) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		setValue(value);
		this.sellPrice = sellPrice;
		this.reorderLevel = reorderLevel;
		this.reorderQuantity = reorderQuantity;
		setProductCategoryUuid(productCategoryUuid);
		setAttributeSetId(entity.getM_AttributeSet_ID());
		setId(entity.get_ID());
		setType(entity.getProductType());
		setIsStocked(entity.isStocked());
	}

	public Product(int clientId, int orgId, String uuid, Boolean isActive, String created, int createdBy, String name,
			String description, BigDecimal sellPrice, MProduct_BH entity) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.sellPrice = sellPrice;
		setAttributeSetId(entity.getM_AttributeSet_ID());
		setId(entity.get_ID());
		setType(entity.getProductType());
		setIsStocked(entity.isStocked());
	}

	public Product(String uuid, String name, String created, BigDecimal sellPrice, Boolean isActive,
			MProduct_BH entity) {
		setUuid(uuid);
		setName(name);
		setCreated(created);
		setIsActive(isActive);

		this.sellPrice = sellPrice;
		setAttributeSetId(entity.getM_AttributeSet_ID());
		setId(entity.get_ID());
		setType(entity.getProductType());
		setIsStocked(entity.isStocked());
	}

	@XmlElement
	public Boolean getIsStocked() {
		return isStocked;
	}

	public void setIsStocked(Boolean isStocked) {
		this.isStocked = isStocked;
	}

	@XmlElement
	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	@XmlElement
	public Integer getReorderQuantity() {
		return reorderQuantity;
	}

	public void setReorderQuantity(Integer reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}

	@XmlElement
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	@XmlElement
	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProductCategoryUuid() {
		return productCategoryUuid;
	}

	public void setProductCategoryUuid(String productCategoryUuid) {
		this.productCategoryUuid = productCategoryUuid;
	}

	public BigDecimal getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(BigDecimal totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	@XmlElement
	public BigDecimal getDefaultStockLevel() {
		return defaultStockLevel;
	}

	public void setDefaultStockLevel(BigDecimal defaultStockLevel) {
		this.defaultStockLevel = defaultStockLevel;
	}

	public List<StorageOnHand> getStorageOnHandList() {
		return storageOnHandList;
	}

	public void setStorageOnHandList(List<StorageOnHand> storageOnHandList) {
		this.storageOnHandList = storageOnHandList;
	}

	public Integer getAttributeSetId() {
		return attributeSetId;
	}

	public void setAttributeSetId(Integer attributeSetId) {
		this.attributeSetId = attributeSetId;
	}

	public AttributeSet getAttributeSet() {
		return attributeSet;
	}

	public void setAttributeSet(AttributeSet attributeSet) {
		this.attributeSet = attributeSet;
	}
}