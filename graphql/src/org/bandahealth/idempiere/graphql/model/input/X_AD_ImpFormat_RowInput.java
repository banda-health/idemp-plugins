package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_ImpFormat;
import org.compiere.model.X_AD_ImpFormat_Row;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ImpFormat_Row - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ImpFormat_RowInput extends X_AD_ImpFormat_Row implements I_AD_ImpFormat_RowInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_ImpFormat;
	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mDataType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_ImpFormat_Row_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ImpFormat_RowInput(@JsonProperty("UU") String UU) {
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
							.setParameters(AD_Column.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Import Format.
	 *
	 * @param AD_ImpFormat Import Format
	 */
	@JsonProperty("AD_ImpFormat")
	public void setAD_ImpFormatInput(ForeignEntityInput AD_ImpFormat) {
		this.mAD_ImpFormat = AD_ImpFormat;
		if (get_ID() != 0) {
			return;
		}
		if (AD_ImpFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_ImpFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ImpFormat", "AD_ImpFormat_UU=?", get_TrxName())
							.setParameters(AD_ImpFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_ImpFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ImpFormat with UU " + AD_ImpFormat.getUU());
			}
		} else {
			this.setAD_ImpFormat_ID(0);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_ImpFormat_Row_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_ImpFormat_Row_UU();
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
	 * Set Data Type.
	 *
	 * @param DataType Type of data
	 */
	@JsonProperty("DataType")
	public void setDataTypeInput(I_AD_Ref_ListInput DataType) {
		this.mDataType = DataType;
		if (DataType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DataType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDataType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DataType.getUU());
			}
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
