package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attributeSetInstance")
@JsonInclude(value = Include.NON_NULL)
public class AttributeSetInstance extends BaseMetadata {
	
	private static final long serialVersionUID = 1L;
	
	private Timestamp guaranteeDate;
	private ReferenceList updateReason;
	private String serialNumber;
	private String lot;
	@JsonIgnore
	private Integer attributeSetId;
	private AttributeSet attributeSet;
	private BigDecimal purchasePrice;
	private Timestamp purchaseDate;

	/**
	 * Empty constructor needed for deserialization
	 */
	public AttributeSetInstance() {}

	public AttributeSetInstance(MAttributeSetInstance_BH model) {
		super(model);
		setGuaranteeDate(model.getGuaranteeDate());
		this.serialNumber = model.getSerNo();
		this.lot = model.getLot();
	}

	@XmlElement
	public Timestamp getGuaranteeDate() {
		return guaranteeDate;
	}

	@XmlElement
	public ReferenceList getUpdateReason() {
		return updateReason;
	}
	
	public void setGuaranteeDate(Timestamp guaranteeDate) {
		this.guaranteeDate = guaranteeDate;
	}
	
	public void setUpdateReason(ReferenceList updateReason) {
		this.updateReason = updateReason;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public AttributeSet getAttributeSet() {
		return attributeSet;
	}

	public void setAttributeSet(AttributeSet attributeSet) {
		this.attributeSet = attributeSet;
	}

	public Integer getAttributeSetId() {
		return attributeSetId;
	}

	public void setAttributeSetId(Integer attributeSetId) {
		this.attributeSetId = attributeSetId;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
