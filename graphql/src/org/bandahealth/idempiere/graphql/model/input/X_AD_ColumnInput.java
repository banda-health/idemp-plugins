package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChart;
import org.compiere.model.MColumn;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.MValRule;
import org.compiere.model.M_Element;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ColumnInput extends MColumn implements I_AD_ColumnInput {

	private ForeignEntityInput mAD_Chart;
	private ForeignEntityInput mAD_Element;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mAD_Val_Rule;
	private ForeignEntityInput mAD_Val_Rule_Lookup;
	private ForeignEntityInput mPA_DashboardContent;
	private I_AD_Ref_ListInput mFKConstraintType;
	private I_AD_Ref_ListInput mIsEncrypted;
	private I_AD_Ref_ListInput mIsToolbarButton;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Column_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ColumnInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MColumn(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Chart.
	 *
	 * @param AD_Chart Chart
	 */
	@JsonProperty("AD_Chart")
	public void setAD_ChartInput(ForeignEntityInput AD_Chart) {
		this.mAD_Chart = AD_Chart;
		MChart foreignEntity;
		if (AD_Chart != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Chart", "AD_Chart_UU=?", get_TrxName())
							.setParameters(AD_Chart.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Chart_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Chart with UUID " + AD_Chart.getUUID());
			}
		} else {
			super.setAD_Chart_ID(0);
		}
	}

	/**
	 * Get Chart.
	 *
	 * @return Chart
	 */
	@JsonProperty("AD_Chart")
	public ForeignEntityInput AD_Chart() {
		return mAD_Chart;
	}
	/**
	 * Set Column.
	 *
	 * @param AD_Column_ID Column in the table
	 */

	public void setAD_Column_ID(int AD_Column_ID) {
		if (get_ID() == 0) {
			super.setAD_Column_ID(AD_Column_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Column_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Column_UU();
	}

	/**
	 * Set System Element.
	 *
	 * @param AD_Element System Element enables the central maintenance of column description and help.
	 */
	@JsonProperty("AD_Element")
	public void setAD_ElementInput(ForeignEntityInput AD_Element) {
		this.mAD_Element = AD_Element;
		M_Element foreignEntity;
		if (AD_Element != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Element", "AD_Element_UU=?", get_TrxName())
							.setParameters(AD_Element.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Element_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Element with UUID " + AD_Element.getUUID());
			}
		} else {
			super.setAD_Element_ID(0);
		}
	}

	/**
	 * Get System Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	@JsonProperty("AD_Element")
	public ForeignEntityInput AD_Element() {
		return mAD_Element;
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
		if (AD_Process != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
							.setParameters(AD_Process.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Process_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process with UUID " + AD_Process.getUUID());
			}
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
		if (AD_Reference != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Reference_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UUID " + AD_Reference.getUUID());
			}
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
	 * Set Reference Key.
	 *
	 * @param AD_Reference_Value Required to specify, if data type is Table or List
	 */
	@JsonProperty("AD_Reference_Value")
	public void setAD_Reference_ValueInput(ForeignEntityInput AD_Reference_Value) {
		this.mAD_Reference_Value = AD_Reference_Value;
		MReference_BH foreignEntity;
		if (AD_Reference_Value != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference_Value.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Reference_Value_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UUID " + AD_Reference_Value.getUUID());
			}
		} else {
			super.setAD_Reference_Value_ID(0);
		}
	}

	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	@JsonProperty("AD_Reference_Value")
	public ForeignEntityInput AD_Reference_Value() {
		return mAD_Reference_Value;
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
		if (get_ID() == 0 && AD_Table != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UUID " + AD_Table.getUUID());
			}
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
		if (AD_Val_Rule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Val_Rule", "AD_Val_Rule_UU=?", get_TrxName())
							.setParameters(AD_Val_Rule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Val_Rule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Val_Rule with UUID " + AD_Val_Rule.getUUID());
			}
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
	 * Set Dynamic Validation (Lookup).
	 *
	 * @param AD_Val_Rule_Lookup Override Dynamic Validation Rule for Lookup Window
	 */
	@JsonProperty("AD_Val_Rule_Lookup")
	public void setAD_Val_Rule_LookupInput(ForeignEntityInput AD_Val_Rule_Lookup) {
		this.mAD_Val_Rule_Lookup = AD_Val_Rule_Lookup;
		MValRule foreignEntity;
		if (AD_Val_Rule_Lookup != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Val_Rule", "AD_Val_Rule_UU=?", get_TrxName())
							.setParameters(AD_Val_Rule_Lookup.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Val_Rule_Lookup_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Val_Rule with UUID " + AD_Val_Rule_Lookup.getUUID());
			}
		} else {
			super.setAD_Val_Rule_Lookup_ID(0);
		}
	}

	/**
	 * Get Dynamic Validation (Lookup).
	 *
	 * @return Override Dynamic Validation Rule for Lookup Window
	 */
	@JsonProperty("AD_Val_Rule_Lookup")
	public ForeignEntityInput AD_Val_Rule_Lookup() {
		return mAD_Val_Rule_Lookup;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UUID " + AD_EntityType.getUUID());
			}
		} else {
			super.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Constraint Type.
	 *
	 * @param FKConstraintType Constraint Type
	 */
	@JsonProperty("FKConstraintType")
	public void setFKConstraintTypeInput(I_AD_Ref_ListInput FKConstraintType) {
		this.mFKConstraintType = FKConstraintType;
		MRefList_BH foreignEntity;
		if (FKConstraintType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FKConstraintType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFKConstraintType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + FKConstraintType.getUUID());
			}
		} else {
			this.setFKConstraintType(null);
		}
	}

	/**
	 * Get Constraint Type.
	 *
	 * @return Constraint Type
	 */
	@JsonProperty("FKConstraintType")
	public I_AD_Ref_ListInput FKConstraintType() {
		return mFKConstraintType;
	}

	/**
	 * Set Encrypted.
	 *
	 * @param IsEncrypted Display or Storage is encrypted
	 */
	@JsonProperty("IsEncrypted")
	public void setIsEncryptedInput(I_AD_Ref_ListInput IsEncrypted) {
		this.mIsEncrypted = IsEncrypted;
		MRefList_BH foreignEntity;
		if (IsEncrypted != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsEncrypted.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsEncrypted(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsEncrypted.getUUID());
			}
		} else {
			this.setIsEncrypted(null);
		}
	}

	/**
	 * Get Encrypted.
	 *
	 * @return Display or Storage is encrypted
	 */
	@JsonProperty("IsEncrypted")
	public I_AD_Ref_ListInput IsEncrypted() {
		return mIsEncrypted;
	}

	/**
	 * Set Toolbar Button.
	 *
	 * @param IsToolbarButton Show the button on the toolbar, the window, or both
	 */
	@JsonProperty("IsToolbarButton")
	public void setIsToolbarButtonInput(I_AD_Ref_ListInput IsToolbarButton) {
		this.mIsToolbarButton = IsToolbarButton;
		MRefList_BH foreignEntity;
		if (IsToolbarButton != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsToolbarButton.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsToolbarButton(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsToolbarButton.getUUID());
			}
		} else {
			this.setIsToolbarButton(null);
		}
	}

	/**
	 * Get Toolbar Button.
	 *
	 * @return Show the button on the toolbar, the window, or both
	 */
	@JsonProperty("IsToolbarButton")
	public I_AD_Ref_ListInput IsToolbarButton() {
		return mIsToolbarButton;
	}

	/**
	 * Set Dashboard Content.
	 *
	 * @param PA_DashboardContent Dashboard Content
	 */
	@JsonProperty("PA_DashboardContent")
	public void setPA_DashboardContentInput(ForeignEntityInput PA_DashboardContent) {
		this.mPA_DashboardContent = PA_DashboardContent;
		MDashboardContent foreignEntity;
		if (PA_DashboardContent != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "PA_DashboardContent", "PA_DashboardContent_UU=?", get_TrxName())
							.setParameters(PA_DashboardContent.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_DashboardContent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_DashboardContent with UUID " + PA_DashboardContent.getUUID());
			}
		} else {
			super.setPA_DashboardContent_ID(0);
		}
	}

	/**
	 * Get Dashboard Content.
	 *
	 * @return Dashboard Content
	 */
	@JsonProperty("PA_DashboardContent")
	public ForeignEntityInput PA_DashboardContent() {
		return mPA_DashboardContent;
	}
}
