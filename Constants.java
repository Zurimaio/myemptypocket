package com.floridia.maurizio.myemptypocket;

import com.google.firebase.auth.FirebaseAuth;

public class Constants {

    static public String getProfilePath(String UID){
        return "users/" + UID + "/profile";
    }



}
