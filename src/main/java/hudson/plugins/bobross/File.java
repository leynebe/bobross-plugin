package hudson.plugins.bobross;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;

import java.util.Set;
import java.util.regex.Pattern;

/**
  * This class finds images.
  */
public class File {

    public Set<String> findFiles(String searchValue) {
        Reflections reflections = new Reflections("hudson.plugins.bobross", new ResourcesScanner());
//        Set<String> fileNames = reflections.getResources(Pattern.compile(".*"+searchValue+".*\\.jpg"));
        Set<String> fileNames = reflections.getResources(Pattern.compile(".*\\.jpg"));

        return fileNames;
    }
}