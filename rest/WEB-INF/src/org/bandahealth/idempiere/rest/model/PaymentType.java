package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.compiere.model.MRefList;

@XmlRootElement(name = "paymentType")
@JsonInclude(value = Include.NON_NULL)
public class PaymentType extends ReferenceList {

	private static final long serialVersionUID = 1L;

	public PaymentType() {
	}

	public PaymentType(MRefList entity) {
		super(entity);
	}
}
