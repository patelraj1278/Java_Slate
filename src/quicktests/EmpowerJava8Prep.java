package quicktests;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmpowerJava8Prep {

    public boolean containsOnlyDigit(String str){
        /*Boolean b = false;
        char[] ch = str.toCharArray();
        for(char c=0; c <ch.length ; c++){
                if(Character.isDigit(ch[c])){
                    b = true;
                    break;
                }
        }
        return b;*/
        return str.chars().anyMatch(x -> Character.isDigit((char)x));

    }


    public void mostFrequent(){
        int[] i = new int[5];
        i[0] = 3;
        i[1] = 1;
        i[2] = 2;
        i[3] = 4;

        int[] arr = { 40, 50, 30, 40, 50, 30, 30, 40};

        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(arrList, Comparator.naturalOrder());
        arrList.stream().forEach(System.out::println);

        System.out.println("Get Min ::"+Arrays.stream(arr).reduce((x,y) -> Integer.min(x,y)).getAsInt());
        System.out.println("Get Sum ::"+Arrays.stream(arr).reduce((x,y) -> Integer.sum(x,y)).getAsInt());
        System.out.println("Get Max ::"+Arrays.stream(arr).reduce((x,y) -> Integer.max(x,y)).getAsInt());
        StringBuilder sb = new StringBuilder();
                Arrays.stream(arr).mapToObj(String::valueOf)
                .map(x -> sb.append(x).reverse())
                        .forEach(System.out::println);

        Map<Boolean, List<Integer>> partitionBy = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(x -> x > 30));
        partitionBy.entrySet().forEach(x -> {
            System.out.println("Partition Key::"+x.getKey()+"Partition Value::"+x.getValue());
        });
        System.out.println("Get Max ::"+Arrays.stream(arr).summaryStatistics().getMax());
        System.out.println("Get Sum ::"+Arrays.stream(arr).summaryStatistics().getSum());
        System.out.println("Get Sum ::"+Arrays.stream(arr).reduce(0, Integer::sum));
        Map<Long,Long> result = Arrays.stream(arr).boxed().map(x -> x.longValue())
                        .collect(Collectors.groupingBy(Long::longValue,Collectors.counting()));
        result.entrySet().forEach(x -> {
            System.out.println("Key :"+x.getKey()+"Value :"+x.getValue());
        });
        Map.Entry<Long,Long> entry = result.entrySet().stream().collect(Collectors.maxBy(Map.Entry.comparingByValue())).get();
        System.out.println("mostFrequent Entry => "+entry);

        System.out.println("Get Count ::"+Arrays.stream(arr).summaryStatistics().getCount());
        System.out.println("Get Distinct Count ::"+Arrays.stream(arr).distinct().summaryStatistics().getCount());
        System.out.println("Get Average ::"+Arrays.stream(arr).summaryStatistics().getAverage());
        System.out.println("Get Min ::"+Arrays.stream(arr).summaryStatistics().getMin());

    }

    public void getAccumelator(){
        int[] i1 = {1,4,5,6,7};

        Collector<Integer, ArrayList<Integer> , List<Integer>> accountListCollector = Collector.of(
                ArrayList::new, //Supplier - Supplier
                ArrayList::add, //Accumelator - BiConsumer
                (l1,l2) -> {l1.addAll(l2); return l1; }, //BinaryOperator - Combiner
                Collections::unmodifiableList // Function - Finisher
        );

        List<Integer> resultList = Arrays.stream(i1).boxed().collect(accountListCollector);
        System.out.println("Final Accumalator Result ::=>"+resultList);
    }

    public List<Integer> getListOfInteger(){
        List<Integer> list = Arrays.asList(5,3,3,5,6);
        //list.stream().sorted().forEach(System.out::println);
        //list.stream().distinct().sorted().forEach(System.out::println);
        Map<Integer,Long> result = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        result.entrySet().forEach(x -> {
            System.out.println("Key :"+x.getKey()+"Value :"+x.getValue());
        });

        result.forEach((k,v) -> {
            System.out.println("Hello Key :"+k+"Hello Value :"+v);
        });

        System.out.println("Max Key ::"+result.keySet().stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get());
        System.out.println("Get Value From Map Using Above Key::"+result.get(result.keySet().stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get()));
        System.out.println("Min Value ::"+result.values().stream().collect(Collectors.minBy(Comparator.naturalOrder())).get());
        result.entrySet().stream().filter(x -> x.getKey().toString().equalsIgnoreCase("6")).forEach(x -> {
            System.out.println("Filtered Value :"+ x.getValue() );
        });


        Optional<Map.Entry<Integer,Long>> result2 = result.entrySet().stream().collect(Collectors.maxBy(Comparator.comparing(x -> x.getValue())));
        result2.stream().forEach(x -> {
            System.out.println("Max Occurred Found Key:"+x.getKey()+"Max Occurred Found Value:"+x.getValue());
        });

        return list;
    }

    public List<String> getListOfString(){
        List<String> list = Arrays.asList("23","155","32","44");
        list.stream().forEach(x -> {
            System.out.println(x.length());
        });

        list.stream().filter(x -> x.length() > 2).forEach(System.out::println);

        return list;
    }

    public void mapOperation(){
        Map<String,List<JobExperienceHistory>> newMap= new HashMap<>();
        newMap.put("Raj",Arrays.asList(new JobExperienceHistory("JPMC","AWM",BigDecimal.valueOf(100000L)),new JobExperienceHistory("JPMC","CCB",BigDecimal.valueOf(150000L))));
        newMap.put("Ami",Arrays.asList(new JobExperienceHistory("AMNEAL","R&D",BigDecimal.valueOf(85000L)),new JobExperienceHistory("Novel","Practictioner",BigDecimal.valueOf(20000L))));
        newMap.put("Heman",Arrays.asList(new JobExperienceHistory("HouseWife","House",BigDecimal.valueOf(25000L))));

        Stream.of(newMap).forEach(x -> {
                System.out.println("Key :"+x.keySet().size());
        });
        newMap.entrySet().forEach(x -> {
            System.out.println("Key :"+x.getKey());
        });
        newMap.entrySet().stream().filter(x -> x.getKey().equalsIgnoreCase("Raj")).forEach(x -> {
            System.out.println(x.getValue().stream().collect(Collectors.maxBy(Comparator.comparing(JobExperienceHistory::getSalary))).get().getDepartment());
        });

        newMap.values().stream()
                .flatMap(x -> x.stream())
                .sorted(Comparator.comparing(JobExperienceHistory::getSalary))
                .forEach(x -> {
                    System.out.println("Sorted :=>"+x.getDepartment());
                });

        Map<String, List<JobExperienceHistory>>  result = newMap.values().stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.groupingBy(JobExperienceHistory::getCompanyName,Collectors.toList()));
        System.out.println("Group By =>"+result);

        System.out.println("Max By"+newMap.values().stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.maxBy(Comparator.comparing(JobExperienceHistory::getSalary))).get());

        Map<Boolean, List<JobExperienceHistory>> partiotionByHst= newMap.values().stream()
                .flatMap(x->x.stream())
                .sorted(Comparator.comparingLong(x-> x.getSalary().longValue()))
                .collect(Collectors.partitioningBy(x -> x.getSalary().longValue() > 50000L));
        System.out.println(partiotionByHst);

        LongSummaryStatistics amountSummaryStatistics = newMap.values().stream()
                .flatMap(x->x.stream())
                .collect(Collectors.summarizingLong(x -> x.getSalary().longValue()));
        System.out.println(amountSummaryStatistics);

        JobExperienceHistory hst = newMap.values().stream()
                .flatMap(x->x.stream())
                .collect(Collectors.reducing(BinaryOperator.minBy(Comparator.comparing(x->x.getSalary().longValue())))).get();
        System.out.println("JobExperienceHistory ::>"+hst);

        Map<String,BigDecimal> updatedMap=newMap.values().stream().flatMap(x->x.stream())
                .collect(Collectors.toMap(x->x.getCompanyName(),x->x.getSalary(),(o,n)-> n,HashMap::new));
        updatedMap.entrySet().forEach(x->{
            System.out.println("Key::"+x.getKey()+"Value::"+x.getValue());
        });
        System.out.println(updatedMap);
    }

    public void randomThought(){
        int[] i = {1,2,3,4,5};
        IntStream.rangeClosed(1,11).boxed().filter(x -> x % 2 != 0).forEach(System.out::println);
        Arrays.stream(i).boxed().filter(x -> x % 2 != 0).forEach(System.out::println);
        IntSupplier intSupplier = () -> 5;
        IntStream.iterate(0, x-> x+1)
                .limit(10)
                .forEach(System.out::println);

        StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        StringJoiner sj1 = new StringJoiner(",","start-","-end");
        sj1.add("aaa");
        sj1.add("bbb");
        sj1.add("ccc");
        System.out.println(sj1);

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

    public static void main(String [] args){
        EmpowerJava8Prep emp = new EmpowerJava8Prep();
        //emp.getListOfString();
        //emp.getListOfInteger();
        //emp.mostFrequent();
        //emp.getAccumelator();
        //System.out.println(emp.containsOnlyDigit("raj"));
        //emp.mapOperation();
        emp.randomThought();
    }

}
