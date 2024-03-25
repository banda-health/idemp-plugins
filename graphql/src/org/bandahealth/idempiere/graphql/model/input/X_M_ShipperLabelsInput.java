package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperLabels;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperLabelsCfg;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperLabelsInput extends MShipperLabels implements I_M_ShipperLabelsInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_ShipperLabelsCfg;
	private I_AD_Ref_ListInput mLabelPrintMethod;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ShipperLabels_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ShipperLabelsInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set Label Print Method.
	 *
	 * @param LabelPrintMethod Label Print Method
	 */
	@JsonProperty("LabelPrintMethod")
	public void setLabelPrintMethodInput(I_AD_Ref_ListInput LabelPrintMethod) {
		this.mLabelPrintMethod = LabelPrintMethod;
		if (LabelPrintMethod != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LabelPrintMethod.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setLabelPrintMethod(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + LabelPrintMethod.getUUID());
			}
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
		if (get_ID() != 0) {
			return;
		}
		if (M_Shipper != null) {
			// Since an entity was passed, make sure it's in the DB
			MShipper foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Shipper", "M_Shipper_UU=?", get_TrxName())
							.setParameters(M_Shipper.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Shipper_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Shipper with UUID " + M_Shipper.getUUID());
			}
		} else {
			this.setM_Shipper_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_ShipperLabels_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (M_ShipperLabelsCfg != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_ShipperLabelsCfg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShipperLabelsCfg", "M_ShipperLabelsCfg_UU=?", get_TrxName())
							.setParameters(M_ShipperLabelsCfg.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_ShipperLabelsCfg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShipperLabelsCfg with UUID " + M_ShipperLabelsCfg.getUUID());
			}
		} else {
			this.setM_ShipperLabelsCfg_ID(0);
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
