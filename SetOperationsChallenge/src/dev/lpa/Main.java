package dev.lpa;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        Set<Task> annsTasks = TaskData.getTasks("Ann");
        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        Set<Task> carolsTasks = TaskData.getTasks("Carol");

        sortAndPrint("All Tasks", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Comparator<Task> sortByAssignee = Comparator.comparing(Task::getAssignee);


//        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);
//        sortAndPrint("Ann's Tasks", annsTasks);

        // Add all tasks to a list of sets
        List<Set<Task>> everyTask = List.of(tasks, annsTasks,bobsTasks,carolsTasks);

        // Confirm all tasks are in this list
//       for(Set<Task> curentTaskSet : everyTask){
//           int index = everyTask.indexOf(curentTaskSet)+1;
//           sortAndPrint("Task List #" + index, curentTaskSet);
//       }

        // Full Task List
       Set<Task> unionOfAllTasks = getUnion(everyTask);
       sortAndPrint("Union of All Task Lists", unionOfAllTasks, sortByAssignee);

       // Tasks assigned to at least 1 employee
        Set<Task> assginedTasks = getUnion(List.of(
                getIntersect(annsTasks, unionOfAllTasks),
                getIntersect(bobsTasks, unionOfAllTasks),
                getIntersect(carolsTasks, unionOfAllTasks)
        ));
        sortAndPrint("Tasks assigned to at least 1 employee", assginedTasks);

        // Tasks that still need to be assigned
        // Get all the employees' tasks
        // Remove the employees' tasks from the full task list
        Set<Task> unassignedTasks = getDifference(unionOfAllTasks, assginedTasks);
        sortAndPrint("Unassigned Tasks", unassignedTasks);

        Set<Task> assignedToMultipleEmployees = getUnion(List.of(
                getIntersect(bobsTasks, carolsTasks),
                getIntersect(bobsTasks,annsTasks),
                getIntersect(annsTasks, carolsTasks)
        ));
        sortAndPrint("Assigned to Multiple Employees", assignedToMultipleEmployees, sortByPriority);

    }

    private static void sortAndPrint(String header, Collection<Task> collection){
        sortAndPrint(header,collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter){

        String lineSeparator = "-".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    /**
     * Take a List of Sets that contain Tasks and return
     * the union of all the sets.
     * @param taskList A list of sets that contains tasks
     * @return a Set of Tasks
     */
    private static Set<Task> getUnion(List<Set<Task>> taskList){
        Set<Task> union = new HashSet<>();

        taskList.forEach(union::addAll);
        return union;
    }

    private static Set<Task> getIntersect(Set<Task> t1, Set<Task> t2){
        Set<Task> intersect = new HashSet<>(t1);
        intersect.retainAll(t2);

        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> t1, Set<Task> t2){
        Set<Task> taskDiff = new HashSet<>(t1);
        taskDiff.removeAll(t2);

        return taskDiff;
    }
}
