package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bandahealth.idempiere.base.model.MBHOrderLineChargeInfo;

public class OrderLineChargeInformation extends BaseEntity {
	@JsonIgnore
	private int orderLineId;
	@JsonIgnore
	private int chargeInformationId;
	private String chargeInformationUuid;

	/**
	 * Empty constructor needed for deserialization
	 */
	public OrderLineChargeInformation() {}

	public OrderLineChargeInformation(MBHOrderLineChargeInfo entity) {
		super(entity, entity.getName(), entity.getDescription(), null);

		setOrderLineId(entity.getC_OrderLine_ID());
		setChargeInformationId(entity.getBH_Charge_Info_ID());
	}

	public int getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(int orderLineId) {
		this.orderLineId = orderLineId;
	}

	public int getChargeInformationId() {
		return chargeInformationId;
	}

	public void setChargeInformationId(int chargeInformationId) {
		this.chargeInformationId = chargeInformationId;
	}

	public String getChargeInformationUuid() {
		return chargeInformationUuid;
	}

	public void setChargeInformationUuid(String chargeInformationUuid) {
		this.chargeInformationUuid = chargeInformationUuid;
	}
}
