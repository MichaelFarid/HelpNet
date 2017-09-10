package com.micha.example.core.registration;

import android.app.Activity;

import com.google.firebase.auth.FirebaseUser;



public class RegisterPresenter implements RegisterContract.Presenter, RegisterContract.OnRegistrationListener {
    private RegisterContract.View mRegisterView;
    private RegisterInteractor mRegisterInteractor;

    public RegisterPresenter(RegisterContract.View registerView) {
        this.mRegisterView = registerView;
        mRegisterInteractor = new RegisterInteractor(this);
    }

    @Override
    public void register(Activity activity, String email, String password) {
        mRegisterInteractor.performFirebaseRegistration(activity, email, password);
    }

    public void register(Activity activity, String email, String password, String Name ,String age, String height, String weight,String gender, boolean c, boolean a,boolean e) {
        mRegisterInteractor.performFirebaseRegistration(activity, email, password, Name, age, height, weight,gender, c,a,e);
    }

    @Override
    public void onSuccess(FirebaseUser firebaseUser) {
        mRegisterView.onRegistrationSuccess(firebaseUser);
    }

    @Override
    public void onFailure(String message) {
        mRegisterView.onRegistrationFailure(message);
    }
}
