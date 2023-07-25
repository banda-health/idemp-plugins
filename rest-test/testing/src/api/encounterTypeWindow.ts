import { EncounterTypeWindow } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class EncounterTypeWindowApi extends BaseApi<EncounterTypeWindow> {
	entityName = 'encounter-window-types';
}

export const encounterTypeWindowApi = new EncounterTypeWindowApi();
