package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Language;
import org.compiere.model.X_AD_PrintPaper;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LanguageInput extends X_AD_Language implements I_AD_LanguageInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintPaperInput AD_PrintPaper;

	/**
	 * Standard constructor
	 */
	public X_AD_LanguageInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
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
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Print Paper.
	 *
	 * @param AD_PrintPaper Printer paper definition
	 */
	public void setAD_PrintPaper(I_AD_PrintPaperInput AD_PrintPaper) {
		this.AD_PrintPaper = AD_PrintPaper;
		X_AD_PrintPaper foreignEntity;
		if (AD_PrintPaper != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintPaper.Table_Name, X_AD_PrintPaper.COLUMNNAME_AD_PrintPaper_UU + "=?", get_TrxName())
						.setParameters(AD_PrintPaper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintPaper_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintPaper_ID(0);
		}
	}

	/**
	 * Get Print Paper.
	 *
	 * @return Printer paper definition
	 */
	public I_AD_PrintPaperInput getAD_PrintPaper() {
		return AD_PrintPaper;
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
