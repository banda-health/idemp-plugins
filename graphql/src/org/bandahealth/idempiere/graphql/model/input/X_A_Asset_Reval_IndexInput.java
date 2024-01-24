package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Reval_IndexInput extends X_A_Asset_Reval_Index implements I_A_Asset_Reval_IndexInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mA_Reval_Code;
	private I_AD_Ref_ListInput mA_Reval_Multiplier;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Asset_Reval_Index_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_Reval_IndexInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_A_Asset_Reval_Index(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set Asset Reval Index.
	 *
	 * @param A_Asset_Reval_Index_ID Asset Reval Index
	 */

	public void setA_Asset_Reval_Index_ID(int A_Asset_Reval_Index_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Reval_Index_ID(A_Asset_Reval_Index_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Asset_Reval_Index_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getA_Asset_Reval_Index_UU();
	}

	/**
	 * Set Reval. Code.
	 *
	 * @param A_Reval_Code Reval. Code
	 */
	@JsonProperty("A_Reval_Code")
	public void setA_Reval_CodeInput(I_AD_Ref_ListInput A_Reval_Code) {
		this.mA_Reval_Code = A_Reval_Code;
		MRefList_BH foreignEntity;
		if (A_Reval_Code != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Reval_Code.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Reval_Code(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + A_Reval_Code.getUUID());
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
	public I_AD_Ref_ListInput A_Reval_Code() {
		return mA_Reval_Code;
	}

	/**
	 * Set Reval. Multiplier.
	 *
	 * @param A_Reval_Multiplier Reval. Multiplier
	 */
	@JsonProperty("A_Reval_Multiplier")
	public void setA_Reval_MultiplierInput(I_AD_Ref_ListInput A_Reval_Multiplier) {
		this.mA_Reval_Multiplier = A_Reval_Multiplier;
		MRefList_BH foreignEntity;
		if (A_Reval_Multiplier != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Reval_Multiplier.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Reval_Multiplier(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + A_Reval_Multiplier.getUUID());
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
	public I_AD_Ref_ListInput A_Reval_Multiplier() {
		return mA_Reval_Multiplier;
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
		if (AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			super.setAD_Org_ID(0);
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
}
