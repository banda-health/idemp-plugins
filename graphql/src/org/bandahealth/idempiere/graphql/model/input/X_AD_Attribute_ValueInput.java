package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Attribute;
import org.compiere.model.X_AD_Attribute_Value;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Attribute_Value - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Attribute_ValueInput extends X_AD_Attribute_Value implements I_AD_Attribute_ValueInput {

	private ForeignEntityInput mAD_Attribute;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Attribute_Value_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Attribute_ValueInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_Attribute_Value(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set System Attribute.
	 *
	 * @param AD_Attribute System Attribute
	 */
	@JsonProperty("AD_Attribute")
	public void setAD_AttributeInput(ForeignEntityInput AD_Attribute) {
		this.mAD_Attribute = AD_Attribute;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Attribute != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Attribute foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Attribute", "AD_Attribute_UU=?", get_TrxName())
							.setParameters(AD_Attribute.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Attribute_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Attribute with UUID " + AD_Attribute.getUUID());
			}
		} else {
			this.setAD_Attribute_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Attribute_Value_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
