package src.main.java.companywise.google.medium;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        list = createGraph(prerequisites, list);
        return checkCourseCompletion(list, numCourses);
    }

    private boolean checkCourseCompletion(List<List<Integer>> list, int numCourses) {
        int[] courses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (checkCourseCompletion(list, i, courses)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCourseCompletion(List<List<Integer>> list, int course, int[] courses) {
        if (courses[course] == 2) {
            return true;
        }

        courses[course] = 2;

        for (int i : list.get(course)) {
            if (courses[i] != 1) {
                if (checkCourseCompletion(list, i, courses)) {
                    return true;
                }
            }
        }
        courses[course] = 1;
        return false;
    }

    private List<List<Integer>> createGraph(int[][] prerequisites, List<List<Integer>> list) {
        for (int[] row : prerequisites) {
            list.get(row[0]).add(row[1]);
        }
        return list;
    }
}
