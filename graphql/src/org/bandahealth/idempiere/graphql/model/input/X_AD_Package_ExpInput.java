package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPackageExp;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_ExpInput extends MPackageExp implements I_AD_Package_ExpInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mAD_Package_Type;
	private I_AD_Ref_ListInput mReleaseNo;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Package_ExpInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MPackageExp(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	/**
	 * Set Package Exp..
	 *
	 * @param AD_Package_Exp_ID Package Exp.
	 */

	public void setAD_Package_Exp_ID(int AD_Package_Exp_ID) {
		if (get_ID() == 0) {
			super.setAD_Package_Exp_ID(AD_Package_Exp_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Package_Exp_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Package_Exp_UU();
	}

	/**
	 * Set Package Type.
	 *
	 * @param AD_Package_Type Package Type
	 */
	@JsonProperty("AD_Package_Type")
	public void setAD_Package_TypeInput(I_AD_Ref_ListInput AD_Package_Type) {
		this.mAD_Package_Type = AD_Package_Type;
		MRefList_BH foreignEntity;
		if (AD_Package_Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AD_Package_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Package_Type(foreignEntity.getValue());
		} else {
			this.setAD_Package_Type(null);
		}
	}

	/**
	 * Get Package Type.
	 *
	 * @return Package Type
	 */
	@JsonProperty("AD_Package_Type")
	public I_AD_Ref_ListInput AD_Package_Type() {
		return mAD_Package_Type;
	}

	/**
	 * Set Release No.
	 *
	 * @param ReleaseNo Internal Release Number
	 */
	@JsonProperty("ReleaseNo")
	public void setReleaseNoInput(I_AD_Ref_ListInput ReleaseNo) {
		this.mReleaseNo = ReleaseNo;
		MRefList_BH foreignEntity;
		if (ReleaseNo != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ReleaseNo.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReleaseNo(foreignEntity.getValue());
		} else {
			this.setReleaseNo(null);
		}
	}

	/**
	 * Get Release No.
	 *
	 * @return Internal Release Number
	 */
	@JsonProperty("ReleaseNo")
	public I_AD_Ref_ListInput ReleaseNo() {
		return mReleaseNo;
	}
}
