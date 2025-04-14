package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_Package_Exp_DetailResolver;
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
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Exp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
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
	private ForeignEntityInput mAD_Workflow;
	private ForeignEntityInput mDBType;
	private ForeignEntityInput mReleaseNo;
	private ForeignEntityInput mType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Package_Exp_Detail_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Package_Exp_DetailInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType System Entity Type
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_EntityType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UU " + AD_EntityType.getUU());
			}
		} else {
			this.setAD_EntityType_ID(0);
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
	 * Set Import Format.
	 *
	 * @param AD_ImpFormat Import Format
	 */
	@JsonProperty("AD_ImpFormat")
	public void setAD_ImpFormatInput(ForeignEntityInput AD_ImpFormat) {
		this.mAD_ImpFormat = AD_ImpFormat;
		if (AD_ImpFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_ImpFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ImpFormat", "AD_ImpFormat_UU=?", get_TrxName())
							.setParameters(AD_ImpFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_ImpFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ImpFormat with UU " + AD_ImpFormat.getUU());
			}
		} else {
			this.setAD_ImpFormat_ID(0);
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
		if (AD_InfoWindow != null) {
			// Since an entity was passed, make sure it's in the DB
			MInfoWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_InfoWindow", "AD_InfoWindow_UU=?", get_TrxName())
							.setParameters(AD_InfoWindow.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_InfoWindow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoWindow with UU " + AD_InfoWindow.getUU());
			}
		} else {
			this.setAD_InfoWindow_ID(0);
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
		if (AD_Menu != null) {
			// Since an entity was passed, make sure it's in the DB
			MMenu_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Menu", "AD_Menu_UU=?", get_TrxName())
							.setParameters(AD_Menu.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Menu_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Menu with UU " + AD_Menu.getUU());
			}
		} else {
			this.setAD_Menu_ID(0);
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
		if (AD_Message != null) {
			// Since an entity was passed, make sure it's in the DB
			MMessage_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Message", "AD_Message_UU=?", get_TrxName())
							.setParameters(AD_Message.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Message_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Message with UU " + AD_Message.getUU());
			}
		} else {
			this.setAD_Message_ID(0);
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
		if (AD_ModelValidator != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_ModelValidator foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ModelValidator", "AD_ModelValidator_UU=?", get_TrxName())
							.setParameters(AD_ModelValidator.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_ModelValidator_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ModelValidator with UU " + AD_ModelValidator.getUU());
			}
		} else {
			this.setAD_ModelValidator_ID(0);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Package_Exp_Detail_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Package_Exp != null) {
			// Since an entity was passed, make sure it's in the DB
			MPackageExp foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Package_Exp", "AD_Package_Exp_UU=?", get_TrxName())
							.setParameters(AD_Package_Exp.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Package_Exp_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Package_Exp with UU " + AD_Package_Exp.getUU());
			}
		} else {
			this.setAD_Package_Exp_ID(0);
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
		if (AD_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(AD_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + AD_PrintFormat.getUU());
			}
		} else {
			this.setAD_PrintFormat_ID(0);
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
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		if (AD_Reference != null) {
			// Since an entity was passed, make sure it's in the DB
			MReference_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Reference_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UU " + AD_Reference.getUU());
			}
		} else {
			this.setAD_Reference_ID(0);
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
		if (AD_ReportView != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportView foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ReportView", "AD_ReportView_UU=?", get_TrxName())
							.setParameters(AD_ReportView.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_ReportView_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ReportView with UU " + AD_ReportView.getUU());
			}
		} else {
			this.setAD_ReportView_ID(0);
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
		if (AD_Role != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Role foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(AD_Role.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UU " + AD_Role.getUU());
			}
		} else {
			this.setAD_Role_ID(-1);
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
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
			}
		} else {
			this.setAD_Table_ID(0);
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
		if (AD_Val_Rule != null) {
			// Since an entity was passed, make sure it's in the DB
			MValRule foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Val_Rule", "AD_Val_Rule_UU=?", get_TrxName())
							.setParameters(AD_Val_Rule.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Val_Rule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Val_Rule with UU " + AD_Val_Rule.getUU());
			}
		} else {
			this.setAD_Val_Rule_ID(0);
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
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public void setAD_WorkflowInput(ForeignEntityInput AD_Workflow) {
		this.mAD_Workflow = AD_Workflow;
		if (AD_Workflow != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Workflow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Workflow", "AD_Workflow_UU=?", get_TrxName())
							.setParameters(AD_Workflow.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Workflow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Workflow with UU " + AD_Workflow.getUU());
			}
		} else {
			this.setAD_Workflow_ID(0);
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
	 * Set DB Type.
	 *
	 * @param DBType DB Type
	 */
	@JsonProperty("DBType")
	public void setDBTypeInput(ForeignEntityInput DBType) {
		this.mDBType = DBType;
		if (DBType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_Package_Exp_DetailResolver.DBTYPE_UUIDS_BY_VALUE.containsValue(DBType.getUU())) {
				throw new AdempiereException("The reference list UU of " + DBType.getUU() +
						" is not in the list defined for the DBType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DBType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDBType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DBType.getUU());
			}
		} else {
			this.setDBType(null);
		}
	}

	/**
	 * Get DB Type.
	 *
	 * @return DB Type
	 */
	@JsonProperty("DBType")
	public ForeignEntityInput DBType() {
		return mDBType;
	}

	/**
	 * Set Release No.
	 *
	 * @param ReleaseNo Internal Release Number
	 */
	@JsonProperty("ReleaseNo")
	public void setReleaseNoInput(ForeignEntityInput ReleaseNo) {
		this.mReleaseNo = ReleaseNo;
		if (ReleaseNo != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_Package_Exp_DetailResolver.RELEASENO_UUIDS_BY_VALUE.containsValue(ReleaseNo.getUU())) {
				throw new AdempiereException("The reference list UU of " + ReleaseNo.getUU() +
						" is not in the list defined for the ReleaseNo column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ReleaseNo.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setReleaseNo(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ReleaseNo.getUU());
			}
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
	public ForeignEntityInput ReleaseNo() {
		return mReleaseNo;
	}

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public void setTypeInput(ForeignEntityInput Type) {
		this.mType = Type;
		if (Type != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_Package_Exp_DetailResolver.TYPE_UUIDS_BY_VALUE.containsValue(Type.getUU())) {
				throw new AdempiereException("The reference list UU of " + Type.getUU() +
						" is not in the list defined for the Type column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Type.getUU());
			}
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
	public ForeignEntityInput Type() {
		return mType;
	}
}
