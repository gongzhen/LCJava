package com.leetcode.AMAZONOA;

import java.util.List;

/*
*Amazon's distribution network consists of fulfillment centers located in N cities. Some of the cities are directly connected to each other by bidirectional roads. To prepare for the holiday season and satisfy customer demands, items will have to be moved between cities on regularly-scheduled delivery routes. A delivery route is the path that connects the two cities either directly or via some other cities. Amazon-already has delivery routes between some of the cities, but needs to augment this set of routes with additional ones to connect them all. Before any new routes can be developed, new roads need to be constructed such that all cities are accessible from each other. Amazon will be assisting in the planning and construction of the new roads. Write an algorithm to calculate the minimum cost to add new roads between the cities such that all the cities are accessible from each other.

Input

The input to the function/method consists of five arguments:

nurnTotalAvailableCities, an integer representing the total number of cities (N) (e.g., if N = 3, the cities are represented as 1, 2, 3);

numTotalAvailableRoads, an integer representing the total number of currently available roads;

roadsAvailable, a list where each element consists of an integer pair representing the cities directly connected by a road,

numNewRoadsConstruct, an integer representing the total number of roads that can be added;

costNewRoadsConstruct, a list where each element consists of an integer triplet representing the pair of cities between which the road can be added and the cost of addition of the road, respectively (es  [1, 3, 10] means to construct a road between cities 1 and 3, the cost would be 10)


Output

Return an integer representing the minimum cost incurred to add new roads such that all the cities are accessible from each other. If there is no solution, return -1





ConItrains

0 <= nurnTotatAvaliableCities <= 50 (ie., total available cities is between 0 and 50)

1 <= costatewRoadsConstruct[i][2]<= 1000 (i.e. the cost to construct any new road is between 1 and 1000)

0 <= i < nurnNewRoadsConstruct

Example

Input:

numTotalAvailableCities = 6

numTotalAvailableRoads = 3

roadsAvallable = [[1,4], [4,5], [2,3]]

numNewRoadsConstruct = 4

costNowPoadsConstruct = [ [1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5] ]

Output

7

Explaination:

There are three networks: [1,4,5], [2,3] and [6].

We can connect these networks into a single network by connecting the city 1 to city 2 and city 1 to city 6 at a minimum cost of 5+2

So, the output is 7

思路

这是个最小生成树（MST）问题。但要注意整个图中已经有一些边了，不是从0开始的最小生成树。具体来说，可以先Union-Find所有已经有的路 in roadsAvailable list，然后把所有可以建的路 in costNewRoadsConstruct list 按照 cost 排序放入 min-heap。然后每次从 min-heap 中拿出最小 cost 的路来接着 Union-Find整个图。每次需要Union的时候，累积目前为止的 cost。当总的 edges 数目等于总的 vertices 数目减 1 时，整个图就被构建成了一颗树。这时输入累积的cost作为输出。

注意：
这个题不太容易过所有的 test case （目前有19个test cases），因为有些坑需要避免。
1. 城市的ID是从1开始，不是从0开始。所以UnionFind的时候要多注意。
2. 输入的roadsAvailable list 和 costNewRoadsConstruct list 互相之间可能有重复。所以不要在算Graph中的 edges 数目的时候要格外注意。

*
*/
public class MINCOSTTOCONSTRUCT {


}
