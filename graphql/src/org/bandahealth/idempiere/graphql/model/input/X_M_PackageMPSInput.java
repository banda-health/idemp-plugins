package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPackage;
import org.compiere.model.MPackageMPS;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_PackageMPS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PackageMPSInput extends MPackageMPS implements I_M_PackageMPSInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_UOMInput C_UOM_Length;
	 private I_C_UOMInput C_UOM_Weight;
	 private I_M_PackageInput M_Package;

	/**
	 * Standard constructor
	 */
	public X_M_PackageMPSInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set UOM for Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	public void setC_UOM_Length(I_C_UOMInput C_UOM_Length) {
		this.C_UOM_Length = C_UOM_Length;
		MUOM foreignEntity;
		if (C_UOM_Length != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM_Length.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_Length_ID(foreignEntity.get_ID());
		} else {
			this.setC_UOM_Length_ID(0);
		}
	}

	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	public I_C_UOMInput getC_UOM_Length() {
		return C_UOM_Length;
	}

	/**
	 * Set UOM for Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	public void setC_UOM_Weight(I_C_UOMInput C_UOM_Weight) {
		this.C_UOM_Weight = C_UOM_Weight;
		MUOM foreignEntity;
		if (C_UOM_Weight != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM_Weight.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_Weight_ID(foreignEntity.get_ID());
		} else {
			this.setC_UOM_Weight_ID(0);
		}
	}

	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	public I_C_UOMInput getC_UOM_Weight() {
		return C_UOM_Weight;
	}

	/**
	 * Set Package.
	 *
	 * @param M_Package Shipment Package
	 */
	public void setM_Package(I_M_PackageInput M_Package) {
		this.M_Package = M_Package;
		MPackage foreignEntity;
		if (get_ID() == 0 &&M_Package != null &&
				(foreignEntity = new Query(getCtx(), MPackage.Table_Name, MPackage.COLUMNNAME_M_Package_UU + "=?", get_TrxName())
						.setParameters(M_Package.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Package_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Package.
	 *
	 * @return Shipment Package
	 */
	public I_M_PackageInput getM_Package() {
		return M_Package;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_PackageMPS_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_PackageMPS_UU();
	}
}
