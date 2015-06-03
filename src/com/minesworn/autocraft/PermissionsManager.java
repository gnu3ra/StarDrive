package com.minesworn.autocraft;

import com.minesworn.autocraft.core.permissions.PermissionBase;

public class PermissionsManager extends PermissionBase {

	public enum Permission {
		CMD_ALLOWED("allowed"),
		CMD_DISMOUNT("dismount"),
		CMD_DROP("drop"),
		CMD_FIRE("fire"),
		CMD_INFO("info"),
		CMD_LIST("list"),
		CMD_NAPALM("napalm"),
		CMD_PILOT("pilot"),
		CMD_ROTATE("rotate"),
		CMD_TORPEDO("torpedo"),
		CMD_SCOURGE("scourge"),
		CMD_SPEED("speed"),
		CMD_SCOURGE_TORPEDO("sTorpedo");  //LEFT OFF HERE
		
		public final String node;
		Permission(final String node) {
			this.node = (Autocraft.p.getName() + "." + node).toLowerCase();
		}
	}
	
}
