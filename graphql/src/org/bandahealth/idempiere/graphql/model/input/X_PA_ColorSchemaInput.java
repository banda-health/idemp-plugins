package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColorSchema;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;

import java.sql.ResultSet;

/**
 * Generated Model for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_ColorSchemaInput extends MColorSchema implements I_PA_ColorSchemaInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintColor1;
	private ForeignEntityInput mAD_PrintColor2;
	private ForeignEntityInput mAD_PrintColor3;
	private ForeignEntityInput mAD_PrintColor4;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_ColorSchemaInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MColorSchema(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set Color 1.
	 *
	 * @param AD_PrintColor1 First color used
	 */
	@JsonProperty("AD_PrintColor1")
	public void setAD_PrintColor1Input(ForeignEntityInput AD_PrintColor1) {
		this.mAD_PrintColor1 = AD_PrintColor1;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor1 != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(AD_PrintColor1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintColor1_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintColor1_ID(0);
		}
	}

	/**
	 * Get Color 1.
	 *
	 * @return First color used
	 */
	@JsonProperty("AD_PrintColor1")
	public ForeignEntityInput AD_PrintColor1() {
		return mAD_PrintColor1;
	}

	/**
	 * Set Color 2.
	 *
	 * @param AD_PrintColor2 Second color used
	 */
	@JsonProperty("AD_PrintColor2")
	public void setAD_PrintColor2Input(ForeignEntityInput AD_PrintColor2) {
		this.mAD_PrintColor2 = AD_PrintColor2;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor2 != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(AD_PrintColor2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintColor2_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintColor2_ID(0);
		}
	}

	/**
	 * Get Color 2.
	 *
	 * @return Second color used
	 */
	@JsonProperty("AD_PrintColor2")
	public ForeignEntityInput AD_PrintColor2() {
		return mAD_PrintColor2;
	}

	/**
	 * Set Color 3.
	 *
	 * @param AD_PrintColor3 Third color used
	 */
	@JsonProperty("AD_PrintColor3")
	public void setAD_PrintColor3Input(ForeignEntityInput AD_PrintColor3) {
		this.mAD_PrintColor3 = AD_PrintColor3;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor3 != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(AD_PrintColor3.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintColor3_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintColor3_ID(0);
		}
	}

	/**
	 * Get Color 3.
	 *
	 * @return Third color used
	 */
	@JsonProperty("AD_PrintColor3")
	public ForeignEntityInput AD_PrintColor3() {
		return mAD_PrintColor3;
	}

	/**
	 * Set Color 4.
	 *
	 * @param AD_PrintColor4 Forth color used
	 */
	@JsonProperty("AD_PrintColor4")
	public void setAD_PrintColor4Input(ForeignEntityInput AD_PrintColor4) {
		this.mAD_PrintColor4 = AD_PrintColor4;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor4 != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(AD_PrintColor4.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintColor4_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintColor4_ID(0);
		}
	}

	/**
	 * Get Color 4.
	 *
	 * @return Forth color used
	 */
	@JsonProperty("AD_PrintColor4")
	public ForeignEntityInput AD_PrintColor4() {
		return mAD_PrintColor4;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}
	/**
	 * Set Color Schema.
	 *
	 * @param PA_ColorSchema_ID Performance Color Schema
	 */

	public void setPA_ColorSchema_ID(int PA_ColorSchema_ID) {
		if (get_ID() == 0) {
			super.setPA_ColorSchema_ID(PA_ColorSchema_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_ColorSchema_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_ColorSchema_UU();
	}
}
