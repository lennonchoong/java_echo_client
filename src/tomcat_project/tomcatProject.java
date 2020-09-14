package tomcat_project;

import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class tomcatProject {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Send Http POST request");
	    sendPost(args[0], args[1]);

    }
	
    private static void sendPost(String urlstring, String inputParams) throws Exception {

        String url = urlstring;

        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();

        //add request header
        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = inputParams;//"sn=bigdick69&cn=&locale=&caller=&num=12345";

        // Send post request
        httpClient.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
        }

        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {

            String line;
            String response = new String();

            while ((line = in.readLine()) != null) {
                response += line;
            }

            //print result
            System.out.println("Response : " + response);

        }

    }

}
