import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidSudoku {

    /**
     * Intuition:
     * - Sudoku validation involves verifying three constraints:
     * 1. Each row contains distinct numbers or empty cells.
     * 2. Each column contains distinct numbers or empty cells.
     * 3. Each sub-region (grid) contains distinct numbers or empty cells.
     *
     *
     *
     * - To check these constraints:
     * a. For rows: Iterate through each row and check for duplicates.
     * b. For columns: Iterate through each column and check for duplicates.
     * c. For sub-regions: Divide the grid into square sub-grids of size √n,
     * and verify each sub-grid for duplicates.
     * - A helper function `hasDuplicate` is used to confirm the presence of duplicates
     * in a specified portion of the grid by tracking visited numbers using
     * a boolean list `isPresent`.
     * - If duplicates exist in any row, column, or sub-region, the Sudoku configuration
     * is deemed invalid.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */

    public static boolean isValidSudoku(List<List<Integer>> partialArrangements) {

        for (int i = 0; i < partialArrangements.size(); i++) {
            if (hasDuplicate(partialArrangements, i, i + 1, 0, partialArrangements.size())) {
                return false;
            }
        }

        for (int j = 0; j < partialArrangements.size(); j++) {
            if (hasDuplicate(partialArrangements, 0, partialArrangements.size(), j, j + 1)) {
                return false;
            }
        }

        int regionSize = (int) Math.sqrt(partialArrangements.size());
        for (int i = 0; i < regionSize; i++) {

            for (int j = 0; j < regionSize; j++) {
                if (hasDuplicate(partialArrangements, regionSize * i,
                        regionSize * (i + 1), regionSize * j,
                        regionSize * (j + 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasDuplicate(List<List<Integer>> partialArrangements, int startRow, int endRow, int startCol, int endCol) {

        List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(partialArrangements.size() + 1, false));

        for (int i = startRow; i < endRow; i++) {

            for (int j = startCol; j < endCol; j++) {

                if (partialArrangements.get(i).get(j) != 0 && isPresent.get(partialArrangements.get(i).get(j))) {
                    return true;
                }

                isPresent.set(partialArrangements.get(i).get(j), true);
            }
        }

        return false;
    }
}
