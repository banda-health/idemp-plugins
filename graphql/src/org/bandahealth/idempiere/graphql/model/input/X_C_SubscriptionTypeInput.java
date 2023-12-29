package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_C_SubscriptionType;
import org.compiere.util.Env;

/**
 * Generated Model for C_SubscriptionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SubscriptionTypeInput extends X_C_SubscriptionType implements I_C_SubscriptionTypeInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput FrequencyType_RL;

	/**
	 * Standard constructor
	 */
	public X_C_SubscriptionTypeInput(String ID) {
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_SubscriptionType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_SubscriptionType_UU();
	}

	/**
	 * Set Frequency Type.
	 *
	 * @param FrequencyType_RL Frequency of event
	 */
	public void setFrequencyType_RL(I_AD_Ref_ListInput FrequencyType_RL) {
		this.FrequencyType_RL = FrequencyType_RL;
		MRefList foreignEntity;
		if (FrequencyType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FrequencyType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFrequencyType(foreignEntity.getValue());
		} else {
			this.setFrequencyType(null);
		}
	}

	/**
	 * Get Frequency Type.
	 *
	 * @return Frequency of event
	 */
	public I_AD_Ref_ListInput getFrequencyType_RL() {
		return FrequencyType_RL;
	}
}
