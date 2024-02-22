import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Collections {

    public static void main(String[] args) throws Exception {
       
        /*
        * Tipos de Listas
        */

        //List
        List<String> list = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        Collection<String> collection = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();  

        //Set
        Set<String> set = new HashSet<>();
        SortedSet<String> sortedSet = new TreeSet<>(); 
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        //Queue
        Queue<Integer> integerQueue = new LinkedList<>();

        testList(list);
        testArrayList(arrayList);
        testCollection(collection);

        testSortedSet(sortedSet);
        testNavigableSet(navigableSet);
        testTreeSet(treeSet);
        
        testQueue(integerQueue);
    }

    @SuppressWarnings("unchecked")
    public static void testList(List list){
        list = Arrays.asList("1", "2", "3", "4", "");
        list.forEach(itemCollection ->
            System.out.println(itemCollection)
        );

        list.sort(Comparator.naturalOrder());
        list.get(2);
        list.set(2, "ab");

        list.addAll(new ArrayList<String>());
        
        list.contains("1");
        list.size();
        list.isEmpty();

        list.remove("1");
        list.remove(0);
        list.removeAll(new ArrayList<String>());
        list.removeIf(s -> s.equals("2"));
        
        list.iterator();
        list.spliterator();
        list.clear();
    }

    @SuppressWarnings("unchecked")
    public static void testArrayList(ArrayList arrayList){
        arrayList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", ""));
        
        arrayList.forEach(itemCollection ->
            System.out.println(itemCollection)
        );

        arrayList.sort(Comparator.naturalOrder());
        arrayList.get(2);
        arrayList.set(2, "ab");

        arrayList.addAll(new ArrayList<String>());
        
        arrayList.contains("1");
        arrayList.size();
        arrayList.isEmpty();

        //arrayList.first();
        //arrayList.last();

        arrayList.remove("1");
        arrayList.remove(0);
        arrayList.removeAll(new ArrayList<String>());
        arrayList.removeIf(s -> s.equals("2"));
        
        arrayList.iterator();
        arrayList.spliterator();
        arrayList.clear();
    }

    @SuppressWarnings("unchecked")
    public static void testCollection(Collection collection){
        collection = new ArrayList<>(Arrays.asList("1", "2", "3", "4", ""));
        
        collection.forEach(itemCollection ->
            System.out.println(itemCollection)
        );

        //collection.sort(Comparator.naturalOrder());
        //collection.get(2);
        //collection.set(2, "ab");

        collection.addAll(new ArrayList<String>());
        
        collection.contains("1");
        collection.size();
        collection.isEmpty();

        //collection.first();
        //collection.last();

        collection.remove("1");
        collection.remove(0);
        collection.removeAll(new ArrayList<String>());
        collection.removeIf(s -> s.equals("2"));
        
        collection.iterator();
        collection.spliterator();
        collection.clear();
    }

    @SuppressWarnings("unchecked")
    public static void testSortedSet(SortedSet sortedSet){
        sortedSet = new SortedSet<>(Arrays.asList("1", "2", "3", "4", ""));
        
        sortedSet.forEach(itemCollection ->
            System.out.println(itemCollection)
        );

        //sortedSet.sort(Comparator.naturalOrder());
        //sortedSet.get(2);
        //sortedSet.set(2, "ab");

        sortedSet.addAll(new ArrayList<String>());
        
        sortedSet.contains("1");
        sortedSet.size();
        sortedSet.isEmpty();

        sortedSet.first();
        sortedSet.last();

        sortedSet.remove("1");
        sortedSet.remove(0);
        sortedSet.removeAll(new ArrayList<String>());
        sortedSet.removeIf(s -> s.equals("2"));
        
        sortedSet.iterator();
        sortedSet.spliterator();
        sortedSet.clear();
    }

    @SuppressWarnings("unchecked")
    public static void testNavigableSet(NavigableSet navigableSet){
        navigableSet = new NavigableSet<>(Arrays.asList("1", "2", "3", "4", ""));
        
        navigableSet.forEach(itemCollection ->
            System.out.println(itemCollection)
        );

        //navigableSet.sort(Comparator.naturalOrder());
        //navigableSet.get(2);
        //navigableSet.set(2, "ab");

        navigableSet.addAll(new ArrayList<String>());
        
        navigableSet.contains("1");
        navigableSet.size();
        navigableSet.isEmpty();

        navigableSet.first();
        navigableSet.last();

        navigableSet.remove("1");
        navigableSet.remove(0);
        navigableSet.removeAll(new ArrayList<String>());
        navigableSet.removeIf(s -> s.equals("2"));
        
        navigableSet.iterator();
        navigableSet.spliterator();
        navigableSet.clear();

        navigableSet.add(5);
        navigableSet.add(6);

        // criando um set na ordem reversa do integerNavigableSet
        NavigableSet<Integer> reverseIntegerNavigableSet = navigableSet.descendingSet();
        // print the normal and reverse views
        System.out.println("Ordem ascendente: " + navigableSet);
        System.out.println("Ordem descendente: " + reverseIntegerNavigableSet);

    }

    @SuppressWarnings("unchecked")
    public static void testTreeSet(TreeSet treeSet){
        treeSet = new NavigableSet<>(Arrays.asList("1", "2", "3", "4", ""));
        
        treeSet.forEach(itemCollection ->
            System.out.println(itemCollection)
        );

        //treeSet.sort(Comparator.naturalOrder());
        //treeSet.get(2);
        //treeSet.set(2, "ab");

        treeSet.addAll(new ArrayList<String>());
        
        treeSet.contains("1");
        treeSet.size();
        treeSet.isEmpty();

        treeSet.first();
        treeSet.last();

        treeSet.remove("1");
        treeSet.remove(0);
        treeSet.removeAll(new ArrayList<String>());
        treeSet.removeIf(s -> s.equals("2"));
        
        treeSet.iterator();
        treeSet.spliterator();
        treeSet.clear();

        treeSet.add(5);
        treeSet.add(6);
        treeSet.add("c");
        treeSet.add("a");
    }

    @SuppressWarnings("unchecked")
    public static void testQueue(Queue<Integer> integerQueue){
        integerQueue = new NavigableSet<>(Arrays.asList("1", "2", "3", "4", ""));
        
        integerQueue.forEach(itemCollection ->
            System.out.println(itemCollection)
        );

        //integerQueue.sort(Comparator.naturalOrder());
        //integerQueue.get(2);
        //integerQueue.set(2, "ab");

        //integerQueue.addAll(new ArrayList<String>());
        
        integerQueue.contains("1");
        integerQueue.size();
        integerQueue.isEmpty();

        //integerQueue.first();
        //integerQueue.last();

        integerQueue.remove("1");
        integerQueue.remove(0);
        integerQueue.removeAll(new ArrayList<String>());
        integerQueue.removeIf(s -> s.equals("2"));
        
        integerQueue.iterator();
        integerQueue.spliterator();
        integerQueue.clear();

        integerQueue.add(5);
        integerQueue.add(6);
        //integerQueue.add("c");
        //integerQueue.add("a");
        
        System.out.println("Elements of queue " + integerQueue);
        
        // removendo o primeiro intem da fila
        int removedItem = integerQueue.remove();
        System.out.println("Elemento Removido: " + removedItem);
        System.out.println(integerQueue);
        
        // visualizando o primeiro elemento da fila
        int head = integerQueue.peek();
        System.out.println("Primeiro elemento da fila: " + head);
        
        // item adicionado ao fim da lista
        integerQueue.add(5);
        System.out.println(integerQueue);
    }
}