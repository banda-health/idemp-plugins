package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrg;
import org.compiere.model.MPackage;
import org.compiere.model.MPackageLine;
import org.compiere.model.MPackageMPS;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_PackageLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PackageLineInput extends MPackageLine implements I_M_PackageLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_InOutLine;
	private ForeignEntityInput mM_Package;
	private ForeignEntityInput mM_PackageMPS;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_PackageLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_PackageLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MPackageLine(null, (ResultSet) null, null),
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(ForeignEntityInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		if (get_ID() != 0) {
			return;
		}
		if (M_InOutLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInOutLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
							.setParameters(M_InOutLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_InOutLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOutLine with UUID " + M_InOutLine.getUUID());
			}
		} else {
			this.setM_InOutLine_ID(0);
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public ForeignEntityInput M_InOutLine() {
		return mM_InOutLine;
	}

	/**
	 * Set Package.
	 *
	 * @param M_Package Shipment Package
	 */
	@JsonProperty("M_Package")
	public void setM_PackageInput(ForeignEntityInput M_Package) {
		this.mM_Package = M_Package;
		if (get_ID() != 0) {
			return;
		}
		if (M_Package != null) {
			// Since an entity was passed, make sure it's in the DB
			MPackage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Package", "M_Package_UU=?", get_TrxName())
							.setParameters(M_Package.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Package_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Package with UUID " + M_Package.getUUID());
			}
		} else {
			this.setM_Package_ID(0);
		}
	}

	/**
	 * Get Package.
	 *
	 * @return Shipment Package
	 */
	@JsonProperty("M_Package")
	public ForeignEntityInput M_Package() {
		return mM_Package;
	}
	/**
	 * Set Package Line.
	 *
	 * @param M_PackageLine_ID The detail content of the Package
	 */

	public void setM_PackageLine_ID(int M_PackageLine_ID) {
		if (get_ID() == 0) {
			super.setM_PackageLine_ID(M_PackageLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_PackageLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_PackageLine_UU();
	}

	/**
	 * Set Package MPS.
	 *
	 * @param M_PackageMPS Package MPS
	 */
	@JsonProperty("M_PackageMPS")
	public void setM_PackageMPSInput(ForeignEntityInput M_PackageMPS) {
		this.mM_PackageMPS = M_PackageMPS;
		if (M_PackageMPS != null) {
			// Since an entity was passed, make sure it's in the DB
			MPackageMPS foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PackageMPS", "M_PackageMPS_UU=?", get_TrxName())
							.setParameters(M_PackageMPS.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_PackageMPS_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PackageMPS with UUID " + M_PackageMPS.getUUID());
			}
		} else {
			this.setM_PackageMPS_ID(0);
		}
	}

	/**
	 * Get Package MPS.
	 *
	 * @return Package MPS
	 */
	@JsonProperty("M_PackageMPS")
	public ForeignEntityInput M_PackageMPS() {
		return mM_PackageMPS;
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
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
}
