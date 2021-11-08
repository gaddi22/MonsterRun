package com.swoopsoft.monsterrun.data.model.abilities;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.swoopsoft.monsterrun.model.Monster;
import com.swoopsoft.monsterrun.model.Player;

public class AveragePush extends Ability {

    public final String description = "Pushes a monster 400 steps back";
    public final String name = "Average Push";
    public Player player;

    @Override
    public void ability(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        player = parsePlayer(user.getUid());
        player.monster.distance += 400;
    }

    private Player parsePlayer(String uid) {
        //TODO: add or get a player parser
        return null;
    }
}
