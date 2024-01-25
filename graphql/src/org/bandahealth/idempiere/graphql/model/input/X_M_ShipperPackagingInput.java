package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperPackaging;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperPackagingCfg;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShipperPackaging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPackagingInput extends MShipperPackaging implements I_M_ShipperPackagingInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_ShipperPackagingCfg;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ShipperPackaging_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ShipperPackagingInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MShipperPackaging(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
							.setParameters(M_Shipper.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_ShipperPackaging_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_ShipperPackaging_UU();
	}

	/**
	 * Set Shipper Packaging Configuration.
	 *
	 * @param M_ShipperPackagingCfg Shipper Packaging Configuration
	 */
	@JsonProperty("M_ShipperPackagingCfg")
	public void setM_ShipperPackagingCfgInput(ForeignEntityInput M_ShipperPackagingCfg) {
		this.mM_ShipperPackagingCfg = M_ShipperPackagingCfg;
		if (M_ShipperPackagingCfg != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_ShipperPackagingCfg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShipperPackagingCfg", "M_ShipperPackagingCfg_UU=?", get_TrxName())
							.setParameters(M_ShipperPackagingCfg.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ShipperPackagingCfg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShipperPackagingCfg with UUID " + M_ShipperPackagingCfg.getUUID());
			}
		} else {
			this.setM_ShipperPackagingCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Packaging Configuration.
	 *
	 * @return Shipper Packaging Configuration
	 */
	@JsonProperty("M_ShipperPackagingCfg")
	public ForeignEntityInput M_ShipperPackagingCfg() {
		return mM_ShipperPackagingCfg;
	}
}
