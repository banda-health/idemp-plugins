package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrderTax;
import org.compiere.model.MOrg;
import org.compiere.model.MTax;
import org.compiere.model.MTaxProvider;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_OrderTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrderTaxInput extends MOrderTax implements I_C_OrderTaxInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_Tax;
	private ForeignEntityInput mC_TaxProvider;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_OrderTax_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_OrderTaxInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MOrderTax(null, (ResultSet) null, null),
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
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 && C_Order != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(C_Order.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UUID " + C_Order.getUUID());
			}
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public ForeignEntityInput C_Order() {
		return mC_Order;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_OrderTax_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_OrderTax_UU();
	}

	/**
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	@JsonProperty("C_Tax")
	public void setC_TaxInput(ForeignEntityInput C_Tax) {
		this.mC_Tax = C_Tax;
		MTax foreignEntity;
		if (get_ID() == 0 && C_Tax != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Tax", "C_Tax_UU=?", get_TrxName())
							.setParameters(C_Tax.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Tax_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Tax with UUID " + C_Tax.getUUID());
			}
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	@JsonProperty("C_Tax")
	public ForeignEntityInput C_Tax() {
		return mC_Tax;
	}

	/**
	 * Set Tax Provider.
	 *
	 * @param C_TaxProvider Tax Provider
	 */
	@JsonProperty("C_TaxProvider")
	public void setC_TaxProviderInput(ForeignEntityInput C_TaxProvider) {
		this.mC_TaxProvider = C_TaxProvider;
		MTaxProvider foreignEntity;
		if (get_ID() == 0 && C_TaxProvider != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxProvider", "C_TaxProvider_UU=?", get_TrxName())
							.setParameters(C_TaxProvider.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_TaxProvider_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxProvider with UUID " + C_TaxProvider.getUUID());
			}
		}
	}

	/**
	 * Get Tax Provider.
	 *
	 * @return Tax Provider
	 */
	@JsonProperty("C_TaxProvider")
	public ForeignEntityInput C_TaxProvider() {
		return mC_TaxProvider;
	}
	/**
	 * Set Tax Amount.
	 *
	 * @param TaxAmt Tax Amount for a document
	 */

	public void setTaxAmt(BigDecimal TaxAmt) {
		if (get_ID() == 0) {
			super.setTaxAmt(TaxAmt);
		}
	}
	/**
	 * Set Tax base Amount.
	 *
	 * @param TaxBaseAmt Base for calculating the tax amount
	 */

	public void setTaxBaseAmt(BigDecimal TaxBaseAmt) {
		if (get_ID() == 0) {
			super.setTaxBaseAmt(TaxBaseAmt);
		}
	}
}
