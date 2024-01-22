package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Role_WarehouseAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Role_WarehouseAccessInput extends MBHRoleWarehouseAccess implements I_BH_Role_WarehouseAccessInput {

	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mBH_Role_WarehouseAccess;
	private ForeignEntityInput mM_Warehouse;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_Role_WarehouseAccessInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHRoleWarehouseAccess(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (get_ID() == 0 && AD_Role != null &&
				(foreignEntity = new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public ForeignEntityInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set BH_Role_WarehouseAccess_ID.
	 *
	 * @param BH_Role_WarehouseAccess BH_Role_WarehouseAccess_ID
	 */
	@JsonProperty("BH_Role_WarehouseAccess")
	public void setBH_Role_WarehouseAccessInput(ForeignEntityInput BH_Role_WarehouseAccess) {
		this.mBH_Role_WarehouseAccess = BH_Role_WarehouseAccess;
		MBHRoleWarehouseAccess foreignEntity;
		if (BH_Role_WarehouseAccess != null &&
				(foreignEntity = new Query(getCtx(), "BH_Role_WarehouseAccess", "BH_Role_WarehouseAccess_UU=?", get_TrxName())
						.setParameters(BH_Role_WarehouseAccess.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_Role_WarehouseAccess_ID(foreignEntity.get_ID());
		} else {
			super.setBH_Role_WarehouseAccess_ID(0);
		}
	}

	/**
	 * Get BH_Role_WarehouseAccess_ID.
	 *
	 * @return BH_Role_WarehouseAccess_ID
	 */
	@JsonProperty("BH_Role_WarehouseAccess")
	public ForeignEntityInput BH_Role_WarehouseAccess() {
		return mBH_Role_WarehouseAccess;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_Role_WarehouseAccess_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_Role_WarehouseAccess_UU();
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
