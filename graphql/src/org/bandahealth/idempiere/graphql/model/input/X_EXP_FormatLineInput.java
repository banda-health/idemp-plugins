package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_EXP_FormatLineResolver;
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
 * @version Release 12 - $Id$
 */
public class X_EXP_FormatLineInput extends MEXPFormatLine implements I_EXP_FormatLineInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mEXP_EmbeddedFormat;
	private ForeignEntityInput mEXP_Format;
	private ForeignEntityInput mType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The EXP_FormatLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_EXP_FormatLineInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
							.setParameters(AD_Column.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UU " + AD_Column.getUU());
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
							.setParameters(EXP_EmbeddedFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setEXP_EmbeddedFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table EXP_Format with UU " + EXP_EmbeddedFormat.getUU());
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
							.setParameters(EXP_Format.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setEXP_Format_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table EXP_Format with UU " + EXP_Format.getUU());
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
	@JsonProperty("EXP_FormatLine_ID")
	public void setEXP_FormatLine_IDFromJson(int EXP_FormatLine_ID) {
		if (get_ID() == 0) {
			super.setEXP_FormatLine_ID(EXP_FormatLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setEXP_FormatLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getEXP_FormatLine_UU();
	}

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public void setTypeInput(ForeignEntityInput Type) {
		this.mType = Type;
		if (Type != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_EXP_FormatLineResolver.TYPE_UUIDS_BY_VALUE.containsValue(Type.getUU())) {
				throw new AdempiereException("The reference list UU of " + Type.getUU() +
						" is not in the list defined for the Type column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Type.getUU());
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
	public ForeignEntityInput Type() {
		return mType;
	}
}
