package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColor;
import org.compiere.model.MEntityType;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WindowInput extends MWindow implements I_AD_WindowInput {

	 private I_AD_ColorInput mAD_Color;
	 private I_AD_EntityTypeInput mAD_EntityType;
	 private I_AD_ImageInput mAD_Image;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mWindowType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_WindowInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set System Color.
	 *
	 * @param AD_Color Color for backgrounds or indicators
	 */
	@JsonProperty("AD_Color")
	public void setAD_ColorInput(I_AD_ColorInput AD_Color) {
		this.mAD_Color = AD_Color;
		MColor foreignEntity;
		if (AD_Color != null &&
				(foreignEntity = new Query(getCtx(), MColor.Table_Name, MColor.COLUMNNAME_AD_Color_UU + "=?", get_TrxName())
						.setParameters(AD_Color.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Color_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Color_ID(0);
		}
	}

	/**
	 * Get System Color.
	 *
	 * @return Color for backgrounds or indicators
	 */
	@JsonProperty("AD_Color")
	public I_AD_ColorInput AD_Color() {
		return mAD_Color;
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(I_AD_ImageInput AD_Image) {
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
	public I_AD_ImageInput AD_Image() {
		return mAD_Image;
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Window_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Window_UU();
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
		} else {
			super.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public I_AD_EntityTypeInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set WindowType.
	 *
	 * @param WindowType Type or classification of a Window
	 */
	@JsonProperty("WindowType")
	public void setWindowTypeInput(I_AD_Ref_ListInput WindowType) {
		this.mWindowType = WindowType;
		MRefList_BH foreignEntity;
		if (WindowType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(WindowType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setWindowType(foreignEntity.getValue());
		} else {
			this.setWindowType(null);
		}
	}

	/**
	 * Get WindowType.
	 *
	 * @return Type or classification of a Window
	 */
	@JsonProperty("WindowType")
	public I_AD_Ref_ListInput WindowType() {
		return mWindowType;
	}
}
