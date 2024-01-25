package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MConversionRate;
import org.compiere.model.MConversionType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for C_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Conversion_RateInput extends MConversionRate implements I_C_Conversion_RateInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ConversionType;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_Currency_To;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Conversion_Rate_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_Conversion_RateInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MConversionRate(null, (ResultSet) null, null),
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
	 * Set Conversion Rate.
	 *
	 * @param C_Conversion_Rate_ID Rate used for converting currencies
	 */

	public void setC_Conversion_Rate_ID(int C_Conversion_Rate_ID) {
		if (get_ID() == 0) {
			super.setC_Conversion_Rate_ID(C_Conversion_Rate_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Conversion_Rate_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_Conversion_Rate_UU();
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType) {
		this.mC_ConversionType = C_ConversionType;
		if (get_ID() != 0) {
			return;
		}
		if (C_ConversionType != null) {
			// Since an entity was passed, make sure it's in the DB
			MConversionType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
							.setParameters(C_ConversionType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_ConversionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UUID " + C_ConversionType.getUUID());
			}
		} else {
			this.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public ForeignEntityInput C_ConversionType() {
		return mC_ConversionType;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		if (get_ID() != 0) {
			return;
		}
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Currency To.
	 *
	 * @param C_Currency_To Target currency
	 */
	@JsonProperty("C_Currency_To")
	public void setC_Currency_ToInput(ForeignEntityInput C_Currency_To) {
		this.mC_Currency_To = C_Currency_To;
		if (get_ID() != 0) {
			return;
		}
		if (C_Currency_To != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency_To.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID_To(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency_To.getUUID());
			}
		} else {
			this.setC_Currency_ID_To(0);
		}
	}

	/**
	 * Get Currency To.
	 *
	 * @return Target currency
	 */
	@JsonProperty("C_Currency_To")
	public ForeignEntityInput C_Currency_To() {
		return mC_Currency_To;
	}
	/**
	 * Set Valid from.
	 *
	 * @param ValidFrom Valid from including this date (first day)
	 */

	public void setValidFrom(Timestamp ValidFrom) {
		if (get_ID() == 0) {
			super.setValidFrom(ValidFrom);
		}
	}
	/**
	 * Set Valid to.
	 *
	 * @param ValidTo Valid to including this date (last day)
	 */

	public void setValidTo(Timestamp ValidTo) {
		if (get_ID() == 0) {
			super.setValidTo(ValidTo);
		}
	}
}
