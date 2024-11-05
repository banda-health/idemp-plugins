package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocation;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Warehouse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_WarehouseInput extends MWarehouse_BH implements I_M_WarehouseInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Location;
	private ForeignEntityInput mM_ReserveLocator;
	private ForeignEntityInput mM_WarehouseSource;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_Warehouse_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_WarehouseInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	@JsonProperty("C_Location")
	public void setC_LocationInput(ForeignEntityInput C_Location) {
		this.mC_Location = C_Location;
		if (C_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(C_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UU " + C_Location.getUU());
			}
		} else {
			this.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	@JsonProperty("C_Location")
	public ForeignEntityInput C_Location() {
		return mC_Location;
	}

	/**
	 * Set Reservation Locator.
	 *
	 * @param M_ReserveLocator Reservation Locator (just for reporting purposes)
	 */
	@JsonProperty("M_ReserveLocator")
	public void setM_ReserveLocatorInput(ForeignEntityInput M_ReserveLocator) {
		this.mM_ReserveLocator = M_ReserveLocator;
		if (M_ReserveLocator != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocator foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
							.setParameters(M_ReserveLocator.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_ReserveLocator_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Locator with UU " + M_ReserveLocator.getUU());
			}
		} else {
			this.setM_ReserveLocator_ID(0);
		}
	}

	/**
	 * Get Reservation Locator.
	 *
	 * @return Reservation Locator (just for reporting purposes)
	 */
	@JsonProperty("M_ReserveLocator")
	public ForeignEntityInput M_ReserveLocator() {
		return mM_ReserveLocator;
	}
	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse_ID Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse_ID")
	public void setM_Warehouse_IDFromJson(int M_Warehouse_ID) {
		if (get_ID() == 0) {
			super.setM_Warehouse_ID(M_Warehouse_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_Warehouse_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_Warehouse_UU();
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
							.setParameters(M_WarehouseSource.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_WarehouseSource_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UU " + M_WarehouseSource.getUU());
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
