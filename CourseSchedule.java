// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/*
 * Problem#207
 * 
 */

import java.util.*;;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses]; // holds the count of dependencies.ß ; Vertices
        Map<Integer, List<Integer>> cache = new HashMap<>(); // Edges
        int count = 0;

        for (int[] pr : prerequisites) { // number of edges O(E)
            indegrees[pr[0]]++; // Number of times this course occurs in schedule.
            if (!cache.containsKey(pr[1])) { // independent course
                cache.put(pr[1], new ArrayList<>());
            }
            cache.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegrees.length; i++) { // O(V) number of vertices
            if (indegrees[i] == 0) { // seed is the list of nodes that have 0 dependencies.
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) { // O(V+E)
            int course = queue.poll();
            List<Integer> li = cache.get(course); // get list of courses dependent on course.
            if (li != null) {
                for (Integer c : li) { // loop through the dependent courses and reduce the indegree count to 1
                    indegrees[c]--;
                    if (indegrees[c] == 0) { // if indegree of a course is 0; add to queue
                        queue.add(c);
                        count++;
                    }
                }
            }

        }

        return count == numCourses; // if count == number of courses we can finish
    }
}