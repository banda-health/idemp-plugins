package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShipperPackagingCfg;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShipperPackagingCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPackagingCfgInput extends X_M_ShipperPackagingCfg implements I_M_ShipperPackagingCfgInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_ShipperCfg;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ShipperPackagingCfg_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ShipperPackagingCfgInput(@JsonProperty("UUID") String UUID) {
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Shipper Configuration.
	 *
	 * @param M_ShipperCfg Shipper Configuration
	 */
	@JsonProperty("M_ShipperCfg")
	public void setM_ShipperCfgInput(ForeignEntityInput M_ShipperCfg) {
		this.mM_ShipperCfg = M_ShipperCfg;
		if (get_ID() != 0) {
			return;
		}
		if (M_ShipperCfg != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_ShipperCfg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShipperCfg", "M_ShipperCfg_UU=?", get_TrxName())
							.setParameters(M_ShipperCfg.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_ShipperCfg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShipperCfg with UUID " + M_ShipperCfg.getUUID());
			}
		} else {
			this.setM_ShipperCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	@JsonProperty("M_ShipperCfg")
	public ForeignEntityInput M_ShipperCfg() {
		return mM_ShipperCfg;
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_ShipperPackagingCfg_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_ShipperPackagingCfg_UU();
	}
}
