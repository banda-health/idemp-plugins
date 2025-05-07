package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MImportTemplate;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_ImportTemplateAccess;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ImportTemplateAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ImportTemplateAccessInput extends X_AD_ImportTemplateAccess implements I_AD_ImportTemplateAccessInput {

	private ForeignEntityInput mAD_ImportTemplate;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_ImportTemplateAccess_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ImportTemplateAccessInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Import Template.
	 *
	 * @param AD_ImportTemplate Import Template
	 */
	@JsonProperty("AD_ImportTemplate")
	public void setAD_ImportTemplateInput(ForeignEntityInput AD_ImportTemplate) {
		this.mAD_ImportTemplate = AD_ImportTemplate;
		if (!is_new()) {
			return;
		}
		if (AD_ImportTemplate != null) {
			// Since an entity was passed, make sure it's in the DB
			MImportTemplate foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ImportTemplate", "AD_ImportTemplate_UU=?", get_TrxName())
							.setParameters(AD_ImportTemplate.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_ImportTemplate_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ImportTemplate with UU " + AD_ImportTemplate.getUU());
			}
		} else {
			this.setAD_ImportTemplate_ID(0);
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
	@JsonProperty("AD_ImportTemplateAccess_ID")
	public void setAD_ImportTemplateAccess_IDFromJson(int AD_ImportTemplateAccess_ID) {
		if (get_ID() == 0) {
			super.setAD_ImportTemplateAccess_ID(AD_ImportTemplateAccess_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_ImportTemplateAccess_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_ImportTemplateAccess_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (!is_new()) {
			return;
		}
		if (AD_Role != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Role foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(AD_Role.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UU " + AD_Role.getUU());
			}
		} else {
			this.setAD_Role_ID(-1);
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
