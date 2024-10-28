package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_C_JobCategory;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_JobInput extends X_C_Job implements I_C_JobInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_JobCategory;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_Job_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_JobInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
	 * Set Position.
	 *
	 * @param C_Job_ID Job Position
	 */
	@JsonProperty("C_Job_ID")
	public void setC_Job_IDFromJson(int C_Job_ID) {
		if (get_ID() == 0) {
			super.setC_Job_ID(C_Job_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_Job_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_Job_UU();
	}

	/**
	 * Set Position Category.
	 *
	 * @param C_JobCategory Job Position Category
	 */
	@JsonProperty("C_JobCategory")
	public void setC_JobCategoryInput(ForeignEntityInput C_JobCategory) {
		this.mC_JobCategory = C_JobCategory;
		if (C_JobCategory != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_JobCategory foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_JobCategory", "C_JobCategory_UU=?", get_TrxName())
							.setParameters(C_JobCategory.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_JobCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_JobCategory with UU " + C_JobCategory.getUU());
			}
		} else {
			this.setC_JobCategory_ID(0);
		}
	}

	/**
	 * Get Position Category.
	 *
	 * @return Job Position Category
	 */
	@JsonProperty("C_JobCategory")
	public ForeignEntityInput C_JobCategory() {
		return mC_JobCategory;
	}
}
