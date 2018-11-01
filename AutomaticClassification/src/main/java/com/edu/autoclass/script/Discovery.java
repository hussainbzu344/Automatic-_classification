package com.edu.autoclass.script;

import com.edu.autoclass.bean.EntryPoint;
import com.edu.autoclass.bean.Framework;
import com.edu.autoclass.bean.ProjectType;
import com.edu.autoclass.bean.SearchResult;
import com.edu.autoclass.util.DbConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class Discovery {
    private DbConfig dbConfig;

    public Discovery() {
        dbConfig = new DbConfig();
    }

    public SearchResult findLibraries(String url) {
        SearchResult searchResult = new SearchResult();
        List<String> libraries = new ArrayList<>();
        try {
            File dir = new File(url);

            String[] extensions = new String[]{"xml", "java", "gradle"};

            String pom_pattern = "(pom.xml)";
            String gradle_pattern = "(build.gradle)";
            String java_pattern = "(java)";

            Pattern pom_r = Pattern.compile(pom_pattern);
            Pattern gradle_r = Pattern.compile(gradle_pattern);
            Pattern java_r = Pattern.compile(java_pattern);

            BufferedReader br = null;
            FileReader fr = null;
            String line;

            List<String> searchedFile = new ArrayList<String>();

          //  System.out.println("Provide string to be searched in the Files :");

            String search_pattern = "import";
            Pattern search_r = Pattern.compile(search_pattern);

          //  System.out.println("Getting all  " + dir.getCanonicalPath()
           //         + " including those in subdirectories");
            List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);


            for (File file : files) {
                Matcher java_match = java_r.matcher(file.getCanonicalPath());

                if (java_match.find()) {
                  //  System.out.println(file.getCanonicalPath());
                    fr = new FileReader(file.getCanonicalPath());
                    br = new BufferedReader(fr);
                    while ((line = br.readLine()) != null) {
                        Matcher search_match = search_r.matcher(line);

                        if (search_match.find()) {
                            line = line.replace("import", "");
                            line = line.replace("static", "");
                            line = line.replace(";", "");
                            if(!libraries.contains(line)){
                                libraries.add(line);
                            }
                            searchedFile.add(file.getCanonicalPath());
                        }
                    }
                }


                Matcher pom_match = pom_r.matcher(file.getCanonicalPath());
                if (pom_match.find()) {
                //    System.out.println(file.getCanonicalPath());
                }
                Matcher gradle_match = gradle_r.matcher(file.getCanonicalPath());
                if (gradle_match.find()) {
                  //  System.out.println(file.getCanonicalPath());
                }


            }
            List<Framework> frameworks = new ArrayList<>();
            List<EntryPoint> entryPoints = new ArrayList<>();
            List<ProjectType> projectTypes = new ArrayList<>();
            for (String library : libraries) {
                 frameworks.addAll(dbConfig.getFramework(library));
                for (Framework framework : dbConfig.getFramework(library)) {
                    entryPoints.addAll(dbConfig.getEnteryPointsById(framework.getId()));
                    projectTypes.addAll(dbConfig.getType(framework.getTypeId()));
                }
              }

            searchResult.setFrameworks(frameworks);
            searchResult.setEntryPoints(entryPoints);
            searchResult.setProjectTypes(projectTypes);
            searchResult.setLibraries(libraries);
            Set<String> unique_path = new HashSet<String>(searchedFile);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchResult;
    }

}