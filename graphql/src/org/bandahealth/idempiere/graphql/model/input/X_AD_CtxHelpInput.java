package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_CtxHelp;
import org.compiere.util.Env;

/**
 * Generated Model for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_CtxHelpInput extends X_AD_CtxHelp implements I_AD_CtxHelpInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CtxType_RL;

	/**
	 * Standard constructor
	 */
	public X_AD_CtxHelpInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
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
	 * Set Context Type.
	 *
	 * @param CtxType_RL Type of Context Help
	 */
	public void setCtxType_RL(I_AD_Ref_ListInput CtxType_RL) {
		this.CtxType_RL = CtxType_RL;
		MRefList foreignEntity;
		if (CtxType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CtxType_RL.getID())
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
	public I_AD_Ref_ListInput getCtxType_RL() {
		return CtxType_RL;
	}
}
