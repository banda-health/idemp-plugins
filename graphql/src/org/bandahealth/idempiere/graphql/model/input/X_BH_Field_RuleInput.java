package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHFieldRule;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Field_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Field_RuleInput extends MBHFieldRule implements I_BH_Field_RuleInput {

	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Field_Rule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Field_RuleInput(@JsonProperty("UU") String UU) {
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
	 * Set Field Key.
	 *
	 * @param BH_FieldKey Field Key
	 */
	@JsonProperty("BH_FieldKey")
	public void setBH_FieldKeyFromJson(String BH_FieldKey) {
		if (get_ID() == 0) {
			super.setBH_FieldKey(BH_FieldKey);
		}
	}
	/**
	 * Set Field Rule.
	 *
	 * @param BH_Field_Rule_ID Field Rule
	 */
	@JsonProperty("BH_Field_Rule_ID")
	public void setBH_Field_Rule_IDFromJson(int BH_Field_Rule_ID) {
		super.setBH_Field_Rule_ID(BH_Field_Rule_ID);
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Field_Rule_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Field_Rule_UU();
	}
	/**
	 * Set Form.
	 *
	 * @param BH_Form Form
	 */
	@JsonProperty("BH_Form")
	public void setBH_FormFromJson(String BH_Form) {
		if (get_ID() == 0) {
			super.setBH_Form(BH_Form);
		}
	}
}
