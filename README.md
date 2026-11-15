# Interactive Signs
### Paper, Purpur, Folia (1.21 - 26.3)
The plugin allows you to insert your items into the sign by clicking **the right mouse button**. To pick up an item, you need to hit the sign with **the left mouse button**.
Also, items on signs can be waxed with **honeycomb**, once they are waxed they cannot be taken by anyone. Waxing can be removed by using an **axe**.

This plugin also supports sign protection from plugins: **WorldGuard**, **Lands**, **Residence**, **HuskClaims**, **GriefPrevention**, **SuperiorSkyblock2**, **ChestProtect**, **GriefDefender**, **Dominion** and **LWC Extended**.

Hopefully this will improve and diversify **your gaming experience**.

![Example](/images/example_new.png)

## Core Protect
If you are using **CoreProtect (v22.0+)** to view player actions.
You can use the command to view the actions of putting and taking an item from the signs.
> **/co lookup action:sign**

![Example](/images/example_coreprotect.png)

## Commands:
- **/ins help**  "Shows information on commands" (Permission: interactive_signs.help)
- **/ins reload**  "Restarts the plugin (to configure "text.yml")" (Permission: interactive_signs.reload)
- **/ins clear**  "Clears the item in signs within the specified radius" (Permission: interactive_signs.clear)

## File "config.yml":
```
# InteractiveSigns v1.5+
# Author: Vovari2

# True - so that when you insert an item into the signs, it will be three-dimensional (3D)
# False - so that when an item is inserted into the signs, it will be flat (2D)
enable_items_volume: false


# A list of items that will not be allowed to be tabbed (default: empty)
blacklist_of_items:
  - #nothing

# True - so players need the “permission_can_use_signs” permission to insert items into the signs
# False - so all players can insert items into signs
player_need_to_have_permission_to_use_signs: false
# Permission required to insert items into the signs
permission_can_use_signs: "interactive_signs.use"


## Settings for plugins
# WorldEdit (FAWE)
worldedit:
  # True - Enable automatic drop of items from signs when using //set commands in WorldEdit (may affect server performance)
  # False - Items from removed signs remain suspended in the air
  auto_drop_items: true

# HuskClaims
huskclaims:
  flag_id: "items_in_signs"

# Lands
lands:
  flag_id: "items_in_signs"
  flag_name: "Items in signs"
  flag_material: "SPRUCE_HANGING_SIGN"
  flag_description: "Flag that allows you to insert and take items from sings"

# Dominion
dominion:
  flag_id: "items_in_signs"
  flag_name: "Items in signs"
  flag_material: "SPRUCE_HANGING_SIGN"
  flag_description: "Whether can insert and take items from sings"
```

## File "text.yml":
```
# Messages, when using plugin commands
command-help: "<gradient:#54B435:#82CD47><strikethrough>        </strikethrough></gradient> <#E8E7AB>InteractiveSigns</#E8E7AB> <gradient:#82CD47:#54B435><strikethrough>        </strikethrough></gradient>
    <newline>  <#54B435>- <#E8E7AB> <hover:show_text:'<#E8E7AB>Message about the information of the plugin commands'>/is help</hover></#E8E7AB>
    <newline>  <#54B435>- <#E8E7AB> <hover:show_text:'<#E8E7AB>Reloading the plugin'>/is reload</hover></#E8E7AB>
    <newline>  <#54B435>- <#E8E7AB> <hover:show_text:'<#E8E7AB>Clear all entities created by the plugin within a certain radius'>/is clear <radius></hover></#E8E7AB><newline>"
command-reload-confirm: "<gradient:#54B435:#82CD47>The plugin has been restarted!</gradient>"
command-reload: "<gradient:#54B435:#82CD47>Confirm reload with the <yellow>/ins reloadconfirm</yellow> command</gradient>"
command-clear: "<gradient:#54B435:#82CD47>All displays within a <#F2AE66><%radius%></#F2AE66> radius have been removed!"


# Warning, when a player put a prohibited item in the sign (if you make the field empty (“”) , the message will not be sent)
warning-you-cant-put-that-here: "<bold><red>Hey!</bold> <gray>Sorry, but you can'tput that here"

# Warning, when a player uses a plaque in someone else's region (if you make the field empty (“”) , the message will not be sent)
warning-you-cant-use-that-here: "<bold><red>Hey!</bold> <gray>Sorry, but you can'tuse that here"
```