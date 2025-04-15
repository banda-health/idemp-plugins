package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MChangeRequest;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.MPPProductBOM;

import java.sql.ResultSet;

/**
 * Generated Model for M_ChangeRequest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ChangeRequestInput extends MChangeRequest implements I_M_ChangeRequestInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_ChangeNotice;
	private ForeignEntityInput mM_FixChangeNotice;
	private ForeignEntityInput mPP_Product_BOM;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_ChangeRequest_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ChangeRequestInput(@JsonProperty("UU") String UU) {
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
		if (get_ID() != 0) {
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
	 * Set Change Notice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public void setM_ChangeNoticeInput(ForeignEntityInput M_ChangeNotice) {
		this.mM_ChangeNotice = M_ChangeNotice;
		if (get_ID() != 0) {
			return;
		}
		if (M_ChangeNotice != null) {
			// Since an entity was passed, make sure it's in the DB
			MChangeNotice foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
							.setParameters(M_ChangeNotice.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_ChangeNotice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ChangeNotice with UU " + M_ChangeNotice.getUU());
			}
		} else {
			this.setM_ChangeNotice_ID(0);
		}
	}

	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public ForeignEntityInput M_ChangeNotice() {
		return mM_ChangeNotice;
	}
	/**
	 * Set Change Request.
	 *
	 * @param M_ChangeRequest_ID BOM (Engineering) Change Request
	 */
	@JsonProperty("M_ChangeRequest_ID")
	public void setM_ChangeRequest_IDFromJson(int M_ChangeRequest_ID) {
		if (get_ID() == 0) {
			super.setM_ChangeRequest_ID(M_ChangeRequest_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_ChangeRequest_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_ChangeRequest_UU();
	}

	/**
	 * Set Fixed in.
	 *
	 * @param M_FixChangeNotice Fixed in Change Notice
	 */
	@JsonProperty("M_FixChangeNotice")
	public void setM_FixChangeNoticeInput(ForeignEntityInput M_FixChangeNotice) {
		this.mM_FixChangeNotice = M_FixChangeNotice;
		if (get_ID() != 0) {
			return;
		}
		if (M_FixChangeNotice != null) {
			// Since an entity was passed, make sure it's in the DB
			MChangeNotice foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
							.setParameters(M_FixChangeNotice.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_FixChangeNotice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ChangeNotice with UU " + M_FixChangeNotice.getUU());
			}
		} else {
			this.setM_FixChangeNotice_ID(0);
		}
	}

	/**
	 * Get Fixed in.
	 *
	 * @return Fixed in Change Notice
	 */
	@JsonProperty("M_FixChangeNotice")
	public ForeignEntityInput M_FixChangeNotice() {
		return mM_FixChangeNotice;
	}

	/**
	 * Set BOM & Formula.
	 *
	 * @param PP_Product_BOM BOM & Formula
	 */
	@JsonProperty("PP_Product_BOM")
	public void setPP_Product_BOMInput(ForeignEntityInput PP_Product_BOM) {
		this.mPP_Product_BOM = PP_Product_BOM;
		if (get_ID() != 0) {
			return;
		}
		if (PP_Product_BOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MPPProductBOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Product_BOM", "PP_Product_BOM_UU=?", get_TrxName())
							.setParameters(PP_Product_BOM.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPP_Product_BOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Product_BOM with UU " + PP_Product_BOM.getUU());
			}
		} else {
			this.setPP_Product_BOM_ID(0);
		}
	}

	/**
	 * Get BOM & Formula.
	 *
	 * @return BOM & Formula
	 */
	@JsonProperty("PP_Product_BOM")
	public ForeignEntityInput PP_Product_BOM() {
		return mPP_Product_BOM;
	}
}
