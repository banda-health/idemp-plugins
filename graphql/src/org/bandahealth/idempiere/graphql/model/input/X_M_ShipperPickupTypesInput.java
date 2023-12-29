package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperPickupTypes;
import org.compiere.model.X_M_ShipperPickupTypesCfg;
import org.compiere.util.Env;

/**
 * Generated Model for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPickupTypesInput extends X_M_ShipperPickupTypes implements I_M_ShipperPickupTypesInput {

	 private I_AD_OrgInput AD_Org;
	 private I_M_ShipperInput M_Shipper;
	 private I_M_ShipperPickupTypesCfgInput M_ShipperPickupTypesCfg;

	/**
	 * Standard constructor
	 */
	public X_M_ShipperPickupTypesInput(String ID) {
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
	 * Set Shipper Pickup Types.
	 *
	 * @param M_ShipperPickupTypes_ID Shipper Pickup Types
	 */

	public void setM_ShipperPickupTypes_ID(int M_ShipperPickupTypes_ID) {
		if (get_ID() == 0) {
			super.setM_ShipperPickupTypes_ID(M_ShipperPickupTypes_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ShipperPickupTypes_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ShipperPickupTypes_UU();
	}

	/**
	 * Set Shipper Pickup Types Configuration.
	 *
	 * @param M_ShipperPickupTypesCfg Shipper Pickup Types Configuration
	 */
	public void setM_ShipperPickupTypesCfg(I_M_ShipperPickupTypesCfgInput M_ShipperPickupTypesCfg) {
		this.M_ShipperPickupTypesCfg = M_ShipperPickupTypesCfg;
		X_M_ShipperPickupTypesCfg foreignEntity;
		if (M_ShipperPickupTypesCfg != null &&
				(foreignEntity = new Query(getCtx(), X_M_ShipperPickupTypesCfg.Table_Name, X_M_ShipperPickupTypesCfg.COLUMNNAME_M_ShipperPickupTypesCfg_UU + "=?", get_TrxName())
						.setParameters(M_ShipperPickupTypesCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShipperPickupTypesCfg_ID(foreignEntity.get_ID());
		} else {
			this.setM_ShipperPickupTypesCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Pickup Types Configuration.
	 *
	 * @return Shipper Pickup Types Configuration
	 */
	public I_M_ShipperPickupTypesCfgInput getM_ShipperPickupTypesCfg() {
		return M_ShipperPickupTypesCfg;
	}
}
