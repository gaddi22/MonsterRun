package com.swoopsoft.monsterrun.exceptions;

import androidx.annotation.Nullable;

public class MonsterAlarmException extends Exception{

    @Nullable
    @Override
    public String getMessage() {
        return "No Monster Received For Alarm";
    }
}
