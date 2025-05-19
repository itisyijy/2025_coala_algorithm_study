package CrosswordPuzzle;

import java.util.ArrayList;
import java.util.List;

class Slot {
    int row, col, len;
    char dir; // 'H' or 'V'
    Slot(int r, int c, int l, char d) {
        row = r; col = c; len = l; dir = d;
    }
}

class Result {
    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        char[][] grid = new char[10][10];

        // 1. 문자열 List<String> -> char[][] 변환
        for (int i = 0; i < 10; i++) {
            grid[i] = crossword.get(i).toCharArray();
        }

        // 2. 단어 분리
        String[] wordList = words.split(";");

        // 3. 슬롯 위치 찾기
        List<Slot> slots = findSlots(grid);

        // 4. used 배열 생성
        boolean[] used = new boolean[wordList.length];

        // 5. 백트래킹 수행
        solve(grid, slots, wordList, used, 0);

        // 6. char[][] -> List<String> 변환 후 반환
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(new String(grid[i]));
        }
        return result;
    }

    // === 아래에 슬롯 찾기, 배치, 복원, 검증, 재귀 구현 필요 ===

    static List<Slot> findSlots(char[][] grid) {
        List<Slot> slots = new ArrayList<>();

        // 가로 슬롯 탐색
        for (int i = 0; i < 10; i++) {
            int j = 0;
            while (j < 10) {
                while (j < 10 && grid[i][j] == '+')
                    j++;
                int start = j;
                while (j < 10 && grid[i][j] == '-')
                    j++;
                if (j - start > 1) {
                    slots.add(new Slot(i, start, j - start, 'H'));
                }
            }
        }

        // 세로 슬롯 탐색
        for (int j = 0; j < 10; j++) {
            int i = 0;
            while (i < 10) {
                while (i < 10 && grid[i][j] == '+') i++;
                int start = i;
                while (i < 10 && grid[i][j] == '-') i++;
                if (i - start > 1) {
                    slots.add(new Slot(start, j, i - start, 'V'));
                }
            }
        }

        return slots;
    }

    static boolean canPlace(char[][] grid, Slot s, String word) {
        for (int i = 0; i < s.len; i++) {
            int r = s.row + (s.dir == 'V' ? i : 0);
            int c = s.col + (s.dir == 'H' ? i : 0);
            char g = grid[r][c];
            if (g != '-' && g != word.charAt(i)) return false;
        }
        return true;
    }

    static char[] placeWord(char[][] grid, Slot s, String word) {
        char[] original = new char[s.len];
        for (int i = 0; i < s.len; i++) {
            int r = s.row + (s.dir == 'V' ? i : 0);
            int c = s.col + (s.dir == 'H' ? i : 0);
            original[i] = grid[r][c];
            grid[r][c] = word.charAt(i);
        }
        return original;
    }

    static void restore(char[][] grid, Slot s, char[] original) {
        for (int i = 0; i < s.len; i++) {
            int r = s.row + (s.dir == 'V' ? i : 0);
            int c = s.col + (s.dir == 'H' ? i : 0);
            grid[r][c] = original[i];
        }
    }

    static boolean solve(char[][] grid, List<Slot> slots, String[] words, boolean[] used, int index) {
        if (index == slots.size()) return true;

        Slot s = slots.get(index);

        for (int i = 0; i < words.length; i++) {
            if (used[i] || words[i].length() != s.len) continue;

            if (canPlace(grid, s, words[i])) {
                char[] backup = placeWord(grid, s, words[i]);
                used[i] = true;

                if (solve(grid, slots, words, used, index + 1))
                    return true;

                restore(grid, s, backup);
                used[i] = false;
            }
        }

        return false;
    }
}


public class CrosswordPuzzle {
    public static void main(String[] args) {

    }
}
