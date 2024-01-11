package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_Currency - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CurrencyInput extends MCurrency_BH implements I_C_CurrencyInput {

	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_CurrencyInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MCurrency_BH(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Currency.
	 *
	 * @param C_Currency_ID The Currency for this record
	 */

	public void setC_Currency_ID(int C_Currency_ID) {
		if (get_ID() == 0) {
			super.setC_Currency_ID(C_Currency_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Currency_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Currency_UU();
	}
}
