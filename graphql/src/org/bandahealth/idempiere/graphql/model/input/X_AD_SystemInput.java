package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_SystemResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSystem;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for AD_System - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SystemInput extends MSystem implements I_AD_SystemInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mReplicationType;
	private ForeignEntityInput mSystemStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_System_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_SystemInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_System_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
	public void setReplicationTypeInput(ForeignEntityInput ReplicationType) {
		this.mReplicationType = ReplicationType;
		if (ReplicationType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_SystemResolver.REPLICATIONTYPE_UUIDS_BY_VALUE.containsValue(ReplicationType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ReplicationType.getUU() +
						" is not in the list defined for the ReplicationType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ReplicationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setReplicationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ReplicationType.getUU());
			}
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
	public ForeignEntityInput ReplicationType() {
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
	public void setSystemStatusInput(ForeignEntityInput SystemStatus) {
		this.mSystemStatus = SystemStatus;
		if (SystemStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_SystemResolver.SYSTEMSTATUS_UUIDS_BY_VALUE.containsValue(SystemStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + SystemStatus.getUU() +
						" is not in the list defined for the SystemStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(SystemStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSystemStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + SystemStatus.getUU());
			}
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
	public ForeignEntityInput SystemStatus() {
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
