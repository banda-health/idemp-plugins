package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MQualityTest;
import org.compiere.model.Query;
import org.compiere.model.X_M_Product_QualityTest;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Product_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_Product_QualityTestInput extends X_M_Product_QualityTest implements I_M_Product_QualityTestInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_QualityTest;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Product_QualityTest_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_Product_QualityTestInput(@JsonProperty("UUID") String UUID) {
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
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		if (get_ID() != 0) {
			return;
		}
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		} else {
			this.setM_Product_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_Product_QualityTest_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
}
