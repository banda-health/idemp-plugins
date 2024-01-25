package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Role_WarehouseAccess_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Role_WarehouseAccessInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MBHRoleWarehouseAccess(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Role != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Role foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(AD_Role.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UUID " + AD_Role.getUUID());
			}
		} else {
			this.setAD_Role_ID(0);
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
		if (BH_Role_WarehouseAccess != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHRoleWarehouseAccess foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Role_WarehouseAccess", "BH_Role_WarehouseAccess_UU=?", get_TrxName())
							.setParameters(BH_Role_WarehouseAccess.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBH_Role_WarehouseAccess_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Role_WarehouseAccess with UUID " + BH_Role_WarehouseAccess.getUUID());
			}
		} else {
			this.setBH_Role_WarehouseAccess_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_Role_WarehouseAccess_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
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
}
