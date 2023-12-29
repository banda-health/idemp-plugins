package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperLabels;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperLabelsCfg;
import org.compiere.util.Env;

/**
 * Generated Model for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperLabelsInput extends MShipperLabels implements I_M_ShipperLabelsInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput LabelPrintMethod_RL;
	 private I_M_ShipperInput M_Shipper;
	 private I_M_ShipperLabelsCfgInput M_ShipperLabelsCfg;

	/**
	 * Standard constructor
	 */
	public X_M_ShipperLabelsInput(String ID) {
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
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	public void setM_Shipper(I_M_ShipperInput M_Shipper) {
		this.M_Shipper = M_Shipper;
		MShipper foreignEntity;
		if (get_ID() == 0 &&M_Shipper != null &&
				(foreignEntity = new Query(getCtx(), MShipper.Table_Name, MShipper.COLUMNNAME_M_Shipper_UU + "=?", get_TrxName())
						.setParameters(M_Shipper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Shipper_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public I_M_ShipperInput getM_Shipper() {
		return M_Shipper;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ShipperLabels_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ShipperLabels_UU();
	}

	/**
	 * Set Shipper Labels Configuration.
	 *
	 * @param M_ShipperLabelsCfg Shipper Labels Configuration
	 */
	public void setM_ShipperLabelsCfg(I_M_ShipperLabelsCfgInput M_ShipperLabelsCfg) {
		this.M_ShipperLabelsCfg = M_ShipperLabelsCfg;
		X_M_ShipperLabelsCfg foreignEntity;
		if (M_ShipperLabelsCfg != null &&
				(foreignEntity = new Query(getCtx(), X_M_ShipperLabelsCfg.Table_Name, X_M_ShipperLabelsCfg.COLUMNNAME_M_ShipperLabelsCfg_UU + "=?", get_TrxName())
						.setParameters(M_ShipperLabelsCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShipperLabelsCfg_ID(foreignEntity.get_ID());
		} else {
			this.setM_ShipperLabelsCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Labels Configuration.
	 *
	 * @return Shipper Labels Configuration
	 */
	public I_M_ShipperLabelsCfgInput getM_ShipperLabelsCfg() {
		return M_ShipperLabelsCfg;
	}
}
