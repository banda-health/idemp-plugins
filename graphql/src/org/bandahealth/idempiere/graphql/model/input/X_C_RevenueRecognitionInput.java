package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_C_RevenueRecognition;
import org.compiere.util.Env;

/**
 * Generated Model for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RevenueRecognitionInput extends X_C_RevenueRecognition implements I_C_RevenueRecognitionInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput RecognitionFrequency_RL;

	/**
	 * Standard constructor
	 */
	public X_C_RevenueRecognitionInput(String ID) {
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
	 * Set Revenue Recognition.
	 *
	 * @param C_RevenueRecognition_ID Method for recording revenue
	 */

	public void setC_RevenueRecognition_ID(int C_RevenueRecognition_ID) {
		if (get_ID() == 0) {
			super.setC_RevenueRecognition_ID(C_RevenueRecognition_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_RevenueRecognition_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_RevenueRecognition_UU();
	}

	/**
	 * Set Recognition frequency.
	 *
	 * @param RecognitionFrequency_RL Recognition frequency
	 */
	public void setRecognitionFrequency_RL(I_AD_Ref_ListInput RecognitionFrequency_RL) {
		this.RecognitionFrequency_RL = RecognitionFrequency_RL;
		MRefList foreignEntity;
		if (RecognitionFrequency_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RecognitionFrequency_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRecognitionFrequency(foreignEntity.getValue());
		} else {
			this.setRecognitionFrequency(null);
		}
	}

	/**
	 * Get Recognition frequency.
	 *
	 * @return Recognition frequency
	 */
	public I_AD_Ref_ListInput getRecognitionFrequency_RL() {
		return RecognitionFrequency_RL;
	}
}
