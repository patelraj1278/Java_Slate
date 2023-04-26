package quicktests;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuickTest5 {

    public void testList(){

    }
    public void testMap(){
        Map<String, List<JobExperienceHistory>> newMap= new HashMap<>();
        newMap.put("Raj", Arrays.asList(new JobExperienceHistory("JPMC","AWM", BigDecimal.valueOf(100000L)),new JobExperienceHistory("JPMC","CCB",BigDecimal.valueOf(150000L))));
        newMap.put("Ami",Arrays.asList(new JobExperienceHistory("AMNEAL","R&D",BigDecimal.valueOf(85000L)),new JobExperienceHistory("Novel","Practictioner",BigDecimal.valueOf(20000L))));
        newMap.put("Heman",Arrays.asList(new JobExperienceHistory("HouseWife","House",BigDecimal.valueOf(25000L))));

        newMap.entrySet().stream().flatMap(x->x.getValue().stream())
                .filter(x->x.getCompanyName().equalsIgnoreCase("AMNEAL"))
                .filter(x-> x.getSalary().intValue() > 84000)
                .forEach(x->{
                    System.out.println(x.getSalary());
                });

        Map<String, List<JobExperienceHistory>> updatedMap = newMap.entrySet().stream()
                .flatMap(x->x.getValue().stream())
                .sorted(Comparator.comparing(JobExperienceHistory::getSalary))
                .collect(Collectors.groupingBy(x->x.getCompanyName(),Collectors.toList()));
        System.out.println(updatedMap);



    }

    public void findSecondHighest(){
        int[] array= { 1, 2, 7, 6, 4, 9, 12,15 };

        int maxValue = Integer.MIN_VALUE;
        int secondMaxValue = Integer.MIN_VALUE;

        for(int i=0 ; i< array.length ; i++){
            if(array[i] > maxValue){
                secondMaxValue= maxValue;
                maxValue = array[i];
            }else if(array[i] > secondMaxValue){
                secondMaxValue=array[i];
            }
        }
        System.out.println(secondMaxValue);
    }

    public void findCharOccurances(){
        String str= "abcd skfeas";
        char find = 's';

        Map.Entry<Character,Long> entryMap = str.chars().mapToObj(x->(char)x)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get();

        Map.Entry<Character,Long> entry = str.chars().mapToObj(x->(char)x)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getKey().equals(find))
                        .findAny().get();

        System.out.println(entry);
    }


    public static void main(String [] args){
        QuickTest5 qt = new QuickTest5();
        qt.testMap();
        qt.findSecondHighest();
        qt.findCharOccurances();
    }


}

class JobExperienceHistory{
    private String companyName;
    private String department;
    private BigDecimal salary;

    @Override
    public String toString() {
        return "JobExperienceHistory{" +
                "companyName='" + companyName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public JobExperienceHistory(String companyName, String department, BigDecimal salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
