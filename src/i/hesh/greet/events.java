package i.hesh.greet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class events implements Listener { 
	
	String prefix = ChatColor.AQUA + "[" + ChatColor.BLUE + "5radl" + ChatColor.AQUA + "] "; //[ 5radl ]
	
	@EventHandler
	public void player(PlayerJoinEvent e) { 
		
		Player p = e.getPlayer();
		e.setJoinMessage(prefix + ChatColor.GRAY + p.getName().toLowerCase() + ChatColor.AQUA + " joined 5radl Server!");
		String pName = p.getDisplayName();
		p.sendMessage(ChatColor.AQUA +"Hello " + pName +  ", Welcome to 5radl Server");
		//p.sendMessage(ChatColor.AQUA +"Online Players are "+ Bukkit.getOnlinePlayers());
		
		
		p.sendMessage(ChatColor.GRAY + "Online Players :");
		int i = 1;
		for(Player player : Bukkit.getOnlinePlayers()) {			
			p.sendMessage(ChatColor.RED + "" + i + "- " + player.getName());
			i++;
		}
		p.sendMessage(ChatColor.AQUA +"Type"+ ChatColor.GREEN +" (/help greet) "+ ChatColor.AQUA+ "for list of new commands");
		
	}
	@EventHandler
	public void Quit(PlayerQuitEvent e ) {
		Player p = e.getPlayer();
		e.setQuitMessage(prefix +ChatColor.GRAY  + p.getName().toLowerCase() + ChatColor.DARK_RED + " left the server");
	}
	
	public void player(PlayerBedEnterEvent e) { //Changed TRY! 
		Player p = e.getPlayer();
		p.sendMessage("aaaaaaaaaaa");
		Bukkit.getWorld("world").setFullTime(1);
		Bukkit.getConsoleSender().sendMessage(prefix +"Good Morning!");
	}
	
	
	
}
	
