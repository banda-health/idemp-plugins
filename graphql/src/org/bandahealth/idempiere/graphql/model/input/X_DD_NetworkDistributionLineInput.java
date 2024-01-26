package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_DD_NetworkDistribution;
import org.eevolution.model.X_DD_NetworkDistributionLine;

import java.sql.ResultSet;

/**
 * Generated Model for DD_NetworkDistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_NetworkDistributionLineInput extends X_DD_NetworkDistributionLine implements I_DD_NetworkDistributionLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mDD_NetworkDistribution;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mM_WarehouseSource;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The DD_NetworkDistributionLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_DD_NetworkDistributionLineInput(@JsonProperty("UUID") String UUID) {
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
	 * Set Network Distribution.
	 *
	 * @param DD_NetworkDistribution Network Distribution
	 */
	@JsonProperty("DD_NetworkDistribution")
	public void setDD_NetworkDistributionInput(ForeignEntityInput DD_NetworkDistribution) {
		this.mDD_NetworkDistribution = DD_NetworkDistribution;
		if (get_ID() != 0) {
			return;
		}
		if (DD_NetworkDistribution != null) {
			// Since an entity was passed, make sure it's in the DB
			X_DD_NetworkDistribution foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "DD_NetworkDistribution", "DD_NetworkDistribution_UU=?", get_TrxName())
							.setParameters(DD_NetworkDistribution.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDD_NetworkDistribution_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table DD_NetworkDistribution with UUID " + DD_NetworkDistribution.getUUID());
			}
		} else {
			this.setDD_NetworkDistribution_ID(0);
		}
	}

	/**
	 * Get Network Distribution.
	 *
	 * @return Network Distribution
	 */
	@JsonProperty("DD_NetworkDistribution")
	public ForeignEntityInput DD_NetworkDistribution() {
		return mDD_NetworkDistribution;
	}
	/**
	 * Set Network Distribution Line.
	 *
	 * @param DD_NetworkDistributionLine_ID Network Distribution Line
	 */

	public void setDD_NetworkDistributionLine_ID(int DD_NetworkDistributionLine_ID) {
		if (get_ID() == 0) {
			super.setDD_NetworkDistributionLine_ID(DD_NetworkDistributionLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setDD_NetworkDistributionLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getDD_NetworkDistributionLine_UU();
	}

	/**
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public void setM_ShipperInput(ForeignEntityInput M_Shipper) {
		this.mM_Shipper = M_Shipper;
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
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UUID " + M_Warehouse.getUUID());
			}
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public ForeignEntityInput M_Warehouse() {
		return mM_Warehouse;
	}

	/**
	 * Set Source Warehouse.
	 *
	 * @param M_WarehouseSource Optional Warehouse to replenish from
	 */
	@JsonProperty("M_WarehouseSource")
	public void setM_WarehouseSourceInput(ForeignEntityInput M_WarehouseSource) {
		this.mM_WarehouseSource = M_WarehouseSource;
		if (M_WarehouseSource != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_WarehouseSource.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_WarehouseSource_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UUID " + M_WarehouseSource.getUUID());
			}
		} else {
			this.setM_WarehouseSource_ID(0);
		}
	}

	/**
	 * Get Source Warehouse.
	 *
	 * @return Optional Warehouse to replenish from
	 */
	@JsonProperty("M_WarehouseSource")
	public ForeignEntityInput M_WarehouseSource() {
		return mM_WarehouseSource;
	}
}
