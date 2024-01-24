package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.model.X_AD_PrintTableFormat;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintTableFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_PrintTableFormatInput extends X_AD_PrintTableFormat implements I_AD_PrintTableFormatInput {

	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mFunctBG_PrintColor;
	private ForeignEntityInput mFunctFG_PrintColor;
	private ForeignEntityInput mFunct_PrintFont;
	private ForeignEntityInput mHdrLine_PrintColor;
	private ForeignEntityInput mHdrTextBG_PrintColor;
	private ForeignEntityInput mHdrTextFG_PrintColor;
	private ForeignEntityInput mHdr_PrintFont;
	private ForeignEntityInput mLine_PrintColor;
	private I_AD_Ref_ListInput mHdrStrokeType;
	private I_AD_Ref_ListInput mLineStrokeType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_PrintTableFormat_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PrintTableFormatInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_PrintTableFormat(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
							.setParameters(AD_Image.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Image_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Image with UUID " + AD_Image.getUUID());
			}
		} else {
			super.setAD_Image_ID(0);
		}
	}

	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	@JsonProperty("AD_Image")
	public ForeignEntityInput AD_Image() {
		return mAD_Image;
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
	 * Set Print Table Format.
	 *
	 * @param AD_PrintTableFormat_ID Table Format in Reports
	 */

	public void setAD_PrintTableFormat_ID(int AD_PrintTableFormat_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintTableFormat_ID(AD_PrintTableFormat_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_PrintTableFormat_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_PrintTableFormat_UU();
	}

	/**
	 * Set Function Font.
	 *
	 * @param Funct_PrintFont Function row Font
	 */
	@JsonProperty("Funct_PrintFont")
	public void setFunct_PrintFontInput(ForeignEntityInput Funct_PrintFont) {
		this.mFunct_PrintFont = Funct_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (Funct_PrintFont != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFont", "AD_PrintFont_UU=?", get_TrxName())
							.setParameters(Funct_PrintFont.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFunct_PrintFont_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFont with UUID " + Funct_PrintFont.getUUID());
			}
		} else {
			super.setFunct_PrintFont_ID(0);
		}
	}

	/**
	 * Get Function Font.
	 *
	 * @return Function row Font
	 */
	@JsonProperty("Funct_PrintFont")
	public ForeignEntityInput Funct_PrintFont() {
		return mFunct_PrintFont;
	}

	/**
	 * Set Function BG Color.
	 *
	 * @param FunctBG_PrintColor Function Background Color
	 */
	@JsonProperty("FunctBG_PrintColor")
	public void setFunctBG_PrintColorInput(ForeignEntityInput FunctBG_PrintColor) {
		this.mFunctBG_PrintColor = FunctBG_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (FunctBG_PrintColor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(FunctBG_PrintColor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFunctBG_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + FunctBG_PrintColor.getUUID());
			}
		} else {
			super.setFunctBG_PrintColor_ID(0);
		}
	}

	/**
	 * Get Function BG Color.
	 *
	 * @return Function Background Color
	 */
	@JsonProperty("FunctBG_PrintColor")
	public ForeignEntityInput FunctBG_PrintColor() {
		return mFunctBG_PrintColor;
	}

	/**
	 * Set Function Color.
	 *
	 * @param FunctFG_PrintColor Function Foreground Color
	 */
	@JsonProperty("FunctFG_PrintColor")
	public void setFunctFG_PrintColorInput(ForeignEntityInput FunctFG_PrintColor) {
		this.mFunctFG_PrintColor = FunctFG_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (FunctFG_PrintColor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(FunctFG_PrintColor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFunctFG_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + FunctFG_PrintColor.getUUID());
			}
		} else {
			super.setFunctFG_PrintColor_ID(0);
		}
	}

	/**
	 * Get Function Color.
	 *
	 * @return Function Foreground Color
	 */
	@JsonProperty("FunctFG_PrintColor")
	public ForeignEntityInput FunctFG_PrintColor() {
		return mFunctFG_PrintColor;
	}

	/**
	 * Set Header Row Font.
	 *
	 * @param Hdr_PrintFont Header row Font
	 */
	@JsonProperty("Hdr_PrintFont")
	public void setHdr_PrintFontInput(ForeignEntityInput Hdr_PrintFont) {
		this.mHdr_PrintFont = Hdr_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (Hdr_PrintFont != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFont", "AD_PrintFont_UU=?", get_TrxName())
							.setParameters(Hdr_PrintFont.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHdr_PrintFont_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFont with UUID " + Hdr_PrintFont.getUUID());
			}
		} else {
			super.setHdr_PrintFont_ID(0);
		}
	}

	/**
	 * Get Header Row Font.
	 *
	 * @return Header row Font
	 */
	@JsonProperty("Hdr_PrintFont")
	public ForeignEntityInput Hdr_PrintFont() {
		return mHdr_PrintFont;
	}

	/**
	 * Set Header Line Color.
	 *
	 * @param HdrLine_PrintColor Table header row line color
	 */
	@JsonProperty("HdrLine_PrintColor")
	public void setHdrLine_PrintColorInput(ForeignEntityInput HdrLine_PrintColor) {
		this.mHdrLine_PrintColor = HdrLine_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (HdrLine_PrintColor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(HdrLine_PrintColor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHdrLine_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + HdrLine_PrintColor.getUUID());
			}
		} else {
			super.setHdrLine_PrintColor_ID(0);
		}
	}

	/**
	 * Get Header Line Color.
	 *
	 * @return Table header row line color
	 */
	@JsonProperty("HdrLine_PrintColor")
	public ForeignEntityInput HdrLine_PrintColor() {
		return mHdrLine_PrintColor;
	}

	/**
	 * Set Header Stroke Type.
	 *
	 * @param HdrStrokeType Type of the Header Line Stroke
	 */
	@JsonProperty("HdrStrokeType")
	public void setHdrStrokeTypeInput(I_AD_Ref_ListInput HdrStrokeType) {
		this.mHdrStrokeType = HdrStrokeType;
		MRefList_BH foreignEntity;
		if (HdrStrokeType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(HdrStrokeType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHdrStrokeType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + HdrStrokeType.getUUID());
			}
		} else {
			this.setHdrStrokeType(null);
		}
	}

	/**
	 * Get Header Stroke Type.
	 *
	 * @return Type of the Header Line Stroke
	 */
	@JsonProperty("HdrStrokeType")
	public I_AD_Ref_ListInput HdrStrokeType() {
		return mHdrStrokeType;
	}

	/**
	 * Set Header Row BG Color.
	 *
	 * @param HdrTextBG_PrintColor Background color of header row
	 */
	@JsonProperty("HdrTextBG_PrintColor")
	public void setHdrTextBG_PrintColorInput(ForeignEntityInput HdrTextBG_PrintColor) {
		this.mHdrTextBG_PrintColor = HdrTextBG_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (HdrTextBG_PrintColor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(HdrTextBG_PrintColor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHdrTextBG_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + HdrTextBG_PrintColor.getUUID());
			}
		} else {
			super.setHdrTextBG_PrintColor_ID(0);
		}
	}

	/**
	 * Get Header Row BG Color.
	 *
	 * @return Background color of header row
	 */
	@JsonProperty("HdrTextBG_PrintColor")
	public ForeignEntityInput HdrTextBG_PrintColor() {
		return mHdrTextBG_PrintColor;
	}

	/**
	 * Set Header Row Color.
	 *
	 * @param HdrTextFG_PrintColor Foreground color if the table header row
	 */
	@JsonProperty("HdrTextFG_PrintColor")
	public void setHdrTextFG_PrintColorInput(ForeignEntityInput HdrTextFG_PrintColor) {
		this.mHdrTextFG_PrintColor = HdrTextFG_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (HdrTextFG_PrintColor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(HdrTextFG_PrintColor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHdrTextFG_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + HdrTextFG_PrintColor.getUUID());
			}
		} else {
			super.setHdrTextFG_PrintColor_ID(0);
		}
	}

	/**
	 * Get Header Row Color.
	 *
	 * @return Foreground color if the table header row
	 */
	@JsonProperty("HdrTextFG_PrintColor")
	public ForeignEntityInput HdrTextFG_PrintColor() {
		return mHdrTextFG_PrintColor;
	}

	/**
	 * Set Line Color.
	 *
	 * @param Line_PrintColor Table line color
	 */
	@JsonProperty("Line_PrintColor")
	public void setLine_PrintColorInput(ForeignEntityInput Line_PrintColor) {
		this.mLine_PrintColor = Line_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (Line_PrintColor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(Line_PrintColor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setLine_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + Line_PrintColor.getUUID());
			}
		} else {
			super.setLine_PrintColor_ID(0);
		}
	}

	/**
	 * Get Line Color.
	 *
	 * @return Table line color
	 */
	@JsonProperty("Line_PrintColor")
	public ForeignEntityInput Line_PrintColor() {
		return mLine_PrintColor;
	}

	/**
	 * Set Line Stroke Type.
	 *
	 * @param LineStrokeType Type of the Line Stroke
	 */
	@JsonProperty("LineStrokeType")
	public void setLineStrokeTypeInput(I_AD_Ref_ListInput LineStrokeType) {
		this.mLineStrokeType = LineStrokeType;
		MRefList_BH foreignEntity;
		if (LineStrokeType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LineStrokeType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setLineStrokeType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + LineStrokeType.getUUID());
			}
		} else {
			this.setLineStrokeType(null);
		}
	}

	/**
	 * Get Line Stroke Type.
	 *
	 * @return Type of the Line Stroke
	 */
	@JsonProperty("LineStrokeType")
	public I_AD_Ref_ListInput LineStrokeType() {
		return mLineStrokeType;
	}
}
