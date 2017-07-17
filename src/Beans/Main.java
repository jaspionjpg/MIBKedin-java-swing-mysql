package Beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	public static void main(String[] args) throws IOException {
		String endereco1 = "metro bresser";
		String endereco2 = "faculdade sao judas tadeu";
		endereco1 = endereco1.replace(" ", "+");
		endereco2 = endereco2.replace(" ", "+");
		try {  
			HttpURLConnection conexao;
			String urlFormatada = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+endereco1+"&destinations="+endereco2+"&mode=bicycling&key=AIzaSyCEyexJnYjXUyxSswQH2y4SIwDTITjUcMw";
			URL url = new URL(urlFormatada);  
			
			conexao = (HttpURLConnection) url.openConnection();
			conexao.setConnectTimeout(1);
			conexao.setRequestMethod("GET");
			conexao.setUseCaches (false);
			conexao.setDoInput(true);
			conexao.setDoOutput(true);
			

            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream(), "UTF-8"));  
            String str;              

            while ((str = in.readLine()) != null) {  
               System.out.println(str);
            } 
            
            in.close();
            
        } catch (MalformedURLException e) {  
            e.printStackTrace();
        } catch (IOException e) {  
            e.printStackTrace();
        }
	}
}
