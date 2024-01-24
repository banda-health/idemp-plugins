package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCountry;
import org.compiere.model.MFreightCategory;
import org.compiere.model.MOrg;
import org.compiere.model.MRegion;
import org.compiere.model.MShipper;
import org.compiere.model.Query;
import org.compiere.model.X_M_Freight;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Freight - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_FreightInput extends X_M_Freight implements I_M_FreightInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Country;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_Region;
	private ForeignEntityInput mM_FreightCategory;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mTo_Region;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Freight_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_FreightInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_M_Freight(null, (ResultSet) null, null),
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
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	@JsonProperty("C_Country")
	public void setC_CountryInput(ForeignEntityInput C_Country) {
		this.mC_Country = C_Country;
		MCountry foreignEntity;
		if (C_Country != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Country", "C_Country_UU=?", get_TrxName())
							.setParameters(C_Country.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Country_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Country with UUID " + C_Country.getUUID());
			}
		} else {
			super.setC_Country_ID(0);
		}
	}

	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	@JsonProperty("C_Country")
	public ForeignEntityInput C_Country() {
		return mC_Country;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			super.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public void setC_RegionInput(ForeignEntityInput C_Region) {
		this.mC_Region = C_Region;
		MRegion foreignEntity;
		if (C_Region != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Region", "C_Region_UU=?", get_TrxName())
							.setParameters(C_Region.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Region_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Region with UUID " + C_Region.getUUID());
			}
		} else {
			super.setC_Region_ID(0);
		}
	}

	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public ForeignEntityInput C_Region() {
		return mC_Region;
	}
	/**
	 * Set Freight.
	 *
	 * @param M_Freight_ID Freight Rate
	 */

	public void setM_Freight_ID(int M_Freight_ID) {
		if (get_ID() == 0) {
			super.setM_Freight_ID(M_Freight_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_Freight_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_Freight_UU();
	}

	/**
	 * Set Freight Category.
	 *
	 * @param M_FreightCategory Category of the Freight
	 */
	@JsonProperty("M_FreightCategory")
	public void setM_FreightCategoryInput(ForeignEntityInput M_FreightCategory) {
		this.mM_FreightCategory = M_FreightCategory;
		MFreightCategory foreignEntity;
		if (M_FreightCategory != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_FreightCategory", "M_FreightCategory_UU=?", get_TrxName())
							.setParameters(M_FreightCategory.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_FreightCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_FreightCategory with UUID " + M_FreightCategory.getUUID());
			}
		} else {
			super.setM_FreightCategory_ID(0);
		}
	}

	/**
	 * Get Freight Category.
	 *
	 * @return Category of the Freight
	 */
	@JsonProperty("M_FreightCategory")
	public ForeignEntityInput M_FreightCategory() {
		return mM_FreightCategory;
	}

	/**
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public void setM_ShipperInput(ForeignEntityInput M_Shipper) {
		this.mM_Shipper = M_Shipper;
		MShipper foreignEntity;
		if (get_ID() == 0 && M_Shipper != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Shipper", "M_Shipper_UU=?", get_TrxName())
							.setParameters(M_Shipper.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Shipper_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Shipper with UUID " + M_Shipper.getUUID());
			}
		}
	}

	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public ForeignEntityInput M_Shipper() {
		return mM_Shipper;
	}

	/**
	 * Set To.
	 *
	 * @param To_Region Receiving Region
	 */
	@JsonProperty("To_Region")
	public void setTo_RegionInput(ForeignEntityInput To_Region) {
		this.mTo_Region = To_Region;
		MRegion foreignEntity;
		if (To_Region != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Region", "C_Region_UU=?", get_TrxName())
							.setParameters(To_Region.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setTo_Region_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Region with UUID " + To_Region.getUUID());
			}
		} else {
			super.setTo_Region_ID(0);
		}
	}

	/**
	 * Get To.
	 *
	 * @return Receiving Region
	 */
	@JsonProperty("To_Region")
	public ForeignEntityInput To_Region() {
		return mTo_Region;
	}
}
