package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Reval_Index;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Reval_Index - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Reval_IndexInput extends X_A_Asset_Reval_Index implements I_A_Asset_Reval_IndexInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Reval_Code_RL;
	 private I_AD_Ref_ListInput A_Reval_Multiplier_RL;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_Reval_IndexInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Reval_Index_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Reval_Index_UU();
	}

	/**
	 * Set Reval. Code.
	 *
	 * @param A_Reval_Code_RL Reval. Code
	 */
	public void setA_Reval_Code_RL(I_AD_Ref_ListInput A_Reval_Code_RL) {
		this.A_Reval_Code_RL = A_Reval_Code_RL;
		MRefList foreignEntity;
		if (A_Reval_Code_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Code_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Code(foreignEntity.getValue());
		} else {
			this.setA_Reval_Code(null);
		}
	}

	/**
	 * Get Reval. Code.
	 *
	 * @return Reval. Code
	 */
	public I_AD_Ref_ListInput getA_Reval_Code_RL() {
		return A_Reval_Code_RL;
	}

	/**
	 * Set Reval. Multiplier.
	 *
	 * @param A_Reval_Multiplier_RL Reval. Multiplier
	 */
	public void setA_Reval_Multiplier_RL(I_AD_Ref_ListInput A_Reval_Multiplier_RL) {
		this.A_Reval_Multiplier_RL = A_Reval_Multiplier_RL;
		MRefList foreignEntity;
		if (A_Reval_Multiplier_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Multiplier_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Multiplier(foreignEntity.getValue());
		} else {
			this.setA_Reval_Multiplier(null);
		}
	}

	/**
	 * Get Reval. Multiplier.
	 *
	 * @return Reval. Multiplier
	 */
	public I_AD_Ref_ListInput getA_Reval_Multiplier_RL() {
		return A_Reval_Multiplier_RL;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
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
}
