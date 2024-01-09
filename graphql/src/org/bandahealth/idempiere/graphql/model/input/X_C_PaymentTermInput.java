package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentTermInput extends MPaymentTerm implements I_C_PaymentTermInput {

	 private ForeignEntityInput mAD_Org;
	 private I_AD_Ref_ListInput mNetDay;
	 private I_AD_Ref_ListInput mPaymentTermUsage;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_PaymentTermInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_PaymentTerm_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_PaymentTerm_UU();
	}

	/**
	 * Set Net Day.
	 *
	 * @param NetDay Day when payment is due net
	 */
	@JsonProperty("NetDay")
	public void setNetDayInput(I_AD_Ref_ListInput NetDay) {
		this.mNetDay = NetDay;
		MRefList_BH foreignEntity;
		if (NetDay != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(NetDay.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setNetDay(foreignEntity.getValue());
		} else {
			this.setNetDay(null);
		}
	}

	/**
	 * Get Net Day.
	 *
	 * @return Day when payment is due net
	 */
	@JsonProperty("NetDay")
	public I_AD_Ref_ListInput NetDay() {
		return mNetDay;
	}

	/**
	 * Set Payment Term Usage.
	 *
	 * @param PaymentTermUsage Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	@JsonProperty("PaymentTermUsage")
	public void setPaymentTermUsageInput(I_AD_Ref_ListInput PaymentTermUsage) {
		this.mPaymentTermUsage = PaymentTermUsage;
		MRefList_BH foreignEntity;
		if (PaymentTermUsage != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PaymentTermUsage.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPaymentTermUsage(foreignEntity.getValue());
		} else {
			this.setPaymentTermUsage(null);
		}
	}

	/**
	 * Get Payment Term Usage.
	 *
	 * @return Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	@JsonProperty("PaymentTermUsage")
	public I_AD_Ref_ListInput PaymentTermUsage() {
		return mPaymentTermUsage;
	}
}
