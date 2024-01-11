package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_B_BidComment;
import org.compiere.model.X_B_Topic;

import java.sql.ResultSet;

/**
 * Generated Model for B_BidComment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_BidCommentInput extends X_B_BidComment implements I_B_BidCommentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mB_Topic;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_B_BidCommentInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_B_BidComment(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setB_BidComment_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		if (B_Topic != null &&
				(foreignEntity = new Query(getCtx(), "B_Topic", "B_Topic_UU=?", get_TrxName())
						.setParameters(B_Topic.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setB_Topic_ID(foreignEntity.get_ID());
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
