package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MRefList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "processStage")
@JsonInclude(value = Include.NON_NULL)
public class ProcessStage extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public ProcessStage() {
	}

	public ProcessStage(String value) {
		setValue(value);
	}

	public ProcessStage(MRefList instance) {
		super(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
				instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
				instance.getCreatedBy(), instance.getName(), instance.getDescription());
		
		setValue(instance.getValue());
	}
}
