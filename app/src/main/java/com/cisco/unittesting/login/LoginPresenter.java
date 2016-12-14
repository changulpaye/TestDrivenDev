package com.cisco.unittesting.login;

import com.cisco.unittesting.R;

/**
 * Created by pchangul on 12/12/2016.
 */

class LoginPresenter  {

    private final LoginContract.View mView;
    private final LoginAPI mLoginAPI;

    LoginPresenter(LoginContract.View view, LoginAPI loginAPI) {

        mView = view;
        mLoginAPI = loginAPI;
    }

    void onLoginButtonClick() {

        String username =  mView.getUsername();
        if(username.isEmpty()) {
            mView.showEmptyUsernameErrorMessage(R.string.empty_username_error);
            return;
        }

        String password = mView.getPassword();
        if(password.isEmpty()) {
            mView.showEmptyPasswordErrorMessage(R.string.empty_password_error);
            return;
        }

        if(mLoginAPI.authenticate(username, password)) {
            mView.startMainActivity();
            return;
        }

        mView.showUnsuccessfulAuthenticationMessage();
    }
}
