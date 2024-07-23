package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_WindowResolver;
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
 * @version Release 11 - $Id$
 */
public class X_AD_WindowInput extends MWindow implements I_AD_WindowInput {

	private ForeignEntityInput mAD_Color;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mWindowType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Window_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_WindowInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
							.setParameters(AD_Color.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Color_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Color with UU " + AD_Color.getUU());
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
							.setParameters(AD_Image.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Image_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Image with UU " + AD_Image.getUU());
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
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
	@JsonProperty("AD_Window_ID")
	public void setAD_Window_IDFromJson(int AD_Window_ID) {
		if (get_ID() == 0) {
			super.setAD_Window_ID(AD_Window_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Window_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UU " + AD_EntityType.getUU());
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
	 * Set Window Type.
	 *
	 * @param WindowType Type or classification of a Window
	 */
	@JsonProperty("WindowType")
	public void setWindowTypeInput(ForeignEntityInput WindowType) {
		this.mWindowType = WindowType;
		if (WindowType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_WindowResolver.WINDOWTYPE_UUIDS_BY_VALUE.containsValue(WindowType.getUU())) {
				throw new AdempiereException("The reference list UU of " + WindowType.getUU() +
						" is not in the list defined for the WindowType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(WindowType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setWindowType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + WindowType.getUU());
			}
		} else {
			this.setWindowType(null);
		}
	}

	/**
	 * Get Window Type.
	 *
	 * @return Type or classification of a Window
	 */
	@JsonProperty("WindowType")
	public ForeignEntityInput WindowType() {
		return mWindowType;
	}
}
