package RPCraft.rPCraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateKingdom implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player player) {
            if(args.length == 0) {
                player.sendMessage("You're supposed to put a name!");
                return false;
            }
            //the capital's name will be the kingdom's name
            City capital = new City(args[0], player.getLocation());
            //create a new kingdom
            Kingdom kingdom = new Kingdom(args[0], capital, player);
            player.sendMessage("The capital's name has been set to " + args[0] + ". To change that, use /setCapitalName");
            Data data = new Data(args[0], player.getUniqueId(), new City(args[0], player.getLocation()));
            data.saveData("plugins/RPCraft/data/kingdomData.json");
        }
        return true;
    }

    public boolean loadToFile(String kingdomName, String userName) {
        String filePath = "resources/KingdomData";

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            JSONArray namesArray = new JSONArray();
            namesArray.put(userName);
            if(jsonObject.has(kingdomName)) {
                JSONArray existingArray = jsonObject.getJSONArray(kingdomName);
                existingArray.put(userName);
            } else {
                jsonObject.put(kingdomName, namesArray);
            }

            Files.write(Paths.get(filePath), jsonObject.toString(4).getBytes());
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
