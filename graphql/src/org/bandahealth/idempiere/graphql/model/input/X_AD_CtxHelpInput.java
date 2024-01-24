package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_CtxHelpInput extends MCtxHelp implements I_AD_CtxHelpInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mCtxType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_CtxHelpInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MCtxHelp(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}
	/**
	 * Set Context Help.
	 *
	 * @param AD_CtxHelp_ID Context Help
	 */

	public void setAD_CtxHelp_ID(int AD_CtxHelp_ID) {
		if (get_ID() == 0) {
			super.setAD_CtxHelp_ID(AD_CtxHelp_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_CtxHelp_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_CtxHelp_UU();
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
	 * Set Context Type.
	 *
	 * @param CtxType Type of Context Help
	 */
	@JsonProperty("CtxType")
	public void setCtxTypeInput(I_AD_Ref_ListInput CtxType) {
		this.mCtxType = CtxType;
		MRefList_BH foreignEntity;
		if (CtxType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CtxType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCtxType(foreignEntity.getValue());
		} else {
			this.setCtxType(null);
		}
	}

	/**
	 * Get Context Type.
	 *
	 * @return Type of Context Help
	 */
	@JsonProperty("CtxType")
	public I_AD_Ref_ListInput CtxType() {
		return mCtxType;
	}
}
