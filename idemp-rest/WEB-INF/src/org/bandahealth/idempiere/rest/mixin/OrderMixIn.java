package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.util.Env;

import java.util.Properties;

@JsonIncludeProperties(
		value = {"businessPartnerId", "id", "created", "createdBy", "updated", "updatedBy", "isActive", "clientId",
				"organizationId", "dateOrdered", "grandTotal", "uuid", "docStatus", "isNewVisit", "visitNotes", "diagnosis",
				"chiefComplaint", "temperature", "pulse", "respiratoryRate", "bloodPressure", "height", "weight",
				"secondDiagnosis"})
public abstract class OrderMixIn extends MOrder_BH implements POMixIn {
	/**
	 * The JsonCreator must match a superclass constructor to be used instead
	 *
	 * @param ctx     Unused
	 * @param id      Pulled from JSON
	 * @param trxName Unused
	 */
	@JsonCreator
	public OrderMixIn(@JsonProperty("nonExistentCtx") Properties ctx, @JsonProperty("id") int id,
			@JsonProperty("nonExistentTrxName") String trxName) {
		super(Env.getCtx(), id, null);
	}

	@JsonProperty("businessPartnerId")
	@Override
	public abstract int getC_BPartner_ID();

	@JsonProperty("uuid")
	@Override
	public abstract String getC_Order_UU();

	@JsonProperty("isNewVisit")
	@Override
	public abstract boolean isBH_NewVisit();

	@JsonProperty("visitNotes")
	@Override
	public abstract String getbh_lab_notes();

	@JsonProperty("diagnosis")
	@Override
	public abstract String getDescription();

	@JsonProperty("chiefComplaint")
	@Override
	public abstract String getBH_Chief_Complaint();

	@JsonProperty("temperature")
	@Override
	public abstract String getBH_Temperature();

	@JsonProperty("pulse")
	@Override
	public abstract String getBH_Pulse();

	@JsonProperty("respiratoryRate")
	@Override
	public abstract String getBH_Respiratory_Rate();

	@JsonProperty("bloodPressure")
	@Override
	public abstract String getBH_Blood_Pressure();

	@JsonProperty("height")
	@Override
	public abstract String getBH_Height();

	@JsonProperty("weight")
	@Override
	public abstract String getBH_Weight();

	@JsonProperty("secondDiagnosis")
	@Override
	public abstract String getBH_SecondDiagnosis();
}
