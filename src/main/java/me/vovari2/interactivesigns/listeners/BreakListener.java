package me.vovari2.interactivesigns.listeners;

import com.destroystokyo.paper.MaterialSetTag;
import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import me.vovari2.interactivesigns.utils.ItemDisplayUtils;
import me.vovari2.interactivesigns.utils.VersionUtils;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.sign.Side;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakListener implements Listener {
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onBreakBlockByWorld(BlockDestroyEvent event){
        Block block = event.getBlock();
        if (!MaterialSetTag.ALL_SIGNS.isTagged(block.getType()))
            return;

        Location location = VersionUtils.getBlockCenter(block.getLocation());

        ItemDisplayUtils.convertFromOldDisplay(ItemDisplayUtils.getItemDisplayOnSignOld(location));
        ItemDisplayUtils.convertFromOldDisplay(ItemDisplayUtils.getItemDisplayOnSignOld(location));

        ItemDisplayUtils.dropItemFromDisplay(location, Side.FRONT);
        ItemDisplayUtils.dropItemFromDisplay(location, Side.BACK);
    }
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBreakBlockByPlayer(BlockBreakEvent event){
        Block block = event.getBlock();
        if (!MaterialSetTag.ALL_SIGNS.isTagged(block.getType()))
            return;

        Location location = VersionUtils.getBlockCenter(block.getLocation());

        ItemDisplayUtils.convertFromOldDisplay(ItemDisplayUtils.getItemDisplayOnSignOld(location));
        ItemDisplayUtils.convertFromOldDisplay(ItemDisplayUtils.getItemDisplayOnSignOld(location));

        ItemDisplayUtils.dropItemFromDisplay(location, Side.FRONT);
        ItemDisplayUtils.dropItemFromDisplay(location, Side.BACK);
    }
}
