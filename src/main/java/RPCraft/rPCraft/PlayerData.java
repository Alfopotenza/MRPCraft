package RPCraft.rPCraft;

import org.bukkit.entity.Player;

public class PlayerData {
    Player player;
    String role;
    Kingdom kingdom;

    public PlayerData(Player player, String role, Kingdom kingdom) {
        this.player = player;
        this.role = role;
        this.kingdom = kingdom;
    }

    public Player getPlayer() {
        return player;
    }
}
