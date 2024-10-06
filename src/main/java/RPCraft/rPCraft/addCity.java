package RPCraft.rPCraft;

import it.unimi.dsi.fastutil.Hash;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class addCity implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player player) {
            Data gameData = Data.loadData("plugins/RPCraft/data/kingdomData.json");
            int playerKingdomIndex = gameData.playerID.indexOf(player.getUniqueId());
            if (gameData.kingdom.keySet().toArray()[playerKingdomIndex] != null) {
                City newCity = new City(args[0], player.getLocation());
                ArrayList<HashMap<String, Location>> citySer = gameData.kingdom.get(gameData.kingdom.keySet().toArray()[gameData.playerID.indexOf(player.getUniqueId())]);
                citySer.add(newCity.serialize());
                Data dataToSave = new Data(gameData.kingdom.keySet().toArray()[playerKingdomIndex].toString(), player.getUniqueId(), citySer);
                dataToSave.saveData("plugins/RPCraft/data/kingdomData.json");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
