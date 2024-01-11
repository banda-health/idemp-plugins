package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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

import java.sql.ResultSet;

/**
 * Generated Model for AD_Issue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_IssueInput extends MIssue implements I_AD_IssueInput {

	private ForeignEntityInput mAD_Form;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_Window;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mR_IssueKnown;
	private ForeignEntityInput mR_IssueProject;
	private ForeignEntityInput mR_IssueSystem;
	private ForeignEntityInput mR_IssueUser;
	private ForeignEntityInput mR_Request;
	private I_AD_Ref_ListInput mIsReproducible;
	private I_AD_Ref_ListInput mIsVanillaSystem;
	private I_AD_Ref_ListInput mIssueSource;
	private I_AD_Ref_ListInput mSystemStatus;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_IssueInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MIssue(null, (ResultSet) null, null), null, Table_Name, ID),
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
		if (get_ID() == 0 && A_Asset != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
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
		MForm foreignEntity;
		if (AD_Form != null &&
				(foreignEntity = new Query(getCtx(), "AD_Form", "AD_Form_UU=?", get_TrxName())
						.setParameters(AD_Form.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Form_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Form_ID(0);
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

	public void setAD_Issue_ID(int AD_Issue_ID) {
		if (get_ID() == 0) {
			super.setAD_Issue_ID(AD_Issue_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Issue_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Issue_UU();
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
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	@JsonProperty("AD_Process")
	public void setAD_ProcessInput(ForeignEntityInput AD_Process) {
		this.mAD_Process = AD_Process;
		MProcess_BH foreignEntity;
		if (AD_Process != null &&
				(foreignEntity = new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
						.setParameters(AD_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Process_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Process_ID(0);
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
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Window_ID(0);
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

	public void setDatabaseInfo(String DatabaseInfo) {
		if (get_ID() == 0) {
			super.setDatabaseInfo(DatabaseInfo);
		}
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
	 * Set Reproducible.
	 *
	 * @param IsReproducible Problem can re reproduced in Gardenworld
	 */
	@JsonProperty("IsReproducible")
	public void setIsReproducibleInput(I_AD_Ref_ListInput IsReproducible) {
		this.mIsReproducible = IsReproducible;
		MRefList_BH foreignEntity;
		if (IsReproducible != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsReproducible.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsReproducible(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput IsReproducible() {
		return mIsReproducible;
	}

	/**
	 * Set Source.
	 *
	 * @param IssueSource Issue Source
	 */
	@JsonProperty("IssueSource")
	public void setIssueSourceInput(I_AD_Ref_ListInput IssueSource) {
		this.mIssueSource = IssueSource;
		MRefList_BH foreignEntity;
		if (IssueSource != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IssueSource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIssueSource(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput IssueSource() {
		return mIssueSource;
	}

	/**
	 * Set Vanilla System.
	 *
	 * @param IsVanillaSystem The system was NOT compiled from Source - i.e. standard distribution
	 */
	@JsonProperty("IsVanillaSystem")
	public void setIsVanillaSystemInput(I_AD_Ref_ListInput IsVanillaSystem) {
		this.mIsVanillaSystem = IsVanillaSystem;
		MRefList_BH foreignEntity;
		if (IsVanillaSystem != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsVanillaSystem.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsVanillaSystem(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput IsVanillaSystem() {
		return mIsVanillaSystem;
	}
	/**
	 * Set Java Info.
	 *
	 * @param JavaInfo Java Version Info
	 */

	public void setJavaInfo(String JavaInfo) {
		if (get_ID() == 0) {
			super.setJavaInfo(JavaInfo);
		}
	}
	/**
	 * Set Local Host.
	 *
	 * @param Local_Host Local Host Info
	 */

	public void setLocal_Host(String Local_Host) {
		if (get_ID() == 0) {
			super.setLocal_Host(Local_Host);
		}
	}
	/**
	 * Set Name.
	 *
	 * @param Name Alphanumeric identifier of the entity
	 */

	public void setName(String Name) {
		if (get_ID() == 0) {
			super.setName(Name);
		}
	}
	/**
	 * Set Operating System.
	 *
	 * @param OperatingSystemInfo Operating System Info
	 */

	public void setOperatingSystemInfo(String OperatingSystemInfo) {
		if (get_ID() == 0) {
			super.setOperatingSystemInfo(OperatingSystemInfo);
		}
	}
	/**
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */

	public void setProcessed(boolean Processed) {
		if (get_ID() == 0) {
			super.setProcessed(Processed);
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
	 * Set Known Issue.
	 *
	 * @param R_IssueKnown Known Issue
	 */
	@JsonProperty("R_IssueKnown")
	public void setR_IssueKnownInput(ForeignEntityInput R_IssueKnown) {
		this.mR_IssueKnown = R_IssueKnown;
		X_R_IssueKnown foreignEntity;
		if (R_IssueKnown != null &&
				(foreignEntity = new Query(getCtx(), "R_IssueKnown", "R_IssueKnown_UU=?", get_TrxName())
						.setParameters(R_IssueKnown.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_IssueKnown_ID(foreignEntity.get_ID());
		} else {
			super.setR_IssueKnown_ID(0);
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
		MIssueProject foreignEntity;
		if (R_IssueProject != null &&
				(foreignEntity = new Query(getCtx(), "R_IssueProject", "R_IssueProject_UU=?", get_TrxName())
						.setParameters(R_IssueProject.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_IssueProject_ID(foreignEntity.get_ID());
		} else {
			super.setR_IssueProject_ID(0);
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
		MIssueSystem foreignEntity;
		if (R_IssueSystem != null &&
				(foreignEntity = new Query(getCtx(), "R_IssueSystem", "R_IssueSystem_UU=?", get_TrxName())
						.setParameters(R_IssueSystem.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_IssueSystem_ID(foreignEntity.get_ID());
		} else {
			super.setR_IssueSystem_ID(0);
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
	 * Set IssueUser.
	 *
	 * @param R_IssueUser User who reported issues
	 */
	@JsonProperty("R_IssueUser")
	public void setR_IssueUserInput(ForeignEntityInput R_IssueUser) {
		this.mR_IssueUser = R_IssueUser;
		MIssueUser foreignEntity;
		if (R_IssueUser != null &&
				(foreignEntity = new Query(getCtx(), "R_IssueUser", "R_IssueUser_UU=?", get_TrxName())
						.setParameters(R_IssueUser.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_IssueUser_ID(foreignEntity.get_ID());
		} else {
			super.setR_IssueUser_ID(0);
		}
	}

	/**
	 * Get IssueUser.
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
		MRequest foreignEntity;
		if (get_ID() == 0 && R_Request != null &&
				(foreignEntity = new Query(getCtx(), "R_Request", "R_Request_UU=?", get_TrxName())
						.setParameters(R_Request.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_Request_ID(foreignEntity.get_ID());
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
	 * Set Record ID.
	 *
	 * @param Record_ID Direct internal record ID
	 */

	public void setRecord_ID(int Record_ID) {
		if (get_ID() == 0) {
			super.setRecord_ID(Record_ID);
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
	 * Set Remote Addr.
	 *
	 * @param Remote_Addr Remote Address
	 */

	public void setRemote_Addr(String Remote_Addr) {
		if (get_ID() == 0) {
			super.setRemote_Addr(Remote_Addr);
		}
	}
	/**
	 * Set Remote Host.
	 *
	 * @param Remote_Host Remote host Info
	 */

	public void setRemote_Host(String Remote_Host) {
		if (get_ID() == 0) {
			super.setRemote_Host(Remote_Host);
		}
	}
	/**
	 * Set Request Document No.
	 *
	 * @param RequestDocumentNo iDempiere Request Document No
	 */

	public void setRequestDocumentNo(String RequestDocumentNo) {
		if (get_ID() == 0) {
			super.setRequestDocumentNo(RequestDocumentNo);
		}
	}
	/**
	 * Set Response Text.
	 *
	 * @param ResponseText Request Response Text
	 */

	public void setResponseText(String ResponseText) {
		if (get_ID() == 0) {
			super.setResponseText(ResponseText);
		}
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
	/**
	 * Set User Name.
	 *
	 * @param UserName User Name
	 */

	public void setUserName(String UserName) {
		if (get_ID() == 0) {
			super.setUserName(UserName);
		}
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
