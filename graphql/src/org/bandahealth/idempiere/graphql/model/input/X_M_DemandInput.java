package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCalendar;
import org.compiere.model.MOrg;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.model.X_M_Demand;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Demand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DemandInput extends X_M_Demand implements I_M_DemandInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Calendar;
	private ForeignEntityInput mC_Year;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Demand_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_DemandInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
	 * @return Organizational entity within client
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
	 * Set Demand.
	 *
	 * @param M_Demand_ID Material Demand
	 */

	public void setM_Demand_ID(int M_Demand_ID) {
		if (get_ID() == 0) {
			super.setM_Demand_ID(M_Demand_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_Demand_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_Demand_UU();
	}
}
