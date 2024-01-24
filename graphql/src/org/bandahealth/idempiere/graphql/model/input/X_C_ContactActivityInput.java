package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOpportunity;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_ContactActivity;

import java.sql.ResultSet;

/**
 * Generated Model for C_ContactActivity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ContactActivityInput extends X_C_ContactActivity implements I_C_ContactActivityInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mC_Opportunity;
	private ForeignEntityInput mSalesRep;
	private I_AD_Ref_ListInput mContactActivityType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_ContactActivityInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_ContactActivity(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}
	/**
	 * Set Contact Activity.
	 *
	 * @param C_ContactActivity_ID Events, tasks, communications related to a contact
	 */

	public void setC_ContactActivity_ID(int C_ContactActivity_ID) {
		if (get_ID() == 0) {
			super.setC_ContactActivity_ID(C_ContactActivity_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_ContactActivity_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_ContactActivity_UU();
	}

	/**
	 * Set Sales Opportunity.
	 *
	 * @param C_Opportunity Sales Opportunity
	 */
	@JsonProperty("C_Opportunity")
	public void setC_OpportunityInput(ForeignEntityInput C_Opportunity) {
		this.mC_Opportunity = C_Opportunity;
		MOpportunity foreignEntity;
		if (C_Opportunity != null &&
				(foreignEntity = new Query(getCtx(), "C_Opportunity", "C_Opportunity_UU=?", get_TrxName())
						.setParameters(C_Opportunity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Opportunity_ID(foreignEntity.get_ID());
		} else {
			super.setC_Opportunity_ID(0);
		}
	}

	/**
	 * Get Sales Opportunity.
	 *
	 * @return Sales Opportunity
	 */
	@JsonProperty("C_Opportunity")
	public ForeignEntityInput C_Opportunity() {
		return mC_Opportunity;
	}

	/**
	 * Set Activity Type.
	 *
	 * @param ContactActivityType Type of activity, e.g. task, email, phone call
	 */
	@JsonProperty("ContactActivityType")
	public void setContactActivityTypeInput(I_AD_Ref_ListInput ContactActivityType) {
		this.mContactActivityType = ContactActivityType;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&ContactActivityType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ContactActivityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setContactActivityType(foreignEntity.getValue());
		}
	}

	/**
	 * Get Activity Type.
	 *
	 * @return Type of activity, e.g. task, email, phone call
	 */
	@JsonProperty("ContactActivityType")
	public I_AD_Ref_ListInput ContactActivityType() {
		return mContactActivityType;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(SalesRep.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSalesRep_ID(foreignEntity.get_ID());
		} else {
			super.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public ForeignEntityInput SalesRep() {
		return mSalesRep;
	}
}
