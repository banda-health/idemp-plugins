package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MImportTemplate;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_ImportTemplateAccess;
import org.compiere.model.X_AD_Role;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ImportTemplateAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ImportTemplateAccessInput extends X_AD_ImportTemplateAccess implements I_AD_ImportTemplateAccessInput {

	private ForeignEntityInput mAD_ImportTemplate;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ImportTemplateAccessInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_ImportTemplateAccess(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Import Template.
	 *
	 * @param AD_ImportTemplate Import Template
	 */
	@JsonProperty("AD_ImportTemplate")
	public void setAD_ImportTemplateInput(ForeignEntityInput AD_ImportTemplate) {
		this.mAD_ImportTemplate = AD_ImportTemplate;
		MImportTemplate foreignEntity;
		if (get_ID() == 0 && AD_ImportTemplate != null &&
				(foreignEntity = new Query(getCtx(), "AD_ImportTemplate", "AD_ImportTemplate_UU=?", get_TrxName())
						.setParameters(AD_ImportTemplate.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ImportTemplate_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Import Template.
	 *
	 * @return Import Template
	 */
	@JsonProperty("AD_ImportTemplate")
	public ForeignEntityInput AD_ImportTemplate() {
		return mAD_ImportTemplate;
	}
	/**
	 * Set Import Template Access.
	 *
	 * @param AD_ImportTemplateAccess_ID Import Template Access
	 */

	public void setAD_ImportTemplateAccess_ID(int AD_ImportTemplateAccess_ID) {
		if (get_ID() == 0) {
			super.setAD_ImportTemplateAccess_ID(AD_ImportTemplateAccess_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_ImportTemplateAccess_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_ImportTemplateAccess_UU();
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (get_ID() == 0 && AD_Role != null &&
				(foreignEntity = new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public ForeignEntityInput AD_Role() {
		return mAD_Role;
	}
}
