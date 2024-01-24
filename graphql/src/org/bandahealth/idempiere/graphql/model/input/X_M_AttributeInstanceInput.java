package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttribute;
import org.compiere.model.MAttributeInstance;
import org.compiere.model.MAttributeValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_AttributeInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeInstanceInput extends MAttributeInstance implements I_M_AttributeInstanceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Attribute;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_AttributeValue;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_AttributeInstanceInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAttributeInstance(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Attribute.
	 *
	 * @param M_Attribute Product Attribute
	 */
	@JsonProperty("M_Attribute")
	public void setM_AttributeInput(ForeignEntityInput M_Attribute) {
		this.mM_Attribute = M_Attribute;
		MAttribute foreignEntity;
		if (get_ID() == 0 && M_Attribute != null &&
				(foreignEntity = new Query(getCtx(), "M_Attribute", "M_Attribute_UU=?", get_TrxName())
						.setParameters(M_Attribute.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Attribute_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Attribute.
	 *
	 * @return Product Attribute
	 */
	@JsonProperty("M_Attribute")
	public ForeignEntityInput M_Attribute() {
		return mM_Attribute;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_AttributeInstance_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_AttributeInstance_UU();
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (get_ID() == 0 && M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public ForeignEntityInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}

	/**
	 * Set Attribute Value.
	 *
	 * @param M_AttributeValue Product Attribute Value
	 */
	@JsonProperty("M_AttributeValue")
	public void setM_AttributeValueInput(ForeignEntityInput M_AttributeValue) {
		this.mM_AttributeValue = M_AttributeValue;
		MAttributeValue foreignEntity;
		if (M_AttributeValue != null &&
				(foreignEntity = new Query(getCtx(), "M_AttributeValue", "M_AttributeValue_UU=?", get_TrxName())
						.setParameters(M_AttributeValue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeValue_ID(foreignEntity.get_ID());
		} else {
			super.setM_AttributeValue_ID(0);
		}
	}

	/**
	 * Get Attribute Value.
	 *
	 * @return Product Attribute Value
	 */
	@JsonProperty("M_AttributeValue")
	public ForeignEntityInput M_AttributeValue() {
		return mM_AttributeValue;
	}
}
