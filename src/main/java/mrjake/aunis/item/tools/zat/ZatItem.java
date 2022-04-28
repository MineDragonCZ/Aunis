package mrjake.aunis.item.tools.zat;

import mrjake.aunis.AunisDamageSources;
import mrjake.aunis.entity.AunisEnergyProjectile;
import mrjake.aunis.entity.EntityRegister;
import mrjake.aunis.item.tools.EnergyWeapon;
import mrjake.aunis.sound.SoundEventEnum;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ZatItem extends EnergyWeapon {

    public static final String ITEM_NAME = "zat";

    public ZatItem() {
        super(ITEM_NAME, 500_000, 10_000);
    }

    @Override
    public TileEntityItemStackRenderer createTEISR() {
        return new ZatTEISR();
    }

    @Override
    public void playShootSound(World world, EntityPlayer player){
        EntityRegister.playSoundEvent(SoundEventEnum.ZAT_SHOOT, player);
    }

    @Override
    public DamageSource getDamageSource(){
        return AunisDamageSources.DAMAGE_ZAT;
    }

    @Override
    public void setEnergyBallParams(AunisEnergyProjectile projectile) {
        super.setEnergyBallParams(projectile);
        projectile.maxAliveTime = 25;
        projectile.paralyze = true;
        projectile.damage = 1.0F;
        projectile.igniteGround = false;
    }
}