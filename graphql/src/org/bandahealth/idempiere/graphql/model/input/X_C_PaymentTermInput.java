package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_C_PaymentTerm;
import org.compiere.util.Env;

/**
 * Generated Model for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentTermInput extends X_C_PaymentTerm implements I_C_PaymentTermInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput NetDay_RL;
	 private I_AD_Ref_ListInput PaymentTermUsage_RL;

	/**
	 * Standard constructor
	 */
	public X_C_PaymentTermInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}
	/**
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm_ID The terms of Payment (timing, discount)
	 */

	public void setC_PaymentTerm_ID(int C_PaymentTerm_ID) {
		if (get_ID() == 0) {
			super.setC_PaymentTerm_ID(C_PaymentTerm_ID);
		}
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
	 * @param NetDay_RL Day when payment is due net
	 */
	public void setNetDay_RL(I_AD_Ref_ListInput NetDay_RL) {
		this.NetDay_RL = NetDay_RL;
		MRefList foreignEntity;
		if (NetDay_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(NetDay_RL.getID())
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
	public I_AD_Ref_ListInput getNetDay_RL() {
		return NetDay_RL;
	}

	/**
	 * Set Payment Term Usage.
	 *
	 * @param PaymentTermUsage_RL Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	public void setPaymentTermUsage_RL(I_AD_Ref_ListInput PaymentTermUsage_RL) {
		this.PaymentTermUsage_RL = PaymentTermUsage_RL;
		MRefList foreignEntity;
		if (PaymentTermUsage_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PaymentTermUsage_RL.getID())
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
	public I_AD_Ref_ListInput getPaymentTermUsage_RL() {
		return PaymentTermUsage_RL;
	}
}
