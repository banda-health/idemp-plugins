package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Payroll;
import org.eevolution.model.X_HR_Year;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_YearInput extends X_HR_Year implements I_HR_YearInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Year;
	private ForeignEntityInput mHR_Payroll;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The HR_Year_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_YearInput(@JsonProperty("UUID") String UUID) {
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set Year.
	 *
	 * @param C_Year Calendar Year
	 */
	@JsonProperty("C_Year")
	public void setC_YearInput(ForeignEntityInput C_Year) {
		this.mC_Year = C_Year;
		if (C_Year != null) {
			// Since an entity was passed, make sure it's in the DB
			MYear foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Year", "C_Year_UU=?", get_TrxName())
							.setParameters(C_Year.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set Payroll.
	 *
	 * @param HR_Payroll Payroll
	 */
	@JsonProperty("HR_Payroll")
	public void setHR_PayrollInput(ForeignEntityInput HR_Payroll) {
		this.mHR_Payroll = HR_Payroll;
		if (get_ID() != 0) {
			return;
		}
		if (HR_Payroll != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Payroll foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Payroll", "HR_Payroll_UU=?", get_TrxName())
							.setParameters(HR_Payroll.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Payroll_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Payroll with UUID " + HR_Payroll.getUUID());
			}
		} else {
			this.setHR_Payroll_ID(0);
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
	 * Set Payroll Year.
	 *
	 * @param HR_Year_ID Payroll Year
	 */

	public void setHR_Year_ID(int HR_Year_ID) {
		if (get_ID() == 0) {
			super.setHR_Year_ID(HR_Year_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setHR_Year_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getHR_Year_UU();
	}
}
