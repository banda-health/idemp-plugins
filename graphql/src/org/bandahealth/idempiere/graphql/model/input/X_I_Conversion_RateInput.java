package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MConversionRate;
import org.compiere.model.MConversionType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_I_Conversion_Rate;

import java.sql.ResultSet;

/**
 * Generated Model for I_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_Conversion_RateInput extends X_I_Conversion_Rate implements I_I_Conversion_RateInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ConversionType;
	private ForeignEntityInput mC_Conversion_Rate;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_Currency_To;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_I_Conversion_RateInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_I_Conversion_Rate(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
	 * @param C_Conversion_Rate Rate used for converting currencies
	 */
	@JsonProperty("C_Conversion_Rate")
	public void setC_Conversion_RateInput(ForeignEntityInput C_Conversion_Rate) {
		this.mC_Conversion_Rate = C_Conversion_Rate;
		MConversionRate foreignEntity;
		if (C_Conversion_Rate != null &&
				(foreignEntity = new Query(getCtx(), "C_Conversion_Rate", "C_Conversion_Rate_UU=?", get_TrxName())
						.setParameters(C_Conversion_Rate.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Conversion_Rate_ID(foreignEntity.get_ID());
		} else {
			super.setC_Conversion_Rate_ID(0);
		}
	}

	/**
	 * Get Conversion Rate.
	 *
	 * @return Rate used for converting currencies
	 */
	@JsonProperty("C_Conversion_Rate")
	public ForeignEntityInput C_Conversion_Rate() {
		return mC_Conversion_Rate;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType) {
		this.mC_ConversionType = C_ConversionType;
		MConversionType foreignEntity;
		if (C_ConversionType != null &&
				(foreignEntity = new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
						.setParameters(C_ConversionType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ConversionType_ID(foreignEntity.get_ID());
		} else {
			super.setC_ConversionType_ID(0);
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
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID(0);
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
		MCurrency_BH foreignEntity;
		if (C_Currency_To != null &&
				(foreignEntity = new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
						.setParameters(C_Currency_To.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID_To(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID_To(0);
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
	 * Set Import Conversion Rate.
	 *
	 * @param I_Conversion_Rate_ID Import Currency Conversion Rate
	 */

	public void setI_Conversion_Rate_ID(int I_Conversion_Rate_ID) {
		if (get_ID() == 0) {
			super.setI_Conversion_Rate_ID(I_Conversion_Rate_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setI_Conversion_Rate_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getI_Conversion_Rate_UU();
	}
}
