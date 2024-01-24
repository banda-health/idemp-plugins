package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Info_Tax;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Info_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_Info_TaxInput extends X_A_Asset_Info_Tax implements I_A_Asset_Info_TaxInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private I_AD_Ref_ListInput mA_Finance_Meth;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Asset_Info_Tax_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_Info_TaxInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_A_Asset_Info_Tax(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && A_Asset != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Asset_Info_Tax_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (A_Finance_Meth != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Finance_Meth.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Finance_Meth(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + A_Finance_Meth.getUUID());
			}
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
}
