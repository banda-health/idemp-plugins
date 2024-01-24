package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MIssueSystem;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueSystemInput extends MIssueSystem implements I_R_IssueSystemInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private I_AD_Ref_ListInput mSystemStatus;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_R_IssueSystemInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MIssueSystem(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_ID(0);
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
	 * Set DB Address.
	 *
	 * @param DBAddress JDBC URL of the database server
	 */

	public void setDBAddress(String DBAddress) {
		if (get_ID() == 0) {
			super.setDBAddress(DBAddress);
		}
	}
	/**
	 * Set Profile.
	 *
	 * @param ProfileInfo Information to help profiling the system for solving support issues
	 */

	public void setProfileInfo(String ProfileInfo) {
		if (get_ID() == 0) {
			super.setProfileInfo(ProfileInfo);
		}
	}
	/**
	 * Set Issue System.
	 *
	 * @param R_IssueSystem_ID System creating the issue
	 */

	public void setR_IssueSystem_ID(int R_IssueSystem_ID) {
		if (get_ID() == 0) {
			super.setR_IssueSystem_ID(R_IssueSystem_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setR_IssueSystem_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getR_IssueSystem_UU();
	}
	/**
	 * Set Statistics.
	 *
	 * @param StatisticsInfo Information to help profiling the system for solving support issues
	 */

	public void setStatisticsInfo(String StatisticsInfo) {
		if (get_ID() == 0) {
			super.setStatisticsInfo(StatisticsInfo);
		}
	}

	/**
	 * Set System Status.
	 *
	 * @param SystemStatus Status of the system - Support priority depends on system status
	 */
	@JsonProperty("SystemStatus")
	public void setSystemStatusInput(I_AD_Ref_ListInput SystemStatus) {
		this.mSystemStatus = SystemStatus;
		MRefList_BH foreignEntity;
		if (SystemStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(SystemStatus.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSystemStatus(foreignEntity.getValue());
		} else {
			this.setSystemStatus(null);
		}
	}

	/**
	 * Get System Status.
	 *
	 * @return Status of the system - Support priority depends on system status
	 */
	@JsonProperty("SystemStatus")
	public I_AD_Ref_ListInput SystemStatus() {
		return mSystemStatus;
	}
}
