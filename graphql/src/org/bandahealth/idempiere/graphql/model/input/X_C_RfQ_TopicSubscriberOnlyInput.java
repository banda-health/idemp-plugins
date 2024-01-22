package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRfQTopicSubscriber;
import org.compiere.model.MRfQTopicSubscriberOnly;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_RfQ_TopicSubscriberOnly - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQ_TopicSubscriberOnlyInput extends MRfQTopicSubscriberOnly implements I_C_RfQ_TopicSubscriberOnlyInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RfQ_TopicSubscriber;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Product_Category;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_RfQ_TopicSubscriberOnlyInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRfQTopicSubscriberOnly(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set RfQ Subscriber.
	 *
	 * @param C_RfQ_TopicSubscriber Request for Quotation Topic Subscriber
	 */
	@JsonProperty("C_RfQ_TopicSubscriber")
	public void setC_RfQ_TopicSubscriberInput(ForeignEntityInput C_RfQ_TopicSubscriber) {
		this.mC_RfQ_TopicSubscriber = C_RfQ_TopicSubscriber;
		MRfQTopicSubscriber foreignEntity;
		if (get_ID() == 0 && C_RfQ_TopicSubscriber != null &&
				(foreignEntity = new Query(getCtx(), "C_RfQ_TopicSubscriber", "C_RfQ_TopicSubscriber_UU=?", get_TrxName())
						.setParameters(C_RfQ_TopicSubscriber.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_RfQ_TopicSubscriber_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get RfQ Subscriber.
	 *
	 * @return Request for Quotation Topic Subscriber
	 */
	@JsonProperty("C_RfQ_TopicSubscriber")
	public ForeignEntityInput C_RfQ_TopicSubscriber() {
		return mC_RfQ_TopicSubscriber;
	}
	/**
	 * Set RfQ Topic Subscriber Restriction.
	 *
	 * @param C_RfQ_TopicSubscriberOnly_ID Include Subscriber only for certain products or product categories
	 */

	public void setC_RfQ_TopicSubscriberOnly_ID(int C_RfQ_TopicSubscriberOnly_ID) {
		if (get_ID() == 0) {
			super.setC_RfQ_TopicSubscriberOnly_ID(C_RfQ_TopicSubscriberOnly_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_RfQ_TopicSubscriberOnly_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_RfQ_TopicSubscriberOnly_UU();
	}

	/**
	 * Set Product Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category) {
		this.mM_Product_Category = M_Product_Category;
		MProductCategory_BH foreignEntity;
		if (M_Product_Category != null &&
				(foreignEntity = new Query(getCtx(), "M_Product_Category", "M_Product_Category_UU=?", get_TrxName())
						.setParameters(M_Product_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_Category_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_Category_ID(0);
		}
	}

	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public ForeignEntityInput M_Product_Category() {
		return mM_Product_Category;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}
}
