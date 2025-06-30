import java.util.*;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
     List<Integer> evenNumbersFormList= StreamExamples.getEvenNumbers();
     System.out.println(evenNumbersFormList);

     List<Integer> listNumsGreaterthan25= StreamExamples.getNumbersGreaterthan25();
     System.out.println(listNumsGreaterthan25);

     List<String>  listOfStringstoUpperCase= StreamExamples.getUpperCase();
     System.out.println(listOfStringstoUpperCase);

     long countStringsStartsWithG=StreamExamples.getCountStringStartsWithG();
     System.out.println(countStringsStartsWithG);

     String longestString=StreamExamples.getLongestStringInList();
     System.out.println(longestString);

     List<Integer> flatNestedList=StreamExamples.flatNestedList();
     System.out.println(flatNestedList);

     Map<Character,List<String>> listgroupByFirsChar=StreamExamples.groupByFirsChar();
     System.out.println(listgroupByFirsChar);

     String commaSeperatedString=StreamExamples.getCommaSepartedString();
     System.out.println(commaSeperatedString);

     Map<String,Long> countOfStringInList=StreamExamples.countOfStrings();
     System.out.println(countOfStringInList);

     List<String> top3LongestStringsInList=StreamExamples.top3LongestStrings();
     System.out.println(top3LongestStringsInList);

     Map<Boolean,List<Integer>> partitionEvenOddList=StreamExamples.partitionEvenOdd();
     System.out.println(partitionEvenOddList);

     StreamExamples streamexample=new StreamExamples();

     List<String> listOfDuplicateStrings=streamexample.listOfDuplicate();
     System.out.println(listOfDuplicateStrings);

     List<String> wordsfromSentences=streamexample.getwordsfromSentences();
     System.out.println(wordsfromSentences);

     String mostFrequentString=streamexample.mostFrequentString();
     System.out.println(mostFrequentString);

     List<String> listOfCitiesSortedByFrequency=StreamExamples.listOfCitiesSortedByFrequency();
     System.out.println(listOfCitiesSortedByFrequency);

     Map<String,List<String>> groupingEmployeesByDepartment=streamexample.groupingEmployeesByDepartment();
     System.out.println(groupingEmployeesByDepartment);

     Map<Boolean,List<String>> partioningEmployeesByDepartment=streamexample.partioningEmployeesByDepartment();
     System.out.println(partioningEmployeesByDepartment);

     Map<String,List<String>> groupingAndFilteringEmployeesByDepartment= streamexample.groupingAndFilteringEmployeesByDepartment();
     System.out.println(groupingAndFilteringEmployeesByDepartment);

     Integer reduceProductOfNumbers=StreamExamples.reduceProductOfNumbers();
     System.out.println(reduceProductOfNumbers);

     OptionalDouble averageLengt0fAllWords=StreamExamples.averageLengt0fAllWords();
     System.out.println(averageLengt0fAllWords);

     IntSummaryStatistics summaryStatistics=StreamExamples.summaryStatistics();
     System.out.println(summaryStatistics);

     List<String> peekBeforeFiltering=StreamExamples.peekBeforeFiltering();
     System.out.println(peekBeforeFiltering);



    }

}