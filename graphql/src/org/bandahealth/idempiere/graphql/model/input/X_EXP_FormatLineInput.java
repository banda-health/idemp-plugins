package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEXPFormat;
import org.compiere.model.MEXPFormatLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for EXP_FormatLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_FormatLineInput extends MEXPFormatLine implements I_EXP_FormatLineInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mEXP_EmbeddedFormat;
	private ForeignEntityInput mEXP_Format;
	private I_AD_Ref_ListInput mType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The EXP_FormatLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_EXP_FormatLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		if (AD_Column != null) {
			// Since an entity was passed, make sure it's in the DB
			MColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(AD_Column.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UUID " + AD_Column.getUUID());
			}
		} else {
			this.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	@JsonProperty("AD_Column")
	public ForeignEntityInput AD_Column() {
		return mAD_Column;
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Reference != null) {
			// Since an entity was passed, make sure it's in the DB
			MReference_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Reference_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UUID " + AD_Reference.getUUID());
			}
		} else {
			this.setAD_Reference_ID(0);
		}
	}

	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public ForeignEntityInput AD_Reference() {
		return mAD_Reference;
	}

	/**
	 * Set Embedded Format.
	 *
	 * @param EXP_EmbeddedFormat Embedded Format
	 */
	@JsonProperty("EXP_EmbeddedFormat")
	public void setEXP_EmbeddedFormatInput(ForeignEntityInput EXP_EmbeddedFormat) {
		this.mEXP_EmbeddedFormat = EXP_EmbeddedFormat;
		if (EXP_EmbeddedFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			MEXPFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "EXP_Format", "EXP_Format_UU=?", get_TrxName())
							.setParameters(EXP_EmbeddedFormat.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEXP_EmbeddedFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table EXP_Format with UUID " + EXP_EmbeddedFormat.getUUID());
			}
		} else {
			this.setEXP_EmbeddedFormat_ID(0);
		}
	}

	/**
	 * Get Embedded Format.
	 *
	 * @return Embedded Format
	 */
	@JsonProperty("EXP_EmbeddedFormat")
	public ForeignEntityInput EXP_EmbeddedFormat() {
		return mEXP_EmbeddedFormat;
	}

	/**
	 * Set Export Format.
	 *
	 * @param EXP_Format Export Format
	 */
	@JsonProperty("EXP_Format")
	public void setEXP_FormatInput(ForeignEntityInput EXP_Format) {
		this.mEXP_Format = EXP_Format;
		if (get_ID() != 0) {
			return;
		}
		if (EXP_Format != null) {
			// Since an entity was passed, make sure it's in the DB
			MEXPFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "EXP_Format", "EXP_Format_UU=?", get_TrxName())
							.setParameters(EXP_Format.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEXP_Format_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table EXP_Format with UUID " + EXP_Format.getUUID());
			}
		} else {
			this.setEXP_Format_ID(0);
		}
	}

	/**
	 * Get Export Format.
	 *
	 * @return Export Format
	 */
	@JsonProperty("EXP_Format")
	public ForeignEntityInput EXP_Format() {
		return mEXP_Format;
	}
	/**
	 * Set Format Line.
	 *
	 * @param EXP_FormatLine_ID Format Line
	 */

	public void setEXP_FormatLine_ID(int EXP_FormatLine_ID) {
		if (get_ID() == 0) {
			super.setEXP_FormatLine_ID(EXP_FormatLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setEXP_FormatLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getEXP_FormatLine_UU();
	}

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public void setTypeInput(I_AD_Ref_ListInput Type) {
		this.mType = Type;
		if (Type != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Type.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Type.getUUID());
			}
		} else {
			this.setType(null);
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public I_AD_Ref_ListInput Type() {
		return mType;
	}
}
