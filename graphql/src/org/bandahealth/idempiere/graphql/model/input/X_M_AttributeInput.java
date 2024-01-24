package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttribute_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MValRule;
import org.compiere.model.Query;
import org.compiere.model.X_M_AttributeSearch;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_AttributeInput extends MAttribute_BH implements I_M_AttributeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mAD_Val_Rule;
	private ForeignEntityInput mM_AttributeSearch;
	private I_AD_Ref_ListInput mAttributeValueType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Attribute_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_AttributeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MAttribute_BH(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set Attribute Value Type.
	 *
	 * @param AttributeValueType Type of Attribute Value
	 */
	@JsonProperty("AttributeValueType")
	public void setAttributeValueTypeInput(I_AD_Ref_ListInput AttributeValueType) {
		this.mAttributeValueType = AttributeValueType;
		MRefList_BH foreignEntity;
		if (AttributeValueType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AttributeValueType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAttributeValueType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + AttributeValueType.getUUID());
			}
		} else {
			this.setAttributeValueType(null);
		}
	}

	/**
	 * Get Attribute Value Type.
	 *
	 * @return Type of Attribute Value
	 */
	@JsonProperty("AttributeValueType")
	public I_AD_Ref_ListInput AttributeValueType() {
		return mAttributeValueType;
	}
	/**
	 * Set Attribute.
	 *
	 * @param M_Attribute_ID Product Attribute
	 */

	public void setM_Attribute_ID(int M_Attribute_ID) {
		if (get_ID() == 0) {
			super.setM_Attribute_ID(M_Attribute_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_Attribute_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_Attribute_UU();
	}

	/**
	 * Set Attribute Search.
	 *
	 * @param M_AttributeSearch Common Search Attribute 
	 */
	@JsonProperty("M_AttributeSearch")
	public void setM_AttributeSearchInput(ForeignEntityInput M_AttributeSearch) {
		this.mM_AttributeSearch = M_AttributeSearch;
		X_M_AttributeSearch foreignEntity;
		if (M_AttributeSearch != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSearch", "M_AttributeSearch_UU=?", get_TrxName())
							.setParameters(M_AttributeSearch.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_AttributeSearch_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSearch with UUID " + M_AttributeSearch.getUUID());
			}
		} else {
			super.setM_AttributeSearch_ID(0);
		}
	}

	/**
	 * Get Attribute Search.
	 *
	 * @return Common Search Attribute 
	 */
	@JsonProperty("M_AttributeSearch")
	public ForeignEntityInput M_AttributeSearch() {
		return mM_AttributeSearch;
	}
}
