package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_RegistrationAttribute;
import org.compiere.model.X_A_RegistrationProduct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_RegistrationProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_RegistrationProductInput extends X_A_RegistrationProduct implements I_A_RegistrationProductInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_RegistrationAttribute;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_RegistrationProduct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_RegistrationProductInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Registration Attribute.
	 *
	 * @param A_RegistrationAttribute Asset Registration Attribute
	 */
	@JsonProperty("A_RegistrationAttribute")
	public void setA_RegistrationAttributeInput(ForeignEntityInput A_RegistrationAttribute) {
		this.mA_RegistrationAttribute = A_RegistrationAttribute;
		if (get_ID() != 0) {
			return;
		}
		if (A_RegistrationAttribute != null) {
			// Since an entity was passed, make sure it's in the DB
			X_A_RegistrationAttribute foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_RegistrationAttribute", "A_RegistrationAttribute_UU=?", get_TrxName())
							.setParameters(A_RegistrationAttribute.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_RegistrationAttribute_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_RegistrationAttribute with UU " + A_RegistrationAttribute.getUU());
			}
		} else {
			this.setA_RegistrationAttribute_ID(0);
		}
	}

	/**
	 * Get Registration Attribute.
	 *
	 * @return Asset Registration Attribute
	 */
	@JsonProperty("A_RegistrationAttribute")
	public ForeignEntityInput A_RegistrationAttribute() {
		return mA_RegistrationAttribute;
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_RegistrationProduct_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_RegistrationProduct_UU();
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
							.setParameters(M_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UU " + M_Product.getUU());
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
}
