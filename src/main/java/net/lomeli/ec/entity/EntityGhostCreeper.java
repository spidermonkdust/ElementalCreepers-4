package net.lomeli.ec.entity;

import net.minecraft.world.World;

import net.lomeli.ec.lib.ECVars;

public class EntityGhostCreeper extends EntityBaseCreeper {

    public EntityGhostCreeper(World par1World) {
        super(par1World);
    }

    @Override
    public void explosion(int power, boolean flag) {
        int exPower = ECVars.ghostCreeperRadius * power;
        this.worldObj.createExplosion(this, posX, posY, posZ, exPower, false);
    }

}
