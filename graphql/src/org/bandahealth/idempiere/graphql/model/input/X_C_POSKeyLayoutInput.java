package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPOSKeyLayout;
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

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_PrintColorInput mAD_PrintColor;
	 private I_AD_PrintFontInput mAD_PrintFont;
	 private I_AD_Ref_ListInput mPOSKeyLayoutType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_POSKeyLayoutInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public void setAD_PrintColorInput(I_AD_PrintColorInput AD_PrintColor) {
		this.mAD_PrintColor = AD_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(AD_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintColor_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public I_AD_PrintColorInput AD_PrintColor() {
		return mAD_PrintColor;
	}

	/**
	 * Set Print Font.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	@JsonProperty("AD_PrintFont")
	public void setAD_PrintFontInput(I_AD_PrintFontInput AD_PrintFont) {
		this.mAD_PrintFont = AD_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (AD_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFont.Table_Name, X_AD_PrintFont.COLUMNNAME_AD_PrintFont_UU + "=?", get_TrxName())
						.setParameters(AD_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintFont_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintFont_ID(0);
		}
	}

	/**
	 * Get Print Font.
	 *
	 * @return Maintain Print Font
	 */
	@JsonProperty("AD_PrintFont")
	public I_AD_PrintFontInput AD_PrintFont() {
		return mAD_PrintFont;
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
	 * @param POSKeyLayoutType The type of Key Layout
	 */
	@JsonProperty("POSKeyLayoutType")
	public void setPOSKeyLayoutTypeInput(I_AD_Ref_ListInput POSKeyLayoutType) {
		this.mPOSKeyLayoutType = POSKeyLayoutType;
		MRefList_BH foreignEntity;
		if (POSKeyLayoutType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(POSKeyLayoutType.getID())
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
	@JsonProperty("POSKeyLayoutType")
	public I_AD_Ref_ListInput POSKeyLayoutType() {
		return mPOSKeyLayoutType;
	}
}
