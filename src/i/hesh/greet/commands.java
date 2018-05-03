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
	
	public void onEnable() {
		
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "greet plugin is Enabled");
		Bukkit.getServer().getPluginManager().registerEvents(new events(), this);
		
	}
	public void onDisable() {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Plugin greet is disabled");
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
		String greetprefix = ChatColor.AQUA + "[" + ChatColor.BLUE + "greet" + ChatColor.AQUA + "] "; //[ greet ]
		Player p = (Player) sender;
		
		//use sender class
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
			//p.sendMessage(hesh());
			
			int i = 1;
			p.sendMessage(greetprefix + ChatColor.GRAY + "Online Players :");
			for(Player player : Bukkit.getOnlinePlayers()) {
				
				p.sendMessage(ChatColor.RED + "" + i + "- " + player.getName());
				i++;
			}
			
			
						
		}				
		
		if(cmd.getName().equalsIgnoreCase("kit1")) {
		    ItemStack kit1p = new ItemStack(Material.STONE_PICKAXE);
		    ItemStack kit1s = new ItemStack(Material.STONE_SWORD);
		    ItemStack kit1a = new ItemStack(Material.STONE_AXE);
		    ItemStack kit1t = new ItemStack(Material.TORCH,5);
		    
			p.sendMessage( greetprefix + ChatColor.AQUA + "Survival Kit");
			
		    p.getInventory().addItem(kit1p);
		    p.getInventory().addItem(kit1s);
		    p.getInventory().addItem(kit1a);
		    p.getInventory().addItem(kit1t);
						
		}	
		/*if(cmd.getName().equalsIgnoreCase("setspwan")) { // TODO: give option of new arg to set cords & 
			p.setBedSpawnLocation(p.getLocation());
			p.sendMessage(ChatColor.GREEN +"Your bed Spwan has been updated to currnet location");
			
		}*/ //failed to respwan (bed obstructed) 
		return true;		
		}				
	
	
	public String hesh() {
		String Players;
		Players = Bukkit.getServer().getOnlinePlayers().toString();
		
		
		return Players;
	}
	
} 
