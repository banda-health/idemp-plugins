package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.Query;
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
	 * Standard constructor
	 */
	@JsonCreator
	public X_DD_NetworkDistributionLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_DD_NetworkDistributionLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Network Distribution.
	 *
	 * @param DD_NetworkDistribution Network Distribution
	 */
	@JsonProperty("DD_NetworkDistribution")
	public void setDD_NetworkDistributionInput(ForeignEntityInput DD_NetworkDistribution) {
		this.mDD_NetworkDistribution = DD_NetworkDistribution;
		X_DD_NetworkDistribution foreignEntity;
		if (get_ID() == 0 && DD_NetworkDistribution != null &&
				(foreignEntity = new Query(getCtx(), "DD_NetworkDistribution", "DD_NetworkDistribution_UU=?", get_TrxName())
						.setParameters(DD_NetworkDistribution.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDD_NetworkDistribution_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setDD_NetworkDistributionLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MShipper foreignEntity;
		if (M_Shipper != null &&
				(foreignEntity = new Query(getCtx(), "M_Shipper", "M_Shipper_UU=?", get_TrxName())
						.setParameters(M_Shipper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Shipper_ID(foreignEntity.get_ID());
		} else {
			super.setM_Shipper_ID(0);
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
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			super.setM_Warehouse_ID(0);
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
		MWarehouse_BH foreignEntity;
		if (M_WarehouseSource != null &&
				(foreignEntity = new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
						.setParameters(M_WarehouseSource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_WarehouseSource_ID(foreignEntity.get_ID());
		} else {
			super.setM_WarehouseSource_ID(0);
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
