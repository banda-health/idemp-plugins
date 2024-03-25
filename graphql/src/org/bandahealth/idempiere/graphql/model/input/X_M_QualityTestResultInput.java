package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MQualityTest;
import org.compiere.model.MQualityTestResult;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_QualityTestResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_QualityTestResultInput extends MQualityTestResult implements I_M_QualityTestResultInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_QualityTest;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_QualityTestResult_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_QualityTestResultInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Description.
	 *
	 * @param Description Optional short description of the record
	 */

	public void setDescription(String Description) {
		if (get_ID() == 0) {
			super.setDescription(Description);
		}
	}
	/**
	 * Set Expected Result.
	 *
	 * @param ExpectedResult Expected Result
	 */

	public void setExpectedResult(String ExpectedResult) {
		if (get_ID() == 0) {
			super.setExpectedResult(ExpectedResult);
		}
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
	 * Set Quality Test.
	 *
	 * @param M_QualityTest Quality Test
	 */
	@JsonProperty("M_QualityTest")
	public void setM_QualityTestInput(ForeignEntityInput M_QualityTest) {
		this.mM_QualityTest = M_QualityTest;
		if (get_ID() != 0) {
			return;
		}
		if (M_QualityTest != null) {
			// Since an entity was passed, make sure it's in the DB
			MQualityTest foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_QualityTest", "M_QualityTest_UU=?", get_TrxName())
							.setParameters(M_QualityTest.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_QualityTest_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_QualityTest with UUID " + M_QualityTest.getUUID());
			}
		} else {
			this.setM_QualityTest_ID(0);
		}
	}

	/**
	 * Get Quality Test.
	 *
	 * @return Quality Test
	 */
	@JsonProperty("M_QualityTest")
	public ForeignEntityInput M_QualityTest() {
		return mM_QualityTest;
	}
	/**
	 * Set Quality Test Result.
	 *
	 * @param M_QualityTestResult_ID Quality Test Result
	 */

	public void setM_QualityTestResult_ID(int M_QualityTestResult_ID) {
		if (get_ID() == 0) {
			super.setM_QualityTestResult_ID(M_QualityTestResult_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_QualityTestResult_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_QualityTestResult_UU();
	}
}
