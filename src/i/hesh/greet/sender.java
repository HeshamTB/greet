package i.hesh.greet;


import org.bukkit.*;
import org.bukkit.entity.Player;

public class sender {
	private  static final  String PREFIX = ChatColor.AQUA + "[" + ChatColor.BLUE + "greet" + ChatColor.AQUA + "] "; //[ greet ]
	public static void sendToPlayer(Player p, String msg, ChatColor c) {
		p.sendMessage( PREFIX + c + msg);
		
	}
	public static void sendToAll() {}
	
	
}
