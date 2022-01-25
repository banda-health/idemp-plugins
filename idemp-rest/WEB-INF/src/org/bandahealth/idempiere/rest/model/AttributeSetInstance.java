package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attributeSetInstance")
@JsonInclude(value = Include.NON_NULL)
public class AttributeSetInstance extends BaseMetadata {
	
	private static final long serialVersionUID = 1L;
	
	private Timestamp guaranteeDate;
	private ReferenceList updateReason;

	private Integer attributeSetInstanceId;

	/**
	 * Empty constructor needed for deserialization
	 */
	public AttributeSetInstance() {}

	public AttributeSetInstance(MAttributeSetInstance_BH model) {
		super(model);
		setGuaranteeDate(model.getGuaranteeDate());
	}

	@XmlElement
	public Timestamp getGuaranteeDate() {
		return guaranteeDate;
	}

	@XmlElement
	public ReferenceList getUpdateReason() {
		return updateReason;
	}
	
	@XmlElement
	public Integer getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}
	
	public void setGuaranteeDate(Timestamp guaranteeDate) {
		this.guaranteeDate = guaranteeDate;
	}
	
	public void setUpdateReason(ReferenceList updateReason) {
		this.updateReason = updateReason;
	}
	
	public void setAttributeSetId(Integer attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}
}
