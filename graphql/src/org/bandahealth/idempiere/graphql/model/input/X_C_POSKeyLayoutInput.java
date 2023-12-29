package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPOSKeyLayout;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.util.Env;

/**
 * Generated Model for C_POSKeyLayout - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSKeyLayoutInput extends MPOSKeyLayout implements I_C_POSKeyLayoutInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintColorInput AD_PrintColor;
	 private I_AD_PrintFontInput AD_PrintFont;
	 private I_AD_Ref_ListInput POSKeyLayoutType_RL;

	/**
	 * Standard constructor
	 */
	public X_C_POSKeyLayoutInput(String ID) {
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
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	public void setAD_PrintColor(I_AD_PrintColorInput AD_PrintColor) {
		this.AD_PrintColor = AD_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(AD_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public I_AD_PrintColorInput getAD_PrintColor() {
		return AD_PrintColor;
	}

	/**
	 * Set Print Font.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	public void setAD_PrintFont(I_AD_PrintFontInput AD_PrintFont) {
		this.AD_PrintFont = AD_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (AD_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFont.Table_Name, X_AD_PrintFont.COLUMNNAME_AD_PrintFont_UU + "=?", get_TrxName())
						.setParameters(AD_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintFont_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintFont_ID(0);
		}
	}

	/**
	 * Get Print Font.
	 *
	 * @return Maintain Print Font
	 */
	public I_AD_PrintFontInput getAD_PrintFont() {
		return AD_PrintFont;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_POSKeyLayout_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_POSKeyLayout_UU();
	}

	/**
	 * Set POS Key Layout Type.
	 *
	 * @param POSKeyLayoutType_RL The type of Key Layout
	 */
	public void setPOSKeyLayoutType_RL(I_AD_Ref_ListInput POSKeyLayoutType_RL) {
		this.POSKeyLayoutType_RL = POSKeyLayoutType_RL;
		MRefList foreignEntity;
		if (POSKeyLayoutType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(POSKeyLayoutType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPOSKeyLayoutType(foreignEntity.getValue());
		} else {
			this.setPOSKeyLayoutType(null);
		}
	}

	/**
	 * Get POS Key Layout Type.
	 *
	 * @return The type of Key Layout
	 */
	public I_AD_Ref_ListInput getPOSKeyLayoutType_RL() {
		return POSKeyLayoutType_RL;
	}
}
