package net.guard.passer.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.guard.passer.entity.App;

import java.io.File;
import java.io.IOException;

public class JacksonDataBind {
    public static App parseJson(String path){
        ObjectMapper objectMapper = new ObjectMapper();


        App app = null;
        try {
            app = objectMapper.readValue(new File(path), App.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(app);
        return app;
    }
}
