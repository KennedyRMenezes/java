import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {
        
        List<Person> people = new ArrayList<>();

        people.add(new Person("Warren Buffett", 120));
        people.add(new Person("Jeff Bezos", 150));
        people.add(new Person("Bill Gates", 100));
        people.add(new Person("Mark Zuckerberg", 50));

        // --------------------------------------------- Using Stream and Filter in Chain ---------------------------------------------

        List<Person> hundredSortedClub = people.stream()
                                               .filter(person -> person.billions >= 100)
                                               .sorted(Comparator.comparing(person -> person.name))
                                               .collect(Collectors.toList());

        hundredSortedClub.forEach(person -> System.out.println(person.name));


        // --------------------------------------------- Using Stream ---------------------------------------------

        // List<Person> hundredClub = people.stream()
        //                                  .filter(person -> person.billions >= 100)
        //                                  .collect(Collectors.toList());
        
        // hundredClub.forEach(person -> System.out.println(person.name));


        // --------------------------------------------- Using For Loop ---------------------------------------------

        // List<Person> hundredClub = new ArrayList<>();

        // for(Person p: people){
        //     if(p.billions >= 100){
        //         hundredClub.add(p);
        //     }
        // }

        // hundredClub.forEach(person -> System.out.println(person.name));

    }

    static class Person {

        String name;
        int billions;

        public Person(String name, int bi){

            this.name = name;
            this.billions = bi;

        }

    }

}


