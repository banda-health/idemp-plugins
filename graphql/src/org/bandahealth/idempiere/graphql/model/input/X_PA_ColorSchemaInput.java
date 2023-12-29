package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_PA_ColorSchema;
import org.compiere.util.Env;

/**
 * Generated Model for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ColorSchemaInput extends X_PA_ColorSchema implements I_PA_ColorSchemaInput {

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintColorInput AD_PrintColor1;
	 private I_AD_PrintColorInput AD_PrintColor2;
	 private I_AD_PrintColorInput AD_PrintColor3;
	 private I_AD_PrintColorInput AD_PrintColor4;

	/**
	 * Standard constructor
	 */
	public X_PA_ColorSchemaInput(String ID) {
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
	 * Set Color 1.
	 *
	 * @param AD_PrintColor1 First color used
	 */
	public void setAD_PrintColor1(I_AD_PrintColorInput AD_PrintColor1) {
		this.AD_PrintColor1 = AD_PrintColor1;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor1 != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(AD_PrintColor1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintColor1_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintColor1_ID(0);
		}
	}

	/**
	 * Get Color 1.
	 *
	 * @return First color used
	 */
	public I_AD_PrintColorInput getAD_PrintColor1() {
		return AD_PrintColor1;
	}
	/**
	 * Set Color 1.
	 *
	 * @param AD_PrintColor1_ID First color used
	 */

	public void setAD_PrintColor1_ID(int AD_PrintColor1_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintColor1_ID(AD_PrintColor1_ID);
		}
	}

	/**
	 * Set Color 2.
	 *
	 * @param AD_PrintColor2 Second color used
	 */
	public void setAD_PrintColor2(I_AD_PrintColorInput AD_PrintColor2) {
		this.AD_PrintColor2 = AD_PrintColor2;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor2 != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(AD_PrintColor2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintColor2_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintColor2_ID(0);
		}
	}

	/**
	 * Get Color 2.
	 *
	 * @return Second color used
	 */
	public I_AD_PrintColorInput getAD_PrintColor2() {
		return AD_PrintColor2;
	}
	/**
	 * Set Color 2.
	 *
	 * @param AD_PrintColor2_ID Second color used
	 */

	public void setAD_PrintColor2_ID(int AD_PrintColor2_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintColor2_ID(AD_PrintColor2_ID);
		}
	}

	/**
	 * Set Color 3.
	 *
	 * @param AD_PrintColor3 Third color used
	 */
	public void setAD_PrintColor3(I_AD_PrintColorInput AD_PrintColor3) {
		this.AD_PrintColor3 = AD_PrintColor3;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor3 != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(AD_PrintColor3.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintColor3_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintColor3_ID(0);
		}
	}

	/**
	 * Get Color 3.
	 *
	 * @return Third color used
	 */
	public I_AD_PrintColorInput getAD_PrintColor3() {
		return AD_PrintColor3;
	}
	/**
	 * Set Color 3.
	 *
	 * @param AD_PrintColor3_ID Third color used
	 */

	public void setAD_PrintColor3_ID(int AD_PrintColor3_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintColor3_ID(AD_PrintColor3_ID);
		}
	}

	/**
	 * Set Color 4.
	 *
	 * @param AD_PrintColor4 Forth color used
	 */
	public void setAD_PrintColor4(I_AD_PrintColorInput AD_PrintColor4) {
		this.AD_PrintColor4 = AD_PrintColor4;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor4 != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(AD_PrintColor4.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintColor4_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintColor4_ID(0);
		}
	}

	/**
	 * Get Color 4.
	 *
	 * @return Forth color used
	 */
	public I_AD_PrintColorInput getAD_PrintColor4() {
		return AD_PrintColor4;
	}
	/**
	 * Set Color 4.
	 *
	 * @param AD_PrintColor4_ID Forth color used
	 */

	public void setAD_PrintColor4_ID(int AD_PrintColor4_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintColor4_ID(AD_PrintColor4_ID);
		}
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.getEntityType());
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}
	/**
	 * Set Entity Type.
	 *
	 * @param EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */

	public void setEntityType(String EntityType) {
		if (get_ID() == 0) {
			super.setEntityType(EntityType);
		}
	}
	/**
	 * Set Color Schema.
	 *
	 * @param PA_ColorSchema_ID Performance Color Schema
	 */

	public void setPA_ColorSchema_ID(int PA_ColorSchema_ID) {
		if (get_ID() == 0) {
			super.setPA_ColorSchema_ID(PA_ColorSchema_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_ColorSchema_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_ColorSchema_UU();
	}
}
