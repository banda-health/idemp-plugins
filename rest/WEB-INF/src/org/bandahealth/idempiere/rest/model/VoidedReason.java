package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.base.model.MBHVoidedReason;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "voidedReason")
@JsonInclude(value = Include.NON_NULL)
public class VoidedReason extends BaseEntity {

	private static final long serialVersionUID = -7966806468293136098L;

	private int lineNo;

	public VoidedReason() {
	}

	public VoidedReason(MBHVoidedReason entity) {
		setName(entity.getName());
		setUuid(entity.getbh_voided_reason_uu());
		setDescription(entity.getDescription());
		setIsActive(entity.isActive());
		setLineNo(entity.getLineNo());
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
}
