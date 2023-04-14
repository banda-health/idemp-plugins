import { rm } from 'fs/promises';
import { tmpdir } from 'os';
import { join } from 'path';

const workingDirectory = join(tmpdir(), 'rest-global-setup');

export default async function teardown() {
	await rm(workingDirectory, { recursive: true, force: true });
}
