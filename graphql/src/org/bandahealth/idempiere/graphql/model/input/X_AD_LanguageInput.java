package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintPaper;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_LanguageInput extends MLanguage implements I_AD_LanguageInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintPaper;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_LanguageInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MLanguage(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Language_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Language_UU();
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
	 * Set Print Paper.
	 *
	 * @param AD_PrintPaper Printer paper definition
	 */
	@JsonProperty("AD_PrintPaper")
	public void setAD_PrintPaperInput(ForeignEntityInput AD_PrintPaper) {
		this.mAD_PrintPaper = AD_PrintPaper;
		X_AD_PrintPaper foreignEntity;
		if (AD_PrintPaper != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintPaper", "AD_PrintPaper_UU=?", get_TrxName())
						.setParameters(AD_PrintPaper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintPaper_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintPaper_ID(0);
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
