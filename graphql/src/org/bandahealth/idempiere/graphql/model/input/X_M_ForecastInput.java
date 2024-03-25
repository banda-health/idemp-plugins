package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCalendar;
import org.compiere.model.MForecast;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ForecastInput extends MForecast implements I_M_ForecastInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Calendar;
	private ForeignEntityInput mC_Year;
	private ForeignEntityInput mM_PriceList;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Forecast_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ForecastInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
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
	 * Set Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public void setC_CalendarInput(ForeignEntityInput C_Calendar) {
		this.mC_Calendar = C_Calendar;
		if (get_ID() != 0) {
			return;
		}
		if (C_Calendar != null) {
			// Since an entity was passed, make sure it's in the DB
			MCalendar foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Calendar", "C_Calendar_UU=?", get_TrxName())
							.setParameters(C_Calendar.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Calendar_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Calendar with UUID " + C_Calendar.getUUID());
			}
		} else {
			this.setC_Calendar_ID(0);
		}
	}

	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public ForeignEntityInput C_Calendar() {
		return mC_Calendar;
	}

	/**
	 * Set Year.
	 *
	 * @param C_Year Calendar Year
	 */
	@JsonProperty("C_Year")
	public void setC_YearInput(ForeignEntityInput C_Year) {
		this.mC_Year = C_Year;
		if (get_ID() != 0) {
			return;
		}
		if (C_Year != null) {
			// Since an entity was passed, make sure it's in the DB
			MYear foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Year", "C_Year_UU=?", get_TrxName())
							.setParameters(C_Year.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Year_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Year with UUID " + C_Year.getUUID());
			}
		} else {
			this.setC_Year_ID(0);
		}
	}

	/**
	 * Get Year.
	 *
	 * @return Calendar Year
	 */
	@JsonProperty("C_Year")
	public ForeignEntityInput C_Year() {
		return mC_Year;
	}
	/**
	 * Set Forecast.
	 *
	 * @param M_Forecast_ID Material Forecast
	 */

	public void setM_Forecast_ID(int M_Forecast_ID) {
		if (get_ID() == 0) {
			super.setM_Forecast_ID(M_Forecast_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_Forecast_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_Forecast_UU();
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public void setM_PriceListInput(ForeignEntityInput M_PriceList) {
		this.mM_PriceList = M_PriceList;
		if (M_PriceList != null) {
			// Since an entity was passed, make sure it's in the DB
			MPriceList foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(M_PriceList.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UUID " + M_PriceList.getUUID());
			}
		} else {
			this.setM_PriceList_ID(0);
		}
	}

	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public ForeignEntityInput M_PriceList() {
		return mM_PriceList;
	}
}
