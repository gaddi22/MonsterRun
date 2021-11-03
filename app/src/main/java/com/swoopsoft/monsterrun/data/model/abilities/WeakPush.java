package com.swoopsoft.monsterrun.data.model.abilities;

public class WeakPush extends Ability {
    public final String description = "Pushes the monster back 200 steps";
    public final String name = "Weak Push";

    @Override
    public void ability(){
        Monster.distance += 200;
    }
}
