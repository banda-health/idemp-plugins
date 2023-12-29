package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShipperLabelsCfg;
import org.compiere.util.Env;

/**
 * Generated Model for M_ShipperLabelsCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperLabelsCfgInput extends X_M_ShipperLabelsCfg implements I_M_ShipperLabelsCfgInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput LabelPrintMethod_RL;
	 private I_M_ShipperCfgInput M_ShipperCfg;

	/**
	 * Standard constructor
	 */
	public X_M_ShipperLabelsCfgInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	 * Set Label Print Method.
	 *
	 * @param LabelPrintMethod_RL Label Print Method
	 */
	public void setLabelPrintMethod_RL(I_AD_Ref_ListInput LabelPrintMethod_RL) {
		this.LabelPrintMethod_RL = LabelPrintMethod_RL;
		MRefList foreignEntity;
		if (LabelPrintMethod_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LabelPrintMethod_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLabelPrintMethod(foreignEntity.getValue());
		} else {
			this.setLabelPrintMethod(null);
		}
	}

	/**
	 * Get Label Print Method.
	 *
	 * @return Label Print Method
	 */
	public I_AD_Ref_ListInput getLabelPrintMethod_RL() {
		return LabelPrintMethod_RL;
	}

	/**
	 * Set Shipper Configuration.
	 *
	 * @param M_ShipperCfg Shipper Configuration
	 */
	public void setM_ShipperCfg(I_M_ShipperCfgInput M_ShipperCfg) {
		this.M_ShipperCfg = M_ShipperCfg;
		X_M_ShipperCfg foreignEntity;
		if (get_ID() == 0 &&M_ShipperCfg != null &&
				(foreignEntity = new Query(getCtx(), X_M_ShipperCfg.Table_Name, X_M_ShipperCfg.COLUMNNAME_M_ShipperCfg_UU + "=?", get_TrxName())
						.setParameters(M_ShipperCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShipperCfg_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	public I_M_ShipperCfgInput getM_ShipperCfg() {
		return M_ShipperCfg;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ShipperLabelsCfg_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ShipperLabelsCfg_UU();
	}
}
