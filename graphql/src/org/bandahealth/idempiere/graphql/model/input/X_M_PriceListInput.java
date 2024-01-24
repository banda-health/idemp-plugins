package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PriceListInput extends MPriceList implements I_M_PriceListInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBasePriceList;
	private ForeignEntityInput mC_Currency;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_PriceListInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MPriceList(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Base Pricelist.
	 *
	 * @param BasePriceList Pricelist to be used, if product not found on this pricelist
	 */
	@JsonProperty("BasePriceList")
	public void setBasePriceListInput(ForeignEntityInput BasePriceList) {
		this.mBasePriceList = BasePriceList;
		MPriceList foreignEntity;
		if (BasePriceList != null &&
				(foreignEntity = new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
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
	public ForeignEntityInput BasePriceList() {
		return mBasePriceList;
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
	 * Set Price List.
	 *
	 * @param M_PriceList_ID Unique identifier of a Price List
	 */

	public void setM_PriceList_ID(int M_PriceList_ID) {
		if (get_ID() == 0) {
			super.setM_PriceList_ID(M_PriceList_ID);
		}
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
