package utils;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Class - helps to convert from json to object
 *
 * @author Eduard Zaretski
 */

public class JsonReader {

    private static Logger logger = LoggerFactory.getLogger(JsonReader.class);

    /**
     * @param  path - path to Json file
     * @param  className - name of class
     */
    public static <T> Object getDataFromJson(String path, Class className) {
        Gson gson = new Gson();
        T object = null;
        try {
            object = gson.fromJson(new FileReader(path), (Class<T>) className);
        } catch (FileNotFoundException e) {
            logger.error("File not found!", e);
        }
        return object;
    }

}
