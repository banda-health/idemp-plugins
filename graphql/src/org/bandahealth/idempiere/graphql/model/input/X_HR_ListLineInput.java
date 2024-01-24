package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.eevolution.model.X_HR_ListLine;
import org.eevolution.model.X_HR_ListVersion;

import java.sql.ResultSet;

/**
 * Generated Model for HR_ListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_ListLineInput extends X_HR_ListLine implements I_HR_ListLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mHR_ListVersion;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_HR_ListLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_HR_ListLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Payroll List Line.
	 *
	 * @param HR_ListLine_ID Payroll List Line
	 */

	public void setHR_ListLine_ID(int HR_ListLine_ID) {
		if (get_ID() == 0) {
			super.setHR_ListLine_ID(HR_ListLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setHR_ListLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getHR_ListLine_UU();
	}

	/**
	 * Set Payroll List Version.
	 *
	 * @param HR_ListVersion Payroll List Version
	 */
	@JsonProperty("HR_ListVersion")
	public void setHR_ListVersionInput(ForeignEntityInput HR_ListVersion) {
		this.mHR_ListVersion = HR_ListVersion;
		X_HR_ListVersion foreignEntity;
		if (get_ID() == 0 && HR_ListVersion != null &&
				(foreignEntity = new Query(getCtx(), "HR_ListVersion", "HR_ListVersion_UU=?", get_TrxName())
						.setParameters(HR_ListVersion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_ListVersion_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Payroll List Version.
	 *
	 * @return Payroll List Version
	 */
	@JsonProperty("HR_ListVersion")
	public ForeignEntityInput HR_ListVersion() {
		return mHR_ListVersion;
	}
}
