package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_ContactActivityResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOpportunity;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_ContactActivity;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_ContactActivity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_ContactActivityInput extends X_C_ContactActivity implements I_C_ContactActivityInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mC_Opportunity;
	private ForeignEntityInput mContactActivityType;
	private ForeignEntityInput mSalesRep;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_ContactActivity_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_ContactActivityInput(@JsonProperty("UU") String UU) {
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
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
	@JsonProperty("C_ContactActivity_ID")
	public void setC_ContactActivity_IDFromJson(int C_ContactActivity_ID) {
		if (get_ID() == 0) {
			super.setC_ContactActivity_ID(C_ContactActivity_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_ContactActivity_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (C_Opportunity != null) {
			// Since an entity was passed, make sure it's in the DB
			MOpportunity foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Opportunity", "C_Opportunity_UU=?", get_TrxName())
							.setParameters(C_Opportunity.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Opportunity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Opportunity with UU " + C_Opportunity.getUU());
			}
		} else {
			this.setC_Opportunity_ID(0);
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
	public void setContactActivityTypeInput(ForeignEntityInput ContactActivityType) {
		this.mContactActivityType = ContactActivityType;
		if (get_ID() != 0) {
			return;
		}
		if (ContactActivityType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_ContactActivityResolver.CONTACTACTIVITYTYPE_UUIDS_BY_VALUE.containsValue(ContactActivityType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ContactActivityType.getUU() +
						" is not in the list defined for the ContactActivityType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ContactActivityType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setContactActivityType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ContactActivityType.getUU());
			}
		} else {
			this.setContactActivityType(null);
		}
	}

	/**
	 * Get Activity Type.
	 *
	 * @return Type of activity, e.g. task, email, phone call
	 */
	@JsonProperty("ContactActivityType")
	public ForeignEntityInput ContactActivityType() {
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
		if (SalesRep != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + SalesRep.getUU());
			}
		} else {
			this.setSalesRep_ID(0);
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
