package com.j5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Person> persons = createPersons();

        Map<Integer, Person> hashMapP = new HashMap<>();
        Map<Integer, Person> linkedMapP = new LinkedHashMap<>();
        Map<Integer, Person> treeMapP = new TreeMap<>();
        long fillHashMapTime = fillMap(persons, hashMapP);
        long fillLinkedMapTime = fillMap(persons, linkedMapP);
        long fillTreeMapTime = fillMap(persons, treeMapP);
        System.out.println("Time fill maps : ");
        System.out.println("1. HashMap : " + fillHashMapTime);
        System.out.println("2. LinkedHashMap : " + fillLinkedMapTime);
        System.out.println("3. TreeMap : " + fillTreeMapTime);

        List<Person> list = new ArrayList<>();
        long getHashMapTime = fillList(hashMapP, list);
        list = new ArrayList<>();
        long getLinkedMapTime = fillList(linkedMapP, list);
        list = new ArrayList<>();
        long getTreeMapTime = fillList(treeMapP, list);
        System.out.println("Time get from maps : ");
        System.out.println("1. HashMap : " + getHashMapTime);
        System.out.println("2. LinkedHashMap : " + getLinkedMapTime);
        System.out.println("3. TreeMap : " + getTreeMapTime);

        list.sort(new AgeComparator());
        list.forEach((person -> System.out.println(person)));
    }

    static List<Person> createPersons() {
        Scanner nameScanner = new Scanner(System.in);
        Scanner ageScanner = new Scanner(System.in);
        List<Person> persons = new LinkedList<>();
        boolean stopInput = false;
        while (!stopInput) {
            System.out.println("Enter please name (LastName FirstName MiddleName) :");
            String fio = nameScanner.nextLine();
            System.out.println("Enter please age :");
            int age = ageScanner.nextInt();
            persons.add(Person.createPerson(fio, age));

            System.out.println("Do you want to add one more? Y/N");
            String yesNo = new Scanner(System.in).nextLine();
            if (yesNo.equalsIgnoreCase("N")) {
                stopInput = true;
            }
        }
        return persons;
    }

    static long fillMap(List<Person> personList, Map<Integer, Person> map) {
        long start = System.nanoTime();
        for (int i = 0; i < personList.size(); i++) {
            map.put(i, personList.get(i));
        }
        return System.nanoTime() - start;
    }

    static long fillList(Map<Integer, Person> map, List<Person> list) {
        long start = System.nanoTime();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            list.add(map.get(iterator.next()));
        }
        return System.nanoTime() - start;
    }
}


class AgeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person)o1;
        Person p2 = (Person)o2;
        return Integer.compare(p1.age, p2.age);
    }
}