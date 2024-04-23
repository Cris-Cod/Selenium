package javaStreams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {

        //count the number of names string with alphabet a in list

        List<String> names = new ArrayList<String>();
        names.add("Abhjjeit");
        names.add("Don");
        names.add("Alek");
        names.add("Alyka");
        names.add("Adam");
        names.add("Ramnses");
        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual =names.get(i);
            if(actual.startsWith("A")){
                count++;
            }
        }

        System.out.println(count);
    }

    @Test
    public void streamFilter(){
        List<String> names = new ArrayList<String>();
        names.add("Abhjjeit");
        names.add("Don");
        names.add("Alek");
        names.add("Alyka");
        names.add("Adam");
        names.add("Ramnses");

        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        long d = Stream.of("Abhjjeit","Don", "Alek","Alyka","Adam","Ramnses").filter(s ->
        {
            return s.startsWith("A");
        }).count();
        System.out.println(d);

        names.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));//print names mayor 4 letters
        names.stream().filter(s -> s.length()>4).limit(1).forEach(s-> System.out.println(s));  //print only one name


    }

    @Test
    public void streamMap(){

        List<String> names = new ArrayList<String>();
        names.add("Mand");
        names.add("Don");
        names.add("Alis");
        names.add("Al");
        names.add("Audii");
        names.add("Ram");

        //print names which have last letter as "a" and changes that names to uppercase
        Stream.of("Abhjjeit","Don", "Alek","Alyka","Adama","Ramnses").filter(s ->s.endsWith("a"))
                .map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //print names which have first letter as a with uppercase and sorted
        List<String> names1 = Arrays.asList("Abhjjeit","Don", "Alek","Alyka","Adama","Ramnses");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        //Merging 2 diferents list
        Stream<String> newString = Stream.concat(names1.stream(), names.stream());
        //newString.sorted().forEach(s-> System.out.println(s));
        boolean flag = newString.anyMatch(s -> s.equalsIgnoreCase("Alek"));  // find any name in the stram(list)
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect(){
        //list
        // new list
        List<String> ls = Stream.of("Abhjjeit","Don", "Alek","Alyka","Adama","Ramnses").filter(s ->s.endsWith("a"))
                .map(s -> s.toUpperCase()).collect(Collectors.toList());

        System.out.println(ls.get(0));

        // Print unique number from this array
        // sort the array  -- give me third index
        List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,7,7);
        numbers.stream().distinct().sorted().forEach(s-> System.out.println(s));
        List<Integer> li = numbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }
}
