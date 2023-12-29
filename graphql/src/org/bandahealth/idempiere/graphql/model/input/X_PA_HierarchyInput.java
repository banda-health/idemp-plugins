package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTree;
import org.compiere.model.Query;
import org.compiere.model.X_PA_Hierarchy;
import org.compiere.util.Env;

/**
 * Generated Model for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_HierarchyInput extends X_PA_Hierarchy implements I_PA_HierarchyInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_TreeInput AD_Tree_Account;
	 private I_AD_TreeInput AD_Tree_Activity;
	 private I_AD_TreeInput AD_Tree_BPartner;
	 private I_AD_TreeInput AD_Tree_Campaign;
	 private I_AD_TreeInput AD_Tree_Org;
	 private I_AD_TreeInput AD_Tree_Product;
	 private I_AD_TreeInput AD_Tree_Project;
	 private I_AD_TreeInput AD_Tree_SalesRegion;

	/**
	 * Standard constructor
	 */
	public X_PA_HierarchyInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Account Tree.
	 *
	 * @param AD_Tree_Account Tree for Natural Account Tree
	 */
	public void setAD_Tree_Account(I_AD_TreeInput AD_Tree_Account) {
		this.AD_Tree_Account = AD_Tree_Account;
		MTree foreignEntity;
		if (AD_Tree_Account != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Account.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_Account_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Tree_Account_ID(0);
		}
	}

	/**
	 * Get Account Tree.
	 *
	 * @return Tree for Natural Account Tree
	 */
	public I_AD_TreeInput getAD_Tree_Account() {
		return AD_Tree_Account;
	}
	/**
	 * Set Account Tree.
	 *
	 * @param AD_Tree_Account_ID Tree for Natural Account Tree
	 */

	public void setAD_Tree_Account_ID(int AD_Tree_Account_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_Account_ID(AD_Tree_Account_ID);
		}
	}

	/**
	 * Set Activity Tree.
	 *
	 * @param AD_Tree_Activity Trees are used for (financial) reporting
	 */
	public void setAD_Tree_Activity(I_AD_TreeInput AD_Tree_Activity) {
		this.AD_Tree_Activity = AD_Tree_Activity;
		MTree foreignEntity;
		if (AD_Tree_Activity != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_Activity_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Tree_Activity_ID(0);
		}
	}

	/**
	 * Get Activity Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public I_AD_TreeInput getAD_Tree_Activity() {
		return AD_Tree_Activity;
	}
	/**
	 * Set Activity Tree.
	 *
	 * @param AD_Tree_Activity_ID Trees are used for (financial) reporting
	 */

	public void setAD_Tree_Activity_ID(int AD_Tree_Activity_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_Activity_ID(AD_Tree_Activity_ID);
		}
	}

	/**
	 * Set BPartner Tree.
	 *
	 * @param AD_Tree_BPartner Trees are used for (financial) reporting
	 */
	public void setAD_Tree_BPartner(I_AD_TreeInput AD_Tree_BPartner) {
		this.AD_Tree_BPartner = AD_Tree_BPartner;
		MTree foreignEntity;
		if (AD_Tree_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Tree_BPartner_ID(0);
		}
	}

	/**
	 * Get BPartner Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public I_AD_TreeInput getAD_Tree_BPartner() {
		return AD_Tree_BPartner;
	}
	/**
	 * Set BPartner Tree.
	 *
	 * @param AD_Tree_BPartner_ID Trees are used for (financial) reporting
	 */

	public void setAD_Tree_BPartner_ID(int AD_Tree_BPartner_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_BPartner_ID(AD_Tree_BPartner_ID);
		}
	}

	/**
	 * Set Campaign Tree.
	 *
	 * @param AD_Tree_Campaign Trees are used for (financial) reporting
	 */
	public void setAD_Tree_Campaign(I_AD_TreeInput AD_Tree_Campaign) {
		this.AD_Tree_Campaign = AD_Tree_Campaign;
		MTree foreignEntity;
		if (AD_Tree_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_Campaign_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Tree_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public I_AD_TreeInput getAD_Tree_Campaign() {
		return AD_Tree_Campaign;
	}
	/**
	 * Set Campaign Tree.
	 *
	 * @param AD_Tree_Campaign_ID Trees are used for (financial) reporting
	 */

	public void setAD_Tree_Campaign_ID(int AD_Tree_Campaign_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_Campaign_ID(AD_Tree_Campaign_ID);
		}
	}

	/**
	 * Set Organization Tree.
	 *
	 * @param AD_Tree_Org Trees are used for (financial) reporting and security access (via role)
	 */
	public void setAD_Tree_Org(I_AD_TreeInput AD_Tree_Org) {
		this.AD_Tree_Org = AD_Tree_Org;
		MTree foreignEntity;
		if (AD_Tree_Org != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Tree_Org_ID(0);
		}
	}

	/**
	 * Get Organization Tree.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	public I_AD_TreeInput getAD_Tree_Org() {
		return AD_Tree_Org;
	}
	/**
	 * Set Organization Tree.
	 *
	 * @param AD_Tree_Org_ID Trees are used for (financial) reporting and security access (via role)
	 */

	public void setAD_Tree_Org_ID(int AD_Tree_Org_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_Org_ID(AD_Tree_Org_ID);
		}
	}

	/**
	 * Set Product Tree.
	 *
	 * @param AD_Tree_Product Trees are used for (financial) reporting
	 */
	public void setAD_Tree_Product(I_AD_TreeInput AD_Tree_Product) {
		this.AD_Tree_Product = AD_Tree_Product;
		MTree foreignEntity;
		if (AD_Tree_Product != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_Product_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Tree_Product_ID(0);
		}
	}

	/**
	 * Get Product Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public I_AD_TreeInput getAD_Tree_Product() {
		return AD_Tree_Product;
	}
	/**
	 * Set Product Tree.
	 *
	 * @param AD_Tree_Product_ID Trees are used for (financial) reporting
	 */

	public void setAD_Tree_Product_ID(int AD_Tree_Product_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_Product_ID(AD_Tree_Product_ID);
		}
	}

	/**
	 * Set Project Tree.
	 *
	 * @param AD_Tree_Project Trees are used for (financial) reporting
	 */
	public void setAD_Tree_Project(I_AD_TreeInput AD_Tree_Project) {
		this.AD_Tree_Project = AD_Tree_Project;
		MTree foreignEntity;
		if (AD_Tree_Project != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_Project_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Tree_Project_ID(0);
		}
	}

	/**
	 * Get Project Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public I_AD_TreeInput getAD_Tree_Project() {
		return AD_Tree_Project;
	}
	/**
	 * Set Project Tree.
	 *
	 * @param AD_Tree_Project_ID Trees are used for (financial) reporting
	 */

	public void setAD_Tree_Project_ID(int AD_Tree_Project_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_Project_ID(AD_Tree_Project_ID);
		}
	}

	/**
	 * Set Sales Region Tree.
	 *
	 * @param AD_Tree_SalesRegion Trees are used for (financial) reporting
	 */
	public void setAD_Tree_SalesRegion(I_AD_TreeInput AD_Tree_SalesRegion) {
		this.AD_Tree_SalesRegion = AD_Tree_SalesRegion;
		MTree foreignEntity;
		if (AD_Tree_SalesRegion != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree_SalesRegion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_SalesRegion_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Tree_SalesRegion_ID(0);
		}
	}

	/**
	 * Get Sales Region Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public I_AD_TreeInput getAD_Tree_SalesRegion() {
		return AD_Tree_SalesRegion;
	}
	/**
	 * Set Sales Region Tree.
	 *
	 * @param AD_Tree_SalesRegion_ID Trees are used for (financial) reporting
	 */

	public void setAD_Tree_SalesRegion_ID(int AD_Tree_SalesRegion_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_SalesRegion_ID(AD_Tree_SalesRegion_ID);
		}
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
