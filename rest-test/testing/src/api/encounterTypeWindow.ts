import { EncounterTypeWindow } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class EncounterTypeWindowApi extends BaseApi<EncounterTypeWindow> {
	entityName = 'encounter-type-windows';
}

export const encounterTypeWindowApi = new EncounterTypeWindowApi();
