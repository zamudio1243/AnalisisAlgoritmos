package dinamicos;
/*
Hector noviembre 2019
autor de codigo: https://github.com/williamfiset
*/
import java.util.*;
public class TSP {

    private final int N, start;
    private final double[][] distance;
    private List<Integer> tour = new ArrayList<>();
    private double minTourCost = Double.POSITIVE_INFINITY;
    private boolean ranSolver = false;

    public TSP(double[][] distance) {
        this(0, distance);
    }

    public TSP(int start, double[][] distance) {
        N = distance.length;

        if (N <= 2) throw new IllegalStateException("N <= 2 not yet supported.");
        if (N != distance[0].length) throw new IllegalStateException("Matrix must be square (n x n)");
        if (start < 0 || start >= N) throw new IllegalArgumentException("Invalid start node.");
        if (N > 32)
            throw new IllegalArgumentException(
                    "Matrix too large! A matrix that size for the DP TSP problem with a time complexity of"
                            + "O(n^2*2^n) requires way too much computation for any modern home computer to handle");

        this.start = start;
        this.distance = distance;
    }

    // Returns the optimal tour for the traveling salesman problem.
    public List<Integer> getTour() {
        if (!ranSolver) solve();
        return tour;
    }

    // Returns the minimal tour cost.
    public double getTourCost() {
        if (!ranSolver) solve();
        return minTourCost;
    }

    // Solves the traveling salesman problem and caches solution.
    public void solve() {

        if (ranSolver) return;

        final int END_STATE = (1 << N) - 1;
        Double[][] memo = new Double[N][1 << N];

        // Add all outgoing edges from the starting node to memo table.
        for (int end = 0; end < N; end++) {
            if (end == start) continue;
            memo[end][(1 << start) | (1 << end)] = distance[start][end];
        }

        for (int r = 3; r <= N; r++) {
            for (int subset : combinations(r, N)) {
                if (notIn(start, subset)) continue;
                for (int next = 0; next < N; next++) {
                    if (next == start || notIn(next, subset)) continue;
                    int subsetWithoutNext = subset ^ (1 << next);
                    double minDist = Double.POSITIVE_INFINITY;
                    for (int end = 0; end < N; end++) {
                        if (end == start || end == next || notIn(end, subset)) continue;
                        double newDistance = memo[end][subsetWithoutNext] + distance[end][next];
                        if (newDistance < minDist) {
                            minDist = newDistance;
                        }
                    }
                    memo[next][subset] = minDist;
                }
            }
        }

        // Connect tour back to starting node and minimize cost.
        for (int i = 0; i < N; i++) {
            if (i == start) continue;
            double tourCost = memo[i][END_STATE] + distance[i][start];
            if (tourCost < minTourCost) {
                minTourCost = tourCost;
            }
        }

        int lastIndex = start;
        int state = END_STATE;
        tour.add(start);

        // Reconstruct TSP path from memo table.
        for (int i = 1; i < N; i++) {

            int index = -1;
            for (int j = 0; j < N; j++) {
                if (j == start || notIn(j, state)) continue;
                if (index == -1) index = j;
                double prevDist = memo[index][state] + distance[index][lastIndex];
                double newDist = memo[j][state] + distance[j][lastIndex];
                if (newDist < prevDist) {
                    index = j;
                }
            }

            tour.add(index);
            state = state ^ (1 << index);
            lastIndex = index;
        }

        tour.add(start);
        Collections.reverse(tour);

        ranSolver = true;
    }

    private static boolean notIn(int elem, int subset) {
        return ((1 << elem) & subset) == 0;
    }

    // This method generates all bit sets of size n where r bits
    // are set to one. The result is returned as a list of integer masks.
    public static List<Integer> combinations(int r, int n) {
        List<Integer> subsets = new ArrayList<>();
        combinations(0, 0, r, n, subsets);
        return subsets;
    }

    // To find all the combinations of size r we need to recurse until we have
    // selected r elements (aka r = 0), otherwise if r != 0 then we still need to select
    // an element which is found after the position of our last selected element
    private static void combinations(int set, int at, int r, int n, List<Integer> subsets) {

        // Return early if there are more elements left to select than what is available.
        int elementsLeftToPick = n - at;
        if (elementsLeftToPick < r) return;

        // We selected 'r' elements so we found a valid subset!
        if (r == 0) {
            subsets.add(set);
        } else {
            for (int i = at; i < n; i++) {
                // Try including this element
                set ^= (1 << i);

                combinations(set, i + 1, r - 1, n, subsets);

                // Backtrack and try the instance where we did not include this element
                set ^= (1 << i);
            }
        }
    }

    public static void main(String[] args) {
        // Create adjacency matrix
        int n = 4;
        double[][] distanceMatrix = new double[n][n];
        for (double[] row : distanceMatrix) java.util.Arrays.fill(row, 10000);

        distanceMatrix[0][0]= 0;distanceMatrix[0][1]= 3;distanceMatrix[0][2]= 1;   distanceMatrix[0][3]= 2;
        distanceMatrix[1][0]= 3;distanceMatrix[1][1]= 0;distanceMatrix[1][2]= 6;   distanceMatrix[1][3]= 5;
        distanceMatrix[2][0]= 1; distanceMatrix[2][1]= 6; distanceMatrix[2][2]= 0; distanceMatrix[2][3]= 2;
        distanceMatrix[3][0]= 2;distanceMatrix[3][1]= 5;distanceMatrix[3][2]= 2;   distanceMatrix[3][3]= 0;


/*
        distanceMatrix[0][0] = 0;
        distanceMatrix[0][1] = 13;
        distanceMatrix[0][2] = 33;
        distanceMatrix[0][3] = 28;
        distanceMatrix[0][4] = 37;
        distanceMatrix[0][5] = 7;
        distanceMatrix[0][6] = 32;
        distanceMatrix[0][7] = 40;
        distanceMatrix[0][8] = 80;
        distanceMatrix[0][9] = 26;
        distanceMatrix[1][0] = 13;
        distanceMatrix[1][1] = 0;
        distanceMatrix[1][2] = 39;
        distanceMatrix[1][3] = 83;
        distanceMatrix[1][4] = 50;
        distanceMatrix[1][5] = 68;
        distanceMatrix[1][6] = 16;
        distanceMatrix[1][7] = 98;
        distanceMatrix[1][8] = 81;
        distanceMatrix[1][9] = 55;
        distanceMatrix[2][0] = 33;
        distanceMatrix[2][1] = 39;
        distanceMatrix[2][2] = 0;
        distanceMatrix[2][3] = 80;
        distanceMatrix[2][4] = 88;
        distanceMatrix[2][5] = 49;
        distanceMatrix[2][6] = 53;
        distanceMatrix[2][7] = 75;
        distanceMatrix[2][8] = 63;
        distanceMatrix[2][9] = 55;
        distanceMatrix[3][0] = 28;
        distanceMatrix[3][1] = 89;
        distanceMatrix[3][2] = 80;
        distanceMatrix[3][3] = 0;
        distanceMatrix[3][4] = 94;
        distanceMatrix[3][5] = 4;
        distanceMatrix[3][6] = 20;
        distanceMatrix[3][7] = 6;
        distanceMatrix[3][8] = 59;
        distanceMatrix[3][9] = 76;
        distanceMatrix[4][0] = 37;
        distanceMatrix[4][1] = 50;
        distanceMatrix[4][2] = 88;
        distanceMatrix[4][3] = 94;
        distanceMatrix[4][4] = 0;
        distanceMatrix[4][5] = 81;
        distanceMatrix[4][6] = 87;
        distanceMatrix[4][7] = 85;
        distanceMatrix[4][8] = 4;
        distanceMatrix[4][9] = 19;
        distanceMatrix[5][0] = 7;
        distanceMatrix[5][1] = 68;
        distanceMatrix[5][2] = 49;
        distanceMatrix[5][3] = 4;
        distanceMatrix[5][4] = 81;
        distanceMatrix[5][5] = 0;
        distanceMatrix[5][6] = 96;
        distanceMatrix[5][7] = 53;
        distanceMatrix[5][8] = 40;
        distanceMatrix[5][9] = 37;
        distanceMatrix[6][0] = 32;
        distanceMatrix[6][1] = 16;
        distanceMatrix[6][2] = 53;
        distanceMatrix[6][3] = 20;
        distanceMatrix[6][4] = 87;
        distanceMatrix[6][5] = 96;
        distanceMatrix[6][6] = 0;
        distanceMatrix[6][7] = 80;
        distanceMatrix[6][8] = 57;
        distanceMatrix[6][9] = 68;
        distanceMatrix[7][0] = 40;
        distanceMatrix[7][1] = 98;
        distanceMatrix[7][2] = 75;
        distanceMatrix[7][3] = 6;
        distanceMatrix[7][4] = 85;
        distanceMatrix[7][5] = 53;
        distanceMatrix[7][6] = 80;
        distanceMatrix[7][7] = 0;
        distanceMatrix[7][8] = 65;
        distanceMatrix[7][9] = 41;
        distanceMatrix[8][0] = 80;
        distanceMatrix[8][1] = 81;
        distanceMatrix[8][2] = 63;
        distanceMatrix[8][3] = 59;
        distanceMatrix[8][4] = 4;
        distanceMatrix[8][5] = 40;
        distanceMatrix[8][6] = 57;
        distanceMatrix[8][7] = 65;
        distanceMatrix[8][8] = 0;
        distanceMatrix[8][9] = 97;
        distanceMatrix[9][0] = 26;
        distanceMatrix[9][1] = 55;
        distanceMatrix[9][2] = 55;
        distanceMatrix[9][3] = 76;
        distanceMatrix[9][4] = 19;
        distanceMatrix[9][5] = 37;
        distanceMatrix[9][6] = 68;
        distanceMatrix[9][7] = 41;
        distanceMatrix[9][8] = 37;
        distanceMatrix[9][9] = 0;
*/
        int startNode = 3;
        TSP solver =
                new TSP(startNode, distanceMatrix);

        System.out.println("Tour: " + solver.getTour());


        System.out.println("Tour cost: " + solver.getTourCost());
    }
}
