package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttribute;
import org.compiere.model.MAttributeValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_AttributeValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeValueInput extends MAttributeValue implements I_M_AttributeValueInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Attribute;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_AttributeValue_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_AttributeValueInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (M_Attribute != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttribute foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Attribute", "M_Attribute_UU=?", get_TrxName())
							.setParameters(M_Attribute.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Attribute_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Attribute with UUID " + M_Attribute.getUUID());
			}
		} else {
			this.setM_Attribute_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_AttributeValue_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_AttributeValue_UU();
	}
}
