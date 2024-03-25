package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Fund;
import org.compiere.model.X_GL_FundRestriction;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for GL_FundRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_FundRestrictionInput extends X_GL_FundRestriction implements I_GL_FundRestrictionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ElementValue;
	private ForeignEntityInput mGL_Fund;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The GL_FundRestriction_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_GL_FundRestrictionInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
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
	 * Set Account Element.
	 *
	 * @param C_ElementValue Account Element
	 */
	@JsonProperty("C_ElementValue")
	public void setC_ElementValueInput(ForeignEntityInput C_ElementValue) {
		this.mC_ElementValue = C_ElementValue;
		if (C_ElementValue != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(C_ElementValue.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ElementValue_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + C_ElementValue.getUUID());
			}
		} else {
			this.setC_ElementValue_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (GL_Fund != null) {
			// Since an entity was passed, make sure it's in the DB
			X_GL_Fund foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_Fund", "GL_Fund_UU=?", get_TrxName())
							.setParameters(GL_Fund.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setGL_Fund_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Fund with UUID " + GL_Fund.getUUID());
			}
		} else {
			this.setGL_Fund_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setGL_FundRestriction_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getGL_FundRestriction_UU();
	}
}
