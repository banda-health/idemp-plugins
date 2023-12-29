package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Campaign;
import org.compiere.model.X_C_Channel;
import org.compiere.util.Env;

/**
 * Generated Model for C_Campaign - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CampaignInput extends X_C_Campaign implements I_C_CampaignInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_ChannelInput C_Channel;

	/**
	 * Standard constructor
	 */
	public X_C_CampaignInput(String ID) {
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
	public void setC_Channel(I_C_ChannelInput C_Channel) {
		this.C_Channel = C_Channel;
		X_C_Channel foreignEntity;
		if (C_Channel != null &&
				(foreignEntity = new Query(getCtx(), X_C_Channel.Table_Name, X_C_Channel.COLUMNNAME_C_Channel_UU + "=?", get_TrxName())
						.setParameters(C_Channel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Channel_ID(foreignEntity.get_ID());
		} else {
			this.setC_Channel_ID(0);
		}
	}

	/**
	 * Get Channel.
	 *
	 * @return Sales Channel
	 */
	public I_C_ChannelInput getC_Channel() {
		return C_Channel;
	}
}
