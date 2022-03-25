package com.mycompany.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SquaringService {

    public List<Integer> squaring(final List<Integer> sortedList) {
        if (Objects.isNull(sortedList)) return Collections.emptyList();

        int listSize = sortedList.size();
        int rightIndex = getDividedIndex(sortedList);
        int leftIndex = rightIndex - 1;

        List<Integer> result = new ArrayList<>(listSize);
        while (leftIndex >= 0 && rightIndex < listSize) {
            int leftSquare = square(sortedList, leftIndex);
            int rightSquare = square(sortedList, rightIndex);
            int value;
            if (rightSquare < leftSquare) {
                value = rightSquare;
                rightIndex++;
            } else {
                value = leftSquare;
                leftIndex--;
            }
            result.add(value);
        }

        while (leftIndex >= 0) {
            int value = square(sortedList, leftIndex--);
            result.add(value);
        }

        while (rightIndex < listSize) {
            int value = square(sortedList, rightIndex++);
            result.add(value);
        }

        return result;
    }

    private int square(List<Integer> sortedList, int index) {
        return sortedList.get(index) * sortedList.get(index);
    }

    private int getDividedIndex(final List<Integer> sortedList) {
        int listSize = sortedList.size();
        for(int i = 0,j = listSize - 1; i < listSize && j >= 0; i++, j--) {
            if (sortedList.get(i) > 0) {
                return i;
            }
            if (sortedList.get(j) <= 0) {
                return j;
            }
        }
        return 0;
    }

}
