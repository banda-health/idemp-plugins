package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTaxProvider;
import org.compiere.model.Query;
import org.compiere.model.X_C_TaxProviderCfg;
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_TaxProvider_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_TaxProviderInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MTaxProvider(null, (ResultSet) null, null),
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_TaxProvider_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (C_TaxProviderCfg != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_TaxProviderCfg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxProviderCfg", "C_TaxProviderCfg_UU=?", get_TrxName())
							.setParameters(C_TaxProviderCfg.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_TaxProviderCfg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxProviderCfg with UUID " + C_TaxProviderCfg.getUUID());
			}
		} else {
			this.setC_TaxProviderCfg_ID(0);
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
