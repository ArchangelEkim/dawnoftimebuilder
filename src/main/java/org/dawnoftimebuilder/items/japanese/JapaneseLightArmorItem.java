package org.dawnoftimebuilder.items.japanese;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.dawnoftimebuilder.client.renderer.armor.JapaneseLightArmorModel;
import org.dawnoftimebuilder.items.templates.CustomArmorItem;

import static org.dawnoftimebuilder.utils.DoTBMaterials.ArmorMaterial.JAPANESE_LIGHT;

public class JapaneseLightArmorItem extends CustomArmorItem {

	public JapaneseLightArmorItem(EquipmentSlotType slot) {
		super("japanese_light_armor", JAPANESE_LIGHT, slot);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public BipedModel<?> createModel(LivingEntity entityLiving) {
		return new JapaneseLightArmorModel<>(this.slot, true);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public BipedModel<?> createSlimModel(LivingEntity entityLiving) {
		return new JapaneseLightArmorModel<>(this.slot, false);
	}
}