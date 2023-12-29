package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocation;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_Warehouse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_WarehouseInput extends MWarehouse_BH implements I_M_WarehouseInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_LocationInput C_Location;
	 private I_M_LocatorInput M_ReserveLocator;
	 private I_M_WarehouseInput M_WarehouseSource;

	/**
	 * Standard constructor
	 */
	public X_M_WarehouseInput(String ID) {
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
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	public void setC_Location(I_C_LocationInput C_Location) {
		this.C_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null &&
				(foreignEntity = new Query(getCtx(), MLocation.Table_Name, MLocation.COLUMNNAME_C_Location_UU + "=?", get_TrxName())
						.setParameters(C_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public I_C_LocationInput getC_Location() {
		return C_Location;
	}

	/**
	 * Set Reservation Locator.
	 *
	 * @param M_ReserveLocator Reservation Locator (just for reporting purposes)
	 */
	public void setM_ReserveLocator(I_M_LocatorInput M_ReserveLocator) {
		this.M_ReserveLocator = M_ReserveLocator;
		MLocator foreignEntity;
		if (M_ReserveLocator != null &&
				(foreignEntity = new Query(getCtx(), MLocator.Table_Name, MLocator.COLUMNNAME_M_Locator_UU + "=?", get_TrxName())
						.setParameters(M_ReserveLocator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ReserveLocator_ID(foreignEntity.get_ID());
		} else {
			this.setM_ReserveLocator_ID(0);
		}
	}

	/**
	 * Get Reservation Locator.
	 *
	 * @return Reservation Locator (just for reporting purposes)
	 */
	public I_M_LocatorInput getM_ReserveLocator() {
		return M_ReserveLocator;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Warehouse_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Warehouse_UU();
	}

	/**
	 * Set Source Warehouse.
	 *
	 * @param M_WarehouseSource Optional Warehouse to replenish from
	 */
	public void setM_WarehouseSource(I_M_WarehouseInput M_WarehouseSource) {
		this.M_WarehouseSource = M_WarehouseSource;
		MWarehouse_BH foreignEntity;
		if (M_WarehouseSource != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_WarehouseSource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_WarehouseSource_ID(foreignEntity.get_ID());
		} else {
			this.setM_WarehouseSource_ID(0);
		}
	}

	/**
	 * Get Source Warehouse.
	 *
	 * @return Optional Warehouse to replenish from
	 */
	public I_M_WarehouseInput getM_WarehouseSource() {
		return M_WarehouseSource;
	}
}
