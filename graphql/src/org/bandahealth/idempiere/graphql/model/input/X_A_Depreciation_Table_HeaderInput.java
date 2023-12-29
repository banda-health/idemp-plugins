package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.compiere.util.Env;

/**
 * Generated Model for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_Table_HeaderInput extends X_A_Depreciation_Table_Header implements I_A_Depreciation_Table_HeaderInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Table_Rate_Type_RL;
	 private I_AD_Ref_ListInput A_Term_RL;

	/**
	 * Standard constructor
	 */
	public X_A_Depreciation_Table_HeaderInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Depreciation_Table_Header_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Depreciation_Table_Header_UU();
	}

	/**
	 * Set Type.
	 *
	 * @param A_Table_Rate_Type_RL Type
	 */
	public void setA_Table_Rate_Type_RL(I_AD_Ref_ListInput A_Table_Rate_Type_RL) {
		this.A_Table_Rate_Type_RL = A_Table_Rate_Type_RL;
		MRefList foreignEntity;
		if (A_Table_Rate_Type_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Table_Rate_Type_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Table_Rate_Type(foreignEntity.getValue());
		} else {
			this.setA_Table_Rate_Type(null);
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
	 * Set Period/Yearly.
	 *
	 * @param A_Term_RL Period/Yearly
	 */
	public void setA_Term_RL(I_AD_Ref_ListInput A_Term_RL) {
		this.A_Term_RL = A_Term_RL;
		MRefList foreignEntity;
		if (A_Term_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Term_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Term(foreignEntity.getValue());
		} else {
			this.setA_Term(null);
		}
	}

	/**
	 * Get Period/Yearly.
	 *
	 * @return Period/Yearly
	 */
	public I_AD_Ref_ListInput getA_Term_RL() {
		return A_Term_RL;
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
