package com.ulxsth.hanamiroyale.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomGiveExecuter implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            sender.sendMessage("コンソールから実行しないで！！！");
            return true;
        }

        if(args.length == 0) {
            return false;
        }

        String itemId = args[0];
        int amount = args.length >= 2 ? Integer.parseInt(args[1]) : 1;
        ItemStack itemStack;

        if(itemId.equals("tsuru")) {
            itemStack = new ItemStack(Material.IRON_INGOT, amount);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.displayName(Component.text("Tsuru"));
            itemMeta.addEnchant(org.bukkit.enchantments.Enchantment.DAMAGE_ALL, 1, true);
            itemStack.setItemMeta(itemMeta);
        } else {
            sender.sendMessage("存在しないidです");
            return true;
        }

        player.getInventory().addItem(itemStack);
        return true;
    }
}
