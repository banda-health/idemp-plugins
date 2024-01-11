package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttribute;
import org.compiere.model.MAttributeUse;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_AttributeUse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeUseInput extends MAttributeUse implements I_M_AttributeUseInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Attribute;
	private ForeignEntityInput mM_AttributeSet;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_AttributeUseInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAttributeUse(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Attribute Set.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	@JsonProperty("M_AttributeSet")
	public void setM_AttributeSetInput(ForeignEntityInput M_AttributeSet) {
		this.mM_AttributeSet = M_AttributeSet;
		MAttributeSet_BH foreignEntity;
		if (get_ID() == 0 && M_AttributeSet != null &&
				(foreignEntity = new Query(getCtx(), "M_AttributeSet", "M_AttributeSet_UU=?", get_TrxName())
						.setParameters(M_AttributeSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSet_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	@JsonProperty("M_AttributeSet")
	public ForeignEntityInput M_AttributeSet() {
		return mM_AttributeSet;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_AttributeUse_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_AttributeUse_UU();
	}
}
