package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_WS_WebServiceFieldOutput;
import org.compiere.model.X_WS_WebServiceType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for WS_WebServiceFieldOutput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceFieldOutputInput extends X_WS_WebServiceFieldOutput implements I_WS_WebServiceFieldOutputInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mWS_WebServiceType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The WS_WebServiceFieldOutput_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_WS_WebServiceFieldOutputInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_WS_WebServiceFieldOutput(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
		MColumn foreignEntity;
		if (AD_Column != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(AD_Column.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UUID " + AD_Column.getUUID());
			}
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setWS_WebServiceFieldOutput_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (WS_WebServiceType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "WS_WebServiceType", "WS_WebServiceType_UU=?", get_TrxName())
							.setParameters(WS_WebServiceType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setWS_WebServiceType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table WS_WebServiceType with UUID " + WS_WebServiceType.getUUID());
			}
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
