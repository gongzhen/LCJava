package com.leetcode.Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    private List<Integer> list;
    private static int count = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<Integer>();
        dfs(nestedList);
    }

    private void dfs(List<NestedInteger> nestedList) {
        for(NestedInteger nested : nestedList) {
            if(nested.isInteger()) {
                Integer nestedInt = nested.getInteger();
                this.list.add(nestedInt);
            } else {
                dfs(nested.getList());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}

public class LC341 {

    public static void main(String[] args) {

    }
}
