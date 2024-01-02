package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShipperPickupTypesCfg;
import org.compiere.util.Env;

/**
 * Generated Model for M_ShipperPickupTypesCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPickupTypesCfgInput extends X_M_ShipperPickupTypesCfg implements I_M_ShipperPickupTypesCfgInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_M_ShipperCfgInput mM_ShipperCfg;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_ShipperPickupTypesCfgInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Shipper Configuration.
	 *
	 * @param M_ShipperCfg Shipper Configuration
	 */
	@JsonProperty("M_ShipperCfg")
	public void setM_ShipperCfgInput(I_M_ShipperCfgInput M_ShipperCfg) {
		this.mM_ShipperCfg = M_ShipperCfg;
		X_M_ShipperCfg foreignEntity;
		if (get_ID() == 0 &&M_ShipperCfg != null &&
				(foreignEntity = new Query(getCtx(), X_M_ShipperCfg.Table_Name, X_M_ShipperCfg.COLUMNNAME_M_ShipperCfg_UU + "=?", get_TrxName())
						.setParameters(M_ShipperCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShipperCfg_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	@JsonProperty("M_ShipperCfg")
	public I_M_ShipperCfgInput M_ShipperCfg() {
		return mM_ShipperCfg;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ShipperPickupTypesCfg_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ShipperPickupTypesCfg_UU();
	}
}
