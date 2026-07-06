package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningProduct;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_Visit_Family_Planning_ProductResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Visit_Family_Planning_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_Planning_ProductInput extends MBHVisitFamilyPlanningProduct implements I_BH_Visit_Family_Planning_ProductInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Fp_Method;
	private ForeignEntityInput mBH_Line_Role;
	private ForeignEntityInput mBH_Visit_Family_Planning;
	private ForeignEntityInput mC_OrderLine;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Visit_Family_Planning_Product_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Visit_Family_Planning_ProductInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
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
	 * Set FP Method.
	 *
	 * @param BH_Fp_Method FP Method
	 */
	@JsonProperty("BH_Fp_Method")
	public void setBH_Fp_MethodInput(ForeignEntityInput BH_Fp_Method) {
		this.mBH_Fp_Method = BH_Fp_Method;
		if (BH_Fp_Method != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_Planning_ProductResolver.BH_FP_METHOD_UUIDS_BY_VALUE.containsValue(BH_Fp_Method.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Fp_Method.getUU() +
						" is not in the list defined for the BH_Fp_Method column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Fp_Method.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Fp_Method(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Fp_Method.getUU());
			}
		} else {
			this.setBH_Fp_Method(null);
		}
	}

	/**
	 * Get FP Method.
	 *
	 * @return FP Method
	 */
	@JsonProperty("BH_Fp_Method")
	public ForeignEntityInput BH_Fp_Method() {
		return mBH_Fp_Method;
	}

	/**
	 * Set Line Role.
	 *
	 * @param BH_Line_Role Line Role
	 */
	@JsonProperty("BH_Line_Role")
	public void setBH_Line_RoleInput(ForeignEntityInput BH_Line_Role) {
		this.mBH_Line_Role = BH_Line_Role;
		if (BH_Line_Role != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_Planning_ProductResolver.BH_LINE_ROLE_UUIDS_BY_VALUE.containsValue(BH_Line_Role.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Line_Role.getUU() +
						" is not in the list defined for the BH_Line_Role column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Line_Role.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Line_Role(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Line_Role.getUU());
			}
		} else {
			this.setBH_Line_Role(null);
		}
	}

	/**
	 * Get Line Role.
	 *
	 * @return Line Role
	 */
	@JsonProperty("BH_Line_Role")
	public ForeignEntityInput BH_Line_Role() {
		return mBH_Line_Role;
	}

	/**
	 * Set Visit Family Planning.
	 *
	 * @param BH_Visit_Family_Planning Visit Family Planning
	 */
	@JsonProperty("BH_Visit_Family_Planning")
	public void setBH_Visit_Family_PlanningInput(ForeignEntityInput BH_Visit_Family_Planning) {
		this.mBH_Visit_Family_Planning = BH_Visit_Family_Planning;
		if (BH_Visit_Family_Planning != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHVisitFamilyPlanning foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Visit_Family_Planning", "BH_Visit_Family_Planning_UU=?", get_TrxName())
							.setParameters(BH_Visit_Family_Planning.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Visit_Family_Planning_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Visit_Family_Planning with UU " + BH_Visit_Family_Planning.getUU());
			}
		} else {
			this.setBH_Visit_Family_Planning_ID(0);
		}
	}

	/**
	 * Get Visit Family Planning.
	 *
	 * @return Visit Family Planning
	 */
	@JsonProperty("BH_Visit_Family_Planning")
	public ForeignEntityInput BH_Visit_Family_Planning() {
		return mBH_Visit_Family_Planning;
	}
	/**
	 * Set Visit Family Planning Product.
	 *
	 * @param BH_Visit_Family_Planning_Product_ID Visit Family Planning Product
	 */
	@JsonProperty("BH_Visit_Family_Planning_Product_ID")
	public void setBH_Visit_Family_Planning_Product_IDFromJson(int BH_Visit_Family_Planning_Product_ID) {
		if (get_ID() == 0) {
			super.setBH_Visit_Family_Planning_Product_ID(BH_Visit_Family_Planning_Product_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Visit_Family_Planning_Product_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Visit_Family_Planning_Product_UU();
	}

	/**
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public void setC_OrderLineInput(ForeignEntityInput C_OrderLine) {
		this.mC_OrderLine = C_OrderLine;
		if (C_OrderLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrderLine_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
							.setParameters(C_OrderLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_OrderLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderLine with UU " + C_OrderLine.getUU());
			}
		} else {
			this.setC_OrderLine_ID(0);
		}
	}

	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public ForeignEntityInput C_OrderLine() {
		return mC_OrderLine;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
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
