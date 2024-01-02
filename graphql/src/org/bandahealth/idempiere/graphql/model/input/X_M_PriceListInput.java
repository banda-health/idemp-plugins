package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PriceListInput extends MPriceList implements I_M_PriceListInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_C_CurrencyInput mC_Currency;
	 private I_M_PriceListInput mBasePriceList;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_PriceListInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Base Pricelist.
	 *
	 * @param BasePriceList Pricelist to be used, if product not found on this pricelist
	 */
	@JsonProperty("BasePriceList")
	public void setBasePriceListInput(I_M_PriceListInput BasePriceList) {
		this.mBasePriceList = BasePriceList;
		MPriceList foreignEntity;
		if (BasePriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(BasePriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBasePriceList_ID(foreignEntity.get_ID());
		} else {
			super.setBasePriceList_ID(0);
		}
	}

	/**
	 * Get Base Pricelist.
	 *
	 * @return Pricelist to be used, if product not found on this pricelist
	 */
	@JsonProperty("BasePriceList")
	public I_M_PriceListInput BasePriceList() {
		return mBasePriceList;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(I_C_CurrencyInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency_BH.Table_Name, MCurrency_BH.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
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
	public I_C_CurrencyInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_PriceList_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_PriceList_UU();
	}
}
