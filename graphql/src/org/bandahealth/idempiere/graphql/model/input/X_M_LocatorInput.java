package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocator;
import org.compiere.model.MLocatorType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LocatorInput extends MLocator implements I_M_LocatorInput {

	 private I_AD_OrgInput AD_Org;
	 private I_M_LocatorTypeInput M_LocatorType;
	 private I_M_WarehouseInput M_Warehouse;

	/**
	 * Standard constructor
	 */
	public X_M_LocatorInput(String ID) {
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Locator_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Locator_UU();
	}

	/**
	 * Set Locator Type.
	 *
	 * @param M_LocatorType Locator Type
	 */
	public void setM_LocatorType(I_M_LocatorTypeInput M_LocatorType) {
		this.M_LocatorType = M_LocatorType;
		MLocatorType foreignEntity;
		if (M_LocatorType != null &&
				(foreignEntity = new Query(getCtx(), MLocatorType.Table_Name, MLocatorType.COLUMNNAME_M_LocatorType_UU + "=?", get_TrxName())
						.setParameters(M_LocatorType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_LocatorType_ID(foreignEntity.get_ID());
		} else {
			this.setM_LocatorType_ID(0);
		}
	}

	/**
	 * Get Locator Type.
	 *
	 * @return Locator Type
	 */
	public I_M_LocatorTypeInput getM_LocatorType() {
		return M_LocatorType;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	public void setM_Warehouse(I_M_WarehouseInput M_Warehouse) {
		this.M_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (get_ID() == 0 &&M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Warehouse_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public I_M_WarehouseInput getM_Warehouse() {
		return M_Warehouse;
	}
}
