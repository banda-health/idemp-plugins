package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_SubscriptionType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_SubscriptionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_SubscriptionTypeInput extends X_C_SubscriptionType implements I_C_SubscriptionTypeInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mFrequencyType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_SubscriptionType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_SubscriptionTypeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_SubscriptionType(null, (ResultSet) null, null),
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Subscription Type.
	 *
	 * @param C_SubscriptionType_ID Type of subscription
	 */

	public void setC_SubscriptionType_ID(int C_SubscriptionType_ID) {
		if (get_ID() == 0) {
			super.setC_SubscriptionType_ID(C_SubscriptionType_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_SubscriptionType_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_SubscriptionType_UU();
	}

	/**
	 * Set Frequency Type.
	 *
	 * @param FrequencyType Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public void setFrequencyTypeInput(I_AD_Ref_ListInput FrequencyType) {
		this.mFrequencyType = FrequencyType;
		MRefList_BH foreignEntity;
		if (FrequencyType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FrequencyType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFrequencyType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + FrequencyType.getUUID());
			}
		} else {
			this.setFrequencyType(null);
		}
	}

	/**
	 * Get Frequency Type.
	 *
	 * @return Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public I_AD_Ref_ListInput FrequencyType() {
		return mFrequencyType;
	}
}
