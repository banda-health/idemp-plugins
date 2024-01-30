package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
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
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetInput extends MAttributeSet_BH implements I_M_AttributeSetInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_LotCtl;
	private ForeignEntityInput mM_SerNoCtl;
	private I_AD_Ref_ListInput mM_AttributeSet_Type;
	private I_AD_Ref_ListInput mMandatoryType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_AttributeSet_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_AttributeSetInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
	 * @return Organizational entity within client
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
	 * Set AttributeSet Type.
	 *
	 * @param M_AttributeSet_Type AttributeSet Type
	 */
	@JsonProperty("M_AttributeSet_Type")
	public void setM_AttributeSet_TypeInput(I_AD_Ref_ListInput M_AttributeSet_Type) {
		this.mM_AttributeSet_Type = M_AttributeSet_Type;
		if (M_AttributeSet_Type != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(M_AttributeSet_Type.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_AttributeSet_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + M_AttributeSet_Type.getUUID());
			}
		} else {
			this.setM_AttributeSet_Type(null);
		}
	}

	/**
	 * Get AttributeSet Type.
	 *
	 * @return AttributeSet Type
	 */
	@JsonProperty("M_AttributeSet_Type")
	public I_AD_Ref_ListInput M_AttributeSet_Type() {
		return mM_AttributeSet_Type;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_AttributeSet_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
							.setParameters(M_LotCtl.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_LotCtl_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_LotCtl with UUID " + M_LotCtl.getUUID());
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
							.setParameters(M_SerNoCtl.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_SerNoCtl_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_SerNoCtl with UUID " + M_SerNoCtl.getUUID());
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
	public void setMandatoryTypeInput(I_AD_Ref_ListInput MandatoryType) {
		this.mMandatoryType = MandatoryType;
		if (MandatoryType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MandatoryType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setMandatoryType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + MandatoryType.getUUID());
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
	public I_AD_Ref_ListInput MandatoryType() {
		return mMandatoryType;
	}
}
