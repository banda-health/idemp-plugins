package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLotCtl;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_M_AttributeSet;
import org.compiere.util.Env;

/**
 * Generated Model for M_AttributeSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetInput extends X_M_AttributeSet implements I_M_AttributeSetInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput M_AttributeSet_Type_RL;
	 private I_AD_Ref_ListInput MandatoryType_RL;
	 private I_M_LotCtlInput M_LotCtl;
	 private I_M_SerNoCtlInput M_SerNoCtl;

	/**
	 * Standard constructor
	 */
	public X_M_AttributeSetInput(String ID) {
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
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public void setBH_Locked(boolean BH_Locked) {
		set_Value(COLUMNNAME_BH_Locked, BH_Locked);
	}


	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public boolean isBH_Locked() {
 		Object columnValue = get_Value(COLUMNNAME_BH_Locked);
		if (columnValue != null) {
			if (columnValue instanceof Boolean) {
				return ((Boolean) columnValue);
			}
			return "Y".equals(columnValue);
		}
		return false;
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
	 * @param M_AttributeSet_Type_RL AttributeSet Type
	 */
	public void setM_AttributeSet_Type_RL(I_AD_Ref_ListInput M_AttributeSet_Type_RL) {
		this.M_AttributeSet_Type_RL = M_AttributeSet_Type_RL;
		MRefList foreignEntity;
		if (M_AttributeSet_Type_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSet_Type_RL.getID())
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
	public I_AD_Ref_ListInput getM_AttributeSet_Type_RL() {
		return M_AttributeSet_Type_RL;
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
	public void setM_LotCtl(I_M_LotCtlInput M_LotCtl) {
		this.M_LotCtl = M_LotCtl;
		MLotCtl foreignEntity;
		if (M_LotCtl != null &&
				(foreignEntity = new Query(getCtx(), MLotCtl.Table_Name, MLotCtl.COLUMNNAME_M_LotCtl_UU + "=?", get_TrxName())
						.setParameters(M_LotCtl.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_LotCtl_ID(foreignEntity.get_ID());
		} else {
			this.setM_LotCtl_ID(0);
		}
	}

	/**
	 * Get Lot Control.
	 *
	 * @return Product Lot Control
	 */
	public I_M_LotCtlInput getM_LotCtl() {
		return M_LotCtl;
	}

	/**
	 * Set Serial No Control.
	 *
	 * @param M_SerNoCtl Product Serial Number Control
	 */
	public void setM_SerNoCtl(I_M_SerNoCtlInput M_SerNoCtl) {
		this.M_SerNoCtl = M_SerNoCtl;
		MSerNoCtl_BH foreignEntity;
		if (M_SerNoCtl != null &&
				(foreignEntity = new Query(getCtx(), MSerNoCtl_BH.Table_Name, MSerNoCtl_BH.COLUMNNAME_M_SerNoCtl_UU + "=?", get_TrxName())
						.setParameters(M_SerNoCtl.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_SerNoCtl_ID(foreignEntity.get_ID());
		} else {
			this.setM_SerNoCtl_ID(0);
		}
	}

	/**
	 * Get Serial No Control.
	 *
	 * @return Product Serial Number Control
	 */
	public I_M_SerNoCtlInput getM_SerNoCtl() {
		return M_SerNoCtl;
	}

	/**
	 * Set Mandatory Type.
	 *
	 * @param MandatoryType_RL The specification of a Product Attribute Instance is mandatory
	 */
	public void setMandatoryType_RL(I_AD_Ref_ListInput MandatoryType_RL) {
		this.MandatoryType_RL = MandatoryType_RL;
		MRefList foreignEntity;
		if (MandatoryType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MandatoryType_RL.getID())
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
	public I_AD_Ref_ListInput getMandatoryType_RL() {
		return MandatoryType_RL;
	}
}
