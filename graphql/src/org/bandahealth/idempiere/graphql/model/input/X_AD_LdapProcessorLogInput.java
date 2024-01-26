package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLdapProcessor;
import org.compiere.model.MLdapProcessorLog;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_LdapProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LdapProcessorLogInput extends MLdapProcessorLog implements I_AD_LdapProcessorLogInput {

	private ForeignEntityInput mAD_LdapProcessor;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_LdapProcessorLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_LdapProcessorLogInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Ldap Processor.
	 *
	 * @param AD_LdapProcessor LDAP Server to authenticate and authorize external systems based on iDempiere
	 */
	@JsonProperty("AD_LdapProcessor")
	public void setAD_LdapProcessorInput(ForeignEntityInput AD_LdapProcessor) {
		this.mAD_LdapProcessor = AD_LdapProcessor;
		if (get_ID() != 0) {
			return;
		}
		if (AD_LdapProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			MLdapProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_LdapProcessor", "AD_LdapProcessor_UU=?", get_TrxName())
							.setParameters(AD_LdapProcessor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_LdapProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_LdapProcessor with UUID " + AD_LdapProcessor.getUUID());
			}
		} else {
			this.setAD_LdapProcessor_ID(0);
		}
	}

	/**
	 * Get Ldap Processor.
	 *
	 * @return LDAP Server to authenticate and authorize external systems based on iDempiere
	 */
	@JsonProperty("AD_LdapProcessor")
	public ForeignEntityInput AD_LdapProcessor() {
		return mAD_LdapProcessor;
	}
	/**
	 * Set Ldap Processor Log.
	 *
	 * @param AD_LdapProcessorLog_ID LDAP Server Log
	 */

	public void setAD_LdapProcessorLog_ID(int AD_LdapProcessorLog_ID) {
		if (get_ID() == 0) {
			super.setAD_LdapProcessorLog_ID(AD_LdapProcessorLog_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_LdapProcessorLog_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_LdapProcessorLog_UU();
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
}
