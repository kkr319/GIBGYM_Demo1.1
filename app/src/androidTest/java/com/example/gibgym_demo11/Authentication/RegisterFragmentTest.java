package com.example.gibgym_demo11.Authentication;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.results.SignUpResult;
import com.example.gibgym_demo11.R;
import com.google.common.base.Strings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.*;

public class RegisterFragmentTest {
    private RegisterFragment registerFragment = new RegisterFragment();
    String str = "user_agreement.txt";
    
    public RegisterFragmentTest() throws IOException {
    }


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreateView() {
    }


    @Test
    public void initAssets() {
    }

    @Test
    public void getStringTest() throws IOException {
    }

    @Test
    public void onActivityCreated() {

    }

    @Test
    public void onCreate() {
    }

    @Test
    public void signup() {
    }

    @Test
    public void isValidPassword() {
        boolean ivres = registerFragment.isValidPassword("12,34,5");
        assertFalse(ivres);
    }

    @Test
    public void ifRegisEmp() {

    }
}