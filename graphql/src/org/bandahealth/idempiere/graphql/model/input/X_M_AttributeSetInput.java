package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLotCtl;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_AttributeSetInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAttributeSet_BH(null, (ResultSet) null, null), null, Table_Name, ID),
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
		MRefList_BH foreignEntity;
		if (M_AttributeSet_Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSet_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSet_Type(foreignEntity.getValue());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_AttributeSet_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MLotCtl foreignEntity;
		if (M_LotCtl != null &&
				(foreignEntity = new Query(getCtx(), "M_LotCtl", "M_LotCtl_UU=?", get_TrxName())
						.setParameters(M_LotCtl.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_LotCtl_ID(foreignEntity.get_ID());
		} else {
			super.setM_LotCtl_ID(0);
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
		MSerNoCtl_BH foreignEntity;
		if (M_SerNoCtl != null &&
				(foreignEntity = new Query(getCtx(), "M_SerNoCtl", "M_SerNoCtl_UU=?", get_TrxName())
						.setParameters(M_SerNoCtl.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_SerNoCtl_ID(foreignEntity.get_ID());
		} else {
			super.setM_SerNoCtl_ID(0);
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
		MRefList_BH foreignEntity;
		if (MandatoryType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MandatoryType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMandatoryType(foreignEntity.getValue());
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
