package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "product")
@JsonInclude(value = Include.NON_NULL)
public class Product extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String value;
	private boolean isStocked;
	private Integer reorderLevel;
	private Integer reorderQuantity;
	private BigDecimal buyPrice;
	private BigDecimal sellPrice;
	private String productType;

	public Product() {
	}

	public Product(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
			String description, String value, boolean isStocked, BigDecimal buyPrice, BigDecimal sellPrice,
			String productType, Integer reorderLevel, Integer reorderQuantity) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.value = value;
		this.isStocked = isStocked;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.productType = productType;
		this.reorderLevel = reorderLevel;
		this.reorderQuantity = reorderQuantity;
	}

	public Product(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
			String description) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);
	}

	@XmlElement
	public String getValue() {
		return value;
	}

	@XmlElement
	public boolean getIsStocked() {
		return isStocked;
	}

	@XmlElement
	public Integer getReorderLevel() {
		return reorderLevel;
	}

	@XmlElement
	public Integer getReorderQuantity() {
		return reorderQuantity;
	}

	@XmlElement
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	@XmlElement
	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	@XmlElement
	public String getProductType() {
		return productType;
	}

	public void setIsStocked(boolean isStocked) {
		this.isStocked = isStocked;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public void setReorderQuantity(Integer reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}