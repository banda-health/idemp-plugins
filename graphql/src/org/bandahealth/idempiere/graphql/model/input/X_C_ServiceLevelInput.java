package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRevenueRecognitionPlan;
import org.compiere.model.Query;
import org.compiere.model.X_C_ServiceLevel;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_ServiceLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ServiceLevelInput extends X_C_ServiceLevel implements I_C_ServiceLevelInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RevenueRecognition_Plan;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_ServiceLevel_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_ServiceLevelInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_ServiceLevel(null, (ResultSet) null, null),
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Revenue Recognition Plan.
	 *
	 * @param C_RevenueRecognition_Plan Plan for recognizing or recording revenue
	 */
	@JsonProperty("C_RevenueRecognition_Plan")
	public void setC_RevenueRecognition_PlanInput(ForeignEntityInput C_RevenueRecognition_Plan) {
		this.mC_RevenueRecognition_Plan = C_RevenueRecognition_Plan;
		MRevenueRecognitionPlan foreignEntity;
		if (get_ID() == 0 && C_RevenueRecognition_Plan != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_RevenueRecognition_Plan", "C_RevenueRecognition_Plan_UU=?", get_TrxName())
							.setParameters(C_RevenueRecognition_Plan.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_RevenueRecognition_Plan_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RevenueRecognition_Plan with UUID " + C_RevenueRecognition_Plan.getUUID());
			}
		}
	}

	/**
	 * Get Revenue Recognition Plan.
	 *
	 * @return Plan for recognizing or recording revenue
	 */
	@JsonProperty("C_RevenueRecognition_Plan")
	public ForeignEntityInput C_RevenueRecognition_Plan() {
		return mC_RevenueRecognition_Plan;
	}
	/**
	 * Set Service Level.
	 *
	 * @param C_ServiceLevel_ID Product Revenue Recognition Service Level 
	 */

	public void setC_ServiceLevel_ID(int C_ServiceLevel_ID) {
		if (get_ID() == 0) {
			super.setC_ServiceLevel_ID(C_ServiceLevel_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_ServiceLevel_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_ServiceLevel_UU();
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
		if (get_ID() == 0 && M_Product != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
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
	 * Set Quantity Invoiced.
	 *
	 * @param ServiceLevelInvoiced Quantity of product or service invoiced
	 */

	public void setServiceLevelInvoiced(BigDecimal ServiceLevelInvoiced) {
		if (get_ID() == 0) {
			super.setServiceLevelInvoiced(ServiceLevelInvoiced);
		}
	}
	/**
	 * Set Quantity Provided.
	 *
	 * @param ServiceLevelProvided Quantity of service or product provided
	 */

	public void setServiceLevelProvided(BigDecimal ServiceLevelProvided) {
		if (get_ID() == 0) {
			super.setServiceLevelProvided(ServiceLevelProvided);
		}
	}
}
