package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MForecast;
import org.compiere.model.MForecastLine;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ForecastLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ForecastLineInput extends MForecastLine implements I_M_ForecastLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Period;
	private ForeignEntityInput mM_Forecast;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mSalesRep;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ForecastLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ForecastLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MForecastLine(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		MPeriod foreignEntity;
		if (get_ID() == 0 && C_Period != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
							.setParameters(C_Period.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UUID " + C_Period.getUUID());
			}
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public ForeignEntityInput C_Period() {
		return mC_Period;
	}

	/**
	 * Set Forecast.
	 *
	 * @param M_Forecast Material Forecast
	 */
	@JsonProperty("M_Forecast")
	public void setM_ForecastInput(ForeignEntityInput M_Forecast) {
		this.mM_Forecast = M_Forecast;
		MForecast foreignEntity;
		if (get_ID() == 0 && M_Forecast != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Forecast", "M_Forecast_UU=?", get_TrxName())
							.setParameters(M_Forecast.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Forecast_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Forecast with UUID " + M_Forecast.getUUID());
			}
		}
	}

	/**
	 * Get Forecast.
	 *
	 * @return Material Forecast
	 */
	@JsonProperty("M_Forecast")
	public ForeignEntityInput M_Forecast() {
		return mM_Forecast;
	}
	/**
	 * Set Forecast Line.
	 *
	 * @param M_ForecastLine_ID Forecast Line
	 */

	public void setM_ForecastLine_ID(int M_ForecastLine_ID) {
		if (get_ID() == 0) {
			super.setM_ForecastLine_ID(M_ForecastLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_ForecastLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_ForecastLine_UU();
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 && M_Product != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
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
		if (M_Warehouse != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UUID " + M_Warehouse.getUUID());
			}
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
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + SalesRep.getUUID());
			}
		} else {
			super.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public ForeignEntityInput SalesRep() {
		return mSalesRep;
	}
}
