package RPCraft.rPCraft;

import org.bukkit.Location;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Data implements Serializable {

    public HashMap<String, ArrayList<HashMap<String, Location>>> kingdom = new HashMap<>();
    public ArrayList<UUID> playerID = new ArrayList<>();

    public Data(String kingdom, UUID playerID, ArrayList<City> city) {
        HashMap<String, Location> map = new HashMap<>();
        //map.put(city.name, city.spawn);
        ArrayList<HashMap<String, Location>> cities = new ArrayList<>();
        cities.add(map);
        this.kingdom.put(kingdom, cities);
        this.playerID.add(playerID);
    }
    public Data(Data loadedData) {
        this.kingdom = loadedData.kingdom;
        this.playerID = loadedData.playerID;
    }
    private static transient final long serialVersionUID = -1681012206529286330L;

    public void saveData(String filePath) {
        try {
            BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject(this);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Data loadData(String filePath) {
        try {
            BukkitObjectInputStream in = new BukkitObjectInputStream(new GZIPInputStream(new FileInputStream(filePath)));
            Data data = (Data) in.readObject();
            in.close();
            return data;
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null ;
        }
    }
}
