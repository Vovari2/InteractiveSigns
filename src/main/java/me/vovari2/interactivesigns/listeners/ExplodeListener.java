package me.vovari2.interactivesigns.listeners;

import com.destroystokyo.paper.MaterialSetTag;
import me.vovari2.interactivesigns.utils.ItemDisplayUtils;
import me.vovari2.interactivesigns.utils.VersionUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.WindCharge;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.*;

public class ExplodeListener  implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onExplodeBlocksByBlock(BlockExplodeEvent event){
        if (event.isCancelled())
            return;

        if (event.getExplodedBlockState().getType().equals(Material.AIR))
            return;

        for (Block block : event.blockList()) {
            if (!MaterialSetTag.ALL_SIGNS.isTagged(block.getType()))
                continue;

            Location location = VersionUtils.getBlockCenter(block.getLocation());

            ItemDisplayUtils.convertFromOldDisplay(ItemDisplayUtils.getItemDisplayOnSignOld(location));
            ItemDisplayUtils.convertFromOldDisplay(ItemDisplayUtils.getItemDisplayOnSignOld(location));

            ItemDisplayUtils.dropItemFromDisplay(location, Side.FRONT);
            ItemDisplayUtils.dropItemFromDisplay(location, Side.BACK);
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onExplodeBlocksByEntity(EntityExplodeEvent event){
        if (event.getEntity() instanceof WindCharge)
            return;

        for (Block block : event.blockList()) {
            if (!MaterialSetTag.ALL_SIGNS.isTagged(block.getType()))
                continue;

            Location location = VersionUtils.getBlockCenter(block.getLocation());

            ItemDisplayUtils.convertFromOldDisplay(ItemDisplayUtils.getItemDisplayOnSignOld(location));
            ItemDisplayUtils.convertFromOldDisplay(ItemDisplayUtils.getItemDisplayOnSignOld(location));

            ItemDisplayUtils.dropItemFromDisplay(location, Side.FRONT);
            ItemDisplayUtils.dropItemFromDisplay(location, Side.BACK);
        }
    }
}

