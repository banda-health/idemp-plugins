package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCurrency;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.model.X_M_PriceList;
import org.compiere.util.Env;

/**
 * Generated Model for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PriceListInput extends X_M_PriceList implements I_M_PriceListInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_CurrencyInput C_Currency;
	 private I_M_PriceListInput BasePriceList;

	/**
	 * Standard constructor
	 */
	public X_M_PriceListInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Base Pricelist.
	 *
	 * @param BasePriceList Pricelist to be used, if product not found on this pricelist
	 */
	public void setBasePriceList(I_M_PriceListInput BasePriceList) {
		this.BasePriceList = BasePriceList;
		MPriceList foreignEntity;
		if (BasePriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(BasePriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBasePriceList_ID(foreignEntity.get_ID());
		} else {
			this.setBasePriceList_ID(0);
		}
	}

	/**
	 * Get Base Pricelist.
	 *
	 * @return Pricelist to be used, if product not found on this pricelist
	 */
	public I_M_PriceListInput getBasePriceList() {
		return BasePriceList;
	}
	/**
	 * Set Base Pricelist.
	 *
	 * @param BasePriceList_ID Pricelist to be used, if product not found on this pricelist
	 */

	public void setBasePriceList_ID(int BasePriceList_ID) {
		if (get_ID() == 0) {
			super.setBasePriceList_ID(BasePriceList_ID);
		}
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
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
