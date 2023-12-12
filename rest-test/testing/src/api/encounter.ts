import { Encounter } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class EncounterApi extends BaseApi<Encounter> {
	entityName = 'encounters';
}

export const encounterApi = new EncounterApi();
