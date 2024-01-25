package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Table_Detail;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_Table_DetailInput extends X_A_Depreciation_Table_Detail implements I_A_Depreciation_Table_DetailInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mA_Table_Rate_Type;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Depreciation_Table_Detail_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Depreciation_Table_DetailInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_A_Depreciation_Table_Detail(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set Depreciation Code.
	 *
	 * @param A_Depreciation_Table_Code Depreciation Code
	 */

	public void setA_Depreciation_Table_Code(String A_Depreciation_Table_Code) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Table_Code(A_Depreciation_Table_Code);
		}
	}
	/**
	 * Set Depreciation Table Detail.
	 *
	 * @param A_Depreciation_Table_Detail_ID Depreciation Table Detail
	 */

	public void setA_Depreciation_Table_Detail_ID(int A_Depreciation_Table_Detail_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Table_Detail_ID(A_Depreciation_Table_Detail_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Depreciation_Table_Detail_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getA_Depreciation_Table_Detail_UU();
	}

	/**
	 * Set Type.
	 *
	 * @param A_Table_Rate_Type Type
	 */
	@JsonProperty("A_Table_Rate_Type")
	public void setA_Table_Rate_TypeInput(I_AD_Ref_ListInput A_Table_Rate_Type) {
		this.mA_Table_Rate_Type = A_Table_Rate_Type;
		if (get_ID() != 0) {
			return;
		}
		if (A_Table_Rate_Type != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Table_Rate_Type.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Table_Rate_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + A_Table_Rate_Type.getUUID());
			}
		} else {
			this.setA_Table_Rate_Type(null);
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Type
	 */
	@JsonProperty("A_Table_Rate_Type")
	public I_AD_Ref_ListInput A_Table_Rate_Type() {
		return mA_Table_Rate_Type;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
}
