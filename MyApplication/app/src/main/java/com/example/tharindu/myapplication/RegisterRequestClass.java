package com.example.tharindu.myapplication;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by kgks on 8/22/17.
 */

public class RegisterRequestClass extends StringRequest{
    private static String REGISTER_REQUEST_URL = "https://kgks999.000webhostapp.com/SiginUp.php";
    private Map<String, String> parms;

    public RegisterRequestClass(String name, String email, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        parms = new HashMap<>();
        parms.put("name", name);
        parms.put("email", email);
        parms.put("password", password);
    }

    public Map<String, String> getParms() {
        return parms;
    }
}
