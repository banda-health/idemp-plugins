package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHBPartnerTags;
import org.bandahealth.idempiere.base.model.MBHTags;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_BPartner_Tags - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_BPartner_TagsInput extends MBHBPartnerTags implements I_BH_BPartner_TagsInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Tags;
	private ForeignEntityInput mC_BPartner;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_BPartner_Tags_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_BPartner_TagsInput(@JsonProperty("UU") String UU) {
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_BPartner_Tags_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_BPartner_Tags_UU();
	}

	/**
	 * Set BH Tags.
	 *
	 * @param BH_Tags BH Tags
	 */
	@JsonProperty("BH_Tags")
	public void setBH_TagsInput(ForeignEntityInput BH_Tags) {
		this.mBH_Tags = BH_Tags;
		if (!is_new()) {
			return;
		}
		if (BH_Tags != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHTags foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Tags", "BH_Tags_UU=?", get_TrxName())
							.setParameters(BH_Tags.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Tags_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Tags with UU " + BH_Tags.getUU());
			}
		} else {
			this.setBH_Tags_ID(0);
		}
	}

	/**
	 * Get BH Tags.
	 *
	 * @return BH Tags
	 */
	@JsonProperty("BH_Tags")
	public ForeignEntityInput BH_Tags() {
		return mBH_Tags;
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (!is_new()) {
			return;
		}
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}
}
