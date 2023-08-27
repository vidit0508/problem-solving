package src.main.java.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;
        List<List<Integer>> list = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        list = createGraph(list, prerequisites);
        System.out.println(courseCompletionPossible(list, numCourses));
    }

    private static boolean courseCompletionPossible(List<List<Integer>> list, int numCourses) {
        int[] courses = new int[numCourses];
        for (int i = 0; i < courses.length; i++) {
            if (checkCourseDependencies(i, courses, list)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCourseDependencies(int i, int[] courses, List<List<Integer>> list) {
        if (courses[i] == 2) {
            return true;
        }

        courses[i] = 2;
        for (int l : list.get(i)) {
            if (courses[i] != 1) {
                if (checkCourseDependencies(l, courses, list)) {
                    return true;
                }
            }
        }
        courses[i] = 1;
        return false;
    }

    private static List<List<Integer>> createGraph(List<List<Integer>> list, int[][] prerequisites) {
        for (int[] row : prerequisites) {
            list.get(row[0]).add(row[1]);
        }
        return list;
    }
}
