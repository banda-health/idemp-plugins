package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_AD_WF_Responsible;
import org.compiere.util.Env;

/**
 * Generated Model for AD_WF_Responsible - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ResponsibleInput extends X_AD_WF_Responsible implements I_AD_WF_ResponsibleInput {

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ResponsibleType_RL;
	 private I_AD_RoleInput AD_Role;
	 private I_AD_UserInput AD_User;

	/**
	 * Standard constructor
	 */
	public X_AD_WF_ResponsibleInput(String ID) {
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	public void setAD_Role(I_AD_RoleInput AD_Role) {
		this.AD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Role.Table_Name, X_AD_Role.COLUMNNAME_AD_Role_UU + "=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public I_AD_RoleInput getAD_Role() {
		return AD_Role;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}
	/**
	 * Set User/Contact.
	 *
	 * @param AD_User_ID User within the system - Internal or Business Partner Contact
	 */

	public void setAD_User_ID(int AD_User_ID) {
		if (get_ID() == 0) {
			super.setAD_User_ID(AD_User_ID);
		}
	}
	/**
	 * Set Workflow Responsible.
	 *
	 * @param AD_WF_Responsible_ID Responsible for Workflow Execution
	 */

	public void setAD_WF_Responsible_ID(int AD_WF_Responsible_ID) {
		if (get_ID() == 0) {
			super.setAD_WF_Responsible_ID(AD_WF_Responsible_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WF_Responsible_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WF_Responsible_UU();
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.getEntityType());
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}
	/**
	 * Set Entity Type.
	 *
	 * @param EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */

	public void setEntityType(String EntityType) {
		if (get_ID() == 0) {
			super.setEntityType(EntityType);
		}
	}

	/**
	 * Set Responsible Type.
	 *
	 * @param ResponsibleType_RL Type of the Responsibility for a workflow
	 */
	public void setResponsibleType_RL(I_AD_Ref_ListInput ResponsibleType_RL) {
		this.ResponsibleType_RL = ResponsibleType_RL;
		MRefList foreignEntity;
		if (ResponsibleType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ResponsibleType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setResponsibleType(foreignEntity.getValue());
		} else {
			this.setResponsibleType(null);
		}
	}

	/**
	 * Get Responsible Type.
	 *
	 * @return Type of the Responsibility for a workflow
	 */
	public I_AD_Ref_ListInput getResponsibleType_RL() {
		return ResponsibleType_RL;
	}
}
