package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Subscription;
import org.compiere.model.X_C_Subscription_Delivery;

import java.sql.ResultSet;

/**
 * Generated Model for C_Subscription_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Subscription_DeliveryInput extends X_C_Subscription_Delivery implements I_C_Subscription_DeliveryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Subscription;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_Subscription_DeliveryInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_Subscription_Delivery(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Subscription Delivery.
	 *
	 * @param C_Subscription_Delivery_ID Optional Delivery Record for a Subscription
	 */

	public void setC_Subscription_Delivery_ID(int C_Subscription_Delivery_ID) {
		if (get_ID() == 0) {
			super.setC_Subscription_Delivery_ID(C_Subscription_Delivery_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Subscription_Delivery_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Subscription_Delivery_UU();
	}

	/**
	 * Set Subscription.
	 *
	 * @param C_Subscription Subscription of a Business Partner of a Product to renew
	 */
	@JsonProperty("C_Subscription")
	public void setC_SubscriptionInput(ForeignEntityInput C_Subscription) {
		this.mC_Subscription = C_Subscription;
		X_C_Subscription foreignEntity;
		if (get_ID() == 0 && C_Subscription != null &&
				(foreignEntity = new Query(getCtx(), "C_Subscription", "C_Subscription_UU=?", get_TrxName())
						.setParameters(C_Subscription.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Subscription_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Subscription.
	 *
	 * @return Subscription of a Business Partner of a Product to renew
	 */
	@JsonProperty("C_Subscription")
	public ForeignEntityInput C_Subscription() {
		return mC_Subscription;
	}
}
