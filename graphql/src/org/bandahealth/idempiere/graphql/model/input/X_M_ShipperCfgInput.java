package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShippingProcessorCfg;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShipperCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperCfgInput extends X_M_ShipperCfg implements I_M_ShipperCfgInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_ShippingProcessorCfg;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ShipperCfg_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ShipperCfgInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_ShipperCfg_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_ShipperCfg_UU();
	}

	/**
	 * Set Shipping Processor Configuration.
	 *
	 * @param M_ShippingProcessorCfg Shipping Processor Configuration
	 */
	@JsonProperty("M_ShippingProcessorCfg")
	public void setM_ShippingProcessorCfgInput(ForeignEntityInput M_ShippingProcessorCfg) {
		this.mM_ShippingProcessorCfg = M_ShippingProcessorCfg;
		if (M_ShippingProcessorCfg != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_ShippingProcessorCfg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShippingProcessorCfg", "M_ShippingProcessorCfg_UU=?", get_TrxName())
							.setParameters(M_ShippingProcessorCfg.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ShippingProcessorCfg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShippingProcessorCfg with UUID " + M_ShippingProcessorCfg.getUUID());
			}
		} else {
			this.setM_ShippingProcessorCfg_ID(0);
		}
	}

	/**
	 * Get Shipping Processor Configuration.
	 *
	 * @return Shipping Processor Configuration
	 */
	@JsonProperty("M_ShippingProcessorCfg")
	public ForeignEntityInput M_ShippingProcessorCfg() {
		return mM_ShippingProcessorCfg;
	}
}
