package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_IssueResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MForm;
import org.compiere.model.MIssue;
import org.compiere.model.MIssueProject;
import org.compiere.model.MIssueSystem;
import org.compiere.model.MIssueUser;
import org.compiere.model.MOrg;
import org.compiere.model.MRequest;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_R_IssueKnown;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Issue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_IssueInput extends MIssue implements I_AD_IssueInput {

	private ForeignEntityInput mAD_Form;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_Window;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mIsReproducible;
	private ForeignEntityInput mIsVanillaSystem;
	private ForeignEntityInput mIssueSource;
	private ForeignEntityInput mR_IssueKnown;
	private ForeignEntityInput mR_IssueProject;
	private ForeignEntityInput mR_IssueSystem;
	private ForeignEntityInput mR_IssueUser;
	private ForeignEntityInput mR_Request;
	private ForeignEntityInput mSystemStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Issue_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_IssueInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (!is_new()) {
			return;
		}
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UU " + A_Asset.getUU());
			}
		} else {
			this.setA_Asset_ID(0);
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
	 * Set Special Form.
	 *
	 * @param AD_Form Special Form
	 */
	@JsonProperty("AD_Form")
	public void setAD_FormInput(ForeignEntityInput AD_Form) {
		this.mAD_Form = AD_Form;
		if (AD_Form != null) {
			// Since an entity was passed, make sure it's in the DB
			MForm foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Form", "AD_Form_UU=?", get_TrxName())
							.setParameters(AD_Form.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Form_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Form with UU " + AD_Form.getUU());
			}
		} else {
			this.setAD_Form_ID(0);
		}
	}

	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	@JsonProperty("AD_Form")
	public ForeignEntityInput AD_Form() {
		return mAD_Form;
	}
	/**
	 * Set System Issue.
	 *
	 * @param AD_Issue_ID Automatically created or manually entered System Issue
	 */
	@JsonProperty("AD_Issue_ID")
	public void setAD_Issue_IDFromJson(int AD_Issue_ID) {
		if (get_ID() == 0) {
			super.setAD_Issue_ID(AD_Issue_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Issue_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Issue_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
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
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	@JsonProperty("AD_Process")
	public void setAD_ProcessInput(ForeignEntityInput AD_Process) {
		this.mAD_Process = AD_Process;
		if (AD_Process != null) {
			// Since an entity was passed, make sure it's in the DB
			MProcess_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
							.setParameters(AD_Process.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Process_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process with UU " + AD_Process.getUU());
			}
		} else {
			this.setAD_Process_ID(0);
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	@JsonProperty("AD_Process")
	public ForeignEntityInput AD_Process() {
		return mAD_Process;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(ForeignEntityInput AD_Window) {
		this.mAD_Window = AD_Window;
		if (AD_Window != null) {
			// Since an entity was passed, make sure it's in the DB
			MWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
							.setParameters(AD_Window.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Window_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Window with UU " + AD_Window.getUU());
			}
		} else {
			this.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public ForeignEntityInput AD_Window() {
		return mAD_Window;
	}
	/**
	 * Set Database.
	 *
	 * @param DatabaseInfo Database Information
	 */
	@JsonProperty("DatabaseInfo")
	public void setDatabaseInfoFromJson(String DatabaseInfo) {
		if (get_ID() == 0) {
			super.setDatabaseInfo(DatabaseInfo);
		}
	}
	/**
	 * Set DB Address.
	 *
	 * @param DBAddress JDBC URL of the database server
	 */
	@JsonProperty("DBAddress")
	public void setDBAddressFromJson(String DBAddress) {
		if (get_ID() == 0) {
			super.setDBAddress(DBAddress);
		}
	}

	/**
	 * Set Reproducible.
	 *
	 * @param IsReproducible Problem can re reproduced in Gardenworld
	 */
	@JsonProperty("IsReproducible")
	public void setIsReproducibleInput(ForeignEntityInput IsReproducible) {
		this.mIsReproducible = IsReproducible;
		if (IsReproducible != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_IssueResolver.ISREPRODUCIBLE_UUIDS_BY_VALUE.containsValue(IsReproducible.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsReproducible.getUU() +
						" is not in the list defined for the IsReproducible column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsReproducible.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsReproducible(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsReproducible.getUU());
			}
		} else {
			this.setIsReproducible(null);
		}
	}

	/**
	 * Get Reproducible.
	 *
	 * @return Problem can re reproduced in Gardenworld
	 */
	@JsonProperty("IsReproducible")
	public ForeignEntityInput IsReproducible() {
		return mIsReproducible;
	}

	/**
	 * Set Source.
	 *
	 * @param IssueSource Issue Source
	 */
	@JsonProperty("IssueSource")
	public void setIssueSourceInput(ForeignEntityInput IssueSource) {
		this.mIssueSource = IssueSource;
		if (IssueSource != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_IssueResolver.ISSUESOURCE_UUIDS_BY_VALUE.containsValue(IssueSource.getUU())) {
				throw new AdempiereException("The reference list UU of " + IssueSource.getUU() +
						" is not in the list defined for the IssueSource column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IssueSource.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIssueSource(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IssueSource.getUU());
			}
		} else {
			this.setIssueSource(null);
		}
	}

	/**
	 * Get Source.
	 *
	 * @return Issue Source
	 */
	@JsonProperty("IssueSource")
	public ForeignEntityInput IssueSource() {
		return mIssueSource;
	}

	/**
	 * Set Vanilla System.
	 *
	 * @param IsVanillaSystem The system was NOT compiled from Source - i.e. standard distribution
	 */
	@JsonProperty("IsVanillaSystem")
	public void setIsVanillaSystemInput(ForeignEntityInput IsVanillaSystem) {
		this.mIsVanillaSystem = IsVanillaSystem;
		if (IsVanillaSystem != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_IssueResolver.ISVANILLASYSTEM_UUIDS_BY_VALUE.containsValue(IsVanillaSystem.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsVanillaSystem.getUU() +
						" is not in the list defined for the IsVanillaSystem column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsVanillaSystem.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsVanillaSystem(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsVanillaSystem.getUU());
			}
		} else {
			this.setIsVanillaSystem(null);
		}
	}

	/**
	 * Get Vanilla System.
	 *
	 * @return The system was NOT compiled from Source - i.e. standard distribution
	 */
	@JsonProperty("IsVanillaSystem")
	public ForeignEntityInput IsVanillaSystem() {
		return mIsVanillaSystem;
	}
	/**
	 * Set Java Info.
	 *
	 * @param JavaInfo Java Version Info
	 */
	@JsonProperty("JavaInfo")
	public void setJavaInfoFromJson(String JavaInfo) {
		if (get_ID() == 0) {
			super.setJavaInfo(JavaInfo);
		}
	}
	/**
	 * Set Local Host.
	 *
	 * @param Local_Host Local Host Info
	 */
	@JsonProperty("Local_Host")
	public void setLocal_HostFromJson(String Local_Host) {
		if (get_ID() == 0) {
			super.setLocal_Host(Local_Host);
		}
	}
	/**
	 * Set Name.
	 *
	 * @param Name Alphanumeric identifier of the entity
	 */
	@JsonProperty("Name")
	public void setNameFromJson(String Name) {
		if (get_ID() == 0) {
			super.setName(Name);
		}
	}
	/**
	 * Set Operating System.
	 *
	 * @param OperatingSystemInfo Operating System Info
	 */
	@JsonProperty("OperatingSystemInfo")
	public void setOperatingSystemInfoFromJson(String OperatingSystemInfo) {
		if (get_ID() == 0) {
			super.setOperatingSystemInfo(OperatingSystemInfo);
		}
	}
	/**
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */
	@JsonProperty("Processed")
	public void setProcessedFromJson(boolean Processed) {
		if (get_ID() == 0) {
			super.setProcessed(Processed);
		}
	}
	/**
	 * Set Profile.
	 *
	 * @param ProfileInfo Information to help profiling the system for solving support issues
	 */
	@JsonProperty("ProfileInfo")
	public void setProfileInfoFromJson(String ProfileInfo) {
		if (get_ID() == 0) {
			super.setProfileInfo(ProfileInfo);
		}
	}
	/**
	 * Set Record ID.
	 *
	 * @param Record_ID Direct internal record ID
	 */
	@JsonProperty("Record_ID")
	public void setRecord_IDFromJson(int Record_ID) {
		if (get_ID() == 0) {
			super.setRecord_ID(Record_ID);
		}
	}
	/**
	 * Set Release No.
	 *
	 * @param ReleaseNo Internal Release Number
	 */
	@JsonProperty("ReleaseNo")
	public void setReleaseNoFromJson(String ReleaseNo) {
		if (get_ID() == 0) {
			super.setReleaseNo(ReleaseNo);
		}
	}
	/**
	 * Set Remote Addr.
	 *
	 * @param Remote_Addr Remote Address
	 */
	@JsonProperty("Remote_Addr")
	public void setRemote_AddrFromJson(String Remote_Addr) {
		if (get_ID() == 0) {
			super.setRemote_Addr(Remote_Addr);
		}
	}
	/**
	 * Set Remote Host.
	 *
	 * @param Remote_Host Remote host Info
	 */
	@JsonProperty("Remote_Host")
	public void setRemote_HostFromJson(String Remote_Host) {
		if (get_ID() == 0) {
			super.setRemote_Host(Remote_Host);
		}
	}
	/**
	 * Set Request Document No.
	 *
	 * @param RequestDocumentNo iDempiere Request Document No
	 */
	@JsonProperty("RequestDocumentNo")
	public void setRequestDocumentNoFromJson(String RequestDocumentNo) {
		if (get_ID() == 0) {
			super.setRequestDocumentNo(RequestDocumentNo);
		}
	}
	/**
	 * Set Response Text.
	 *
	 * @param ResponseText Request Response Text
	 */
	@JsonProperty("ResponseText")
	public void setResponseTextFromJson(String ResponseText) {
		if (get_ID() == 0) {
			super.setResponseText(ResponseText);
		}
	}

	/**
	 * Set Known Issue.
	 *
	 * @param R_IssueKnown Known Issue
	 */
	@JsonProperty("R_IssueKnown")
	public void setR_IssueKnownInput(ForeignEntityInput R_IssueKnown) {
		this.mR_IssueKnown = R_IssueKnown;
		if (R_IssueKnown != null) {
			// Since an entity was passed, make sure it's in the DB
			X_R_IssueKnown foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_IssueKnown", "R_IssueKnown_UU=?", get_TrxName())
							.setParameters(R_IssueKnown.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setR_IssueKnown_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_IssueKnown with UU " + R_IssueKnown.getUU());
			}
		} else {
			this.setR_IssueKnown_ID(0);
		}
	}

	/**
	 * Get Known Issue.
	 *
	 * @return Known Issue
	 */
	@JsonProperty("R_IssueKnown")
	public ForeignEntityInput R_IssueKnown() {
		return mR_IssueKnown;
	}

	/**
	 * Set Issue Project.
	 *
	 * @param R_IssueProject Implementation Projects
	 */
	@JsonProperty("R_IssueProject")
	public void setR_IssueProjectInput(ForeignEntityInput R_IssueProject) {
		this.mR_IssueProject = R_IssueProject;
		if (R_IssueProject != null) {
			// Since an entity was passed, make sure it's in the DB
			MIssueProject foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_IssueProject", "R_IssueProject_UU=?", get_TrxName())
							.setParameters(R_IssueProject.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setR_IssueProject_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_IssueProject with UU " + R_IssueProject.getUU());
			}
		} else {
			this.setR_IssueProject_ID(0);
		}
	}

	/**
	 * Get Issue Project.
	 *
	 * @return Implementation Projects
	 */
	@JsonProperty("R_IssueProject")
	public ForeignEntityInput R_IssueProject() {
		return mR_IssueProject;
	}

	/**
	 * Set Issue System.
	 *
	 * @param R_IssueSystem System creating the issue
	 */
	@JsonProperty("R_IssueSystem")
	public void setR_IssueSystemInput(ForeignEntityInput R_IssueSystem) {
		this.mR_IssueSystem = R_IssueSystem;
		if (R_IssueSystem != null) {
			// Since an entity was passed, make sure it's in the DB
			MIssueSystem foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_IssueSystem", "R_IssueSystem_UU=?", get_TrxName())
							.setParameters(R_IssueSystem.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setR_IssueSystem_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_IssueSystem with UU " + R_IssueSystem.getUU());
			}
		} else {
			this.setR_IssueSystem_ID(0);
		}
	}

	/**
	 * Get Issue System.
	 *
	 * @return System creating the issue
	 */
	@JsonProperty("R_IssueSystem")
	public ForeignEntityInput R_IssueSystem() {
		return mR_IssueSystem;
	}

	/**
	 * Set Issue User.
	 *
	 * @param R_IssueUser User who reported issues
	 */
	@JsonProperty("R_IssueUser")
	public void setR_IssueUserInput(ForeignEntityInput R_IssueUser) {
		this.mR_IssueUser = R_IssueUser;
		if (R_IssueUser != null) {
			// Since an entity was passed, make sure it's in the DB
			MIssueUser foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_IssueUser", "R_IssueUser_UU=?", get_TrxName())
							.setParameters(R_IssueUser.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setR_IssueUser_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_IssueUser with UU " + R_IssueUser.getUU());
			}
		} else {
			this.setR_IssueUser_ID(0);
		}
	}

	/**
	 * Get Issue User.
	 *
	 * @return User who reported issues
	 */
	@JsonProperty("R_IssueUser")
	public ForeignEntityInput R_IssueUser() {
		return mR_IssueUser;
	}

	/**
	 * Set Request.
	 *
	 * @param R_Request Request from a Business Partner or Prospect
	 */
	@JsonProperty("R_Request")
	public void setR_RequestInput(ForeignEntityInput R_Request) {
		this.mR_Request = R_Request;
		if (!is_new()) {
			return;
		}
		if (R_Request != null) {
			// Since an entity was passed, make sure it's in the DB
			MRequest foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_Request", "R_Request_UU=?", get_TrxName())
							.setParameters(R_Request.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setR_Request_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Request with UU " + R_Request.getUU());
			}
		} else {
			this.setR_Request_ID(0);
		}
	}

	/**
	 * Get Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	@JsonProperty("R_Request")
	public ForeignEntityInput R_Request() {
		return mR_Request;
	}
	/**
	 * Set Statistics.
	 *
	 * @param StatisticsInfo Information to help profiling the system for solving support issues
	 */
	@JsonProperty("StatisticsInfo")
	public void setStatisticsInfoFromJson(String StatisticsInfo) {
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
	public void setSystemStatusInput(ForeignEntityInput SystemStatus) {
		this.mSystemStatus = SystemStatus;
		if (SystemStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_IssueResolver.SYSTEMSTATUS_UUIDS_BY_VALUE.containsValue(SystemStatus.getUU())) {
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
	 * Set User Name.
	 *
	 * @param UserName User Name
	 */
	@JsonProperty("UserName")
	public void setUserNameFromJson(String UserName) {
		if (get_ID() == 0) {
			super.setUserName(UserName);
		}
	}
	/**
	 * Set Version.
	 *
	 * @param Version Version of the table definition
	 */
	@JsonProperty("Version")
	public void setVersionFromJson(String Version) {
		if (get_ID() == 0) {
			super.setVersion(Version);
		}
	}
}
