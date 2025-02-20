// Decompiled with: FernFlower
// Class Version: 8
package io.github.swagree.refixPC;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.storage.PCStorage;
import com.pixelmonmod.pixelmon.comm.packetHandlers.OpenScreen;
import com.pixelmonmod.pixelmon.comm.packetHandlers.clientStorage.newStorage.pc.ClientChangeOpenPC;
import com.pixelmonmod.pixelmon.comm.packetHandlers.clientStorage.newStorage.pc.ClientInitializePC;
import com.pixelmonmod.pixelmon.enums.EnumGuiScreen;
import net.minecraft.entity.player.EntityPlayerMP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerPC implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player != null) {
            EntityPlayerMP entityPlayerMP = Pixelmon.storageManager.getParty(player.getUniqueId()).getPlayer();
            PCStorage pcStorage = Pixelmon.storageManager.getPCForPlayer(player.getUniqueId());
            Pixelmon.network.sendTo(new ClientInitializePC(pcStorage), entityPlayerMP);
            Pixelmon.network.sendTo(new ClientChangeOpenPC(pcStorage.uuid), entityPlayerMP);
            pcStorage.sendContents(entityPlayerMP);
            OpenScreen.open(entityPlayerMP, EnumGuiScreen.PC, new int[0]);
            player.openInventory(player.getInventory());
            player.closeInventory();
        }

    }
}
 