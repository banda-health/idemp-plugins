package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MHierarchy;
import org.compiere.model.MOrg;
import org.compiere.model.MTree;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_HierarchyInput extends MHierarchy implements I_PA_HierarchyInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mAD_Tree_Account;
	 private ForeignEntityInput mAD_Tree_Activity;
	 private ForeignEntityInput mAD_Tree_BPartner;
	 private ForeignEntityInput mAD_Tree_Campaign;
	 private ForeignEntityInput mAD_Tree_Org;
	 private ForeignEntityInput mAD_Tree_Product;
	 private ForeignEntityInput mAD_Tree_Project;
	 private ForeignEntityInput mAD_Tree_SalesRegion;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_HierarchyInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
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
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	 * Set Account Tree.
	 *
	 * @param AD_Tree_Account Tree for Natural Account Tree
	 */
	@JsonProperty("AD_Tree_Account")
	public void setAD_Tree_AccountInput(ForeignEntityInput AD_Tree_Account) {
		this.mAD_Tree_Account = AD_Tree_Account;
		MTree foreignEntity;
		if (AD_Tree_Account != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Account.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Account_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tree_Account_ID(0);
		}
	}

	/**
	 * Get Account Tree.
	 *
	 * @return Tree for Natural Account Tree
	 */
	@JsonProperty("AD_Tree_Account")
	public ForeignEntityInput AD_Tree_Account() {
		return mAD_Tree_Account;
	}

	/**
	 * Set Activity Tree.
	 *
	 * @param AD_Tree_Activity Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Activity")
	public void setAD_Tree_ActivityInput(ForeignEntityInput AD_Tree_Activity) {
		this.mAD_Tree_Activity = AD_Tree_Activity;
		MTree foreignEntity;
		if (AD_Tree_Activity != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Activity_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tree_Activity_ID(0);
		}
	}

	/**
	 * Get Activity Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Activity")
	public ForeignEntityInput AD_Tree_Activity() {
		return mAD_Tree_Activity;
	}

	/**
	 * Set BPartner Tree.
	 *
	 * @param AD_Tree_BPartner Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_BPartner")
	public void setAD_Tree_BPartnerInput(ForeignEntityInput AD_Tree_BPartner) {
		this.mAD_Tree_BPartner = AD_Tree_BPartner;
		MTree foreignEntity;
		if (AD_Tree_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tree_BPartner_ID(0);
		}
	}

	/**
	 * Get BPartner Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_BPartner")
	public ForeignEntityInput AD_Tree_BPartner() {
		return mAD_Tree_BPartner;
	}

	/**
	 * Set Campaign Tree.
	 *
	 * @param AD_Tree_Campaign Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Campaign")
	public void setAD_Tree_CampaignInput(ForeignEntityInput AD_Tree_Campaign) {
		this.mAD_Tree_Campaign = AD_Tree_Campaign;
		MTree foreignEntity;
		if (AD_Tree_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Campaign_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tree_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Campaign")
	public ForeignEntityInput AD_Tree_Campaign() {
		return mAD_Tree_Campaign;
	}

	/**
	 * Set Organization Tree.
	 *
	 * @param AD_Tree_Org Trees are used for (financial) reporting and security access (via role)
	 */
	@JsonProperty("AD_Tree_Org")
	public void setAD_Tree_OrgInput(ForeignEntityInput AD_Tree_Org) {
		this.mAD_Tree_Org = AD_Tree_Org;
		MTree foreignEntity;
		if (AD_Tree_Org != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tree_Org_ID(0);
		}
	}

	/**
	 * Get Organization Tree.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	@JsonProperty("AD_Tree_Org")
	public ForeignEntityInput AD_Tree_Org() {
		return mAD_Tree_Org;
	}

	/**
	 * Set Product Tree.
	 *
	 * @param AD_Tree_Product Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Product")
	public void setAD_Tree_ProductInput(ForeignEntityInput AD_Tree_Product) {
		this.mAD_Tree_Product = AD_Tree_Product;
		MTree foreignEntity;
		if (AD_Tree_Product != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Product_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tree_Product_ID(0);
		}
	}

	/**
	 * Get Product Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Product")
	public ForeignEntityInput AD_Tree_Product() {
		return mAD_Tree_Product;
	}

	/**
	 * Set Project Tree.
	 *
	 * @param AD_Tree_Project Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Project")
	public void setAD_Tree_ProjectInput(ForeignEntityInput AD_Tree_Project) {
		this.mAD_Tree_Project = AD_Tree_Project;
		MTree foreignEntity;
		if (AD_Tree_Project != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Project_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tree_Project_ID(0);
		}
	}

	/**
	 * Get Project Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Project")
	public ForeignEntityInput AD_Tree_Project() {
		return mAD_Tree_Project;
	}

	/**
	 * Set Sales Region Tree.
	 *
	 * @param AD_Tree_SalesRegion Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_SalesRegion")
	public void setAD_Tree_SalesRegionInput(ForeignEntityInput AD_Tree_SalesRegion) {
		this.mAD_Tree_SalesRegion = AD_Tree_SalesRegion;
		MTree foreignEntity;
		if (AD_Tree_SalesRegion != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_SalesRegion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_SalesRegion_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tree_SalesRegion_ID(0);
		}
	}

	/**
	 * Get Sales Region Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_SalesRegion")
	public ForeignEntityInput AD_Tree_SalesRegion() {
		return mAD_Tree_SalesRegion;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_Hierarchy_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_Hierarchy_UU();
	}
}
