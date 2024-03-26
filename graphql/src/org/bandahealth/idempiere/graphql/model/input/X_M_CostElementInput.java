package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCostElement;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_CostElementInput extends MCostElement implements I_M_CostElementInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mCostElementType;
	private I_AD_Ref_ListInput mCostingMethod;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_CostElement_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_CostElementInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (CostElementType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CostElementType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCostElementType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CostElementType.getUUID());
			}
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
		if (CostingMethod != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CostingMethod.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCostingMethod(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CostingMethod.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_CostElement_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_CostElement_UU();
	}
}
