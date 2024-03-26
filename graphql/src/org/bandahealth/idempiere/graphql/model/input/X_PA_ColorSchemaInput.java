package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColorSchema;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ColorSchemaInput extends MColorSchema implements I_PA_ColorSchemaInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintColor1;
	private ForeignEntityInput mAD_PrintColor2;
	private ForeignEntityInput mAD_PrintColor3;
	private ForeignEntityInput mAD_PrintColor4;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_ColorSchema_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_ColorSchemaInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
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
		if (AD_PrintColor1 != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintColor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(AD_PrintColor1.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintColor1_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + AD_PrintColor1.getUUID());
			}
		} else {
			this.setAD_PrintColor1_ID(0);
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
		if (AD_PrintColor2 != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintColor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(AD_PrintColor2.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintColor2_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + AD_PrintColor2.getUUID());
			}
		} else {
			this.setAD_PrintColor2_ID(0);
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
		if (AD_PrintColor3 != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintColor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(AD_PrintColor3.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintColor3_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + AD_PrintColor3.getUUID());
			}
		} else {
			this.setAD_PrintColor3_ID(0);
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
		if (AD_PrintColor4 != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintColor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(AD_PrintColor4.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintColor4_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + AD_PrintColor4.getUUID());
			}
		} else {
			this.setAD_PrintColor4_ID(0);
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
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPA_ColorSchema_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPA_ColorSchema_UU();
	}
}
