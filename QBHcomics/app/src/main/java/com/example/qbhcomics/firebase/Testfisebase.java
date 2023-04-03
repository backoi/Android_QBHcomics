package com.example.qbhcomics.firebase;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class Testfisebase {
    private FirebaseFirestore mFireStore = FirebaseFirestore.getInstance();
    public Testfisebase(){
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        mFireStore.setFirestoreSettings(settings);
    };
}
