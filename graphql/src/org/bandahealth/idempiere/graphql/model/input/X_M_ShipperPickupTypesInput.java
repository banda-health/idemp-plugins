package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperPickupTypes;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperPickupTypesCfg;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperPickupTypesInput extends MShipperPickupTypes implements I_M_ShipperPickupTypesInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_ShipperPickupTypesCfg;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ShipperPickupTypes_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ShipperPickupTypesInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
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
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public void setM_ShipperInput(ForeignEntityInput M_Shipper) {
		this.mM_Shipper = M_Shipper;
		if (get_ID() != 0) {
			return;
		}
		if (M_Shipper != null) {
			// Since an entity was passed, make sure it's in the DB
			MShipper foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Shipper", "M_Shipper_UU=?", get_TrxName())
							.setParameters(M_Shipper.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Shipper_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Shipper with UUID " + M_Shipper.getUUID());
			}
		} else {
			this.setM_Shipper_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_ShipperPickupTypes_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (M_ShipperPickupTypesCfg != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_ShipperPickupTypesCfg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShipperPickupTypesCfg", "M_ShipperPickupTypesCfg_UU=?", get_TrxName())
							.setParameters(M_ShipperPickupTypesCfg.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_ShipperPickupTypesCfg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShipperPickupTypesCfg with UUID " + M_ShipperPickupTypesCfg.getUUID());
			}
		} else {
			this.setM_ShipperPickupTypesCfg_ID(0);
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
