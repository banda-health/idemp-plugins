package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_B_Bid;
import org.compiere.model.X_B_BuyerFunds;
import org.compiere.model.X_B_Topic;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for B_Bid - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_BidInput extends X_B_Bid implements I_B_BidInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mB_BuyerFunds;
	private ForeignEntityInput mB_Topic;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The B_Bid_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_B_BidInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}
	/**
	 * Set Bid.
	 *
	 * @param B_Bid_ID Bid for a Topic
	 */

	public void setB_Bid_ID(int B_Bid_ID) {
		if (get_ID() == 0) {
			super.setB_Bid_ID(B_Bid_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setB_Bid_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getB_Bid_UU();
	}

	/**
	 * Set Buyer Funds.
	 *
	 * @param B_BuyerFunds Buyer Funds for Bids on Topics
	 */
	@JsonProperty("B_BuyerFunds")
	public void setB_BuyerFundsInput(ForeignEntityInput B_BuyerFunds) {
		this.mB_BuyerFunds = B_BuyerFunds;
		if (B_BuyerFunds != null) {
			// Since an entity was passed, make sure it's in the DB
			X_B_BuyerFunds foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "B_BuyerFunds", "B_BuyerFunds_UU=?", get_TrxName())
							.setParameters(B_BuyerFunds.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setB_BuyerFunds_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table B_BuyerFunds with UUID " + B_BuyerFunds.getUUID());
			}
		} else {
			this.setB_BuyerFunds_ID(0);
		}
	}

	/**
	 * Get Buyer Funds.
	 *
	 * @return Buyer Funds for Bids on Topics
	 */
	@JsonProperty("B_BuyerFunds")
	public ForeignEntityInput B_BuyerFunds() {
		return mB_BuyerFunds;
	}

	/**
	 * Set Topic.
	 *
	 * @param B_Topic Auction Topic
	 */
	@JsonProperty("B_Topic")
	public void setB_TopicInput(ForeignEntityInput B_Topic) {
		this.mB_Topic = B_Topic;
		if (B_Topic != null) {
			// Since an entity was passed, make sure it's in the DB
			X_B_Topic foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "B_Topic", "B_Topic_UU=?", get_TrxName())
							.setParameters(B_Topic.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setB_Topic_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table B_Topic with UUID " + B_Topic.getUUID());
			}
		} else {
			this.setB_Topic_ID(0);
		}
	}

	/**
	 * Get Topic.
	 *
	 * @return Auction Topic
	 */
	@JsonProperty("B_Topic")
	public ForeignEntityInput B_Topic() {
		return mB_Topic;
	}
}
