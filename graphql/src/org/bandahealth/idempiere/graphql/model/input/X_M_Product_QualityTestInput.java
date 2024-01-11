package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MQualityTest;
import org.compiere.model.Query;
import org.compiere.model.X_M_Product_QualityTest;

import java.sql.ResultSet;

/**
 * Generated Model for M_Product_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_QualityTestInput extends X_M_Product_QualityTest implements I_M_Product_QualityTestInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_QualityTest;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_Product_QualityTestInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_Product_QualityTest(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 && M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}
	/**
	 * Set Product Quality Test.
	 *
	 * @param M_Product_QualityTest_ID Product Quality Test
	 */

	public void setM_Product_QualityTest_ID(int M_Product_QualityTest_ID) {
		if (get_ID() == 0) {
			super.setM_Product_QualityTest_ID(M_Product_QualityTest_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Product_QualityTest_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Product_QualityTest_UU();
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
}
