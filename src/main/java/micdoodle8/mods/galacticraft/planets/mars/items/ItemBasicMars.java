package micdoodle8.mods.galacticraft.planets.mars.items;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.items.ISortableItem;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryItem;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemBasicMars extends Item implements ISortableItem
{
    public static String[] names = { "raw_desh", "desh_stick", "ingot_desh", "reinforced_plate_t2", "slimeling_cargo", "compressed_desh", "fluid_manip" };

    public ItemBasicMars(String name)
    {
        super();
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setUnlocalizedName(name);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public CreativeTabs getCreativeTab()
    {
        return GalacticraftCore.galacticraftItemsTab;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return ClientProxyCore.galacticraftItem;
    }

    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < ItemBasicMars.names.length; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        if (names.length > par1ItemStack.getItemDamage())
        {
            return "item." + ItemBasicMars.names[par1ItemStack.getItemDamage()];
        }

        return "unnamed";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> tooltip, boolean par4)
    {
        if (par1ItemStack != null && par1ItemStack.getItemDamage() == 3)
        {
            tooltip.add(GCCoreUtil.translate("item.tier2.desc"));
        }
    }

    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }

    @Override
    public EnumSortCategoryItem getCategory(int meta)
    {
        switch (meta)
        {
        case 2:
            return EnumSortCategoryItem.INGOT;
        case 3:
        case 5:
            return EnumSortCategoryItem.PLATE;
        }
        return EnumSortCategoryItem.GENERAL;
    }

    @Override
    public float getSmeltingExperience(ItemStack item)
    {
        switch (item.getItemDamage())
        {
        case 3:
            return 1.5F;
        case 5:
            return 1F;
        }
        return -1F;
    }
}
