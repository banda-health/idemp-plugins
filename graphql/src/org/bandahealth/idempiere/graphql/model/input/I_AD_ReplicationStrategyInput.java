package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ReplicationStrategy;

/**
 * Generated Interface for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ReplicationStrategyInput extends I_AD_ReplicationStrategy {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set AD_EntityType.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType);

	/**
	 * Get AD_EntityType.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	I_AD_EntityTypeInput getAD_EntityType();

	/**
	 * Set EXP_Processor.
	 *
	 * @param EXP_Processor EXP_Processor
	 */
	void setEXP_Processor(I_EXP_ProcessorInput EXP_Processor);

	/**
	 * Get EXP_Processor.
	 *
	 * @return EXP_Processor
	 */
	I_EXP_ProcessorInput getEXP_Processor();
}
