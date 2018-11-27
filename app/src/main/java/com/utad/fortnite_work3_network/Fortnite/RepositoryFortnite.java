package com.utad.fortnite_work3_network.Fortnite;

import io.reactivex.Observable;

public class RepositoryFortnite {

    private static volatile RepositoryFortnite ourInstance = new RepositoryFortnite();

    static RepositoryFortnite getInstance() {
        if (ourInstance == null) {
            synchronized (RepositoryFortnite.class) {
                if (ourInstance == null) {
                    ourInstance = new RepositoryFortnite();
                }
            }
        }
        return ourInstance;
    }

    private RepositoryFortnite() {
    }

    private ForniteAPI forniteApi = ForniteAPI.Factory();


    public Observable<UserFortnite> getFortniteInfo(String platformGame, String epic_nickname){
        //return gerritAPI.loadChanges(status);
        return forniteApi.getFortniteInfo(platformGame,epic_nickname);
    }

}