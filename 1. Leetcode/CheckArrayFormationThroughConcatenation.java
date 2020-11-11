// 1640. Check Array Formation Through Concatenation

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> indexPieceMap = new HashMap<>();

        // Build the inverted index
        for (int i = 0; i < pieces.length; i++) {
            indexPieceMap.put(pieces[i][0], i);
        }

        // Validate by searching for items
        for (int i = 0; i < arr.length;) {

            // Get matching piece

            int index = indexPieceMap.getOrDefault(arr[i], -1);
            if (index == -1) {
                return false;
            }

            int[] piece = pieces[index];
            int j = 0;
            for (; j < piece.length && i < arr.length;) {
                if (piece[j] != arr[i]) {
                    return false;
                }

                j++;
                i++;
            }

            if (j != piece.length) {
                return false;
            }
        }

        return true;
    }
}
