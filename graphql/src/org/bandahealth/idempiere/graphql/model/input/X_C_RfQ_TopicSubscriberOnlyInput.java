package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRfQTopicSubscriber;
import org.compiere.model.MRfQTopicSubscriberOnly;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_RfQ_TopicSubscriberOnly - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQ_TopicSubscriberOnlyInput extends MRfQTopicSubscriberOnly implements I_C_RfQ_TopicSubscriberOnlyInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RfQ_TopicSubscriber;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Product_Category;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_RfQ_TopicSubscriberOnly_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RfQ_TopicSubscriberOnlyInput(@JsonProperty("UUID") String UUID) {
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
	 * Set RfQ Subscriber.
	 *
	 * @param C_RfQ_TopicSubscriber Request for Quotation Topic Subscriber
	 */
	@JsonProperty("C_RfQ_TopicSubscriber")
	public void setC_RfQ_TopicSubscriberInput(ForeignEntityInput C_RfQ_TopicSubscriber) {
		this.mC_RfQ_TopicSubscriber = C_RfQ_TopicSubscriber;
		if (get_ID() != 0) {
			return;
		}
		if (C_RfQ_TopicSubscriber != null) {
			// Since an entity was passed, make sure it's in the DB
			MRfQTopicSubscriber foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_RfQ_TopicSubscriber", "C_RfQ_TopicSubscriber_UU=?", get_TrxName())
							.setParameters(C_RfQ_TopicSubscriber.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_RfQ_TopicSubscriber_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RfQ_TopicSubscriber with UUID " + C_RfQ_TopicSubscriber.getUUID());
			}
		} else {
			this.setC_RfQ_TopicSubscriber_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_RfQ_TopicSubscriberOnly_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (M_Product_Category != null) {
			// Since an entity was passed, make sure it's in the DB
			MProductCategory_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product_Category", "M_Product_Category_UU=?", get_TrxName())
							.setParameters(M_Product_Category.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product_Category with UUID " + M_Product_Category.getUUID());
			}
		} else {
			this.setM_Product_Category_ID(0);
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
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		} else {
			this.setM_Product_ID(0);
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
