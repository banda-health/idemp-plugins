package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_C_JobCategory;

import java.sql.ResultSet;

/**
 * Generated Model for C_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_JobInput extends X_C_Job implements I_C_JobInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_JobCategory;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_JobInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_Job(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Position.
	 *
	 * @param C_Job_ID Job Position
	 */

	public void setC_Job_ID(int C_Job_ID) {
		if (get_ID() == 0) {
			super.setC_Job_ID(C_Job_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Job_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		X_C_JobCategory foreignEntity;
		if (C_JobCategory != null &&
				(foreignEntity = new Query(getCtx(), "C_JobCategory", "C_JobCategory_UU=?", get_TrxName())
						.setParameters(C_JobCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_JobCategory_ID(foreignEntity.get_ID());
		} else {
			super.setC_JobCategory_ID(0);
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
