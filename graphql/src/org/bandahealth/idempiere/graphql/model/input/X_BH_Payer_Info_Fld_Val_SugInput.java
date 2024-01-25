package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Payer_Info_Fld_Val_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Payer_Info_Fld_Val_SugInput extends MBHPayerInfoFldValSug implements I_BH_Payer_Info_Fld_Val_SugInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Payer_Info_Fld_Sug;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Payer_Info_Fld_Val_Sug_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Payer_Info_Fld_Val_SugInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MBHPayerInfoFldValSug(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Payer Info Field Suggestion.
	 *
	 * @param BH_Payer_Info_Fld_Sug Payer Info Field Suggestion
	 */
	@JsonProperty("BH_Payer_Info_Fld_Sug")
	public void setBH_Payer_Info_Fld_SugInput(ForeignEntityInput BH_Payer_Info_Fld_Sug) {
		this.mBH_Payer_Info_Fld_Sug = BH_Payer_Info_Fld_Sug;
		if (get_ID() != 0) {
			return;
		}
		if (BH_Payer_Info_Fld_Sug != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHPayerInfoFldSug foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Payer_Info_Fld_Sug", "BH_Payer_Info_Fld_Sug_UU=?", get_TrxName())
							.setParameters(BH_Payer_Info_Fld_Sug.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBH_Payer_Info_Fld_Sug_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Payer_Info_Fld_Sug with UUID " + BH_Payer_Info_Fld_Sug.getUUID());
			}
		} else {
			this.setBH_Payer_Info_Fld_Sug_ID(0);
		}
	}

	/**
	 * Get Payer Info Field Suggestion.
	 *
	 * @return Payer Info Field Suggestion
	 */
	@JsonProperty("BH_Payer_Info_Fld_Sug")
	public ForeignEntityInput BH_Payer_Info_Fld_Sug() {
		return mBH_Payer_Info_Fld_Sug;
	}
	/**
	 * Set Payer Info Field Value Suggestion.
	 *
	 * @param BH_Payer_Info_Fld_Val_Sug_ID Payer Info Field Value Suggestion
	 */

	public void setBH_Payer_Info_Fld_Val_Sug_ID(int BH_Payer_Info_Fld_Val_Sug_ID) {
		if (get_ID() == 0) {
			super.setBH_Payer_Info_Fld_Val_Sug_ID(BH_Payer_Info_Fld_Val_Sug_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_Payer_Info_Fld_Val_Sug_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getBH_Payer_Info_Fld_Val_Sug_UU();
	}
}
