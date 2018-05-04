package i.hesh.greet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class events implements Listener { 
	
	private final String PREFIX = ChatColor.AQUA + "[" + ChatColor.BLUE + "5radl" + ChatColor.AQUA + "] "; //[ 5radl ]
	Player p;
	ChatColor aqua = ChatColor.AQUA;
	ChatColor gray = ChatColor.GRAY;
	
	@EventHandler
	public void player(PlayerJoinEvent e) { 
		
		p = e.getPlayer();
		String pName = p.getDisplayName();
		e.setJoinMessage(PREFIX + gray + p.getName().toLowerCase() + aqua + " joined 5radl Server!");
		p.sendMessage(aqua +"Hello " + pName +  ", Welcome to 5radl Server");
		p.sendMessage(gray + "Online Players :");
		
		int i = 1;
		for(Player player : Bukkit.getOnlinePlayers()) {			
			p.sendMessage(ChatColor.RED + "" + i + "- " + player.getName());
			i++;
		}

		//p.sendMessage(aqua +"Type"+ ChatColor.GREEN +" (/help greet) "+ aqua+ "for list of new commands");
	}
	
	@EventHandler
	public void Quit(PlayerQuitEvent e ) {
		
		p = e.getPlayer();
		e.setQuitMessage(PREFIX + gray + p.getName().toLowerCase() + ChatColor.DARK_RED + " left the server");
	}
	
	@EventHandler
	public void player(PlayerBedLeaveEvent e) {
		
		p = e.getPlayer();
		Bukkit.getWorld("world").setFullTime(1);
		p.sendMessage(PREFIX+" Good Morning!");	

	}
	@EventHandler
	public void player(PlayerItemConsumeEvent e) {e.getPlayer().sendMessage(ChatColor.BOLD+"nom nom nom!");}
	
	

}
	
