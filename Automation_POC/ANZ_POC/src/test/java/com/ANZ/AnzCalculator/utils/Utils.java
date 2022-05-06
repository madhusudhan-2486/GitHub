package com.ANZ.AnzCalculator.utils;

import com.ANZ.AnzCalculator.models.ConfigModel;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SuppressWarnings("all")
public class Utils {

    public static final ConfigModel CONFIG = loadYaml("config.yaml", ConfigModel.class);
    public static final String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());


    private static <T> T loadYaml(String yamlFileName, Class<T> configClass) {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(yamlFileName);
        return new Yaml().loadAs(inputStream, configClass);
    }
}