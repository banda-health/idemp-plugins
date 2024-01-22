package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_ImpFormat;
import org.compiere.model.X_AD_ImpFormat_Row;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ImpFormat_Row - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ImpFormat_RowInput extends X_AD_ImpFormat_Row implements I_AD_ImpFormat_RowInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_ImpFormat;
	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mDataType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ImpFormat_RowInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_ImpFormat_Row(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Import Format.
	 *
	 * @param AD_ImpFormat Import Format
	 */
	@JsonProperty("AD_ImpFormat")
	public void setAD_ImpFormatInput(ForeignEntityInput AD_ImpFormat) {
		this.mAD_ImpFormat = AD_ImpFormat;
		X_AD_ImpFormat foreignEntity;
		if (get_ID() == 0 && AD_ImpFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_ImpFormat", "AD_ImpFormat_UU=?", get_TrxName())
						.setParameters(AD_ImpFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ImpFormat_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Import Format.
	 *
	 * @return Import Format
	 */
	@JsonProperty("AD_ImpFormat")
	public ForeignEntityInput AD_ImpFormat() {
		return mAD_ImpFormat;
	}
	/**
	 * Set Format Field.
	 *
	 * @param AD_ImpFormat_Row_ID Format Field
	 */

	public void setAD_ImpFormat_Row_ID(int AD_ImpFormat_Row_ID) {
		if (get_ID() == 0) {
			super.setAD_ImpFormat_Row_ID(AD_ImpFormat_Row_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_ImpFormat_Row_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_ImpFormat_Row_UU();
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
	 * Set Data Type.
	 *
	 * @param DataType Type of data
	 */
	@JsonProperty("DataType")
	public void setDataTypeInput(I_AD_Ref_ListInput DataType) {
		this.mDataType = DataType;
		MRefList_BH foreignEntity;
		if (DataType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DataType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDataType(foreignEntity.getValue());
		} else {
			this.setDataType(null);
		}
	}

	/**
	 * Get Data Type.
	 *
	 * @return Type of data
	 */
	@JsonProperty("DataType")
	public I_AD_Ref_ListInput DataType() {
		return mDataType;
	}
}
