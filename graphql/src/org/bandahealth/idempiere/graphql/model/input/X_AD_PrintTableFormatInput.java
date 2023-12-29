package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.model.X_AD_PrintTableFormat;
import org.compiere.util.Env;

/**
 * Generated Model for AD_PrintTableFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintTableFormatInput extends X_AD_PrintTableFormat implements I_AD_PrintTableFormatInput {

	 private I_AD_ImageInput AD_Image;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintColorInput FunctBG_PrintColor;
	 private I_AD_PrintColorInput FunctFG_PrintColor;
	 private I_AD_PrintColorInput HdrLine_PrintColor;
	 private I_AD_PrintColorInput HdrTextBG_PrintColor;
	 private I_AD_PrintColorInput HdrTextFG_PrintColor;
	 private I_AD_PrintColorInput Line_PrintColor;
	 private I_AD_PrintFontInput Funct_PrintFont;
	 private I_AD_PrintFontInput Hdr_PrintFont;
	 private I_AD_Ref_ListInput HdrStrokeType_RL;
	 private I_AD_Ref_ListInput LineStrokeType_RL;

	/**
	 * Standard constructor
	 */
	public X_AD_PrintTableFormatInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	public void setAD_Image(I_AD_ImageInput AD_Image) {
		this.AD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), MImage.Table_Name, MImage.COLUMNNAME_AD_Image_UU + "=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Image_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Image_ID(0);
		}
	}

	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	public I_AD_ImageInput getAD_Image() {
		return AD_Image;
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
	public void setFunct_PrintFont(I_AD_PrintFontInput Funct_PrintFont) {
		this.Funct_PrintFont = Funct_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (Funct_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFont.Table_Name, X_AD_PrintFont.COLUMNNAME_AD_PrintFont_UU + "=?", get_TrxName())
						.setParameters(Funct_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFunct_PrintFont_ID(foreignEntity.get_ID());
		} else {
			this.setFunct_PrintFont_ID(0);
		}
	}

	/**
	 * Get Function Font.
	 *
	 * @return Function row Font
	 */
	public I_AD_PrintFontInput getFunct_PrintFont() {
		return Funct_PrintFont;
	}

	/**
	 * Set Function BG Color.
	 *
	 * @param FunctBG_PrintColor Function Background Color
	 */
	public void setFunctBG_PrintColor(I_AD_PrintColorInput FunctBG_PrintColor) {
		this.FunctBG_PrintColor = FunctBG_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (FunctBG_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(FunctBG_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFunctBG_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setFunctBG_PrintColor_ID(0);
		}
	}

	/**
	 * Get Function BG Color.
	 *
	 * @return Function Background Color
	 */
	public I_AD_PrintColorInput getFunctBG_PrintColor() {
		return FunctBG_PrintColor;
	}

	/**
	 * Set Function Color.
	 *
	 * @param FunctFG_PrintColor Function Foreground Color
	 */
	public void setFunctFG_PrintColor(I_AD_PrintColorInput FunctFG_PrintColor) {
		this.FunctFG_PrintColor = FunctFG_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (FunctFG_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(FunctFG_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFunctFG_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setFunctFG_PrintColor_ID(0);
		}
	}

	/**
	 * Get Function Color.
	 *
	 * @return Function Foreground Color
	 */
	public I_AD_PrintColorInput getFunctFG_PrintColor() {
		return FunctFG_PrintColor;
	}

	/**
	 * Set Header Row Font.
	 *
	 * @param Hdr_PrintFont Header row Font
	 */
	public void setHdr_PrintFont(I_AD_PrintFontInput Hdr_PrintFont) {
		this.Hdr_PrintFont = Hdr_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (Hdr_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFont.Table_Name, X_AD_PrintFont.COLUMNNAME_AD_PrintFont_UU + "=?", get_TrxName())
						.setParameters(Hdr_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setHdr_PrintFont_ID(foreignEntity.get_ID());
		} else {
			this.setHdr_PrintFont_ID(0);
		}
	}

	/**
	 * Get Header Row Font.
	 *
	 * @return Header row Font
	 */
	public I_AD_PrintFontInput getHdr_PrintFont() {
		return Hdr_PrintFont;
	}

	/**
	 * Set Header Line Color.
	 *
	 * @param HdrLine_PrintColor Table header row line color
	 */
	public void setHdrLine_PrintColor(I_AD_PrintColorInput HdrLine_PrintColor) {
		this.HdrLine_PrintColor = HdrLine_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (HdrLine_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(HdrLine_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setHdrLine_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setHdrLine_PrintColor_ID(0);
		}
	}

	/**
	 * Get Header Line Color.
	 *
	 * @return Table header row line color
	 */
	public I_AD_PrintColorInput getHdrLine_PrintColor() {
		return HdrLine_PrintColor;
	}

	/**
	 * Set Header Stroke Type.
	 *
	 * @param HdrStrokeType_RL Type of the Header Line Stroke
	 */
	public void setHdrStrokeType_RL(I_AD_Ref_ListInput HdrStrokeType_RL) {
		this.HdrStrokeType_RL = HdrStrokeType_RL;
		MRefList foreignEntity;
		if (HdrStrokeType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(HdrStrokeType_RL.getID())
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
	public I_AD_Ref_ListInput getHdrStrokeType_RL() {
		return HdrStrokeType_RL;
	}

	/**
	 * Set Header Row BG Color.
	 *
	 * @param HdrTextBG_PrintColor Background color of header row
	 */
	public void setHdrTextBG_PrintColor(I_AD_PrintColorInput HdrTextBG_PrintColor) {
		this.HdrTextBG_PrintColor = HdrTextBG_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (HdrTextBG_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(HdrTextBG_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setHdrTextBG_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setHdrTextBG_PrintColor_ID(0);
		}
	}

	/**
	 * Get Header Row BG Color.
	 *
	 * @return Background color of header row
	 */
	public I_AD_PrintColorInput getHdrTextBG_PrintColor() {
		return HdrTextBG_PrintColor;
	}

	/**
	 * Set Header Row Color.
	 *
	 * @param HdrTextFG_PrintColor Foreground color if the table header row
	 */
	public void setHdrTextFG_PrintColor(I_AD_PrintColorInput HdrTextFG_PrintColor) {
		this.HdrTextFG_PrintColor = HdrTextFG_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (HdrTextFG_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(HdrTextFG_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setHdrTextFG_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setHdrTextFG_PrintColor_ID(0);
		}
	}

	/**
	 * Get Header Row Color.
	 *
	 * @return Foreground color if the table header row
	 */
	public I_AD_PrintColorInput getHdrTextFG_PrintColor() {
		return HdrTextFG_PrintColor;
	}

	/**
	 * Set Line Color.
	 *
	 * @param Line_PrintColor Table line color
	 */
	public void setLine_PrintColor(I_AD_PrintColorInput Line_PrintColor) {
		this.Line_PrintColor = Line_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (Line_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(Line_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLine_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setLine_PrintColor_ID(0);
		}
	}

	/**
	 * Get Line Color.
	 *
	 * @return Table line color
	 */
	public I_AD_PrintColorInput getLine_PrintColor() {
		return Line_PrintColor;
	}

	/**
	 * Set Line Stroke Type.
	 *
	 * @param LineStrokeType_RL Type of the Line Stroke
	 */
	public void setLineStrokeType_RL(I_AD_Ref_ListInput LineStrokeType_RL) {
		this.LineStrokeType_RL = LineStrokeType_RL;
		MRefList foreignEntity;
		if (LineStrokeType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LineStrokeType_RL.getID())
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
	public I_AD_Ref_ListInput getLineStrokeType_RL() {
		return LineStrokeType_RL;
	}
}
