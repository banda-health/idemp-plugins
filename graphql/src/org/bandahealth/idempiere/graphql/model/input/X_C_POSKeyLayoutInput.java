package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPOSKeyLayout;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_POSKeyLayout - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_POSKeyLayoutInput extends MPOSKeyLayout implements I_C_POSKeyLayoutInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintColor;
	private ForeignEntityInput mAD_PrintFont;
	private I_AD_Ref_ListInput mPOSKeyLayoutType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_POSKeyLayout_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_POSKeyLayoutInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MPOSKeyLayout(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public void setAD_PrintColorInput(ForeignEntityInput AD_PrintColor) {
		this.mAD_PrintColor = AD_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(AD_PrintColor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + AD_PrintColor.getUUID());
			}
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
	public ForeignEntityInput AD_PrintColor() {
		return mAD_PrintColor;
	}

	/**
	 * Set Print Font.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	@JsonProperty("AD_PrintFont")
	public void setAD_PrintFontInput(ForeignEntityInput AD_PrintFont) {
		this.mAD_PrintFont = AD_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (AD_PrintFont != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFont", "AD_PrintFont_UU=?", get_TrxName())
							.setParameters(AD_PrintFont.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintFont_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFont with UUID " + AD_PrintFont.getUUID());
			}
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
	public ForeignEntityInput AD_PrintFont() {
		return mAD_PrintFont;
	}
	/**
	 * Set POS Key Layout.
	 *
	 * @param C_POSKeyLayout_ID POS Function Key Layout
	 */

	public void setC_POSKeyLayout_ID(int C_POSKeyLayout_ID) {
		if (get_ID() == 0) {
			super.setC_POSKeyLayout_ID(C_POSKeyLayout_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_POSKeyLayout_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (POSKeyLayoutType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(POSKeyLayoutType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPOSKeyLayoutType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + POSKeyLayoutType.getUUID());
			}
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
