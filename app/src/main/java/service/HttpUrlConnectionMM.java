package service;

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

public class HttpUrlConnectionMM{
    private static String myCookie;

    public static String main(String[] args) throws Exception {
        
      //  System.out.println("Testing 1 - Send Http GET request");
       // http.sendGet();
        String urlParameters =
                "username=" + URLEncoder.encode("jfernandez", "UTF-8") +                
                "&password=" + URLEncoder.encode("Password.01", "UTF-8");
        CookieManager co= new CookieManager(null, CookiePolicy.ACCEPT_ALL);      
        CookieHandler.setDefault(co);
        System.out.println("ex1  "+excutePost("http://192.168.254.144:1881/login.html",urlParameters,co));
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("ex2  "+excuteGet("http://192.168.254.144:1881/support/ticket/companies"));
        //String lg =HttpUrlConnectionMM.excutePost("http://192.168.254.144:1881/login.html",urlParameters,co);
        //String companies = HttpUrlConnectionMM.excuteGet("http://192.168.254.144:1881/support/ticket/companies");
        return "fin";
    }

    public static String excutePost(String targetURL, String urlParameters,CookieManager cookieManager)
    {
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
        
        return response.toString();

      } catch (Exception e) {          
        e.printStackTrace();
        return null;
      } finally {

        if(connection != null) {
          connection.disconnect();
        }
      }
    }
    
    
    public static String excuteGet(String targetURL)
    {
      URL url;
      HttpURLConnection connection = null;  
      try {
        //Create connection        
        url = new URL(targetURL);
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");     
        connection.setRequestProperty("Accept", "*/*"); 
        connection.setRequestProperty("Cookie", myCookie);  
        connection.setUseCaches (false);
        connection.setDoInput(true);
       // connection.setDoOutput(true);
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
        return response.toString();

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
