package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MQualityTest;
import org.compiere.model.MQualityTestResult;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_QualityTestResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_QualityTestResultInput extends MQualityTestResult implements I_M_QualityTestResultInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_QualityTest;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_QualityTestResultInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MQualityTestResult(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Quality Test.
	 *
	 * @param M_QualityTest Quality Test
	 */
	@JsonProperty("M_QualityTest")
	public void setM_QualityTestInput(ForeignEntityInput M_QualityTest) {
		this.mM_QualityTest = M_QualityTest;
		MQualityTest foreignEntity;
		if (get_ID() == 0 && M_QualityTest != null &&
				(foreignEntity = new Query(getCtx(), "M_QualityTest", "M_QualityTest_UU=?", get_TrxName())
						.setParameters(M_QualityTest.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_QualityTest_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_QualityTestResult_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_QualityTestResult_UU();
	}
}
