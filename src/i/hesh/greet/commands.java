package i.hesh.greet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class commands extends JavaPlugin  {
	
	protected static boolean IsBedEvent;
	
	public void onEnable() {
		IsBedEvent = true;
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "greet plugin is Enabled");
		Bukkit.getServer().getPluginManager().registerEvents(new events(), this);
		
	}
	public void onDisable() {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Plugin greet is disabled");
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
		
		String greetprefix = ChatColor.AQUA + "[" + ChatColor.BLUE + "greet" + ChatColor.AQUA + "] "; //[ greet ]
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("opcheck")) {
			
			String pName = p.getDisplayName();
			p.sendMessage(greetprefix + ChatColor.AQUA + "Hello " + pName+"! "  );
			if (p.isOp()) {
				p.sendMessage(greetprefix+ChatColor.GREEN +"You are an Operator");
				//p.giveExp(5);								
			}
			else {
			
				p.sendMessage(greetprefix + ChatColor.GREEN +"You are not an Operator");
			}	
		}
		if(cmd.getName().equalsIgnoreCase("count")) {
	
			int i = 1;
			p.sendMessage(greetprefix + ChatColor.GRAY + "Online Players :");
			
			for(Player player : Bukkit.getOnlinePlayers()) {
				
				p.sendMessage(ChatColor.RED + "" + i + "- " + player.getName());
				i++;
			}					
		}					
		if(cmd.getName().equalsIgnoreCase("kit1") && p.isOp()) {
		   
	    	p.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
		    p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
		    p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
		    p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));			
		}
		
		if (cmd.getName().equalsIgnoreCase("beds")){
			
			if (args[0].equalsIgnoreCase("disable")) {
				if (!IsBedEvent) p.sendMessage(greetprefix + "Bed feature is already disabled!");
				else {
					
					IsBedEvent = false;
					Bukkit.getServer().broadcastMessage(greetprefix + ChatColor.BOLD + ChatColor.DARK_RED + p.getDisplayName() + " has Disabled bed feature");
				}
					
			}
			else if (args[0].equalsIgnoreCase("enable")) {
				
				if (IsBedEvent) p.sendMessage(greetprefix + "Bed feature is already enabled!");
				
				else {
					IsBedEvent = true;
					Bukkit.getServer().broadcastMessage(greetprefix + ChatColor.BOLD + ChatColor.DARK_RED + p.getDisplayName() + " has Enabled bed feature");
				
				}
				
			}
				
			else p.sendMessage(greetprefix + "Unknown argument\n Try disable/enable");
		}
		
		/*if(cmd.getName().equalsIgnoreCase("setspwan")) { // TODO: give option of new arg to set cords & 
			p.setBedSpawnLocation(p.getLocation());
			p.sendMessage(ChatColor.GREEN +"Your bed Spwan has been updated to currnet location");
			
		}*/ //failed to respwan (bed obstructed) 
		return true;		
		}				
} 
