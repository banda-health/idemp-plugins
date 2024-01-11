package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Info_Tax;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Info_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_TaxInput extends X_A_Asset_Info_Tax implements I_A_Asset_Info_TaxInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private I_AD_Ref_ListInput mA_Finance_Meth;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_Info_TaxInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_A_Asset_Info_Tax(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (get_ID() == 0 && A_Asset != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public ForeignEntityInput A_Asset() {
		return mA_Asset;
	}
	/**
	 * Set Asset Info Tax.
	 *
	 * @param A_Asset_Info_Tax_ID Asset Info Tax
	 */

	public void setA_Asset_Info_Tax_ID(int A_Asset_Info_Tax_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Info_Tax_ID(A_Asset_Info_Tax_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Info_Tax_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Info_Tax_UU();
	}

	/**
	 * Set Asset Finance Method.
	 *
	 * @param A_Finance_Meth Asset Finance Method
	 */
	@JsonProperty("A_Finance_Meth")
	public void setA_Finance_MethInput(I_AD_Ref_ListInput A_Finance_Meth) {
		this.mA_Finance_Meth = A_Finance_Meth;
		MRefList_BH foreignEntity;
		if (A_Finance_Meth != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Finance_Meth.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Finance_Meth(foreignEntity.getValue());
		} else {
			this.setA_Finance_Meth(null);
		}
	}

	/**
	 * Get Asset Finance Method.
	 *
	 * @return Asset Finance Method
	 */
	@JsonProperty("A_Finance_Meth")
	public I_AD_Ref_ListInput A_Finance_Meth() {
		return mA_Finance_Meth;
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
}
