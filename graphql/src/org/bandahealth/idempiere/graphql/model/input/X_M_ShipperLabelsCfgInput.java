package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_M_ShipperLabelsCfgResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperCfg;
import org.compiere.model.X_M_ShipperLabelsCfg;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShipperLabelsCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShipperLabelsCfgInput extends X_M_ShipperLabelsCfg implements I_M_ShipperLabelsCfgInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mLabelPrintMethod;
	private ForeignEntityInput mM_ShipperCfg;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_ShipperLabelsCfg_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ShipperLabelsCfgInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
	public void setLabelPrintMethodInput(ForeignEntityInput LabelPrintMethod) {
		this.mLabelPrintMethod = LabelPrintMethod;
		if (LabelPrintMethod != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_ShipperLabelsCfgResolver.LABELPRINTMETHOD_UUIDS_BY_VALUE.containsValue(LabelPrintMethod.getUU())) {
				throw new AdempiereException("The reference list UU of " + LabelPrintMethod.getUU() +
						" is not in the list defined for the LabelPrintMethod column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LabelPrintMethod.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setLabelPrintMethod(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + LabelPrintMethod.getUU());
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
	public ForeignEntityInput LabelPrintMethod() {
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
		if (!is_new()) {
			return;
		}
		if (M_ShipperCfg != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_ShipperCfg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShipperCfg", "M_ShipperCfg_UU=?", get_TrxName())
							.setParameters(M_ShipperCfg.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_ShipperCfg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShipperCfg with UU " + M_ShipperCfg.getUU());
			}
		} else {
			this.setM_ShipperCfg_ID(0);
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
	@JsonProperty("M_ShipperLabelsCfg_ID")
	public void setM_ShipperLabelsCfg_IDFromJson(int M_ShipperLabelsCfg_ID) {
		if (get_ID() == 0) {
			super.setM_ShipperLabelsCfg_ID(M_ShipperLabelsCfg_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_ShipperLabelsCfg_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_ShipperLabelsCfg_UU();
	}
}
