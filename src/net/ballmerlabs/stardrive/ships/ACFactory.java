package net.ballmerlabs.stardrive.ships;

import net.ballmerlabs.stardrive.core.io.EFactory;

public class ACFactory implements EFactory<ACProperties> {


	public ACProperties newEntity() {
		return new ACProperties();
	}
	
}
