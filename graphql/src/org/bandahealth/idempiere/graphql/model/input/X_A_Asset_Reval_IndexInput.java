package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_A_Asset_Reval_IndexResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Reval_Index;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Reval_Index - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_Reval_IndexInput extends X_A_Asset_Reval_Index implements I_A_Asset_Reval_IndexInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Reval_Code;
	private ForeignEntityInput mA_Reval_Multiplier;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_Asset_Reval_Index_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_Reval_IndexInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Asset Reval Index.
	 *
	 * @param A_Asset_Reval_Index_ID Asset Reval Index
	 */
	@JsonProperty("A_Asset_Reval_Index_ID")
	public void setA_Asset_Reval_Index_IDFromJson(int A_Asset_Reval_Index_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Reval_Index_ID(A_Asset_Reval_Index_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Asset_Reval_Index_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_Asset_Reval_Index_UU();
	}

	/**
	 * Set Reval. Code.
	 *
	 * @param A_Reval_Code Reval. Code
	 */
	@JsonProperty("A_Reval_Code")
	public void setA_Reval_CodeInput(ForeignEntityInput A_Reval_Code) {
		this.mA_Reval_Code = A_Reval_Code;
		if (A_Reval_Code != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_Reval_IndexResolver.A_REVAL_CODE_UUIDS_BY_VALUE.containsValue(A_Reval_Code.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Reval_Code.getUU() +
						" is not in the list defined for the A_Reval_Code column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Reval_Code.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Reval_Code(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Reval_Code.getUU());
			}
		} else {
			this.setA_Reval_Code(null);
		}
	}

	/**
	 * Get Reval. Code.
	 *
	 * @return Reval. Code
	 */
	@JsonProperty("A_Reval_Code")
	public ForeignEntityInput A_Reval_Code() {
		return mA_Reval_Code;
	}

	/**
	 * Set Reval. Multiplier.
	 *
	 * @param A_Reval_Multiplier Reval. Multiplier
	 */
	@JsonProperty("A_Reval_Multiplier")
	public void setA_Reval_MultiplierInput(ForeignEntityInput A_Reval_Multiplier) {
		this.mA_Reval_Multiplier = A_Reval_Multiplier;
		if (A_Reval_Multiplier != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_Reval_IndexResolver.A_REVAL_MULTIPLIER_UUIDS_BY_VALUE.containsValue(A_Reval_Multiplier.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Reval_Multiplier.getUU() +
						" is not in the list defined for the A_Reval_Multiplier column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Reval_Multiplier.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Reval_Multiplier(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Reval_Multiplier.getUU());
			}
		} else {
			this.setA_Reval_Multiplier(null);
		}
	}

	/**
	 * Get Reval. Multiplier.
	 *
	 * @return Reval. Multiplier
	 */
	@JsonProperty("A_Reval_Multiplier")
	public ForeignEntityInput A_Reval_Multiplier() {
		return mA_Reval_Multiplier;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
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
}
