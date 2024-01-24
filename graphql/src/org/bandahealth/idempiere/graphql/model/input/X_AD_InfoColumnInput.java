package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MInfoColumn;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MOrg;
import org.compiere.model.MStyle;
import org.compiere.model.MValRule;
import org.compiere.model.M_Element;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_InfoColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_InfoColumnInput extends MInfoColumn implements I_AD_InfoColumnInput {

	private ForeignEntityInput mAD_Element;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_FieldStyle;
	private ForeignEntityInput mAD_InfoWindow;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mAD_Val_Rule;
	private I_AD_Ref_ListInput mQueryOperator;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_InfoColumn_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_InfoColumnInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MInfoColumn(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set Field Style.
	 *
	 * @param AD_FieldStyle Field CSS Style 
	 */
	@JsonProperty("AD_FieldStyle")
	public void setAD_FieldStyleInput(ForeignEntityInput AD_FieldStyle) {
		this.mAD_FieldStyle = AD_FieldStyle;
		MStyle foreignEntity;
		if (AD_FieldStyle != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Style", "AD_Style_UU=?", get_TrxName())
							.setParameters(AD_FieldStyle.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_FieldStyle_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Style with UUID " + AD_FieldStyle.getUUID());
			}
		} else {
			super.setAD_FieldStyle_ID(0);
		}
	}

	/**
	 * Get Field Style.
	 *
	 * @return Field CSS Style 
	 */
	@JsonProperty("AD_FieldStyle")
	public ForeignEntityInput AD_FieldStyle() {
		return mAD_FieldStyle;
	}
	/**
	 * Set Info Column.
	 *
	 * @param AD_InfoColumn_ID Info Window Column
	 */

	public void setAD_InfoColumn_ID(int AD_InfoColumn_ID) {
		if (get_ID() == 0) {
			super.setAD_InfoColumn_ID(AD_InfoColumn_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_InfoColumn_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_InfoColumn_UU();
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
		if (get_ID() == 0 && AD_InfoWindow != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_InfoWindow", "AD_InfoWindow_UU=?", get_TrxName())
							.setParameters(AD_InfoWindow.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_InfoWindow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoWindow with UUID " + AD_InfoWindow.getUUID());
			}
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
	 * Set Query Operator.
	 *
	 * @param QueryOperator Operator for database query
	 */
	@JsonProperty("QueryOperator")
	public void setQueryOperatorInput(I_AD_Ref_ListInput QueryOperator) {
		this.mQueryOperator = QueryOperator;
		MRefList_BH foreignEntity;
		if (QueryOperator != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(QueryOperator.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setQueryOperator(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + QueryOperator.getUUID());
			}
		} else {
			this.setQueryOperator(null);
		}
	}

	/**
	 * Get Query Operator.
	 *
	 * @return Operator for database query
	 */
	@JsonProperty("QueryOperator")
	public I_AD_Ref_ListInput QueryOperator() {
		return mQueryOperator;
	}
}
