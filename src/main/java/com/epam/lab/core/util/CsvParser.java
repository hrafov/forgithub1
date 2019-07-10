package com.epam.lab.core.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static User createObjectsFromCredCsv(String path) {
        List<User> usersList = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(path))) {
        	//here i adder <User> to 
            CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader).withType(User.class).withIgnoreLeadingWhiteSpace(true).build();
            usersList = csvToBean.parse();
        } catch (IOException e) {
            MyLogger.getLogger().error(e);
        }
        return usersList.get(0);
    }
    
}

