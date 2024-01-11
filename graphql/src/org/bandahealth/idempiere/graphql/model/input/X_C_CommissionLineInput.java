package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCommission;
import org.compiere.model.MCommissionLine;
import org.compiere.model.MOrg;
import org.compiere.model.MSalesRegion;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_CommissionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionLineInput extends MCommissionLine implements I_C_CommissionLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BP_Group;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Commission;
	private ForeignEntityInput mC_SalesRegion;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Product_Category;
	private I_AD_Ref_ListInput mPaymentRule;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_CommissionLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MCommissionLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public void setC_BP_GroupInput(ForeignEntityInput C_BP_Group) {
		this.mC_BP_Group = C_BP_Group;
		MBPGroup_BH foreignEntity;
		if (C_BP_Group != null &&
				(foreignEntity = new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
						.setParameters(C_BP_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BP_Group_ID(foreignEntity.get_ID());
		} else {
			super.setC_BP_Group_ID(0);
		}
	}

	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public ForeignEntityInput C_BP_Group() {
		return mC_BP_Group;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Commission.
	 *
	 * @param C_Commission Commission
	 */
	@JsonProperty("C_Commission")
	public void setC_CommissionInput(ForeignEntityInput C_Commission) {
		this.mC_Commission = C_Commission;
		MCommission foreignEntity;
		if (get_ID() == 0 && C_Commission != null &&
				(foreignEntity = new Query(getCtx(), "C_Commission", "C_Commission_UU=?", get_TrxName())
						.setParameters(C_Commission.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Commission_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Commission.
	 *
	 * @return Commission
	 */
	@JsonProperty("C_Commission")
	public ForeignEntityInput C_Commission() {
		return mC_Commission;
	}
	/**
	 * Set Commission Line.
	 *
	 * @param C_CommissionLine_ID Commission Line
	 */

	public void setC_CommissionLine_ID(int C_CommissionLine_ID) {
		if (get_ID() == 0) {
			super.setC_CommissionLine_ID(C_CommissionLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_CommissionLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_CommissionLine_UU();
	}

	/**
	 * Set Sales Region.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	@JsonProperty("C_SalesRegion")
	public void setC_SalesRegionInput(ForeignEntityInput C_SalesRegion) {
		this.mC_SalesRegion = C_SalesRegion;
		MSalesRegion foreignEntity;
		if (C_SalesRegion != null &&
				(foreignEntity = new Query(getCtx(), "C_SalesRegion", "C_SalesRegion_UU=?", get_TrxName())
						.setParameters(C_SalesRegion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_SalesRegion_ID(foreignEntity.get_ID());
		} else {
			super.setC_SalesRegion_ID(0);
		}
	}

	/**
	 * Get Sales Region.
	 *
	 * @return Sales coverage region
	 */
	@JsonProperty("C_SalesRegion")
	public ForeignEntityInput C_SalesRegion() {
		return mC_SalesRegion;
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

	/**
	 * Set Payment Rule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	@JsonProperty("PaymentRule")
	public void setPaymentRuleInput(I_AD_Ref_ListInput PaymentRule) {
		this.mPaymentRule = PaymentRule;
		MRefList_BH foreignEntity;
		if (PaymentRule != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PaymentRule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPaymentRule(foreignEntity.getValue());
		} else {
			this.setPaymentRule(null);
		}
	}

	/**
	 * Get Payment Rule.
	 *
	 * @return How you pay the invoice
	 */
	@JsonProperty("PaymentRule")
	public I_AD_Ref_ListInput PaymentRule() {
		return mPaymentRule;
	}
}
