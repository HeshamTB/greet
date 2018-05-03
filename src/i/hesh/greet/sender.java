package i.hesh.greet;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class sender {
	private  static final  String PREFIX = ChatColor.AQUA + "[" + ChatColor.BLUE + "greet" + ChatColor.AQUA + "] "; //[ greet ]
	
	/** Sends a chat message to the Player*/
	public static void sendToPlayer(Player player, String msg, ChatColor color) {
		player.sendMessage( PREFIX + color + msg);
		
	}
	/**Sends a chat message to all online players*/
	public static void sendToAll() {}
	
	
}
