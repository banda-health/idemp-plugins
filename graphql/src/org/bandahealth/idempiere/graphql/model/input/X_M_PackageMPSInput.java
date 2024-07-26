package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPackage;
import org.compiere.model.MPackageMPS;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_PackageMPS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PackageMPSInput extends MPackageMPS implements I_M_PackageMPSInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_UOM_Length;
	private ForeignEntityInput mC_UOM_Weight;
	private ForeignEntityInput mM_Package;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_PackageMPS_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_PackageMPSInput(@JsonProperty("UU") String UU) {
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
	 * Set UOM for Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public void setC_UOM_LengthInput(ForeignEntityInput C_UOM_Length) {
		this.mC_UOM_Length = C_UOM_Length;
		if (C_UOM_Length != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM_Length.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_UOM_Length_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UU " + C_UOM_Length.getUU());
			}
		} else {
			this.setC_UOM_Length_ID(0);
		}
	}

	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public ForeignEntityInput C_UOM_Length() {
		return mC_UOM_Length;
	}

	/**
	 * Set UOM for Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	@JsonProperty("C_UOM_Weight")
	public void setC_UOM_WeightInput(ForeignEntityInput C_UOM_Weight) {
		this.mC_UOM_Weight = C_UOM_Weight;
		if (C_UOM_Weight != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM_Weight.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_UOM_Weight_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UU " + C_UOM_Weight.getUU());
			}
		} else {
			this.setC_UOM_Weight_ID(0);
		}
	}

	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	@JsonProperty("C_UOM_Weight")
	public ForeignEntityInput C_UOM_Weight() {
		return mC_UOM_Weight;
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
							.setParameters(M_Package.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Package_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Package with UU " + M_Package.getUU());
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
	 * Set Package MPS.
	 *
	 * @param M_PackageMPS_ID Package MPS
	 */
	@JsonProperty("M_PackageMPS_ID")
	public void setM_PackageMPS_IDFromJson(int M_PackageMPS_ID) {
		if (get_ID() == 0) {
			super.setM_PackageMPS_ID(M_PackageMPS_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_PackageMPS_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_PackageMPS_UU();
	}
}
