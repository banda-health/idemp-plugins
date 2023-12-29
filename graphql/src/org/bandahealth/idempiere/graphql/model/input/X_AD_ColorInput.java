package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColor;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Color - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ColorInput extends MColor implements I_AD_ColorInput {

	 private I_AD_ImageInput AD_Image;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ColorType_RL;
	 private I_AD_Ref_ListInput StartPoint_RL;

	/**
	 * Standard constructor
	 */
	public X_AD_ColorInput(String ID) {
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
	 * Set Color Type.
	 *
	 * @param ColorType_RL Color presentation for this color
	 */
	public void setColorType_RL(I_AD_Ref_ListInput ColorType_RL) {
		this.ColorType_RL = ColorType_RL;
		MRefList foreignEntity;
		if (ColorType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ColorType_RL.getID())
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
	public I_AD_Ref_ListInput getColorType_RL() {
		return ColorType_RL;
	}

	/**
	 * Set Start Point.
	 *
	 * @param StartPoint_RL Start point of the gradient colors
	 */
	public void setStartPoint_RL(I_AD_Ref_ListInput StartPoint_RL) {
		this.StartPoint_RL = StartPoint_RL;
		MRefList foreignEntity;
		if (StartPoint_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(StartPoint_RL.getID())
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
	public I_AD_Ref_ListInput getStartPoint_RL() {
		return StartPoint_RL;
	}
}
