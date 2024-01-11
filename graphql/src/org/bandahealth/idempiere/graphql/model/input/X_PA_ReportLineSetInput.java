package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_PA_ReportLineSet;

import java.sql.ResultSet;

/**
 * Generated Model for PA_ReportLineSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportLineSetInput extends X_PA_ReportLineSet implements I_PA_ReportLineSetInput {

	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_ReportLineSetInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_PA_ReportLineSet(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Report Line Set.
	 *
	 * @param PA_ReportLineSet_ID Report Line Set
	 */

	public void setPA_ReportLineSet_ID(int PA_ReportLineSet_ID) {
		if (get_ID() == 0) {
			super.setPA_ReportLineSet_ID(PA_ReportLineSet_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_ReportLineSet_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_ReportLineSet_UU();
	}
}
