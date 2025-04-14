package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAlert;
import org.compiere.model.MAlertRule;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_AlertRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AlertRuleInput extends MAlertRule implements I_AD_AlertRuleInput {

	private ForeignEntityInput mAD_Alert;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_AlertRule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_AlertRuleInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Alert.
	 *
	 * @param AD_Alert iDempiere Alert
	 */
	@JsonProperty("AD_Alert")
	public void setAD_AlertInput(ForeignEntityInput AD_Alert) {
		this.mAD_Alert = AD_Alert;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Alert != null) {
			// Since an entity was passed, make sure it's in the DB
			MAlert foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Alert", "AD_Alert_UU=?", get_TrxName())
							.setParameters(AD_Alert.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Alert_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Alert with UU " + AD_Alert.getUU());
			}
		} else {
			this.setAD_Alert_ID(0);
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
	@JsonProperty("AD_AlertRule_ID")
	public void setAD_AlertRule_IDFromJson(int AD_AlertRule_ID) {
		if (get_ID() == 0) {
			super.setAD_AlertRule_ID(AD_AlertRule_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_AlertRule_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_AlertRule_UU();
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
			}
		} else {
			this.setAD_Table_ID(0);
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
