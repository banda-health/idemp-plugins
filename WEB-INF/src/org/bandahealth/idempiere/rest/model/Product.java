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
	private Boolean isStocked;
	private Integer reorderLevel;
	private Integer reorderQuantity;
	private BigDecimal buyPrice;
	private BigDecimal sellPrice;
	private String type;
	private Boolean hasExpiration;

	public Product() {
	}

	public Product(String name, String uuid, String type) {
		this.setName(name);
		this.setUuid(uuid);

		this.type = type;
	}

	public Product(int clientId, int orgId, String uuid, Boolean isActive, String created, int createdBy, String name,
			String description, String value, Boolean isStocked, BigDecimal buyPrice, BigDecimal sellPrice, String type,
			Integer reorderLevel, Integer reorderQuantity, Boolean hasExpiration) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.value = value;
		this.isStocked = isStocked;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.type = type;
		this.reorderLevel = reorderLevel;
		this.reorderQuantity = reorderQuantity;
		this.hasExpiration = hasExpiration;
	}

	public Product(int clientId, int orgId, String uuid, Boolean isActive, String created, int createdBy, String name,
			String description, BigDecimal buyPrice, BigDecimal sellPrice) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}

	public Product(String uuid, String name, BigDecimal buyPrice, Boolean hasExpiration, String created,
			BigDecimal sellPrice) {
		setUuid(uuid);
		setName(name);
		setCreated(created);

		this.buyPrice = buyPrice;
		this.hasExpiration = hasExpiration;
		this.sellPrice = sellPrice;
	}

	@XmlElement
	public String getValue() {
		return value;
	}

	@XmlElement
	public Boolean getIsStocked() {
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
	public String getType() {
		return type;
	}

	public void setIsStocked(Boolean isStocked) {
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

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement
	public Boolean isHasExpiration() {
		return hasExpiration;
	}

	public void setHasExpiration(Boolean hasExpiration) {
		this.hasExpiration = hasExpiration;
	}
}