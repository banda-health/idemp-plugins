package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSystem;
import org.compiere.model.Query;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for AD_System - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_SystemInput extends MSystem implements I_AD_SystemInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mReplicationType;
	private I_AD_Ref_ListInput mSystemStatus;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_SystemInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MSystem(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set System.
	 *
	 * @param AD_System_ID System Definition
	 */

	public void setAD_System_ID(int AD_System_ID) {
		if (get_ID() == 0) {
			super.setAD_System_ID(AD_System_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_System_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_System_UU();
	}
	/**
	 * Set Encryption Class.
	 *
	 * @param EncryptionKey Encryption Class used for securing data content
	 */

	public void setEncryptionKey(String EncryptionKey) {
		if (get_ID() == 0) {
			super.setEncryptionKey(EncryptionKey);
		}
	}
	/**
	 * Set Info.
	 *
	 * @param Info Information
	 */

	public void setInfo(String Info) {
		if (get_ID() == 0) {
			super.setInfo(Info);
		}
	}
	/**
	 * Set Old Name.
	 *
	 * @param OldName Old Name
	 */

	public void setOldName(String OldName) {
		if (get_ID() == 0) {
			super.setOldName(OldName);
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
	 * Set Release No.
	 *
	 * @param ReleaseNo Internal Release Number
	 */

	public void setReleaseNo(String ReleaseNo) {
		if (get_ID() == 0) {
			super.setReleaseNo(ReleaseNo);
		}
	}

	/**
	 * Set Replication Type.
	 *
	 * @param ReplicationType Type of Data Replication
	 */
	@JsonProperty("ReplicationType")
	public void setReplicationTypeInput(I_AD_Ref_ListInput ReplicationType) {
		this.mReplicationType = ReplicationType;
		MRefList_BH foreignEntity;
		if (ReplicationType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ReplicationType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReplicationType(foreignEntity.getValue());
		} else {
			this.setReplicationType(null);
		}
	}

	/**
	 * Get Replication Type.
	 *
	 * @return Type of Data Replication
	 */
	@JsonProperty("ReplicationType")
	public I_AD_Ref_ListInput ReplicationType() {
		return mReplicationType;
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
	 * Set Support Expires.
	 *
	 * @param SupportExpDate Date when the iDempiere support expires
	 */

	public void setSupportExpDate(Timestamp SupportExpDate) {
		if (get_ID() == 0) {
			super.setSupportExpDate(SupportExpDate);
		}
	}
	/**
	 * Set Internal Users.
	 *
	 * @param SupportUnits Number of Internal Users for iDempiere Support
	 */

	public void setSupportUnits(int SupportUnits) {
		if (get_ID() == 0) {
			super.setSupportUnits(SupportUnits);
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
	/**
	 * Set Version.
	 *
	 * @param Version Version of the table definition
	 */

	public void setVersion(String Version) {
		if (get_ID() == 0) {
			super.setVersion(Version);
		}
	}
}
