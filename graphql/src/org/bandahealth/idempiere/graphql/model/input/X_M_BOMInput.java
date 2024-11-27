package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_M_BOMResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBOM;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_BOMInput extends MBOM implements I_M_BOMInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBOMType;
	private ForeignEntityInput mBOMUse;
	private ForeignEntityInput mM_ChangeNotice;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_BOM_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_BOMInput(@JsonProperty("UU") String UU) {
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
	 * Set BOM Type.
	 *
	 * @param BOMType Type of BOM
	 */
	@JsonProperty("BOMType")
	public void setBOMTypeInput(ForeignEntityInput BOMType) {
		this.mBOMType = BOMType;
		if (BOMType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_BOMResolver.BOMTYPE_UUIDS_BY_VALUE.containsValue(BOMType.getUU())) {
				throw new AdempiereException("The reference list UU of " + BOMType.getUU() +
						" is not in the list defined for the BOMType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BOMType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBOMType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BOMType.getUU());
			}
		} else {
			this.setBOMType(null);
		}
	}

	/**
	 * Get BOM Type.
	 *
	 * @return Type of BOM
	 */
	@JsonProperty("BOMType")
	public ForeignEntityInput BOMType() {
		return mBOMType;
	}

	/**
	 * Set BOM Use.
	 *
	 * @param BOMUse The use of the Bill of Material
	 */
	@JsonProperty("BOMUse")
	public void setBOMUseInput(ForeignEntityInput BOMUse) {
		this.mBOMUse = BOMUse;
		if (BOMUse != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_BOMResolver.BOMUSE_UUIDS_BY_VALUE.containsValue(BOMUse.getUU())) {
				throw new AdempiereException("The reference list UU of " + BOMUse.getUU() +
						" is not in the list defined for the BOMUse column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BOMUse.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBOMUse(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BOMUse.getUU());
			}
		} else {
			this.setBOMUse(null);
		}
	}

	/**
	 * Get BOM Use.
	 *
	 * @return The use of the Bill of Material
	 */
	@JsonProperty("BOMUse")
	public ForeignEntityInput BOMUse() {
		return mBOMUse;
	}
	/**
	 * Set BOM.
	 *
	 * @param M_BOM_ID Bill of Material
	 */
	@JsonProperty("M_BOM_ID")
	public void setM_BOM_IDFromJson(int M_BOM_ID) {
		if (get_ID() == 0) {
			super.setM_BOM_ID(M_BOM_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_BOM_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_BOM_UU();
	}

	/**
	 * Set Change Notice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public void setM_ChangeNoticeInput(ForeignEntityInput M_ChangeNotice) {
		this.mM_ChangeNotice = M_ChangeNotice;
		if (M_ChangeNotice != null) {
			// Since an entity was passed, make sure it's in the DB
			MChangeNotice foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
							.setParameters(M_ChangeNotice.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_ChangeNotice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ChangeNotice with UU " + M_ChangeNotice.getUU());
			}
		} else {
			this.setM_ChangeNotice_ID(0);
		}
	}

	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public ForeignEntityInput M_ChangeNotice() {
		return mM_ChangeNotice;
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
