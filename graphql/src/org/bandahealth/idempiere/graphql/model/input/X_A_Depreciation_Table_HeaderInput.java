package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Table_Header;

import java.sql.ResultSet;

/**
 * Generated Model for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_Table_HeaderInput extends X_A_Depreciation_Table_Header implements I_A_Depreciation_Table_HeaderInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mA_Table_Rate_Type;
	private I_AD_Ref_ListInput mA_Term;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Depreciation_Table_HeaderInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_A_Depreciation_Table_Header(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Depreciation_Table_Header_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Depreciation_Table_Header_UU();
	}

	/**
	 * Set Type.
	 *
	 * @param A_Table_Rate_Type Type
	 */
	@JsonProperty("A_Table_Rate_Type")
	public void setA_Table_Rate_TypeInput(I_AD_Ref_ListInput A_Table_Rate_Type) {
		this.mA_Table_Rate_Type = A_Table_Rate_Type;
		MRefList_BH foreignEntity;
		if (A_Table_Rate_Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Table_Rate_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Table_Rate_Type(foreignEntity.getValue());
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
	 * Set Period/Yearly.
	 *
	 * @param A_Term Period/Yearly
	 */
	@JsonProperty("A_Term")
	public void setA_TermInput(I_AD_Ref_ListInput A_Term) {
		this.mA_Term = A_Term;
		MRefList_BH foreignEntity;
		if (A_Term != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Term.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Term(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput A_Term() {
		return mA_Term;
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
