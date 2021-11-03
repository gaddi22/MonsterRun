package com.swoopsoft.monsterrun.data.model.abilities;

import com.swoopsoft.monsterrun.data.model.Monster;

public class AveragePush extends Ability {

    @Override
    public void ability(){
        Monster.distance += 400;
    }
}
