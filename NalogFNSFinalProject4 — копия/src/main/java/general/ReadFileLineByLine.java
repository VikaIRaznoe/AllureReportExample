package general;

import pages.MainPage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFileLineByLine {

    // построчное считывание файла
    public static void readMy() {
        try {
            File file = new File("/Users/viktoria/IdeaProjects/Java/NalogFNSFinalProjectTemp3/src/test/resources/AppData/AppLocator/locator.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
//            String[] parts = line.split(":");
//            String lastOne = parts[parts .length-1];
            while (line != null) {
                String[] parts = line.split(":");
                String lastOne = parts[parts.length - 1];
                System.out.println(lastOne);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readMy2(){
        String text = "HelpPage://android.widget.Button[@content-desc=\"search Поиск задолженностей \"]";
        String[] words = text.split(":");
        int index = 0;
        for(String word : words){
            index+=1;
            if (index == 2) {
                System.out.println(word);
            }

        }
    }

    public static void readMy3(){
        class Element{
            String nameLocator;
            String locator;
        }
        // Map<String, String> map = new HashMap<String, String>();
        List<Element> elements = new ArrayList<Element>();
        Element element = new Element();
        String text = "HelpPage://android.widget.Button[@content-desc=\"search Поиск задолженностей \"]";
        String[] words = text.split(":");
        int index = 0;
        for(String word : words){
            index+=1;
            if (index == 1) {
//                System.out.println(word);
                element.nameLocator = word;
            }
            if (index == 2) {
//                System.out.println(word);
                element.locator = word;
            }
            index = 0;
            elements.add(element);
        }
//        for (int i = 0; i < elements.size(); i++) {
//            System.out.println(elements.get(i));
//        }
    }

    public static List readMy4(){
        class Element{
            String nameLocator;
            String locator;

            @Override
            public String toString() {
                return "Element{" +
                        "nameLocator='" + nameLocator + '\'' +
                        ", locator='" + locator + '\'' +
                        '}';
            }
        }
//        Map<String, String> map = new HashMap<String, String>();
        List<Element> elements = new ArrayList<Element>();
        Element element = new Element();
        String text = "HelpPage://android.widget.Button[@content-desc=\"search Поиск задолженностей \"]";
        String[] words = text.split(":");
        int index = 0;
        for(String word : words){
            index+=1;
            if (index == 1) {
//                System.out.println(word);
                element.nameLocator = word;
            }
            if (index == 2) {
//                System.out.println(word);
                element.locator = word;
            }
            index = 0;
            elements.add(element);
//            map.put(element.nameLocator,element.locator);
        }

//        return map;
        return elements;
    }


    public static void readMy7(){
//        HashMap<String, String> elemLocator = new HashMap<>();
//        HashMap<String, String> elemLocator = new HashMap<String, String>();
        Map<String, String> elemLocator = new HashMap<>();
        try {
            File file = new File("/Users/viktoria/IdeaProjects/Java/NalogFNSFinalProjectTemp3/src/test/resources/AppData/AppLocator/locator.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int index = 0;
            String firstWord = "";
            String lastWord = "";
            while (line != null) {
                String[] words = line.split(":");
                for(String word : words){
                    index+=1;
                    if (index == 1) {
                        firstWord = word;
                        System.out.println("firstWord: " + firstWord);
//                        index+=1;
                    }
//                    index+=1;
                    if (index == 2) {
                        lastWord = word;
//                        System.out.println("lastWord: " + lastWord);
                    }
//                    elemLocator.put(firstWord,lastWord);
//                    index = 0;

                }
//                String firstOne = words[0];
                line = reader.readLine();
//                elemLocator.put(firstWord,lastWord);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Iterator<Map.Entry<String, String>> entries = elemLocator.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry<String, String> entry = entries.next();
//            System.out.println("Name Element = " + entry.getKey() + " Locator Element = " + entry.getValue());
//        }
    }

    public static void readMy8(){
        String tmp = "HelpPage://android.widget.Button[@content-desc=\"search Поиск задолженностей \"]";
        String[] parts = tmp.split(":");
        String lastOne = parts[parts .length-1];
        String firstOne = parts[0];
        System.out.println(firstOne);
    }

    public static void getLocator(){
        Map<String, String> elemLocator = new HashMap<>();
        try {
            File file = new File("/Users/viktoria/IdeaProjects/Java/NalogFNSFinalProjectTemp3/src/test/resources/AppData/AppLocator/locator.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int index = 0;
            String firstWord = "";
            String lastWord = "";
            while (line != null) {
                String[] words = line.split(":");
                for(String word : words){
                    index+=1;
                    if (index == 1){
                        firstWord = word;
                    }
                    if (index == 2) {
                        lastWord = word;
                    }
                }
//                System.out.println(firstWord);
//                System.out.println(lastWord);
                elemLocator.put(firstWord,lastWord);
                line = reader.readLine();
                index =0;
                firstWord = "";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Просмотр
        for (String key : elemLocator.keySet()) {
            System.out.println("Name Element = " + key + ", Locator Element = " +  elemLocator.get(key));
        }
    }

    public static String getLocatorRefact(String keyName){
        Map<String, String> elemLocator = new HashMap<>();
        try {
            File file = new File("/Users/viktoria/IdeaProjects/Java/NalogFNSFinalProjectTemp3/src/test/resources/AppData/AppLocator/locator.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int index = 0;
            String firstWord = "";
            String lastWord = "";
            while (line != null) {
                String[] words = line.split(":");
                for(String word : words){
                    index+=1;
                    if (index == 1){
                        firstWord = word;
                    }
                    if (index == 2) {
                        lastWord = word;
                    }
                }
//                System.out.println(firstWord);
//                System.out.println(lastWord);
                elemLocator.put(firstWord,lastWord);
                line = reader.readLine();
                index =0;
                firstWord = "";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Просмотр
        for (String key : elemLocator.keySet()) {
//            System.out.println("Name Element = " + key + ", Locator Element = " +  elemLocator.get(key));
//            System.out.println("Name Element = " + key + ", Locator Element = " +  elemLocator.get(keyName));
        }
//        System.out.println(elemLocator.get(keyName));
        return elemLocator.get(keyName);
    }
}
