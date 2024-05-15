package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_Table_HeaderInput extends X_A_Depreciation_Table_Header implements I_A_Depreciation_Table_HeaderInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Table_Rate_Type;
	private ForeignEntityInput mA_Term;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_Depreciation_Table_Header_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Depreciation_Table_HeaderInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set A_Depreciation_Table_Header_ID.
	 *
	 * @param A_Depreciation_Table_Header_ID A_Depreciation_Table_Header_ID
	 */

	public void setA_Depreciation_Table_Header_ID(int A_Depreciation_Table_Header_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Table_Header_ID(A_Depreciation_Table_Header_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Depreciation_Table_Header_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_Depreciation_Table_Header_UU();
	}

	/**
	 * Set Type.
	 *
	 * @param A_Table_Rate_Type Type
	 */
	@JsonProperty("A_Table_Rate_Type")
	public void setA_Table_Rate_TypeInput(ForeignEntityInput A_Table_Rate_Type) {
		this.mA_Table_Rate_Type = A_Table_Rate_Type;
		if (A_Table_Rate_Type != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Table_Rate_Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Table_Rate_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Table_Rate_Type.getUU());
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
	public ForeignEntityInput A_Table_Rate_Type() {
		return mA_Table_Rate_Type;
	}

	/**
	 * Set Period/Yearly.
	 *
	 * @param A_Term Period/Yearly
	 */
	@JsonProperty("A_Term")
	public void setA_TermInput(ForeignEntityInput A_Term) {
		this.mA_Term = A_Term;
		if (A_Term != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Term.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Term(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Term.getUU());
			}
		} else {
			this.setA_Term(null);
		}
	}

	/**
	 * Get Period/Yearly.
	 *
	 * @return Period/Yearly
	 */
	@JsonProperty("A_Term")
	public ForeignEntityInput A_Term() {
		return mA_Term;
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
