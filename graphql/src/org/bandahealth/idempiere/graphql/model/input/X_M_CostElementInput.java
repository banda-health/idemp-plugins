package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_M_CostElement;
import org.compiere.util.Env;

/**
 * Generated Model for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostElementInput extends X_M_CostElement implements I_M_CostElementInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CostElementType_RL;
	 private I_AD_Ref_ListInput CostingMethod_RL;

	/**
	 * Standard constructor
	 */
	public X_M_CostElementInput(String ID) {
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
	 * Set Cost Element Type.
	 *
	 * @param CostElementType_RL Type of Cost Element
	 */
	public void setCostElementType_RL(I_AD_Ref_ListInput CostElementType_RL) {
		this.CostElementType_RL = CostElementType_RL;
		MRefList foreignEntity;
		if (CostElementType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostElementType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCostElementType(foreignEntity.getValue());
		} else {
			this.setCostElementType(null);
		}
	}

	/**
	 * Get Cost Element Type.
	 *
	 * @return Type of Cost Element
	 */
	public I_AD_Ref_ListInput getCostElementType_RL() {
		return CostElementType_RL;
	}

	/**
	 * Set Costing Method.
	 *
	 * @param CostingMethod_RL Indicates how Costs will be calculated
	 */
	public void setCostingMethod_RL(I_AD_Ref_ListInput CostingMethod_RL) {
		this.CostingMethod_RL = CostingMethod_RL;
		MRefList foreignEntity;
		if (CostingMethod_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostingMethod_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCostingMethod(foreignEntity.getValue());
		} else {
			this.setCostingMethod(null);
		}
	}

	/**
	 * Get Costing Method.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	public I_AD_Ref_ListInput getCostingMethod_RL() {
		return CostingMethod_RL;
	}
	/**
	 * Set Cost Element.
	 *
	 * @param M_CostElement_ID Product Cost Element
	 */

	public void setM_CostElement_ID(int M_CostElement_ID) {
		if (get_ID() == 0) {
			super.setM_CostElement_ID(M_CostElement_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_CostElement_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_CostElement_UU();
	}
}
