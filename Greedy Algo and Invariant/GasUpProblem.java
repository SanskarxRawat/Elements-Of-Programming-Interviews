public class GasUpProblem {

    /**
     * Given an instance of the gasup problem, how would you efficiently compute an ample
     * city? You can assume that there exists an ample city.
     *
     * Approach:
     * - Think of the problem as simulating a circuit around a circular track of cities.
     * - Each city has a gas station, and you are given the amount of gas at each station and
     * the distance (in gas units) required to travel to the next city.
     * - The goal is to identify the starting city (ample city) such that you can complete
     * the circuit without running out of gas.
     *
     * Algorithm:
     * 1. Compute the remaining gas after reaching each city.
     * 2. Traverse all cities while keeping track of the total remaining gas and total gas
     * needed. If at any point the remaining gas becomes negative, reset the starting
     * city to the next city and reset remaining gas to 0.
     * 3. Return the last starting city where the loop was reset to as the ample city.
     *
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /**
     * Intuition:
     * - The problem can be thought of as trying to balance gas usage and availability across a circular route.
     * - If we consider each city, the net gas added/subtracted at that city is gas[i] - distance[i].
     * - The algorithm ensures that we calculate a feasible starting city such that, starting from this city,
     * any shortages in gas are mitigated as we traverse the remaining cities.
     * - If the totalGas is negative, it means the solution is impossible (though here it's given that a solution always exists).
     * - The variable `remainingGas` tracks the gas balance at any point. Whenever it becomes negative, it indicates that
     * the journey can't be completed from the current starting city up to that point, so we reset the starting city
     * and continue the search.
     * - This ensures that by the end of the loop, `startCity` is the ample city.
     */
    public static int findAmpleCity(int[] gas, int[] distance) {
        int totalGas = 0, remainingGas = 0, startCity = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - distance[i];
            remainingGas += gas[i] - distance[i];
            if (remainingGas < 0) {
                startCity = i + 1;
                remainingGas = 0;
            }
        }

        return totalGas >= 0 ? startCity : -1; // Return the starting city if the circuit can be completed.
    }

}
