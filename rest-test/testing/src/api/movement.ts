import { Movement } from '../types/org.bandahealth.idempiere.rest';
import { DocumentApi } from './documents';

class MovementApi extends DocumentApi<Movement> {
	entityName = 'movements';
}

export const movementApi = new MovementApi();
