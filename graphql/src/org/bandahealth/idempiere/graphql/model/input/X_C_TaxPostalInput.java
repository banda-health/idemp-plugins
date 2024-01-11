package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTax;
import org.compiere.model.MTaxPostal;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_TaxPostal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxPostalInput extends MTaxPostal implements I_C_TaxPostalInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Tax;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_TaxPostalInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MTaxPostal(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	@JsonProperty("C_Tax")
	public void setC_TaxInput(ForeignEntityInput C_Tax) {
		this.mC_Tax = C_Tax;
		MTax foreignEntity;
		if (get_ID() == 0 && C_Tax != null &&
				(foreignEntity = new Query(getCtx(), "C_Tax", "C_Tax_UU=?", get_TrxName())
						.setParameters(C_Tax.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Tax_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	@JsonProperty("C_Tax")
	public ForeignEntityInput C_Tax() {
		return mC_Tax;
	}
	/**
	 * Set Tax ZIP.
	 *
	 * @param C_TaxPostal_ID Tax Postal/ZIP
	 */

	public void setC_TaxPostal_ID(int C_TaxPostal_ID) {
		if (get_ID() == 0) {
			super.setC_TaxPostal_ID(C_TaxPostal_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_TaxPostal_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_TaxPostal_UU();
	}
}
