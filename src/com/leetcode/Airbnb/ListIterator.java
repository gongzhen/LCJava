package com.leetcode.Airbnb;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Two D List of Iterator
// https://medium.com/@harycane/peeking-iterator-ef69ce9ef788
// https://rextester.com/SWJH94490
public class ListIterator {

    private static class MyIterator implements Iterator<Integer> {

        private Iterator<List<Integer>> itrOfList;
        private Iterator<Integer> nextItr;

        public MyIterator(List<List<Integer>> listOfList) {
            this.itrOfList = listOfList.iterator();
            this.nextItr = this.itrOfList.next().iterator();
        }

        @Override
        public boolean hasNext() {
            if (nextItr == null) {
                nextItr = itrOfList.next().iterator();
                return nextItr.hasNext();
            } else {
                return nextItr.hasNext();
            }
        }

        @Override
        public Integer next() {
            if (hasNext() == false) {
                this.nextItr = this.itrOfList.next().iterator();
                return null;
            }
            return nextItr.next();
        }

        @Override
        public void remove() {
            if (nextItr != null && nextItr.hasNext()) {
                nextItr.next();
                nextItr.remove();
            }
        }
    }

    public static void main(String[] args) {
        //  [[99], [1,2,3],[4,5],[],[],[],[7],[8],[9],[10],[]]
        List<Integer> empty = new ArrayList<>();
        List<Integer> empty1 = new ArrayList<>();
        List<Integer> empty11 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5));
        List<Integer> empty2 = new ArrayList<>();
        List<List<Integer>> listOfList = new ArrayList<>();
        listOfList.add(empty);
        listOfList.add(empty1);
        listOfList.add(empty11);
        listOfList.add(list1);
        listOfList.add(list2);
        listOfList.add(empty2);
        MyIterator myIterator = new MyIterator(listOfList);
        PrintUtils.printString("hasNext: " + myIterator.hasNext());
        myIterator.remove();
        if (myIterator.hasNext() == true) {
            myIterator.remove();
        } else {
            myIterator.next();
        }
        PrintUtils.printString("next: " + myIterator.next());
        PrintUtils.printString("hasNext: " + myIterator.hasNext());
        PrintUtils.printString("next: " + myIterator.next());
        PrintUtils.printString("hasNext: " + myIterator.hasNext());
        PrintUtils.printString("next: " + myIterator.next());
        PrintUtils.printString("hasNext: " + myIterator.hasNext());
        PrintUtils.printString("next: " + myIterator.next());
        PrintUtils.printString("hasNext: " + myIterator.hasNext());
        PrintUtils.printString("next: " + myIterator.next());
        PrintUtils.printString("hasNext: " + myIterator.hasNext());
        PrintUtils.printString("next: " + myIterator.next());
        PrintUtils.printString("hasNext: " + myIterator.hasNext());
        PrintUtils.printString("next: " + myIterator.next());
    }
}
