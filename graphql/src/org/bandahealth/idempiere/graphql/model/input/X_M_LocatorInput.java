package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocator;
import org.compiere.model.MLocatorType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_LocatorInput extends MLocator implements I_M_LocatorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_LocatorType;
	private ForeignEntityInput mM_Warehouse;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_Locator_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_LocatorInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Locator.
	 *
	 * @param M_Locator_ID Warehouse Locator
	 */
	@JsonProperty("M_Locator_ID")
	public void setM_Locator_IDFromJson(int M_Locator_ID) {
		if (get_ID() == 0) {
			super.setM_Locator_ID(M_Locator_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_Locator_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (M_LocatorType != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocatorType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_LocatorType", "M_LocatorType_UU=?", get_TrxName())
							.setParameters(M_LocatorType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_LocatorType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_LocatorType with UU " + M_LocatorType.getUU());
			}
		} else {
			this.setM_LocatorType_ID(0);
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
		if (!is_new()) {
			return;
		}
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UU " + M_Warehouse.getUU());
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
