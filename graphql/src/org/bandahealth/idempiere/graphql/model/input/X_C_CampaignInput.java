package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCampaign;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Channel;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Campaign - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CampaignInput extends MCampaign implements I_C_CampaignInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Channel;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Campaign_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_CampaignInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MCampaign(null, (ResultSet) null, null),
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
	 * Set Campaign.
	 *
	 * @param C_Campaign_ID Marketing Campaign
	 */

	public void setC_Campaign_ID(int C_Campaign_ID) {
		if (get_ID() == 0) {
			super.setC_Campaign_ID(C_Campaign_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Campaign_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_Campaign_UU();
	}

	/**
	 * Set Channel.
	 *
	 * @param C_Channel Sales Channel
	 */
	@JsonProperty("C_Channel")
	public void setC_ChannelInput(ForeignEntityInput C_Channel) {
		this.mC_Channel = C_Channel;
		if (C_Channel != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_Channel foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Channel", "C_Channel_UU=?", get_TrxName())
							.setParameters(C_Channel.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Channel_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Channel with UUID " + C_Channel.getUUID());
			}
		} else {
			this.setC_Channel_ID(0);
		}
	}

	/**
	 * Get Channel.
	 *
	 * @return Sales Channel
	 */
	@JsonProperty("C_Channel")
	public ForeignEntityInput C_Channel() {
		return mC_Channel;
	}
}
