package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrg;
import org.compiere.model.MPackage;
import org.compiere.model.MPackageLine;
import org.compiere.model.MPackageMPS;
import org.compiere.model.Query;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_PackageLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MPackageLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(ForeignEntityInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (get_ID() == 0 && M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InOutLine_ID(foreignEntity.get_ID());
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
		MPackage foreignEntity;
		if (get_ID() == 0 && M_Package != null &&
				(foreignEntity = new Query(getCtx(), "M_Package", "M_Package_UU=?", get_TrxName())
						.setParameters(M_Package.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Package_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_PackageLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MPackageMPS foreignEntity;
		if (M_PackageMPS != null &&
				(foreignEntity = new Query(getCtx(), "M_PackageMPS", "M_PackageMPS_UU=?", get_TrxName())
						.setParameters(M_PackageMPS.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PackageMPS_ID(foreignEntity.get_ID());
		} else {
			super.setM_PackageMPS_ID(0);
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
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
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
