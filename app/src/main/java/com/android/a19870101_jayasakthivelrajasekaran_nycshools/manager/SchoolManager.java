package com.android.a19870101_jayasakthivelrajasekaran_nycshools.manager;

import androidx.annotation.NonNull;

import com.android.a19870101_jayasakthivelrajasekaran_nycshools.model.HighSchoolsJson;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.model.SatScoreJson;

import java.util.List;

public interface SchoolManager {

    /**
     * Callback for HighSchool.
     */
    interface HighSchoolListener {
        void onReceiveHighSchool(List<HighSchoolsJson> response);

        void onError(String message);
    }

    /**
     * Get the HighSchool  Response.
     *
     * @param callback response callback
     */
    void getHighSchool(@NonNull HighSchoolListener callback);

    /**
     * Callback for HighSchool.
     */
    interface SatListener {
        void onReceiveSatScore(List<SatScoreJson> response);

        void onError(String message);
    }

    /**
     * Get the HighSchool  Response.
     *
     * @param callback response callback
     */
    void getSatScore(String id ,@NonNull SatListener callback);
}
