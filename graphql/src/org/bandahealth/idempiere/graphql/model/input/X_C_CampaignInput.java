package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCampaign;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Channel;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_CampaignInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MCampaign(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Campaign_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		X_C_Channel foreignEntity;
		if (C_Channel != null &&
				(foreignEntity = new Query(getCtx(), "C_Channel", "C_Channel_UU=?", get_TrxName())
						.setParameters(C_Channel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Channel_ID(foreignEntity.get_ID());
		} else {
			super.setC_Channel_ID(0);
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
