package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCostElement;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostElementInput extends MCostElement implements I_M_CostElementInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mCostElementType;
	private I_AD_Ref_ListInput mCostingMethod;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_CostElementInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MCostElement(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
	 * Set Cost Element Type.
	 *
	 * @param CostElementType Type of Cost Element
	 */
	@JsonProperty("CostElementType")
	public void setCostElementTypeInput(I_AD_Ref_ListInput CostElementType) {
		this.mCostElementType = CostElementType;
		MRefList_BH foreignEntity;
		if (CostElementType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostElementType.getID())
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
	@JsonProperty("CostElementType")
	public I_AD_Ref_ListInput CostElementType() {
		return mCostElementType;
	}

	/**
	 * Set Costing Method.
	 *
	 * @param CostingMethod Indicates how Costs will be calculated
	 */
	@JsonProperty("CostingMethod")
	public void setCostingMethodInput(I_AD_Ref_ListInput CostingMethod) {
		this.mCostingMethod = CostingMethod;
		MRefList_BH foreignEntity;
		if (CostingMethod != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostingMethod.getID())
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
	@JsonProperty("CostingMethod")
	public I_AD_Ref_ListInput CostingMethod() {
		return mCostingMethod;
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
