package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Remuneration;

import java.sql.ResultSet;

/**
 * Generated Model for C_Remuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RemunerationInput extends X_C_Remuneration implements I_C_RemunerationInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mRemunerationType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_RemunerationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_Remuneration(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Remuneration.
	 *
	 * @param C_Remuneration_ID Wage or Salary
	 */

	public void setC_Remuneration_ID(int C_Remuneration_ID) {
		if (get_ID() == 0) {
			super.setC_Remuneration_ID(C_Remuneration_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Remuneration_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Remuneration_UU();
	}

	/**
	 * Set Remuneration Type.
	 *
	 * @param RemunerationType Type of Remuneration
	 */
	@JsonProperty("RemunerationType")
	public void setRemunerationTypeInput(I_AD_Ref_ListInput RemunerationType) {
		this.mRemunerationType = RemunerationType;
		MRefList_BH foreignEntity;
		if (RemunerationType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RemunerationType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRemunerationType(foreignEntity.getValue());
		} else {
			this.setRemunerationType(null);
		}
	}

	/**
	 * Get Remuneration Type.
	 *
	 * @return Type of Remuneration
	 */
	@JsonProperty("RemunerationType")
	public I_AD_Ref_ListInput RemunerationType() {
		return mRemunerationType;
	}
}
