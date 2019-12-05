package com.example.laytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

import factory.LoginServiceFactory;
import service.LoginService;


public class LoginActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Button btnLogin;
    private EditText userText;
    private EditText passText;
    private ProgressBar loginProgressBar;
    private LoginService loginService = LoginServiceFactory.getLoginService();
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appContext = getApplicationContext();
        setContentView(R.layout.login);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        userText = (EditText) findViewById(R.id.userText);
        userText.setText("jfernandez");
        passText = (EditText) findViewById(R.id.passText);
        passText.setText("Password.01");
        loginProgressBar = (ProgressBar) findViewById(R.id.loginProgressBar);
        loginProgressBar.setVisibility(View.GONE);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        btnLogin.setOnClickListener(loginOnClickListener);
        mTextMessage = findViewById(R.id.message);
    }

    private View.OnClickListener loginOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tryDoLogin();
        }
    };

    private void tryDoLogin(){
        loginProgressBar.setVisibility(View.VISIBLE);
        Runnable runnableLogin = new Runnable() {
            @Override
            public void run() {
                boolean loginSucceededFull = login();
                if (loginSucceededFull) startTicketCreationActivity();
                loginProgressBar.setVisibility(View.GONE);
            }
        };
        executorService.submit(runnableLogin);
    }

    private boolean login() {
        return loginService.login(userText.getText().toString(), passText.getText().toString());

    }

    private void startTicketCreationActivity() {
        Intent ticketCreation = new Intent(getApplicationContext(), TicketCreationActivity.class);
        startActivity(ticketCreation);
    }


    private void sendPost() throws Exception {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    String url = "https://slack.com/api/chat.postMessage";
                    URL obj = new URL(url);
                    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

                    //add reuqest header
                    con.setRequestMethod("POST");
                    //con.setRequestProperty("User-Agent", USER_AGENT);
                    //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                    con.setRequestProperty("Authorization", "Bearer xoxp-445726298631-481370596708-717194665540-c8b1febcc2ab18b1daa1fc58e238d244");
                    con.setRequestProperty("Content-Type", "application/json; utf-8");
                    String jsonInputString = "{\"channel\": \"UE5AWHJLU\",\"text\": \"Android Support text terst\"}";

                    String urlParameters = "";

                    // Send post request
                    con.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                    wr.writeBytes(jsonInputString);
//        byte[] input = jsonInputString.getBytes("utf-8");
//        wr.write(input, 0, input.length);

                    wr.flush();
                    wr.close();

                    int responseCode = con.getResponseCode();
                    System.out.println("\nSending 'POST' request to URL : " + url);
                    System.out.println("Post parameters : " + urlParameters);
                    System.out.println("Response Code : " + responseCode);

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    //print result
                    System.out.println(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();


    }


    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder feedback = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                feedback.append("&");

            feedback.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            feedback.append("=");
            feedback.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return feedback.toString();
    }


}
