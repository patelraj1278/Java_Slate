package quicktests;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.security.cert.CollectionCertStoreParameters;
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
        int[] arr2 = { 1,2,3,40};

        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.minBy(Comparator.naturalOrder())).orElse(0));
        Map<Boolean,List<Integer>> partBy  = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(x->x > 30));
        partBy.entrySet().forEach(System.out::println);

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

        List<Employee> employeeList
                = Arrays.asList(new Employee("Tom Jones", 45, 15000.00),
                new Employee("Harry Andrews", 45, 7000.00),
                new Employee("Ethan Hardy", 65, 8000.00),
                new Employee("Nancy Smith", 22, 10000.00),
                new Employee("Deborah Sprightly", 29, 9000.00));

            List<String> employeeNamess = employeeList
                    .stream()
                    .collect(Collectors.mapping(Employee::getName, Collectors.toList()));
            employeeNamess.forEach(System.out::println);

        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        employeeList.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
        employeeList.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
    }

    public void testSorting(){
        int[] i = {1,2,3,4,5};
        Arrays.stream(i).boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        Map<String,List<JobExperienceHistory>> newMap= new HashMap<>();
        newMap.put("Raj",Arrays.asList(new JobExperienceHistory("JPMC","AWM",BigDecimal.valueOf(100000L)),new JobExperienceHistory("JPMC","CCB",BigDecimal.valueOf(150000L))));
        newMap.put("Ami",Arrays.asList(new JobExperienceHistory("AMNEAL","R&D",BigDecimal.valueOf(85000L)),new JobExperienceHistory("Novel","Practictioner",BigDecimal.valueOf(20000L))));
        newMap.put("Heman",Arrays.asList(new JobExperienceHistory("HouseWife","House",BigDecimal.valueOf(25000L))));

        newMap.entrySet().stream()
                .map(x->x.getKey())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        newMap.entrySet().stream()
                .map(x->x.getValue())
                .flatMap(x->x.stream())
                .sorted(Comparator.comparing(x->x.getSalary().longValue(),Comparator.reverseOrder()))
                .forEach(x->{
                    System.out.println(x.getCompanyName());
                });

        newMap.entrySet().stream()
                .map(x->x.getValue())
                .flatMap(x->x.stream())
                .collect(Collectors.groupingBy(JobExperienceHistory::getCompanyName,Collectors.counting()))
                .entrySet().forEach(System.out::println);

        Map<String,Integer> intMap= new HashMap<>();
        intMap.put("Raj",1);
        intMap.put("Ami",2);
        intMap.put("Heman",3);
        String result = intMap.entrySet().stream()
                .collect(Collectors.maxBy(Map.Entry.comparingByValue()))
                .get().getKey();
        System.out.println(result);

        Map<String,JobExperienceHistory> empMap= new HashMap<>();
        empMap.put("Raj",new JobExperienceHistory("JPMC","AWM",BigDecimal.valueOf(0L)));
        empMap.put("Ami",new JobExperienceHistory("Amneal","R&D",BigDecimal.valueOf(85000L)));
        empMap.put("Heman",new JobExperienceHistory("House","HS",BigDecimal.valueOf(35000L)));

        Long salarySum = empMap.entrySet().stream()
                .map(x->x.getValue())
                .sorted(Comparator.comparingLong(x->x.getSalary().longValue()))
                .map(x->x.getSalary())
                .reduce(BigDecimal.ZERO,BigDecimal::add)
                .longValue();
        System.out.println(salarySum);

        Map<String,JobExperienceHistory> newEmpMap = empMap.entrySet().stream()
                .map(x->x.getValue())
                .collect(Collectors.toMap(JobExperienceHistory::getCompanyName,x->x,(o,n)->n,HashMap::new));
        System.out.println(newEmpMap);

        String companyName= empMap.entrySet().stream()
                .map(x->x.getValue())
                .collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(JobExperienceHistory::getSalary)))).get().getCompanyName();
        System.out.println(companyName);

        Map<Boolean,List<JobExperienceHistory>> entryJob=empMap.entrySet().stream()
                .map(x->x.getValue())
                .collect(Collectors.partitioningBy(x->x.getSalary().longValue() > 50000L));
        System.out.println(entryJob);

        Double avgSalry = empMap.entrySet().stream()
                .map(x->x.getValue())
                .collect(Collectors.summarizingLong(x->x.getSalary().longValue()))
                .getAverage();
        System.out.println(avgSalry);


        List<Integer> newList = new ArrayList<>();
        newList.add(5);
        newList.add(2);
        newList.add(1);
        newList.add(4);
        newList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        newList.stream().sorted().forEach(System.out::println);


    }

    public void geekForGeeks(){
        int arr[] = {1, 2, 3, 5};
        Arrays.sort(arr);
        List<Integer> intList = new ArrayList<>();
        for(int i=arr[0]; i<=arr[arr.length-1]; i++){
            if((i+1) <= arr.length-1 && (arr[i+1] - arr[i]) != 1){
                intList.add(arr[i]+1);
            }
        }
        //intList.forEach(System.out::println);

        int arr1[] = {10, 5, 3, 4, 3, 5, 6};
        //String finalResult="";
        List<Integer> result = Arrays.stream(arr1).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getValue()>1)
                .map(x->x.getKey())
                .collect(Collectors.toList());
        System.out.println(Arrays.stream(arr1).boxed()
                .filter(x->result.contains(x))
                .findFirst().get());

        /*for(int i=0;i<arr1.length;i++){
            if(result.contains(arr1[i])){
                finalResult=String.valueOf(arr1[i]);
                break;
            }
        }
        System.out.println(finalResult);*/

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

    class Employee {

        private String name;
        private Integer age;
        private Double salary;

        public Employee(String name, Integer age, Double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }
//Setters and Getters for name, age & salary go here

        public String toString(){
            return "Name: "+ this.name
                    + " Age: "+ this.age;
        }

        //Standard implementations for overridden hashcode() & equals() goes here
    }

    public void testSortingGeekForGeek(){
        int arr[] = {2, 5, 2, 8, 5, 6, 8, 8};
        Arrays.stream(arr).boxed()
                .sorted((o1,o2)-> o2.compareTo(o1)).forEach(System.out::println);

        Arrays.stream(arr).boxed()
                .sorted(Comparator.reverseOrder()).forEach(System.out::println);

        Arrays.stream(arr).boxed()
                .sorted((o1,o2)-> o1.compareTo(o2)).forEach(System.out::println);

        Arrays.stream(arr).boxed()
                .sorted(Integer::compareTo).forEach(System.out::println);

        Arrays.stream(arr).boxed()
                .sorted((o1,o2)-> o1.compareTo(o2)).forEach(System.out::println);

        Arrays.stream(arr).boxed()
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                }).forEach(System.out::println);


        //=== CUSTOM SORTING===//
        int[] arr1 = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
        HashMap<Integer,Integer> countMap = new HashMap<>();
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0; i< arr1.length;i++){
            if(countMap.containsKey(arr1[i])){
                countMap.put(arr1[i],countMap.get(arr1[i])+1);
            }else{
                countMap.put(arr1[i],1);
                indexMap.put(arr1[i],i);
            }
        }
        System.out.println("countMap=>"+countMap);
        System.out.println("indexMap=>"+indexMap);

        Collections.sort(Arrays.asList(arr1),(o1, o2)->{
            int freq1= countMap.get(o1);
            int freq2= countMap.get(o2);
            if(freq1!=freq2){
                return freq2-freq1;
            }else{
                int index1=indexMap.get(o1);
                int index2=indexMap.get(o2);
                return index1-index2;
            }
        });
        Arrays.stream(arr1).forEach(System.out::println);
    }

    public static void main(String [] args){
        EmpowerJava8Prep emp = new EmpowerJava8Prep();
        //emp.getListOfString();
        //emp.getListOfInteger();
        emp.mostFrequent();
        //emp.getAccumelator();
        //System.out.println(emp.containsOnlyDigit("raj"));
        //emp.mapOperation();
        //emp.randomThought();
        //emp.geekForGeeks();
        //emp.testSorting();
        //emp.testSortingGeekForGeek();
    }

}
