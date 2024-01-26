package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColor;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Color_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ColorInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set System Color.
	 *
	 * @param AD_Color_ID Color for backgrounds or indicators
	 */

	public void setAD_Color_ID(int AD_Color_ID) {
		if (get_ID() == 0) {
			super.setAD_Color_ID(AD_Color_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Color_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
	 * Set Color Type.
	 *
	 * @param ColorType Color presentation for this color
	 */
	@JsonProperty("ColorType")
	public void setColorTypeInput(I_AD_Ref_ListInput ColorType) {
		this.mColorType = ColorType;
		if (ColorType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ColorType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setColorType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ColorType.getUUID());
			}
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
		if (StartPoint != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(StartPoint.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setStartPoint(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + StartPoint.getUUID());
			}
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
