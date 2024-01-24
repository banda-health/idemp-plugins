package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_WS_WebServiceFieldInput;
import org.compiere.model.X_WS_WebServiceType;

import java.sql.ResultSet;

/**
 * Generated Model for WS_WebServiceFieldInput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceFieldInputInput extends X_WS_WebServiceFieldInput implements I_WS_WebServiceFieldInputInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mWS_WebServiceType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_WS_WebServiceFieldInputInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_WS_WebServiceFieldInput(null, (ResultSet) null, null), null, Table_Name, ID),
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
		if (AD_Reference != null &&
				(foreignEntity = new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
						.setParameters(AD_Reference.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Reference_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Reference_ID(0);
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
	 * Set Reference Key.
	 *
	 * @param AD_Reference_Value Required to specify, if data type is Table or List
	 */
	@JsonProperty("AD_Reference_Value")
	public void setAD_Reference_ValueInput(ForeignEntityInput AD_Reference_Value) {
		this.mAD_Reference_Value = AD_Reference_Value;
		MReference_BH foreignEntity;
		if (AD_Reference_Value != null &&
				(foreignEntity = new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
						.setParameters(AD_Reference_Value.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Reference_Value_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Reference_Value_ID(0);
		}
	}

	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	@JsonProperty("AD_Reference_Value")
	public ForeignEntityInput AD_Reference_Value() {
		return mAD_Reference_Value;
	}
	/**
	 * Set Web Service Field Input.
	 *
	 * @param WS_WebServiceFieldInput_ID Web Service Field Input
	 */

	public void setWS_WebServiceFieldInput_ID(int WS_WebServiceFieldInput_ID) {
		if (get_ID() == 0) {
			super.setWS_WebServiceFieldInput_ID(WS_WebServiceFieldInput_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setWS_WebServiceFieldInput_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getWS_WebServiceFieldInput_UU();
	}

	/**
	 * Set Web Service Type.
	 *
	 * @param WS_WebServiceType Web Service Type
	 */
	@JsonProperty("WS_WebServiceType")
	public void setWS_WebServiceTypeInput(ForeignEntityInput WS_WebServiceType) {
		this.mWS_WebServiceType = WS_WebServiceType;
		X_WS_WebServiceType foreignEntity;
		if (WS_WebServiceType != null &&
				(foreignEntity = new Query(getCtx(), "WS_WebServiceType", "WS_WebServiceType_UU=?", get_TrxName())
						.setParameters(WS_WebServiceType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setWS_WebServiceType_ID(foreignEntity.get_ID());
		} else {
			super.setWS_WebServiceType_ID(0);
		}
	}

	/**
	 * Get Web Service Type.
	 *
	 * @return Web Service Type
	 */
	@JsonProperty("WS_WebServiceType")
	public ForeignEntityInput WS_WebServiceType() {
		return mWS_WebServiceType;
	}
}
