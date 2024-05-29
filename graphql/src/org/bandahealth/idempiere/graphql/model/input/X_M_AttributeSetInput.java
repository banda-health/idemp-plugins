package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_M_AttributeSetResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLotCtl;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_AttributeSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeSetInput extends MAttributeSet_BH implements I_M_AttributeSetInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSet_Type;
	private ForeignEntityInput mM_LotCtl;
	private ForeignEntityInput mM_SerNoCtl;
	private ForeignEntityInput mMandatoryType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_AttributeSet_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_AttributeSetInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
	 * Set Attribute Set.
	 *
	 * @param M_AttributeSet_ID Product Attribute Set
	 */

	public void setM_AttributeSet_ID(int M_AttributeSet_ID) {
		if (get_ID() == 0) {
			super.setM_AttributeSet_ID(M_AttributeSet_ID);
		}
	}

	/**
	 * Set Attribute Set Type.
	 *
	 * @param M_AttributeSet_Type Attribute Set Type
	 */
	@JsonProperty("M_AttributeSet_Type")
	public void setM_AttributeSet_TypeInput(ForeignEntityInput M_AttributeSet_Type) {
		this.mM_AttributeSet_Type = M_AttributeSet_Type;
		if (M_AttributeSet_Type != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_AttributeSetResolver.M_ATTRIBUTESET_TYPE_UUIDS_BY_VALUE.containsValue(M_AttributeSet_Type.getUU())) {
				throw new AdempiereException("The reference list UU of " + M_AttributeSet_Type.getUU() +
						" is not in the list defined for the M_AttributeSet_Type column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(M_AttributeSet_Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_AttributeSet_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + M_AttributeSet_Type.getUU());
			}
		} else {
			this.setM_AttributeSet_Type(null);
		}
	}

	/**
	 * Get Attribute Set Type.
	 *
	 * @return Attribute Set Type
	 */
	@JsonProperty("M_AttributeSet_Type")
	public ForeignEntityInput M_AttributeSet_Type() {
		return mM_AttributeSet_Type;
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_AttributeSet_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_AttributeSet_UU();
	}

	/**
	 * Set Lot Control.
	 *
	 * @param M_LotCtl Product Lot Control
	 */
	@JsonProperty("M_LotCtl")
	public void setM_LotCtlInput(ForeignEntityInput M_LotCtl) {
		this.mM_LotCtl = M_LotCtl;
		if (M_LotCtl != null) {
			// Since an entity was passed, make sure it's in the DB
			MLotCtl foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_LotCtl", "M_LotCtl_UU=?", get_TrxName())
							.setParameters(M_LotCtl.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_LotCtl_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_LotCtl with UU " + M_LotCtl.getUU());
			}
		} else {
			this.setM_LotCtl_ID(0);
		}
	}

	/**
	 * Get Lot Control.
	 *
	 * @return Product Lot Control
	 */
	@JsonProperty("M_LotCtl")
	public ForeignEntityInput M_LotCtl() {
		return mM_LotCtl;
	}

	/**
	 * Set Serial No Control.
	 *
	 * @param M_SerNoCtl Product Serial Number Control
	 */
	@JsonProperty("M_SerNoCtl")
	public void setM_SerNoCtlInput(ForeignEntityInput M_SerNoCtl) {
		this.mM_SerNoCtl = M_SerNoCtl;
		if (M_SerNoCtl != null) {
			// Since an entity was passed, make sure it's in the DB
			MSerNoCtl_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_SerNoCtl", "M_SerNoCtl_UU=?", get_TrxName())
							.setParameters(M_SerNoCtl.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_SerNoCtl_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_SerNoCtl with UU " + M_SerNoCtl.getUU());
			}
		} else {
			this.setM_SerNoCtl_ID(0);
		}
	}

	/**
	 * Get Serial No Control.
	 *
	 * @return Product Serial Number Control
	 */
	@JsonProperty("M_SerNoCtl")
	public ForeignEntityInput M_SerNoCtl() {
		return mM_SerNoCtl;
	}

	/**
	 * Set Mandatory Type.
	 *
	 * @param MandatoryType The specification of a Product Attribute Instance is mandatory
	 */
	@JsonProperty("MandatoryType")
	public void setMandatoryTypeInput(ForeignEntityInput MandatoryType) {
		this.mMandatoryType = MandatoryType;
		if (MandatoryType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_AttributeSetResolver.MANDATORYTYPE_UUIDS_BY_VALUE.containsValue(MandatoryType.getUU())) {
				throw new AdempiereException("The reference list UU of " + MandatoryType.getUU() +
						" is not in the list defined for the MandatoryType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MandatoryType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setMandatoryType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + MandatoryType.getUU());
			}
		} else {
			this.setMandatoryType(null);
		}
	}

	/**
	 * Get Mandatory Type.
	 *
	 * @return The specification of a Product Attribute Instance is mandatory
	 */
	@JsonProperty("MandatoryType")
	public ForeignEntityInput MandatoryType() {
		return mMandatoryType;
	}
}
