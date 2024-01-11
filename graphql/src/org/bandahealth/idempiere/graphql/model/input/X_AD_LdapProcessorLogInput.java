package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLdapProcessor;
import org.compiere.model.MLdapProcessorLog;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_LdapProcessorLogInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MLdapProcessorLog(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Ldap Processor.
	 *
	 * @param AD_LdapProcessor LDAP Server to authenticate and authorize external systems based on iDempiere
	 */
	@JsonProperty("AD_LdapProcessor")
	public void setAD_LdapProcessorInput(ForeignEntityInput AD_LdapProcessor) {
		this.mAD_LdapProcessor = AD_LdapProcessor;
		MLdapProcessor foreignEntity;
		if (get_ID() == 0 && AD_LdapProcessor != null &&
				(foreignEntity = new Query(getCtx(), "AD_LdapProcessor", "AD_LdapProcessor_UU=?", get_TrxName())
						.setParameters(AD_LdapProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_LdapProcessor_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_LdapProcessorLog_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
}
