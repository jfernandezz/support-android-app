package service;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertiesReaderImpl implements ApplicationPropertiesReader {
    private String propertiesFileName;
    private Context context;
    private Properties applicationProperties;

    public ApplicationPropertiesReaderImpl(String propertiesFileName,Context context) {
        this.propertiesFileName = propertiesFileName;
        this.context = context;
        readProperties();
    }

    public String getProperty(String key) {
        return applicationProperties.getProperty(key);
    }

    @Override
    public Properties getProperties() {
        return applicationProperties;
    }

    @Override
    public Properties readProperties() {
        applicationProperties = new Properties();
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open(propertiesFileName);
            applicationProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
        return applicationProperties;
    }
}
