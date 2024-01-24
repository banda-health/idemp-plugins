package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.model.X_AD_PrintTableFormat;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_PrintTableFormatInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_PrintTableFormat(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Image_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_PrintTableFormat_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		if (Funct_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFont", "AD_PrintFont_UU=?", get_TrxName())
						.setParameters(Funct_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setFunct_PrintFont_ID(foreignEntity.get_ID());
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
		if (FunctBG_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(FunctBG_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setFunctBG_PrintColor_ID(foreignEntity.get_ID());
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
		if (FunctFG_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(FunctFG_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setFunctFG_PrintColor_ID(foreignEntity.get_ID());
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
		if (Hdr_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFont", "AD_PrintFont_UU=?", get_TrxName())
						.setParameters(Hdr_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHdr_PrintFont_ID(foreignEntity.get_ID());
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
		if (HdrLine_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(HdrLine_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHdrLine_PrintColor_ID(foreignEntity.get_ID());
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
		if (HdrStrokeType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(HdrStrokeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setHdrStrokeType(foreignEntity.getValue());
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
		if (HdrTextBG_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(HdrTextBG_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHdrTextBG_PrintColor_ID(foreignEntity.get_ID());
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
		if (HdrTextFG_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(HdrTextFG_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHdrTextFG_PrintColor_ID(foreignEntity.get_ID());
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
		if (Line_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(Line_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setLine_PrintColor_ID(foreignEntity.get_ID());
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
		if (LineStrokeType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LineStrokeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLineStrokeType(foreignEntity.getValue());
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
