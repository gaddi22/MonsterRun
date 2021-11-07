package com.swoopsoft.monsterrun.data.model.abilities;

import com.swoopsoft.monsterrun.data.model.Monster;

public class AveragePush extends Ability {

    public final String description = "Pushes a monster 400 steps back";
    public final String name = "Average Push";

    @Override
    public void ability(){
        Monster.distance += 400;
    }
}
