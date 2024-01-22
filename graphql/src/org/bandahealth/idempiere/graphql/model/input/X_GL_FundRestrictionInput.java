package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Fund;
import org.compiere.model.X_GL_FundRestriction;

import java.sql.ResultSet;

/**
 * Generated Model for GL_FundRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_FundRestrictionInput extends X_GL_FundRestriction implements I_GL_FundRestrictionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ElementValue;
	private ForeignEntityInput mGL_Fund;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_GL_FundRestrictionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_GL_FundRestriction(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Account Element.
	 *
	 * @param C_ElementValue Account Element
	 */
	@JsonProperty("C_ElementValue")
	public void setC_ElementValueInput(ForeignEntityInput C_ElementValue) {
		this.mC_ElementValue = C_ElementValue;
		MElementValue foreignEntity;
		if (C_ElementValue != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
						.setParameters(C_ElementValue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ElementValue_ID(foreignEntity.get_ID());
		} else {
			super.setC_ElementValue_ID(0);
		}
	}

	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	@JsonProperty("C_ElementValue")
	public ForeignEntityInput C_ElementValue() {
		return mC_ElementValue;
	}

	/**
	 * Set GL Fund.
	 *
	 * @param GL_Fund General Ledger Funds Control
	 */
	@JsonProperty("GL_Fund")
	public void setGL_FundInput(ForeignEntityInput GL_Fund) {
		this.mGL_Fund = GL_Fund;
		X_GL_Fund foreignEntity;
		if (get_ID() == 0 && GL_Fund != null &&
				(foreignEntity = new Query(getCtx(), "GL_Fund", "GL_Fund_UU=?", get_TrxName())
						.setParameters(GL_Fund.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_Fund_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get GL Fund.
	 *
	 * @return General Ledger Funds Control
	 */
	@JsonProperty("GL_Fund")
	public ForeignEntityInput GL_Fund() {
		return mGL_Fund;
	}
	/**
	 * Set Fund Restriction.
	 *
	 * @param GL_FundRestriction_ID Restriction of Funds
	 */

	public void setGL_FundRestriction_ID(int GL_FundRestriction_ID) {
		if (get_ID() == 0) {
			super.setGL_FundRestriction_ID(GL_FundRestriction_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setGL_FundRestriction_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getGL_FundRestriction_UU();
	}
}
