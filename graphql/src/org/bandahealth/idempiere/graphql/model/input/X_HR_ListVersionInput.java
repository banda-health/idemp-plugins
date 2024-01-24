package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.eevolution.model.X_HR_List;
import org.eevolution.model.X_HR_ListVersion;

import java.sql.ResultSet;

/**
 * Generated Model for HR_ListVersion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ListVersionInput extends X_HR_ListVersion implements I_HR_ListVersionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mHR_List;
	private ForeignEntityInput mHR_ListBase;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_HR_ListVersionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_HR_ListVersion(null, (ResultSet) null, null), null, Table_Name, ID),
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

	/**
	 * Set Payroll List.
	 *
	 * @param HR_List Payroll List
	 */
	@JsonProperty("HR_List")
	public void setHR_ListInput(ForeignEntityInput HR_List) {
		this.mHR_List = HR_List;
		X_HR_List foreignEntity;
		if (get_ID() == 0 && HR_List != null &&
				(foreignEntity = new Query(getCtx(), "HR_List", "HR_List_UU=?", get_TrxName())
						.setParameters(HR_List.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_List_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Payroll List.
	 *
	 * @return Payroll List
	 */
	@JsonProperty("HR_List")
	public ForeignEntityInput HR_List() {
		return mHR_List;
	}

	/**
	 * Set Payroll List Base.
	 *
	 * @param HR_ListBase Payroll List Base
	 */
	@JsonProperty("HR_ListBase")
	public void setHR_ListBaseInput(ForeignEntityInput HR_ListBase) {
		this.mHR_ListBase = HR_ListBase;
		X_HR_List foreignEntity;
		if (HR_ListBase != null &&
				(foreignEntity = new Query(getCtx(), "HR_List", "HR_List_UU=?", get_TrxName())
						.setParameters(HR_ListBase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_ListBase_ID(foreignEntity.get_ID());
		} else {
			super.setHR_ListBase_ID(0);
		}
	}

	/**
	 * Get Payroll List Base.
	 *
	 * @return Payroll List Base
	 */
	@JsonProperty("HR_ListBase")
	public ForeignEntityInput HR_ListBase() {
		return mHR_ListBase;
	}
	/**
	 * Set Payroll List Version.
	 *
	 * @param HR_ListVersion_ID Payroll List Version
	 */

	public void setHR_ListVersion_ID(int HR_ListVersion_ID) {
		if (get_ID() == 0) {
			super.setHR_ListVersion_ID(HR_ListVersion_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setHR_ListVersion_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getHR_ListVersion_UU();
	}
}
