package RPCraft.rPCraft;

import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class Kingdom {
    String name;
    City capital;
    ArrayList<City> colonies;
    ArrayList<Player> members = new ArrayList<>();

    public Kingdom(String name, City capital, Player king) {
        this.name = name;
        this.capital = capital;
        this.members.add(king);
    }

    public String getName() {
        return name;
    }
}
