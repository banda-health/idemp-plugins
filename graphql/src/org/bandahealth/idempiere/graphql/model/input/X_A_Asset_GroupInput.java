package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAssetClass;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_GroupInput extends MAssetGroup implements I_A_Asset_GroupInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset_Class;
	private ForeignEntityInput mA_Asset_Type;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_GroupInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAssetGroup(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Asset class.
	 *
	 * @param A_Asset_Class Asset class
	 */
	@JsonProperty("A_Asset_Class")
	public void setA_Asset_ClassInput(ForeignEntityInput A_Asset_Class) {
		this.mA_Asset_Class = A_Asset_Class;
		MAssetClass foreignEntity;
		if (A_Asset_Class != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset_Class", "A_Asset_Class_UU=?", get_TrxName())
						.setParameters(A_Asset_Class.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Class_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Class_ID(0);
		}
	}

	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	@JsonProperty("A_Asset_Class")
	public ForeignEntityInput A_Asset_Class() {
		return mA_Asset_Class;
	}
	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group_ID Group of Assets
	 */

	public void setA_Asset_Group_ID(int A_Asset_Group_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Group_ID(A_Asset_Group_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Group_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Group_UU();
	}

	/**
	 * Set Asset Type.
	 *
	 * @param A_Asset_Type Asset Type
	 */
	@JsonProperty("A_Asset_Type")
	public void setA_Asset_TypeInput(ForeignEntityInput A_Asset_Type) {
		this.mA_Asset_Type = A_Asset_Type;
		MAssetType foreignEntity;
		if (A_Asset_Type != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset_Type", "A_Asset_Type_UU=?", get_TrxName())
						.setParameters(A_Asset_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Type_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Type_ID(0);
		}
	}

	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	@JsonProperty("A_Asset_Type")
	public ForeignEntityInput A_Asset_Type() {
		return mA_Asset_Type;
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
