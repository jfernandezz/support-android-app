package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import Entity.Session;


public class Login {
    public static String loginUrl="http://192.168.254.144:1881/login.html";



    public static Boolean login(String user , String password){
        try {
            Session.user = user;
            Session.password =password;
        } catch (Exception e) {}
        return login();
    }

    public static Boolean login(){
        boolean ret=true;
        try {
            String urlParameters =
                "username=" + URLEncoder.encode(Session.user, "UTF-8") +
                "&password=" + URLEncoder.encode(Session.password, "UTF-8");
            CookieManager coo= new CookieManager(null, CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(coo);
            switch (Session.sessionId = excuteLoginPost(loginUrl, urlParameters, coo)) {
                case "UCI":ret= false;
            }

        } catch (Exception e) {}
        return ret;
    }


    public static String excuteLoginPost(String targetURL, String urlParameters,CookieManager cookieManager)
    {   String myCookie="";
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Accept", "*/*");
            //  connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
            wr.writeBytes (urlParameters);
            wr.flush ();
            wr.close ();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            //Print  cookies
            List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();
            for (HttpCookie cookie : cookies) {
                System.out.println("cookie.getDomain() "+cookie.getDomain());
                System.out.println("cookie "+cookie);
                myCookie="JSESSIONID="+cookie.getValue();
                System.out.println("myCookie "+ myCookie);
            }
            Gson gson =new GsonBuilder().setPrettyPrinting().create();
            String obj ="{\"_id\":\"farti\",\"preferedStore\":\"1\",\"preferedChain\":\"1\",\"name\":\"farti\",\"googleLoginActive\":false,\"blocked\":false,\"password\":\"7fd079495dd901b5ed41a02219c04da9bd00b1c370db3356f2dea849c4567206\",\"hasToChangePassword\":false,\"passwordHashes\":[{\"hash\":\"7fd079495dd901b5ed41a02219c04da9bd00b1c370db3356f2dea849c4567206\"},{\"hash\":\"679a4cba1e969d622c26900e24b3f99b4dde7fef97403090d681134b166acca8\"},{\"hash\":\"b1035be19a038ad1245360a884b5a0e26544001677bc0b36cc4ef2e31de1bf2e\"}],\"rolesIds\":[\"manager\"],\"phone\":{\"phone\":\"24876352\"},\"companies\":[\"FARM_TING\",\"PHARMACY\",\"DEFAULT_ROLE\",\"DEFAULT_ARTICLE\",\"DEFAULT_TAX\",\"DEFAULT_PAYMENT\",\"DEFAULT_CURRENCY\",\"DEFAULT_REPORT\"],\"pin\":\"1234\",\"_class\":\"uy.com.geocom.geopos3.foodservice.labor.Employee\"}";
           // uy.com.geocom.geopos3.support.entity.ChainGerarchyinGerarchy em = gson.fromJson(obj, ChainGerarchy.class);
           // chainGerarchyh = new uy.com.geocom.geopos3.support.entity.ChainGerarchy();

            /* print staff */

           




            if(response.toString().contains("<title>GEOPOS 3 Support</title>")){myCookie="UCI";}
            return myCookie;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }





}
