package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEXPFormat;
import org.compiere.model.MEXPFormatLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_EXP_FormatLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MEXPFormatLine(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		MColumn foreignEntity;
		if (AD_Column != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(AD_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Column_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Column_ID(0);
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
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		MReference_BH foreignEntity;
		if (get_ID() == 0 && AD_Reference != null &&
				(foreignEntity = new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
						.setParameters(AD_Reference.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Reference_ID(foreignEntity.get_ID());
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
		MEXPFormat foreignEntity;
		if (EXP_EmbeddedFormat != null &&
				(foreignEntity = new Query(getCtx(), "EXP_Format", "EXP_Format_UU=?", get_TrxName())
						.setParameters(EXP_EmbeddedFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEXP_EmbeddedFormat_ID(foreignEntity.get_ID());
		} else {
			super.setEXP_EmbeddedFormat_ID(0);
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
		MEXPFormat foreignEntity;
		if (get_ID() == 0 && EXP_Format != null &&
				(foreignEntity = new Query(getCtx(), "EXP_Format", "EXP_Format_UU=?", get_TrxName())
						.setParameters(EXP_Format.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEXP_Format_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setEXP_FormatLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MRefList_BH foreignEntity;
		if (Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setType(foreignEntity.getValue());
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
