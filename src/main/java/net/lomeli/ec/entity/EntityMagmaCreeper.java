package net.lomeli.ec.entity;

import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import net.lomeli.ec.lib.ECVars;

public class EntityMagmaCreeper extends EntityBaseCreeper {

    public EntityMagmaCreeper(World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!worldObj.isRemote) {
            if ((int) Math.round(posX + 0.5F) != (int) Math.round(prevPosX + 0.5F) || (int) Math.round(posY) != (int) Math.round(prevPosY) || (int) Math.round(posZ + 0.5F) != (int) Math.round(prevPosZ + 0.5F)) {
                if (worldObj.isAirBlock((int) Math.round(prevPosX), (int) Math.round(prevPosY), (int) Math.round(prevPosZ))
                        && Blocks.fire.canPlaceBlockAt(worldObj, (int) Math.round(prevPosX), (int) Math.round(prevPosY), (int) Math.round(prevPosZ)))
                    worldObj.setBlock((int)(prevPosX), (int) (Math.round(prevPosY) + 0.5), (int) (prevPosZ), Blocks.fire);
            }
        }
        if (this.isWet())
            this.attackEntityFrom(DamageSource.drown, 1f);
    }

    @Override
    public void explosion(int power, boolean flag) {
        int radius = getPowered() ? (ECVars.magmaCreeperRadius * power) : ECVars.magmaCreeperRadius;
        if (ECVars.domeExplosion)
            this.domeExplosion(radius, Blocks.lava);
        else
            this.wildExplosion(radius, Blocks.lava);
    }

}
