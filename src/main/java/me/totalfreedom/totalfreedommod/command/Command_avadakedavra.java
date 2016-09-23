package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Avada Kedavra someone! Instant Death!", usage = "/<command> <player>", aliases = "destroy")
public class Command_avadakedavra extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player player = getPlayer(args[0]);
        if (args.length == 0) {
            sender.sendMessage(ChatColor.BLUE + "You must insert a player's name");
            return true;
        }
        if (player == null)
        {
            sender.sendMessage(FreedomCommand.PLAYER_NOT_FOUND);
            return true;
        }
        checkRank(Rank.SENIOR_ADMIN);
        sender.sendMessage(ChatColor.RED + "You are now casting an unforgivable curse on " + player.getName());
        player.setHealth(0);
        player.sendMessage(ChatColor.RED + "Avada Kedavra!");
        
        return true;
    }
    
}
