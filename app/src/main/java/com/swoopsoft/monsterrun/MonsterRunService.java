package com.swoopsoft.monsterrun;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MonsterRunService extends Service {
    public MonsterRunService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}