package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_WizardProcessResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WF_Node;
import org.compiere.model.X_AD_WizardProcess;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_WizardProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WizardProcessInput extends X_AD_WizardProcess implements I_AD_WizardProcessInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mAD_WF_Node;
	private ForeignEntityInput mWizardStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_WizardProcess_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_WizardProcessInput(@JsonProperty("UU") String UU) {
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
	 * Set Node.
	 *
	 * @param AD_WF_Node Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public void setAD_WF_NodeInput(ForeignEntityInput AD_WF_Node) {
		this.mAD_WF_Node = AD_WF_Node;
		if (!is_new()) {
			return;
		}
		if (AD_WF_Node != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_WF_Node foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_WF_Node", "AD_WF_Node_UU=?", get_TrxName())
							.setParameters(AD_WF_Node.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_WF_Node_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_WF_Node with UU " + AD_WF_Node.getUU());
			}
		} else {
			this.setAD_WF_Node_ID(0);
		}
	}

	/**
	 * Get Node.
	 *
	 * @return Workflow Node (activity), step or process
	 */
	@JsonProperty("AD_WF_Node")
	public ForeignEntityInput AD_WF_Node() {
		return mAD_WF_Node;
	}
	/**
	 * Set Wizard Process.
	 *
	 * @param AD_WizardProcess_ID Wizard Process
	 */
	@JsonProperty("AD_WizardProcess_ID")
	public void setAD_WizardProcess_IDFromJson(int AD_WizardProcess_ID) {
		if (get_ID() == 0) {
			super.setAD_WizardProcess_ID(AD_WizardProcess_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_WizardProcess_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_WizardProcess_UU();
	}

	/**
	 * Set Wizard Status.
	 *
	 * @param WizardStatus Wizard Status
	 */
	@JsonProperty("WizardStatus")
	public void setWizardStatusInput(ForeignEntityInput WizardStatus) {
		this.mWizardStatus = WizardStatus;
		if (WizardStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_WizardProcessResolver.WIZARDSTATUS_UUIDS_BY_VALUE.containsValue(WizardStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + WizardStatus.getUU() +
						" is not in the list defined for the WizardStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(WizardStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setWizardStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + WizardStatus.getUU());
			}
		} else {
			this.setWizardStatus(null);
		}
	}

	/**
	 * Get Wizard Status.
	 *
	 * @return Wizard Status
	 */
	@JsonProperty("WizardStatus")
	public ForeignEntityInput WizardStatus() {
		return mWizardStatus;
	}
}
