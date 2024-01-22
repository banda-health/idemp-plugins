package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Reval_Index;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Reval_Index - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_Reval_IndexInput extends X_A_Asset_Reval_Index implements I_A_Asset_Reval_IndexInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mA_Reval_Code;
	private I_AD_Ref_ListInput mA_Reval_Multiplier;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_Reval_IndexInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_A_Asset_Reval_Index(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Reval_Index_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		if (A_Reval_Code != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Code.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Code(foreignEntity.getValue());
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
		if (A_Reval_Multiplier != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Multiplier.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Multiplier(foreignEntity.getValue());
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
