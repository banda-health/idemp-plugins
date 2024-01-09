package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColor;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Color - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ColorInput extends MColor implements I_AD_ColorInput {

	 private ForeignEntityInput mAD_Image;
	 private ForeignEntityInput mAD_Org;
	 private I_AD_Ref_ListInput mColorType;
	 private I_AD_Ref_ListInput mStartPoint;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ColorInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Color_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Color_UU();
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
				(foreignEntity = new Query(getCtx(), MImage.Table_Name, MImage.COLUMNNAME_AD_Image_UU + "=?", get_TrxName())
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
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Color Type.
	 *
	 * @param ColorType Color presentation for this color
	 */
	@JsonProperty("ColorType")
	public void setColorTypeInput(I_AD_Ref_ListInput ColorType) {
		this.mColorType = ColorType;
		MRefList_BH foreignEntity;
		if (ColorType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ColorType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setColorType(foreignEntity.getValue());
		} else {
			this.setColorType(null);
		}
	}

	/**
	 * Get Color Type.
	 *
	 * @return Color presentation for this color
	 */
	@JsonProperty("ColorType")
	public I_AD_Ref_ListInput ColorType() {
		return mColorType;
	}

	/**
	 * Set Start Point.
	 *
	 * @param StartPoint Start point of the gradient colors
	 */
	@JsonProperty("StartPoint")
	public void setStartPointInput(I_AD_Ref_ListInput StartPoint) {
		this.mStartPoint = StartPoint;
		MRefList_BH foreignEntity;
		if (StartPoint != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(StartPoint.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setStartPoint(foreignEntity.getValue());
		} else {
			this.setStartPoint(null);
		}
	}

	/**
	 * Get Start Point.
	 *
	 * @return Start point of the gradient colors
	 */
	@JsonProperty("StartPoint")
	public I_AD_Ref_ListInput StartPoint() {
		return mStartPoint;
	}
}
