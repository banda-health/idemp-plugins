import { Visit } from '../types/org.bandahealth.idempiere.rest';
import { DocumentApi } from './documents';

class VisitApi extends DocumentApi<Visit> {
	entityName = 'visits';
}

export const visitApi = new VisitApi();
