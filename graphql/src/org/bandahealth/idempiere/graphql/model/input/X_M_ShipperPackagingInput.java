package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperPackaging;
import org.compiere.model.X_M_ShipperPackagingCfg;
import org.compiere.util.Env;

/**
 * Generated Model for M_ShipperPackaging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPackagingInput extends X_M_ShipperPackaging implements I_M_ShipperPackagingInput {

	 private I_AD_OrgInput AD_Org;
	 private I_M_ShipperInput M_Shipper;
	 private I_M_ShipperPackagingCfgInput M_ShipperPackagingCfg;

	/**
	 * Standard constructor
	 */
	public X_M_ShipperPackagingInput(String ID) {
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
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	public void setM_Shipper(I_M_ShipperInput M_Shipper) {
		this.M_Shipper = M_Shipper;
		MShipper foreignEntity;
		if (get_ID() == 0 &&M_Shipper != null &&
				(foreignEntity = new Query(getCtx(), MShipper.Table_Name, MShipper.COLUMNNAME_M_Shipper_UU + "=?", get_TrxName())
						.setParameters(M_Shipper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Shipper_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public I_M_ShipperInput getM_Shipper() {
		return M_Shipper;
	}
	/**
	 * Set Shipper.
	 *
	 * @param M_Shipper_ID Method or manner of product delivery
	 */

	public void setM_Shipper_ID(int M_Shipper_ID) {
		if (get_ID() == 0) {
			super.setM_Shipper_ID(M_Shipper_ID);
		}
	}
	/**
	 * Set Shipper Packaging.
	 *
	 * @param M_ShipperPackaging_ID Shipper Packaging
	 */

	public void setM_ShipperPackaging_ID(int M_ShipperPackaging_ID) {
		if (get_ID() == 0) {
			super.setM_ShipperPackaging_ID(M_ShipperPackaging_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ShipperPackaging_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ShipperPackaging_UU();
	}

	/**
	 * Set Shipper Packaging Configuration.
	 *
	 * @param M_ShipperPackagingCfg Shipper Packaging Configuration
	 */
	public void setM_ShipperPackagingCfg(I_M_ShipperPackagingCfgInput M_ShipperPackagingCfg) {
		this.M_ShipperPackagingCfg = M_ShipperPackagingCfg;
		X_M_ShipperPackagingCfg foreignEntity;
		if (M_ShipperPackagingCfg != null &&
				(foreignEntity = new Query(getCtx(), X_M_ShipperPackagingCfg.Table_Name, X_M_ShipperPackagingCfg.COLUMNNAME_M_ShipperPackagingCfg_UU + "=?", get_TrxName())
						.setParameters(M_ShipperPackagingCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShipperPackagingCfg_ID(foreignEntity.get_ID());
		} else {
			this.setM_ShipperPackagingCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Packaging Configuration.
	 *
	 * @return Shipper Packaging Configuration
	 */
	public I_M_ShipperPackagingCfgInput getM_ShipperPackagingCfg() {
		return M_ShipperPackagingCfg;
	}
}
