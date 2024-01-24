package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_WS_WebServiceFieldOutput;
import org.compiere.model.X_WS_WebServiceType;

import java.sql.ResultSet;

/**
 * Generated Model for WS_WebServiceFieldOutput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceFieldOutputInput extends X_WS_WebServiceFieldOutput implements I_WS_WebServiceFieldOutputInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mWS_WebServiceType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_WS_WebServiceFieldOutputInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_WS_WebServiceFieldOutput(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Web Service Field Output.
	 *
	 * @param WS_WebServiceFieldOutput_ID Web Service Field Output
	 */

	public void setWS_WebServiceFieldOutput_ID(int WS_WebServiceFieldOutput_ID) {
		if (get_ID() == 0) {
			super.setWS_WebServiceFieldOutput_ID(WS_WebServiceFieldOutput_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setWS_WebServiceFieldOutput_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getWS_WebServiceFieldOutput_UU();
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
