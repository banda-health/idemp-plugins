package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Desktop;
import org.compiere.model.X_AD_DesktopWorkbench;
import org.compiere.model.X_AD_Workbench;

import java.sql.ResultSet;

/**
 * Generated Model for AD_DesktopWorkbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_DesktopWorkbenchInput extends X_AD_DesktopWorkbench implements I_AD_DesktopWorkbenchInput {

	private ForeignEntityInput mAD_Desktop;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Workbench;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_DesktopWorkbenchInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_DesktopWorkbench(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Desktop.
	 *
	 * @param AD_Desktop Collection of Workbenches
	 */
	@JsonProperty("AD_Desktop")
	public void setAD_DesktopInput(ForeignEntityInput AD_Desktop) {
		this.mAD_Desktop = AD_Desktop;
		X_AD_Desktop foreignEntity;
		if (get_ID() == 0 && AD_Desktop != null &&
				(foreignEntity = new Query(getCtx(), "AD_Desktop", "AD_Desktop_UU=?", get_TrxName())
						.setParameters(AD_Desktop.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Desktop_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Desktop.
	 *
	 * @return Collection of Workbenches
	 */
	@JsonProperty("AD_Desktop")
	public ForeignEntityInput AD_Desktop() {
		return mAD_Desktop;
	}
	/**
	 * Set Desktop Workbench.
	 *
	 * @param AD_DesktopWorkbench_ID Desktop Workbench
	 */

	public void setAD_DesktopWorkbench_ID(int AD_DesktopWorkbench_ID) {
		if (get_ID() == 0) {
			super.setAD_DesktopWorkbench_ID(AD_DesktopWorkbench_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_DesktopWorkbench_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_DesktopWorkbench_UU();
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
	 * Set Workbench.
	 *
	 * @param AD_Workbench Collection of windows, reports
	 */
	@JsonProperty("AD_Workbench")
	public void setAD_WorkbenchInput(ForeignEntityInput AD_Workbench) {
		this.mAD_Workbench = AD_Workbench;
		X_AD_Workbench foreignEntity;
		if (AD_Workbench != null &&
				(foreignEntity = new Query(getCtx(), "AD_Workbench", "AD_Workbench_UU=?", get_TrxName())
						.setParameters(AD_Workbench.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Workbench_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Workbench_ID(0);
		}
	}

	/**
	 * Get Workbench.
	 *
	 * @return Collection of windows, reports
	 */
	@JsonProperty("AD_Workbench")
	public ForeignEntityInput AD_Workbench() {
		return mAD_Workbench;
	}
}
