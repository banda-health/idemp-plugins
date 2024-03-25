package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintPaper;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_LanguageInput extends MLanguage implements I_AD_LanguageInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintPaper;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Language_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_LanguageInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set Language.
	 *
	 * @param AD_Language Language for this entity
	 */

	public void setAD_Language(String AD_Language) {
		if (get_ID() == 0) {
			super.setAD_Language(AD_Language);
		}
	}
	/**
	 * Set Language ID.
	 *
	 * @param AD_Language_ID Language ID
	 */

	public void setAD_Language_ID(int AD_Language_ID) {
		if (get_ID() == 0) {
			super.setAD_Language_ID(AD_Language_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Language_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Language_UU();
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
	 * Set Print Paper.
	 *
	 * @param AD_PrintPaper Printer paper definition
	 */
	@JsonProperty("AD_PrintPaper")
	public void setAD_PrintPaperInput(ForeignEntityInput AD_PrintPaper) {
		this.mAD_PrintPaper = AD_PrintPaper;
		if (AD_PrintPaper != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintPaper foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintPaper", "AD_PrintPaper_UU=?", get_TrxName())
							.setParameters(AD_PrintPaper.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintPaper_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintPaper with UUID " + AD_PrintPaper.getUUID());
			}
		} else {
			this.setAD_PrintPaper_ID(0);
		}
	}

	/**
	 * Get Print Paper.
	 *
	 * @return Printer paper definition
	 */
	@JsonProperty("AD_PrintPaper")
	public ForeignEntityInput AD_PrintPaper() {
		return mAD_PrintPaper;
	}
	/**
	 * Set Base Language.
	 *
	 * @param IsBaseLanguage The system information is maintained in this language
	 */

	public void setIsBaseLanguage(boolean IsBaseLanguage) {
		if (get_ID() == 0) {
			super.setIsBaseLanguage(IsBaseLanguage);
		}
	}
}
