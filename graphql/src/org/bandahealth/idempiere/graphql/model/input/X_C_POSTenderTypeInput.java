package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_C_POSTenderType;
import org.compiere.util.Env;

/**
 * Generated Model for C_POSTenderType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSTenderTypeInput extends X_C_POSTenderType implements I_C_POSTenderTypeInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput TenderType_RL;

	/**
	 * Standard constructor
	 */
	public X_C_POSTenderTypeInput(String ID) {
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
	 * Set POS Tender Type.
	 *
	 * @param C_POSTenderType_ID POS Tender Type
	 */

	public void setC_POSTenderType_ID(int C_POSTenderType_ID) {
		if (get_ID() == 0) {
			super.setC_POSTenderType_ID(C_POSTenderType_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_POSTenderType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_POSTenderType_UU();
	}

	/**
	 * Set Tender type.
	 *
	 * @param TenderType_RL Method of Payment
	 */
	public void setTenderType_RL(I_AD_Ref_ListInput TenderType_RL) {
		this.TenderType_RL = TenderType_RL;
		MRefList foreignEntity;
		if (TenderType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TenderType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTenderType(foreignEntity.getValue());
		} else {
			this.setTenderType(null);
		}
	}

	/**
	 * Get Tender type.
	 *
	 * @return Method of Payment
	 */
	public I_AD_Ref_ListInput getTenderType_RL() {
		return TenderType_RL;
	}
}
