package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MHierarchy;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_Hierarchy_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_HierarchyInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MHierarchy(null, (ResultSet) null, null),
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
	 * Set Account Tree.
	 *
	 * @param AD_Tree_Account Tree for Natural Account Tree
	 */
	@JsonProperty("AD_Tree_Account")
	public void setAD_Tree_AccountInput(ForeignEntityInput AD_Tree_Account) {
		this.mAD_Tree_Account = AD_Tree_Account;
		if (AD_Tree_Account != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree_Account.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_Account_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree_Account.getUUID());
			}
		} else {
			this.setAD_Tree_Account_ID(0);
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
		if (AD_Tree_Activity != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree_Activity.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree_Activity.getUUID());
			}
		} else {
			this.setAD_Tree_Activity_ID(0);
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
		if (AD_Tree_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree_BPartner.getUUID());
			}
		} else {
			this.setAD_Tree_BPartner_ID(0);
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
		if (AD_Tree_Campaign != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree_Campaign.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree_Campaign.getUUID());
			}
		} else {
			this.setAD_Tree_Campaign_ID(0);
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
		if (AD_Tree_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree_Org.getUUID());
			}
		} else {
			this.setAD_Tree_Org_ID(0);
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
		if (AD_Tree_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree_Product.getUUID());
			}
		} else {
			this.setAD_Tree_Product_ID(0);
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
		if (AD_Tree_Project != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree_Project.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree_Project.getUUID());
			}
		} else {
			this.setAD_Tree_Project_ID(0);
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
		if (AD_Tree_SalesRegion != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree_SalesRegion.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_SalesRegion_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree_SalesRegion.getUUID());
			}
		} else {
			this.setAD_Tree_SalesRegion_ID(0);
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
	 * Set Reporting Hierarchy.
	 *
	 * @param PA_Hierarchy_ID Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	 */

	public void setPA_Hierarchy_ID(int PA_Hierarchy_ID) {
		if (get_ID() == 0) {
			super.setPA_Hierarchy_ID(PA_Hierarchy_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPA_Hierarchy_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPA_Hierarchy_UU();
	}
}
