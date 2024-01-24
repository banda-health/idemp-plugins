package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Payroll;
import org.eevolution.model.X_HR_Period;
import org.eevolution.model.X_HR_Year;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_PeriodInput extends X_HR_Period implements I_HR_PeriodInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Period;
	private ForeignEntityInput mC_Year;
	private ForeignEntityInput mHR_Payroll;
	private ForeignEntityInput mHR_Year;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The HR_Period_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_PeriodInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_HR_Period(null, (ResultSet) null, null),
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
		if (C_Period != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
							.setParameters(C_Period.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UUID " + C_Period.getUUID());
			}
		} else {
			super.setC_Period_ID(0);
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
	 * Set Year.
	 *
	 * @param C_Year Calendar Year
	 */
	@JsonProperty("C_Year")
	public void setC_YearInput(ForeignEntityInput C_Year) {
		this.mC_Year = C_Year;
		MYear foreignEntity;
		if (C_Year != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Year", "C_Year_UU=?", get_TrxName())
							.setParameters(C_Year.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Year_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Year with UUID " + C_Year.getUUID());
			}
		} else {
			super.setC_Year_ID(0);
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
	 * Set Payroll.
	 *
	 * @param HR_Payroll Payroll
	 */
	@JsonProperty("HR_Payroll")
	public void setHR_PayrollInput(ForeignEntityInput HR_Payroll) {
		this.mHR_Payroll = HR_Payroll;
		X_HR_Payroll foreignEntity;
		if (HR_Payroll != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "HR_Payroll", "HR_Payroll_UU=?", get_TrxName())
							.setParameters(HR_Payroll.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Payroll_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Payroll with UUID " + HR_Payroll.getUUID());
			}
		} else {
			super.setHR_Payroll_ID(0);
		}
	}

	/**
	 * Get Payroll.
	 *
	 * @return Payroll
	 */
	@JsonProperty("HR_Payroll")
	public ForeignEntityInput HR_Payroll() {
		return mHR_Payroll;
	}
	/**
	 * Set Payroll Period.
	 *
	 * @param HR_Period_ID Payroll Period
	 */

	public void setHR_Period_ID(int HR_Period_ID) {
		if (get_ID() == 0) {
			super.setHR_Period_ID(HR_Period_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setHR_Period_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getHR_Period_UU();
	}

	/**
	 * Set Payroll Year.
	 *
	 * @param HR_Year Payroll Year
	 */
	@JsonProperty("HR_Year")
	public void setHR_YearInput(ForeignEntityInput HR_Year) {
		this.mHR_Year = HR_Year;
		X_HR_Year foreignEntity;
		if (get_ID() == 0 && HR_Year != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "HR_Year", "HR_Year_UU=?", get_TrxName())
							.setParameters(HR_Year.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Year_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Year with UUID " + HR_Year.getUUID());
			}
		}
	}

	/**
	 * Get Payroll Year.
	 *
	 * @return Payroll Year
	 */
	@JsonProperty("HR_Year")
	public ForeignEntityInput HR_Year() {
		return mHR_Year;
	}
}
