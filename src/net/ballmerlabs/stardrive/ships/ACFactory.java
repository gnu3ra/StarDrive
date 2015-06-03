package net.ballmerlabs.stardrive.ships;

import net.ballmerlabs.stardrive.core.io.EFactory;

public class ACFactory implements EFactory<ACProperties> {

	@Override
	public ACProperties newEntity() {
		return new ACProperties();
	}
	
}
