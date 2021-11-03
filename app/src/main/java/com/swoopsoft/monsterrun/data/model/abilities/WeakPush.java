package com.swoopsoft.monsterrun.data.model.abilities;

public class WeakPush extends Ability {
    public String description;

    @Override
    public void ability(){
        Monster.distance += 200;
    }
}
