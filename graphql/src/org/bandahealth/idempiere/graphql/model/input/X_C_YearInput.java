package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCalendar;
import org.compiere.model.MOrg;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_YearInput extends MYear implements I_C_YearInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Calendar;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Year_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_YearInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MYear(null, (ResultSet) null, null),
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
							.setParameters(C_Calendar.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * @param C_Year_ID Calendar Year
	 */

	public void setC_Year_ID(int C_Year_ID) {
		if (get_ID() == 0) {
			super.setC_Year_ID(C_Year_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Year_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_Year_UU();
	}
}
