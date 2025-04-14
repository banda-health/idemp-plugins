package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_B_Offer;
import org.compiere.model.X_B_SellerFunds;
import org.compiere.model.X_B_Topic;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for B_Offer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_B_OfferInput extends X_B_Offer implements I_B_OfferInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mB_SellerFunds;
	private ForeignEntityInput mB_Topic;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The B_Offer_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_B_OfferInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
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
	 * Set Offer.
	 *
	 * @param B_Offer_ID Offer for a Topic
	 */
	@JsonProperty("B_Offer_ID")
	public void setB_Offer_IDFromJson(int B_Offer_ID) {
		if (get_ID() == 0) {
			super.setB_Offer_ID(B_Offer_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setB_Offer_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getB_Offer_UU();
	}

	/**
	 * Set Seller Funds.
	 *
	 * @param B_SellerFunds Seller Funds from Offers on Topics
	 */
	@JsonProperty("B_SellerFunds")
	public void setB_SellerFundsInput(ForeignEntityInput B_SellerFunds) {
		this.mB_SellerFunds = B_SellerFunds;
		if (B_SellerFunds != null) {
			// Since an entity was passed, make sure it's in the DB
			X_B_SellerFunds foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "B_SellerFunds", "B_SellerFunds_UU=?", get_TrxName())
							.setParameters(B_SellerFunds.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setB_SellerFunds_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table B_SellerFunds with UU " + B_SellerFunds.getUU());
			}
		} else {
			this.setB_SellerFunds_ID(0);
		}
	}

	/**
	 * Get Seller Funds.
	 *
	 * @return Seller Funds from Offers on Topics
	 */
	@JsonProperty("B_SellerFunds")
	public ForeignEntityInput B_SellerFunds() {
		return mB_SellerFunds;
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
							.setParameters(B_Topic.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setB_Topic_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table B_Topic with UU " + B_Topic.getUU());
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
