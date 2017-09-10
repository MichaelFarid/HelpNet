package com.micha.example.core.users.add;

import android.content.Context;

import com.google.firebase.auth.FirebaseUser;



public class AddUserPresenter implements AddUserContract.Presenter, AddUserContract.OnUserDatabaseListener {
    private AddUserContract.View mView;
    private AddUserInteractor mAddUserInteractor;

    public AddUserPresenter(AddUserContract.View view) {
        this.mView = view;
        mAddUserInteractor = new AddUserInteractor(this);
    }

    @Override
    public void addUser(Context context, FirebaseUser firebaseUser) {
        mAddUserInteractor.addUserToDatabase(context, firebaseUser);
    }

    public void addUser(Context context, FirebaseUser firebaseUser, String Name,String age, String height, String weight,String gender, boolean c, boolean a,boolean e) {
        mAddUserInteractor.addUserToDatabase(context, firebaseUser, Name,age, height, weight,gender, c,a,e);
    }

    @Override
    public void onSuccess(String message) {
        mView.onAddUserSuccess(message);
    }

    @Override
    public void onFailure(String message) {
        mView.onAddUserFailure(message);
    }
}
