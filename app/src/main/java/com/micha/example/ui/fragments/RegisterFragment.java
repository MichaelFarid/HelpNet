package com.micha.example.ui.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.micha.example.R;
import com.micha.example.core.registration.RegisterContract;
import com.micha.example.core.registration.RegisterPresenter;
import com.micha.example.core.users.add.AddUserContract;
import com.micha.example.core.users.add.AddUserPresenter;
import com.micha.example.ui.activities.UserListingActivity;
import com.google.firebase.auth.FirebaseUser;



public class RegisterFragment extends Fragment implements View.OnClickListener, RegisterContract.View, AddUserContract.View {
    private static final String TAG = RegisterFragment.class.getSimpleName();

    private RegisterPresenter mRegisterPresenter;
    private AddUserPresenter mAddUserPresenter;

    private EditText mETxtEmail, mETxtPassword, mETtest, mETage,mETGender,mETheight,mETWeight;
    private CheckBox mC, mA, mE;
    private Button mBtnRegister;

    private ProgressDialog mProgressDialog;

    public static RegisterFragment newInstance() {
        Bundle args = new Bundle();
        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_register, container, false);
        bindViews(fragmentView);
        return fragmentView;
    }

    private void bindViews(View view) {
        mETxtEmail = (EditText) view.findViewById(R.id.edit_text_email_id);
        mETxtPassword = (EditText) view.findViewById(R.id.edit_text_password);
        mETtest = (EditText) view.findViewById(R.id.editText);
        mETage = (EditText) view.findViewById(R.id.Age);
        mETGender = (EditText) view.findViewById(R.id.Gender);
        mETheight= (EditText)view.findViewById(R.id.Height);
        mETWeight= (EditText)view.findViewById(R.id.Weight);
        mC= (CheckBox)view.findViewById(R.id.CPR);
        mA= (CheckBox)view.findViewById(R.id.AED);
        mE= (CheckBox)view.findViewById(R.id.EMT);



        mBtnRegister = (Button) view.findViewById(R.id.button_register);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        mRegisterPresenter = new RegisterPresenter(this);
        mAddUserPresenter = new AddUserPresenter(this);

        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setTitle(getString(R.string.loading));
        mProgressDialog.setMessage(getString(R.string.please_wait));
        mProgressDialog.setIndeterminate(true);

        mBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        switch (viewId) {
            case R.id.button_register:
                onRegister(view);
                break;
        }
    }

    private void onRegister(View view) {
        String emailId = mETxtEmail.getText().toString();
        String password = mETxtPassword.getText().toString();
        String Name= mETtest.getText().toString();
        String age=mETage.getText().toString();
        String height= mETheight.getText().toString();
        String weight= mETWeight.getText().toString();
        String gender= mETGender.getText().toString();
        boolean c= mC.isChecked();
        boolean a= mA.isChecked();
        boolean e=mE.isChecked();


        mRegisterPresenter.register(getActivity(), emailId, password, Name, age, height, weight,gender, c,a,e);
        mProgressDialog.show();
    }

    @Override
    public void onRegistrationSuccess(FirebaseUser firebaseUser) {
        String Name= mETtest.getText().toString();
        String age=mETage.getText().toString();
        String height= mETheight.getText().toString();
        String weight= mETWeight.getText().toString();
        String gender= mETGender.getText().toString();
        boolean c= mC.isActivated();
        boolean a= mA.isActivated();
        boolean e=mE.isActivated();
        mProgressDialog.setMessage(getString(R.string.adding_user_to_db));
        Toast.makeText(getActivity(), "Registration Successful!", Toast.LENGTH_SHORT).show();
        mAddUserPresenter.addUser(getActivity().getApplicationContext(), firebaseUser, Name, age, height, weight,gender, c,a,e);
    }

    @Override
    public void onRegistrationFailure(String message) {
        mProgressDialog.dismiss();
        mProgressDialog.setMessage(getString(R.string.please_wait));
        Log.e(TAG, "onRegistrationFailure: " + message);
        Toast.makeText(getActivity(), "Registration failed!+\n" + message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAddUserSuccess(String message) {
        mProgressDialog.dismiss();
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        UserListingActivity.startActivity(getActivity(),
                Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    @Override
    public void onAddUserFailure(String message) {
        mProgressDialog.dismiss();
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
