package by.btd.ejtb.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@Configuration
@RequiredArgsConstructor
public class LocalService {

    private static List<JsonObject> languageSettings;

    public static String getString(String language, String key) {
        log.info("Message localization request has been received");
        String type = "";
        loadLanguageSettings(language);

        for (JsonObject jsonObject : languageSettings) {
            if (key.endsWith("COMMAND")) {
                type = "commands";
            } else if (key.endsWith("TEXT")) {
                type = "text";
            }
            return jsonObject
                    .get(type)
                    .getAsJsonArray()
                    .get(0)
                    .getAsJsonObject()
                    .get(key)
                    .getAsString();
        }
        return "";
    }

    @SneakyThrows
    private static void loadLanguageSettings(String language) {
        languageSettings = new ArrayList<>();
        var resourcesFolder = new File("src/main/resources/languages");
        File[] files = resourcesFolder.listFiles();
        boolean checkingFileAvailability = false;

        log.info("Started looking for language settings in folder [{}]", resourcesFolder);
        if (resourcesFolder.exists() && resourcesFolder.isDirectory()) {
            boolean javaFilesExist = false;
            for (File file : files) {
                if (file.isFile()) {
                    javaFilesExist = true;
                    break;
                }
            }
            if (javaFilesExist) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(language + ".json")) {
                        checkingFileAvailability = true;
                        var reader = new FileReader(file);
                        var jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
                        languageSettings.add(jsonObject);
                    }
                }
                if (checkingFileAvailability) {
                    log.info("Language settings file [{}] loaded successfully", language);
                } else {
                    log.error("Language settings file [{}] not found in folder [{}]", language, resourcesFolder);
                }
            }
        } else {
            log.error("The folder with the language files is missing");
        }
    }
}
