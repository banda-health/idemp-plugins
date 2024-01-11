package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTaxProvider;
import org.compiere.model.Query;
import org.compiere.model.X_C_TaxProviderCfg;

import java.sql.ResultSet;

/**
 * Generated Model for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxProviderInput extends MTaxProvider implements I_C_TaxProviderInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_TaxProviderCfg;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_TaxProviderInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MTaxProvider(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Tax Provider.
	 *
	 * @param C_TaxProvider_ID Tax Provider
	 */

	public void setC_TaxProvider_ID(int C_TaxProvider_ID) {
		if (get_ID() == 0) {
			super.setC_TaxProvider_ID(C_TaxProvider_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_TaxProvider_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_TaxProvider_UU();
	}

	/**
	 * Set Tax Provider Configuration.
	 *
	 * @param C_TaxProviderCfg Tax Provider Configuration
	 */
	@JsonProperty("C_TaxProviderCfg")
	public void setC_TaxProviderCfgInput(ForeignEntityInput C_TaxProviderCfg) {
		this.mC_TaxProviderCfg = C_TaxProviderCfg;
		X_C_TaxProviderCfg foreignEntity;
		if (C_TaxProviderCfg != null &&
				(foreignEntity = new Query(getCtx(), "C_TaxProviderCfg", "C_TaxProviderCfg_UU=?", get_TrxName())
						.setParameters(C_TaxProviderCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_TaxProviderCfg_ID(foreignEntity.get_ID());
		} else {
			super.setC_TaxProviderCfg_ID(0);
		}
	}

	/**
	 * Get Tax Provider Configuration.
	 *
	 * @return Tax Provider Configuration
	 */
	@JsonProperty("C_TaxProviderCfg")
	public ForeignEntityInput C_TaxProviderCfg() {
		return mC_TaxProviderCfg;
	}
}
