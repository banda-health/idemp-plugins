package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttribute;
import org.compiere.model.MAttributeInstance;
import org.compiere.model.MAttributeValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_AttributeInstance_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_AttributeInstanceInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MAttributeInstance(null, (ResultSet) null, null),
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_AttributeInstance_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (M_AttributeSetInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSetInstance_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstance.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UUID " + M_AttributeSetInstance.getUUID());
			}
		} else {
			this.setM_AttributeSetInstance_ID(0);
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
		if (M_AttributeValue != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeValue", "M_AttributeValue_UU=?", get_TrxName())
							.setParameters(M_AttributeValue.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_AttributeValue_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeValue with UUID " + M_AttributeValue.getUUID());
			}
		} else {
			this.setM_AttributeValue_ID(0);
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
