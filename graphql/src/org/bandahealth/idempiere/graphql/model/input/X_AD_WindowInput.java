package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColor;
import org.compiere.model.MEntityType;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WindowInput extends MWindow implements I_AD_WindowInput {

	private ForeignEntityInput mAD_Color;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mWindowType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Window_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_WindowInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set System Color.
	 *
	 * @param AD_Color Color for backgrounds or indicators
	 */
	@JsonProperty("AD_Color")
	public void setAD_ColorInput(ForeignEntityInput AD_Color) {
		this.mAD_Color = AD_Color;
		if (AD_Color != null) {
			// Since an entity was passed, make sure it's in the DB
			MColor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Color", "AD_Color_UU=?", get_TrxName())
							.setParameters(AD_Color.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Color_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Color with UUID " + AD_Color.getUUID());
			}
		} else {
			this.setAD_Color_ID(0);
		}
	}

	/**
	 * Get System Color.
	 *
	 * @return Color for backgrounds or indicators
	 */
	@JsonProperty("AD_Color")
	public ForeignEntityInput AD_Color() {
		return mAD_Color;
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		if (AD_Image != null) {
			// Since an entity was passed, make sure it's in the DB
			MImage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
							.setParameters(AD_Image.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Image_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Image with UUID " + AD_Image.getUUID());
			}
		} else {
			this.setAD_Image_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Window.
	 *
	 * @param AD_Window_ID Data entry or display window
	 */

	public void setAD_Window_ID(int AD_Window_ID) {
		if (get_ID() == 0) {
			super.setAD_Window_ID(AD_Window_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Window_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Window_UU();
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UUID " + AD_EntityType.getUUID());
			}
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
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
		if (WindowType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(WindowType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setWindowType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + WindowType.getUUID());
			}
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
