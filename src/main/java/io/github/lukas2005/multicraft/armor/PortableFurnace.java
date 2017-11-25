package io.github.lukas2005.multicraft.armor;

import io.github.lukas2005.multicraft.Reference;
import io.github.lukas2005.multicraft.armor.models.PortableFurnaceModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class PortableFurnace extends ArmorBase {

    private static PortableFurnaceModel model = new PortableFurnaceModel(1.0f);

    public PortableFurnace() {
        super(new ResourceLocation(Reference.MOD_ID,"portable_furnace"),
                6, new int[]{0,1,0,0},
                0,
                0,
                SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                false, true);

        replaceArmorPiece(EntityEquipmentSlot.CHEST, new PortableFurnacePiece());
    }

    private class PortableFurnacePiece extends Chestplate {
        @Override
        @Nullable
        public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel) {
            if (itemStack != null) {
                if (itemStack.getItem() instanceof PortableFurnacePiece) {

                    ModelBiped armorModel = model;

                    armorModel.bipedBody.showModel = true;

                    armorModel.isSneak = defaultModel.isSneak;
                    armorModel.isRiding = defaultModel.isRiding;
                    armorModel.isChild = defaultModel.isChild;
                    armorModel.rightArmPose = defaultModel.rightArmPose;
                    armorModel.leftArmPose = defaultModel.leftArmPose;

                    return armorModel;
                }
            }
            return null;
        }
    }

}