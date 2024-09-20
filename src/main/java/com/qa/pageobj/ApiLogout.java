package com.qa.pageobj;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiLogout {

    public String logoutUser(String username) {
        String logoutUrl = "http://20.219.107.162:8083/ChemtrixApi/api/Account/Logout?userName=" + username;
        StringBuilder response = new StringBuilder();

        try {
            // Create URL object
            URL url = new URL(logoutUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set up the request
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "*/*");
            con.setDoOutput(true);

            // Send the request
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(""); // No body content for this request
                wr.flush();
            }

            // Read the response
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Check if logout was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Logout successful for user: " + username);
                return response.toString();
            } else {
                System.out.println("Logout failed for user: " + username + ". Response Code: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
