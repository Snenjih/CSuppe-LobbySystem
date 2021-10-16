package net.chaotischesuppe.utils.builder;

import com.google.common.collect.Lists;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;

public class ItemStackBuilder {

    public static List<ItemStackBuilder> ITEMS = Lists.newArrayList();

    private ItemStack itemStack;
    private Consumer<PlayerInteractEvent> eventConsumer;

    public ItemStackBuilder(Material material){
        this(material, 1);
    }

    public ItemStackBuilder(ItemStack is){
        this.itemStack=is;
    }

    public ItemStackBuilder(Material m, int amount){
        itemStack= new ItemStack(m, amount);
    }

    public ItemStackBuilder(Material m, short id){
        itemStack= new ItemStack(m, 1, id);
    }

    public ItemStackBuilder(Material m, int amount, short id){
        itemStack= new ItemStack(m, amount, id);
    }

    public ItemStackBuilder(Material m, int amount, byte durability){
        itemStack = new ItemStack(m, amount, durability);
    }

    public ItemStackBuilder setIntractable(Consumer<PlayerInteractEvent> event){
        this.eventConsumer = event;
        ITEMS.add(this);
        return this;
    }



    public ItemStackBuilder setDurability(short dur) {
        itemStack.setDurability(dur);
        return this;
    }


    public ItemStackBuilder setAmount(Integer amount) {
        itemStack.setAmount(amount);
        return this;
    }


    public ItemStackBuilder setName(String name) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return this;
    }


    public ItemStackBuilder setUnbreaked() {
        ItemMeta itemMeta = itemStack.getItemMeta();
        //todo
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStackBuilder addUnsafeEnchantment(Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }


    public ItemStackBuilder removeEnchantment(Enchantment enchantment) {
        itemStack.removeEnchantment(enchantment);
        return this;
    }


    public ItemStackBuilder setSkullOwner(String owner) {
        try{
            SkullMeta im = (SkullMeta)itemStack.getItemMeta();
            im.setOwner(owner);
            itemStack.setItemMeta(im);
        }catch(ClassCastException expected){}
        return this;
    }


    public ItemStackBuilder addEnchant(Enchantment enchantment, int level) {
        ItemMeta im = itemStack.getItemMeta();
        im.addEnchant(enchantment, level, true);
        itemStack.setItemMeta(im);
        return this;
    }


    public ItemStackBuilder addEnchantments(Map<Enchantment, Integer> enchantments) {
        itemStack.addEnchantments(enchantments);
        return this;
    }


    public ItemStackBuilder setInfinityDurability() {
        itemStack.setDurability(Short.MAX_VALUE);
        return this;
    }


    public ItemStackBuilder setLore(String... lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return this;
    }


    public ItemStackBuilder setLore(List<String> lore) {
        ItemMeta im = itemStack.getItemMeta();
        im.setLore(lore);
        itemStack.setItemMeta(im);
        return this;
    }


    public ItemStackBuilder removeLoreLine(String line) {
        ItemMeta im = itemStack.getItemMeta();
        List<String> lore = new ArrayList<>(im.getLore());
        if(!lore.contains(line))return this;
        lore.remove(line);
        im.setLore(lore);
        itemStack.setItemMeta(im);
        return this;
    }


    public ItemStackBuilder removeLoreLine(int index) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> lore = new ArrayList<>(itemMeta.getLore());
        if(index<0||index>lore.size())return this;
        lore.remove(index);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return this;
    }


    public ItemStackBuilder addLoreLine(String line) {
        ItemMeta im = itemStack.getItemMeta();
        List<String> lore = new ArrayList<>();
        if(im.hasLore())lore = new ArrayList<>(im.getLore());
        lore.add(line);
        im.setLore(lore);
        itemStack.setItemMeta(im);
        return this;
    }


    public ItemStackBuilder addLoreLine(String line, int pos) {
        ItemMeta im = itemStack.getItemMeta();
        List<String> lore = new ArrayList<String>(im.getLore());
        lore.set(pos, line);
        im.setLore(lore);
        itemStack.setItemMeta(im);
        return this;
    }


    public ItemStackBuilder setFlags() {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemStack.setItemMeta(itemMeta);
        return this;
    }



    public ItemStackBuilder setLeatherArmorColor(Color color) {
        LeatherArmorMeta im = (LeatherArmorMeta) itemStack.getItemMeta();
        im.setColor(color);
        itemStack.setItemMeta(im);
        return this;
    }


    public ItemStack toItemStack() {
        return itemStack;
    }

    public ItemStackBuilder clone(){
        return new ItemStackBuilder(itemStack);
    }

}
