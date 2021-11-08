package com.swoopsoft.monsterrun.data.model.abilities;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.swoopsoft.monsterrun.model.Player;

public class WeakPush extends Ability {
    public final String description = "Pushes the monster back 200 steps";
    public final String name = "Weak Push";
    public Player player;

    @Override
    public void ability(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        player = parsePlayer(user.getUid());
        player.monster.distance += 200;
    }

    private Player parsePlayer(String uid) {
        //TODO: add or get a player parser
        return null;
    }
}
