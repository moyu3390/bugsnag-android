package com.bugsnag.android.mazerunner.scenarios;

import com.bugsnag.android.Configuration;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CXXThrowSomethingScenario extends Scenario {

    static {
        System.loadLibrary("cxx-scenarios");
    }

    public native void crash(int num);

    public CXXThrowSomethingScenario(@NonNull Configuration config,
                                     @NonNull Context context,
                                     @Nullable String eventMetadata) {
        super(config, context, eventMetadata);
        config.setAutoTrackSessions(false);
    }

    @Override
    public void startScenario() {
        super.startScenario();
        String metadata = getEventMetadata();
        if (metadata != null && metadata.equals("non-crashy")) {
            return;
        }
        crash(23);
    }
}
