package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttribute_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttributeValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_AttributeValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_AttributeValueInput extends MAttributeValue implements I_M_AttributeValueInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Attribute;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_AttributeValueInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAttributeValue(null, (ResultSet) null, null), null, Table_Name, ID),
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
		MAttribute_BH foreignEntity;
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
	 * Set Attribute Value.
	 *
	 * @param M_AttributeValue_ID Product Attribute Value
	 */

	public void setM_AttributeValue_ID(int M_AttributeValue_ID) {
		if (get_ID() == 0) {
			super.setM_AttributeValue_ID(M_AttributeValue_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_AttributeValue_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_AttributeValue_UU();
	}
}
