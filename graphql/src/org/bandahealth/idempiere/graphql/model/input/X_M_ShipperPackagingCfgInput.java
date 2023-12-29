package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShipperPackagingCfg;
import org.compiere.util.Env;

/**
 * Generated Model for M_ShipperPackagingCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPackagingCfgInput extends X_M_ShipperPackagingCfg implements I_M_ShipperPackagingCfgInput {

	 private I_AD_OrgInput AD_Org;
	 private I_M_ShipperCfgInput M_ShipperCfg;

	/**
	 * Standard constructor
	 */
	public X_M_ShipperPackagingCfgInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Shipper Configuration.
	 *
	 * @param M_ShipperCfg Shipper Configuration
	 */
	public void setM_ShipperCfg(I_M_ShipperCfgInput M_ShipperCfg) {
		this.M_ShipperCfg = M_ShipperCfg;
		X_M_ShipperCfg foreignEntity;
		if (get_ID() == 0 &&M_ShipperCfg != null &&
				(foreignEntity = new Query(getCtx(), X_M_ShipperCfg.Table_Name, X_M_ShipperCfg.COLUMNNAME_M_ShipperCfg_UU + "=?", get_TrxName())
						.setParameters(M_ShipperCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShipperCfg_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	public I_M_ShipperCfgInput getM_ShipperCfg() {
		return M_ShipperCfg;
	}
	/**
	 * Set Shipper Configuration.
	 *
	 * @param M_ShipperCfg_ID Shipper Configuration
	 */

	public void setM_ShipperCfg_ID(int M_ShipperCfg_ID) {
		if (get_ID() == 0) {
			super.setM_ShipperCfg_ID(M_ShipperCfg_ID);
		}
	}
	/**
	 * Set Shipper Packaging Configuration.
	 *
	 * @param M_ShipperPackagingCfg_ID Shipper Packaging Configuration
	 */

	public void setM_ShipperPackagingCfg_ID(int M_ShipperPackagingCfg_ID) {
		if (get_ID() == 0) {
			super.setM_ShipperPackagingCfg_ID(M_ShipperPackagingCfg_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ShipperPackagingCfg_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ShipperPackagingCfg_UU();
	}
}
