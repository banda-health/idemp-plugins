package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAssetClass;
import org.compiere.model.MAssetType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Group;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_GroupInput extends X_A_Asset_Group implements I_A_Asset_GroupInput {

	 private I_AD_OrgInput AD_Org;
	 private I_A_Asset_ClassInput A_Asset_Class;
	 private I_A_Asset_TypeInput A_Asset_Type;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_GroupInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset class.
	 *
	 * @param A_Asset_Class Asset class
	 */
	public void setA_Asset_Class(I_A_Asset_ClassInput A_Asset_Class) {
		this.A_Asset_Class = A_Asset_Class;
		MAssetClass foreignEntity;
		if (A_Asset_Class != null &&
				(foreignEntity = new Query(getCtx(), MAssetClass.Table_Name, MAssetClass.COLUMNNAME_A_Asset_Class_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Class.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Class_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Class_ID(0);
		}
	}

	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	public I_A_Asset_ClassInput getA_Asset_Class() {
		return A_Asset_Class;
	}
	/**
	 * Set Asset class.
	 *
	 * @param A_Asset_Class_ID Asset class
	 */

	public void setA_Asset_Class_ID(int A_Asset_Class_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Class_ID(A_Asset_Class_ID);
		}
	}
	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group_ID Group of Assets
	 */

	public void setA_Asset_Group_ID(int A_Asset_Group_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Group_ID(A_Asset_Group_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Group_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Group_UU();
	}

	/**
	 * Set Asset Type.
	 *
	 * @param A_Asset_Type Asset Type
	 */
	public void setA_Asset_Type(I_A_Asset_TypeInput A_Asset_Type) {
		this.A_Asset_Type = A_Asset_Type;
		MAssetType foreignEntity;
		if (A_Asset_Type != null &&
				(foreignEntity = new Query(getCtx(), MAssetType.Table_Name, MAssetType.COLUMNNAME_A_Asset_Type_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Type_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Type_ID(0);
		}
	}

	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	public I_A_Asset_TypeInput getA_Asset_Type() {
		return A_Asset_Type;
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
}
