package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocator;
import org.compiere.model.MLocatorType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_LocatorInput extends MLocator implements I_M_LocatorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_LocatorType;
	private ForeignEntityInput mM_Warehouse;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_LocatorInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MLocator(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Locator.
	 *
	 * @param M_Locator_ID Warehouse Locator
	 */

	public void setM_Locator_ID(int M_Locator_ID) {
		if (get_ID() == 0) {
			super.setM_Locator_ID(M_Locator_ID);
		}
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
	@JsonProperty("M_LocatorType")
	public void setM_LocatorTypeInput(ForeignEntityInput M_LocatorType) {
		this.mM_LocatorType = M_LocatorType;
		MLocatorType foreignEntity;
		if (M_LocatorType != null &&
				(foreignEntity = new Query(getCtx(), "M_LocatorType", "M_LocatorType_UU=?", get_TrxName())
						.setParameters(M_LocatorType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_LocatorType_ID(foreignEntity.get_ID());
		} else {
			super.setM_LocatorType_ID(0);
		}
	}

	/**
	 * Get Locator Type.
	 *
	 * @return Locator Type
	 */
	@JsonProperty("M_LocatorType")
	public ForeignEntityInput M_LocatorType() {
		return mM_LocatorType;
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
		if (get_ID() == 0 && M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Warehouse_ID(foreignEntity.get_ID());
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
}
