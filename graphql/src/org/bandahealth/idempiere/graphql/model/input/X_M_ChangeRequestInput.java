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
 * @version Release 7.1 - $Id$
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
	 * @param UUID The M_ChangeRequest_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ChangeRequestInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MChangeRequest(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Change Notice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public void setM_ChangeNoticeInput(ForeignEntityInput M_ChangeNotice) {
		this.mM_ChangeNotice = M_ChangeNotice;
		MChangeNotice foreignEntity;
		if (get_ID() == 0 && M_ChangeNotice != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
							.setParameters(M_ChangeNotice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ChangeNotice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ChangeNotice with UUID " + M_ChangeNotice.getUUID());
			}
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

	public void setM_ChangeRequest_ID(int M_ChangeRequest_ID) {
		if (get_ID() == 0) {
			super.setM_ChangeRequest_ID(M_ChangeRequest_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_ChangeRequest_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		MChangeNotice foreignEntity;
		if (get_ID() == 0 && M_FixChangeNotice != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
							.setParameters(M_FixChangeNotice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_FixChangeNotice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ChangeNotice with UUID " + M_FixChangeNotice.getUUID());
			}
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
		MPPProductBOM foreignEntity;
		if (get_ID() == 0 && PP_Product_BOM != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "PP_Product_BOM", "PP_Product_BOM_UU=?", get_TrxName())
							.setParameters(PP_Product_BOM.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPP_Product_BOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Product_BOM with UUID " + PP_Product_BOM.getUUID());
			}
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
