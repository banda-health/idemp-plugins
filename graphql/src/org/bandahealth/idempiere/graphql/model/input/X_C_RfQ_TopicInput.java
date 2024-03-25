package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRfQTopic;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_RfQ_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQ_TopicInput extends MRfQTopic implements I_C_RfQ_TopicInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintFormat;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_RfQ_Topic_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RfQ_TopicInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		if (AD_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(AD_PrintFormat.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UUID " + AD_PrintFormat.getUUID());
			}
		} else {
			this.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public ForeignEntityInput AD_PrintFormat() {
		return mAD_PrintFormat;
	}
	/**
	 * Set RfQ Topic.
	 *
	 * @param C_RfQ_Topic_ID Topic for Request for Quotations
	 */

	public void setC_RfQ_Topic_ID(int C_RfQ_Topic_ID) {
		if (get_ID() == 0) {
			super.setC_RfQ_Topic_ID(C_RfQ_Topic_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_RfQ_Topic_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_RfQ_Topic_UU();
	}
}
