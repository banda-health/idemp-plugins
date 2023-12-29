package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColor;
import org.compiere.model.MEntityType;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_ColorInput AD_Color;
	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_ImageInput AD_Image;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput WindowType_RL;

	/**
	 * Standard constructor
	 */
	public X_AD_WindowInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set System Color.
	 *
	 * @param AD_Color Color for backgrounds or indicators
	 */
	public void setAD_Color(I_AD_ColorInput AD_Color) {
		this.AD_Color = AD_Color;
		MColor foreignEntity;
		if (AD_Color != null &&
				(foreignEntity = new Query(getCtx(), MColor.Table_Name, MColor.COLUMNNAME_AD_Color_UU + "=?", get_TrxName())
						.setParameters(AD_Color.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Color_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Color_ID(0);
		}
	}

	/**
	 * Get System Color.
	 *
	 * @return Color for backgrounds or indicators
	 */
	public I_AD_ColorInput getAD_Color() {
		return AD_Color;
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
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.get_ID());
		} else {
			this.setEntityType(0);
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
	 * Set WindowType.
	 *
	 * @param WindowType_RL Type or classification of a Window
	 */
	public void setWindowType_RL(I_AD_Ref_ListInput WindowType_RL) {
		this.WindowType_RL = WindowType_RL;
		MRefList foreignEntity;
		if (WindowType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(WindowType_RL.getID())
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
	public I_AD_Ref_ListInput getWindowType_RL() {
		return WindowType_RL;
	}
}
