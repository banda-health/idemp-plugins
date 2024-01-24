package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_B_BidComment;
import org.compiere.model.X_B_Topic;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for B_BidComment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_B_BidCommentInput extends X_B_BidComment implements I_B_BidCommentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mB_Topic;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The B_BidComment_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_B_BidCommentInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_B_BidComment(null, (ResultSet) null, null),
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
		} else {
			super.setAD_User_ID(0);
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
	 * Set Bid Comment.
	 *
	 * @param B_BidComment_ID Make a comment to a Bid Topic
	 */

	public void setB_BidComment_ID(int B_BidComment_ID) {
		if (get_ID() == 0) {
			super.setB_BidComment_ID(B_BidComment_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setB_BidComment_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getB_BidComment_UU();
	}

	/**
	 * Set Topic.
	 *
	 * @param B_Topic Auction Topic
	 */
	@JsonProperty("B_Topic")
	public void setB_TopicInput(ForeignEntityInput B_Topic) {
		this.mB_Topic = B_Topic;
		X_B_Topic foreignEntity;
		if (B_Topic != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "B_Topic", "B_Topic_UU=?", get_TrxName())
							.setParameters(B_Topic.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setB_Topic_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table B_Topic with UUID " + B_Topic.getUUID());
			}
		} else {
			super.setB_Topic_ID(0);
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
