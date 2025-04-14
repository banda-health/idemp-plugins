package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_PeriodResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PeriodInput extends MPeriod implements I_C_PeriodInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Year;
	private ForeignEntityInput mPeriodType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_Period_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PeriodInput(@JsonProperty("UU") String UU) {
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
	 * Set Period.
	 *
	 * @param C_Period_ID Period of the Calendar
	 */
	@JsonProperty("C_Period_ID")
	public void setC_Period_IDFromJson(int C_Period_ID) {
		if (get_ID() == 0) {
			super.setC_Period_ID(C_Period_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_Period_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_Period_UU();
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
							.setParameters(C_Year.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Year_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Year with UU " + C_Year.getUU());
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
	 * Set Period Type.
	 *
	 * @param PeriodType Period Type
	 */
	@JsonProperty("PeriodType")
	public void setPeriodTypeInput(ForeignEntityInput PeriodType) {
		this.mPeriodType = PeriodType;
		if (get_ID() != 0) {
			return;
		}
		if (PeriodType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PeriodResolver.PERIODTYPE_UUIDS_BY_VALUE.containsValue(PeriodType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PeriodType.getUU() +
						" is not in the list defined for the PeriodType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PeriodType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPeriodType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PeriodType.getUU());
			}
		} else {
			this.setPeriodType(null);
		}
	}

	/**
	 * Get Period Type.
	 *
	 * @return Period Type
	 */
	@JsonProperty("PeriodType")
	public ForeignEntityInput PeriodType() {
		return mPeriodType;
	}
}
