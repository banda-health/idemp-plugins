package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Table_Detail;
import org.compiere.util.Env;

/**
 * Generated Model for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_Table_DetailInput extends X_A_Depreciation_Table_Detail implements I_A_Depreciation_Table_DetailInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Table_Rate_Type_RL;

	/**
	 * Standard constructor
	 */
	public X_A_Depreciation_Table_DetailInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}
	/**
	 * Set Depreciation Code.
	 *
	 * @param A_Depreciation_Table_Code Depreciation Code
	 */
	public void setA_Depreciation_Table_Code(String A_Depreciation_Table_Code) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Table_Code(A_Depreciation_Table_Code);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Depreciation_Table_Detail_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Depreciation_Table_Detail_UU();
	}

	/**
	 * Set Type.
	 *
	 * @param A_Table_Rate_Type_RL Type
	 */
	public void setA_Table_Rate_Type_RL(I_AD_Ref_ListInput A_Table_Rate_Type_RL) {
		this.A_Table_Rate_Type_RL = A_Table_Rate_Type_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&A_Table_Rate_Type_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Table_Rate_Type_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Table_Rate_Type(foreignEntity.getValue());
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Type
	 */
	public I_AD_Ref_ListInput getA_Table_Rate_Type_RL() {
		return A_Table_Rate_Type_RL;
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
}
