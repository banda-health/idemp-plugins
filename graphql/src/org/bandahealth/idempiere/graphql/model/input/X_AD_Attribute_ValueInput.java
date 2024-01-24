package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Attribute;
import org.compiere.model.X_AD_Attribute_Value;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Attribute_Value - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Attribute_ValueInput extends X_AD_Attribute_Value implements I_AD_Attribute_ValueInput {

	private ForeignEntityInput mAD_Attribute;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Attribute_ValueInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_Attribute_Value(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set System Attribute.
	 *
	 * @param AD_Attribute System Attribute
	 */
	@JsonProperty("AD_Attribute")
	public void setAD_AttributeInput(ForeignEntityInput AD_Attribute) {
		this.mAD_Attribute = AD_Attribute;
		X_AD_Attribute foreignEntity;
		if (get_ID() == 0 && AD_Attribute != null &&
				(foreignEntity = new Query(getCtx(), "AD_Attribute", "AD_Attribute_UU=?", get_TrxName())
						.setParameters(AD_Attribute.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Attribute_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get System Attribute.
	 *
	 * @return System Attribute
	 */
	@JsonProperty("AD_Attribute")
	public ForeignEntityInput AD_Attribute() {
		return mAD_Attribute;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Attribute_Value_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Attribute_Value_UU();
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
}
