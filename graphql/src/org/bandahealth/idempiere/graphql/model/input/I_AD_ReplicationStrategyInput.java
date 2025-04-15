package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ReplicationStrategy;

/**
 * Generated Interface for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_ReplicationStrategyInput extends I_AD_ReplicationStrategy {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	ForeignEntityInput AD_EntityType();

	/**
	 * Set EXP_Processor.
	 *
	 * @param EXP_Processor EXP_Processor
	 */
	void setEXP_ProcessorInput(ForeignEntityInput EXP_Processor);

	/**
	 * Get EXP_Processor.
	 *
	 * @return EXP_Processor
	 */
	ForeignEntityInput EXP_Processor();
}
