package RPCraft.rPCraft;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

public class setCapitalName implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Data data = new Data(Objects.requireNonNull(Data.loadData("plugins/RPCraft/data/kingdomData.json")));
        Player player = (Player) commandSender;
        Logger log = Logger.getLogger("Minecraft");
        for (UUID id : data.playerID) {
            if(id.equals(player.getUniqueId())) {
                player.sendMessage("user's name is: " + Objects.requireNonNull(Bukkit.getPlayer(id)).getName() +
                        "and his kingdom is: " + data.kingdom.keySet().toArray()[data.playerID.indexOf(id)] +
                        printCities(data, player));
            }
        }
        return true;
    }
    public String printCities(Data data, Player player) {
        for(HashMap<String, Location> city : data.kingdom.get(data.kingdom.keySet().toArray()[data.playerID.indexOf(player.getUniqueId())])) {
            return (" and his cities are: " + Arrays.toString(city.keySet().toArray()) + " whose locations are: " + Arrays.toString(city.values().toArray()));
        }
        return null;
    }
}
