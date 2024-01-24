package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperPickupTypes;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperPickupTypesCfg;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShipperPickupTypesInput extends MShipperPickupTypes implements I_M_ShipperPickupTypesInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_ShipperPickupTypesCfg;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_ShipperPickupTypesInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MShipperPickupTypes(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public void setM_ShipperInput(ForeignEntityInput M_Shipper) {
		this.mM_Shipper = M_Shipper;
		MShipper foreignEntity;
		if (get_ID() == 0 && M_Shipper != null &&
				(foreignEntity = new Query(getCtx(), "M_Shipper", "M_Shipper_UU=?", get_TrxName())
						.setParameters(M_Shipper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Shipper_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public ForeignEntityInput M_Shipper() {
		return mM_Shipper;
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
	@JsonProperty("M_ShipperPickupTypesCfg")
	public void setM_ShipperPickupTypesCfgInput(ForeignEntityInput M_ShipperPickupTypesCfg) {
		this.mM_ShipperPickupTypesCfg = M_ShipperPickupTypesCfg;
		X_M_ShipperPickupTypesCfg foreignEntity;
		if (M_ShipperPickupTypesCfg != null &&
				(foreignEntity = new Query(getCtx(), "M_ShipperPickupTypesCfg", "M_ShipperPickupTypesCfg_UU=?", get_TrxName())
						.setParameters(M_ShipperPickupTypesCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShipperPickupTypesCfg_ID(foreignEntity.get_ID());
		} else {
			super.setM_ShipperPickupTypesCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Pickup Types Configuration.
	 *
	 * @return Shipper Pickup Types Configuration
	 */
	@JsonProperty("M_ShipperPickupTypesCfg")
	public ForeignEntityInput M_ShipperPickupTypesCfg() {
		return mM_ShipperPickupTypesCfg;
	}
}
