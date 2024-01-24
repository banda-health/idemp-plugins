package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShipperLabelsCfg;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShipperLabelsCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShipperLabelsCfgInput extends X_M_ShipperLabelsCfg implements I_M_ShipperLabelsCfgInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_ShipperCfg;
	private I_AD_Ref_ListInput mLabelPrintMethod;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_ShipperLabelsCfgInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_ShipperLabelsCfg(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Shipper Configuration.
	 *
	 * @param M_ShipperCfg Shipper Configuration
	 */
	@JsonProperty("M_ShipperCfg")
	public void setM_ShipperCfgInput(ForeignEntityInput M_ShipperCfg) {
		this.mM_ShipperCfg = M_ShipperCfg;
		X_M_ShipperCfg foreignEntity;
		if (get_ID() == 0 && M_ShipperCfg != null &&
				(foreignEntity = new Query(getCtx(), "M_ShipperCfg", "M_ShipperCfg_UU=?", get_TrxName())
						.setParameters(M_ShipperCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShipperCfg_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipper Configuration.
	 *
	 * @return Shipper Configuration
	 */
	@JsonProperty("M_ShipperCfg")
	public ForeignEntityInput M_ShipperCfg() {
		return mM_ShipperCfg;
	}
	/**
	 * Set Shipper Labels Configuration.
	 *
	 * @param M_ShipperLabelsCfg_ID Shipper Labels Configuration
	 */

	public void setM_ShipperLabelsCfg_ID(int M_ShipperLabelsCfg_ID) {
		if (get_ID() == 0) {
			super.setM_ShipperLabelsCfg_ID(M_ShipperLabelsCfg_ID);
		}
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
