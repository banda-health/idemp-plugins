package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperLabels;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperLabelsCfg;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperLabelsInput extends MShipperLabels implements I_M_ShipperLabelsInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_ShipperLabelsCfg;
	private I_AD_Ref_ListInput mLabelPrintMethod;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_ShipperLabelsInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MShipperLabels(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Label Print Method.
	 *
	 * @param LabelPrintMethod Label Print Method
	 */
	@JsonProperty("LabelPrintMethod")
	public void setLabelPrintMethodInput(I_AD_Ref_ListInput LabelPrintMethod) {
		this.mLabelPrintMethod = LabelPrintMethod;
		MRefList_BH foreignEntity;
		if (LabelPrintMethod != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LabelPrintMethod.getID())
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
	@JsonProperty("LabelPrintMethod")
	public I_AD_Ref_ListInput LabelPrintMethod() {
		return mLabelPrintMethod;
	}

	/**
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public void setM_ShipperInput(ForeignEntityInput M_Shipper) {
		this.mM_Shipper = M_Shipper;
		MShipper foreignEntity;
		if (get_ID() == 0 && M_Shipper != null &&
				(foreignEntity = new Query(getCtx(), "M_Shipper", "M_Shipper_UU=?", get_TrxName())
						.setParameters(M_Shipper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Shipper_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public ForeignEntityInput M_Shipper() {
		return mM_Shipper;
	}
	/**
	 * Set Shipper Labels.
	 *
	 * @param M_ShipperLabels_ID Shipper Labels
	 */

	public void setM_ShipperLabels_ID(int M_ShipperLabels_ID) {
		if (get_ID() == 0) {
			super.setM_ShipperLabels_ID(M_ShipperLabels_ID);
		}
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
	@JsonProperty("M_ShipperLabelsCfg")
	public void setM_ShipperLabelsCfgInput(ForeignEntityInput M_ShipperLabelsCfg) {
		this.mM_ShipperLabelsCfg = M_ShipperLabelsCfg;
		X_M_ShipperLabelsCfg foreignEntity;
		if (M_ShipperLabelsCfg != null &&
				(foreignEntity = new Query(getCtx(), "M_ShipperLabelsCfg", "M_ShipperLabelsCfg_UU=?", get_TrxName())
						.setParameters(M_ShipperLabelsCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShipperLabelsCfg_ID(foreignEntity.get_ID());
		} else {
			super.setM_ShipperLabelsCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Labels Configuration.
	 *
	 * @return Shipper Labels Configuration
	 */
	@JsonProperty("M_ShipperLabelsCfg")
	public ForeignEntityInput M_ShipperLabelsCfg() {
		return mM_ShipperLabelsCfg;
	}
}
