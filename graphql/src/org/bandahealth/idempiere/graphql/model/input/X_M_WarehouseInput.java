package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

	 private I_AD_OrgInput mAD_Org;
	 private I_C_LocationInput mC_Location;
	 private I_M_LocatorInput mM_ReserveLocator;
	 private I_M_WarehouseInput mM_WarehouseSource;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_WarehouseInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	@JsonProperty("C_Location")
	public void setC_LocationInput(I_C_LocationInput C_Location) {
		this.mC_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null &&
				(foreignEntity = new Query(getCtx(), MLocation.Table_Name, MLocation.COLUMNNAME_C_Location_UU + "=?", get_TrxName())
						.setParameters(C_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	@JsonProperty("C_Location")
	public I_C_LocationInput C_Location() {
		return mC_Location;
	}

	/**
	 * Set Reservation Locator.
	 *
	 * @param M_ReserveLocator Reservation Locator (just for reporting purposes)
	 */
	@JsonProperty("M_ReserveLocator")
	public void setM_ReserveLocatorInput(I_M_LocatorInput M_ReserveLocator) {
		this.mM_ReserveLocator = M_ReserveLocator;
		MLocator foreignEntity;
		if (M_ReserveLocator != null &&
				(foreignEntity = new Query(getCtx(), MLocator.Table_Name, MLocator.COLUMNNAME_M_Locator_UU + "=?", get_TrxName())
						.setParameters(M_ReserveLocator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ReserveLocator_ID(foreignEntity.get_ID());
		} else {
			super.setM_ReserveLocator_ID(0);
		}
	}

	/**
	 * Get Reservation Locator.
	 *
	 * @return Reservation Locator (just for reporting purposes)
	 */
	@JsonProperty("M_ReserveLocator")
	public I_M_LocatorInput M_ReserveLocator() {
		return mM_ReserveLocator;
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
	@JsonProperty("M_WarehouseSource")
	public void setM_WarehouseSourceInput(I_M_WarehouseInput M_WarehouseSource) {
		this.mM_WarehouseSource = M_WarehouseSource;
		MWarehouse_BH foreignEntity;
		if (M_WarehouseSource != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
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
	public I_M_WarehouseInput M_WarehouseSource() {
		return mM_WarehouseSource;
	}
}
