package RPCraft.rPCraft;

import it.unimi.dsi.fastutil.Hash;
import org.bukkit.Location;
import org.bukkit.event.block.BlockCanBuildEvent;

import java.util.HashMap;

public class City {
    String name;
    Location spawn;
    int level;

    public City(String name, Location spawn) {
        this.name = name;
        this.spawn = spawn;
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public Location getSpawn() {
        return spawn;
    }
    public HashMap<String, Location> serialize() {
        HashMap<String, Location> serializedCity = new HashMap<>();
        serializedCity.put(name, spawn);
        return serializedCity;
    }
}
