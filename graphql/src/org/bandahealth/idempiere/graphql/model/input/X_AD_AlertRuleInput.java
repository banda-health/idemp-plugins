package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAlert;
import org.compiere.model.MAlertRule;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_AlertRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_AlertRuleInput extends MAlertRule implements I_AD_AlertRuleInput {

	private ForeignEntityInput mAD_Alert;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_AlertRuleInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAlertRule(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Alert.
	 *
	 * @param AD_Alert iDempiere Alert
	 */
	@JsonProperty("AD_Alert")
	public void setAD_AlertInput(ForeignEntityInput AD_Alert) {
		this.mAD_Alert = AD_Alert;
		MAlert foreignEntity;
		if (get_ID() == 0 && AD_Alert != null &&
				(foreignEntity = new Query(getCtx(), "AD_Alert", "AD_Alert_UU=?", get_TrxName())
						.setParameters(AD_Alert.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Alert_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Alert.
	 *
	 * @return iDempiere Alert
	 */
	@JsonProperty("AD_Alert")
	public ForeignEntityInput AD_Alert() {
		return mAD_Alert;
	}
	/**
	 * Set Alert Rule.
	 *
	 * @param AD_AlertRule_ID Definition of the alert element
	 */

	public void setAD_AlertRule_ID(int AD_AlertRule_ID) {
		if (get_ID() == 0) {
			super.setAD_AlertRule_ID(AD_AlertRule_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_AlertRule_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_AlertRule_UU();
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable_BH foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}
}
