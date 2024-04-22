package com.projet.poketra.utility;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Utility {

    public Utility()
    {
        
    }
    
    public String encodedMessage(String message) throws UnsupportedEncodingException
    {
        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8.toString());

        return encodedMessage;
    }
}
