package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MOrg;
import org.compiere.model.MPackageExp;
import org.compiere.model.MPackageExpDetail;
import org.compiere.model.MReportView;
import org.compiere.model.MTable;
import org.compiere.model.MValRule;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_ImpFormat;
import org.compiere.model.X_AD_ModelValidator;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_AD_Workbench;
import org.compiere.model.X_AD_Workflow;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Exp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Exp_DetailInput extends MPackageExpDetail implements I_AD_Package_Exp_DetailInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Form;
	private ForeignEntityInput mAD_ImpFormat;
	private ForeignEntityInput mAD_InfoWindow;
	private ForeignEntityInput mAD_Menu;
	private ForeignEntityInput mAD_Message;
	private ForeignEntityInput mAD_ModelValidator;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Package_Exp;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_ReportView;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mAD_Val_Rule;
	private ForeignEntityInput mAD_Window;
	private ForeignEntityInput mAD_Workbench;
	private ForeignEntityInput mAD_Workflow;
	private I_AD_Ref_ListInput mDBType;
	private I_AD_Ref_ListInput mReleaseNo;
	private I_AD_Ref_ListInput mType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Package_Exp_DetailInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MPackageExpDetail(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType System Entity Type
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_EntityType_ID(foreignEntity.get_ID());
		} else {
			super.setAD_EntityType_ID(0);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return System Entity Type
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
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
	 * Set Import Format.
	 *
	 * @param AD_ImpFormat Import Format
	 */
	@JsonProperty("AD_ImpFormat")
	public void setAD_ImpFormatInput(ForeignEntityInput AD_ImpFormat) {
		this.mAD_ImpFormat = AD_ImpFormat;
		X_AD_ImpFormat foreignEntity;
		if (AD_ImpFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_ImpFormat", "AD_ImpFormat_UU=?", get_TrxName())
						.setParameters(AD_ImpFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ImpFormat_ID(foreignEntity.get_ID());
		} else {
			super.setAD_ImpFormat_ID(0);
		}
	}

	/**
	 * Get Import Format.
	 *
	 * @return Import Format
	 */
	@JsonProperty("AD_ImpFormat")
	public ForeignEntityInput AD_ImpFormat() {
		return mAD_ImpFormat;
	}

	/**
	 * Set Info Window.
	 *
	 * @param AD_InfoWindow Info and search/select Window
	 */
	@JsonProperty("AD_InfoWindow")
	public void setAD_InfoWindowInput(ForeignEntityInput AD_InfoWindow) {
		this.mAD_InfoWindow = AD_InfoWindow;
		MInfoWindow foreignEntity;
		if (AD_InfoWindow != null &&
				(foreignEntity = new Query(getCtx(), "AD_InfoWindow", "AD_InfoWindow_UU=?", get_TrxName())
						.setParameters(AD_InfoWindow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_InfoWindow_ID(foreignEntity.get_ID());
		} else {
			super.setAD_InfoWindow_ID(0);
		}
	}

	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	@JsonProperty("AD_InfoWindow")
	public ForeignEntityInput AD_InfoWindow() {
		return mAD_InfoWindow;
	}

	/**
	 * Set Menu.
	 *
	 * @param AD_Menu Identifies a Menu
	 */
	@JsonProperty("AD_Menu")
	public void setAD_MenuInput(ForeignEntityInput AD_Menu) {
		this.mAD_Menu = AD_Menu;
		MMenu_BH foreignEntity;
		if (AD_Menu != null &&
				(foreignEntity = new Query(getCtx(), "AD_Menu", "AD_Menu_UU=?", get_TrxName())
						.setParameters(AD_Menu.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Menu_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Menu_ID(0);
		}
	}

	/**
	 * Get Menu.
	 *
	 * @return Identifies a Menu
	 */
	@JsonProperty("AD_Menu")
	public ForeignEntityInput AD_Menu() {
		return mAD_Menu;
	}

	/**
	 * Set Message.
	 *
	 * @param AD_Message System Message
	 */
	@JsonProperty("AD_Message")
	public void setAD_MessageInput(ForeignEntityInput AD_Message) {
		this.mAD_Message = AD_Message;
		MMessage_BH foreignEntity;
		if (AD_Message != null &&
				(foreignEntity = new Query(getCtx(), "AD_Message", "AD_Message_UU=?", get_TrxName())
						.setParameters(AD_Message.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Message_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Message_ID(0);
		}
	}

	/**
	 * Get Message.
	 *
	 * @return System Message
	 */
	@JsonProperty("AD_Message")
	public ForeignEntityInput AD_Message() {
		return mAD_Message;
	}

	/**
	 * Set Model Validator.
	 *
	 * @param AD_ModelValidator Model Validator
	 */
	@JsonProperty("AD_ModelValidator")
	public void setAD_ModelValidatorInput(ForeignEntityInput AD_ModelValidator) {
		this.mAD_ModelValidator = AD_ModelValidator;
		X_AD_ModelValidator foreignEntity;
		if (AD_ModelValidator != null &&
				(foreignEntity = new Query(getCtx(), "AD_ModelValidator", "AD_ModelValidator_UU=?", get_TrxName())
						.setParameters(AD_ModelValidator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ModelValidator_ID(foreignEntity.get_ID());
		} else {
			super.setAD_ModelValidator_ID(0);
		}
	}

	/**
	 * Get Model Validator.
	 *
	 * @return Model Validator
	 */
	@JsonProperty("AD_ModelValidator")
	public ForeignEntityInput AD_ModelValidator() {
		return mAD_ModelValidator;
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Package_Exp_Detail_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Package_Exp_Detail_UU();
	}

	/**
	 * Set Package Exp..
	 *
	 * @param AD_Package_Exp Package Exp.
	 */
	@JsonProperty("AD_Package_Exp")
	public void setAD_Package_ExpInput(ForeignEntityInput AD_Package_Exp) {
		this.mAD_Package_Exp = AD_Package_Exp;
		MPackageExp foreignEntity;
		if (get_ID() == 0 && AD_Package_Exp != null &&
				(foreignEntity = new Query(getCtx(), "AD_Package_Exp", "AD_Package_Exp_UU=?", get_TrxName())
						.setParameters(AD_Package_Exp.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Package_Exp_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Package Exp..
	 *
	 * @return Package Exp.
	 */
	@JsonProperty("AD_Package_Exp")
	public ForeignEntityInput AD_Package_Exp() {
		return mAD_Package_Exp;
	}

	/**
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(AD_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public ForeignEntityInput AD_PrintFormat() {
		return mAD_PrintFormat;
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
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		MReference_BH foreignEntity;
		if (AD_Reference != null &&
				(foreignEntity = new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
						.setParameters(AD_Reference.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Reference_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Reference_ID(0);
		}
	}

	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public ForeignEntityInput AD_Reference() {
		return mAD_Reference;
	}

	/**
	 * Set Report View.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	@JsonProperty("AD_ReportView")
	public void setAD_ReportViewInput(ForeignEntityInput AD_ReportView) {
		this.mAD_ReportView = AD_ReportView;
		MReportView foreignEntity;
		if (AD_ReportView != null &&
				(foreignEntity = new Query(getCtx(), "AD_ReportView", "AD_ReportView_UU=?", get_TrxName())
						.setParameters(AD_ReportView.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ReportView_ID(foreignEntity.get_ID());
		} else {
			super.setAD_ReportView_ID(0);
		}
	}

	/**
	 * Get Report View.
	 *
	 * @return View used to generate this report
	 */
	@JsonProperty("AD_ReportView")
	public ForeignEntityInput AD_ReportView() {
		return mAD_ReportView;
	}

	/**
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public ForeignEntityInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set Dynamic Validation.
	 *
	 * @param AD_Val_Rule Dynamic Validation Rule
	 */
	@JsonProperty("AD_Val_Rule")
	public void setAD_Val_RuleInput(ForeignEntityInput AD_Val_Rule) {
		this.mAD_Val_Rule = AD_Val_Rule;
		MValRule foreignEntity;
		if (AD_Val_Rule != null &&
				(foreignEntity = new Query(getCtx(), "AD_Val_Rule", "AD_Val_Rule_UU=?", get_TrxName())
						.setParameters(AD_Val_Rule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Val_Rule_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Val_Rule_ID(0);
		}
	}

	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	@JsonProperty("AD_Val_Rule")
	public ForeignEntityInput AD_Val_Rule() {
		return mAD_Val_Rule;
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

	/**
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public void setAD_WorkflowInput(ForeignEntityInput AD_Workflow) {
		this.mAD_Workflow = AD_Workflow;
		X_AD_Workflow foreignEntity;
		if (AD_Workflow != null &&
				(foreignEntity = new Query(getCtx(), "AD_Workflow", "AD_Workflow_UU=?", get_TrxName())
						.setParameters(AD_Workflow.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Workflow_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Workflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public ForeignEntityInput AD_Workflow() {
		return mAD_Workflow;
	}

	/**
	 * Set DBType.
	 *
	 * @param DBType DBType
	 */
	@JsonProperty("DBType")
	public void setDBTypeInput(I_AD_Ref_ListInput DBType) {
		this.mDBType = DBType;
		MRefList_BH foreignEntity;
		if (DBType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DBType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDBType(foreignEntity.getValue());
		} else {
			this.setDBType(null);
		}
	}

	/**
	 * Get DBType.
	 *
	 * @return DBType
	 */
	@JsonProperty("DBType")
	public I_AD_Ref_ListInput DBType() {
		return mDBType;
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

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public void setTypeInput(I_AD_Ref_ListInput Type) {
		this.mType = Type;
		MRefList_BH foreignEntity;
		if (Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setType(foreignEntity.getValue());
		} else {
			this.setType(null);
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public I_AD_Ref_ListInput Type() {
		return mType;
	}
}
