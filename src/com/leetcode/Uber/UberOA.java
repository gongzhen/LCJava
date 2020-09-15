package com.leetcode.Uber;

public class UberOA {

    /**
     *
     * buyAndSellStock
     * (
     * 0:34:49
     * )
     * Codewriting
     *
     * You are given the prices of a stock, in the form of an array of integers, prices. Let's say that prices[i] is the price of the stock on the ith day (0-based index). Assuming that you are allowed to buy and sell the stock only once, your task is to find the maximum possible profit (the difference between the buy and sell prices).
     *
     * Note: You can assume there are no fees associated with buying or selling the stock.
     *
     * Example
     *
     * For prices = [6, 3, 1, 2, 5, 4], the output should be buyAndSellStock(prices) = 4.
     *
     * It would be most profitable to buy the stock on day 2 and sell it on day 4. Thus, the maximum profit is prices[4] - prices[2] = 5 - 1 = 4.
     *
     * For prices = [8, 5, 3, 1], the output should be buyAndSellStock(prices) = 0.
     *
     * Since the value of the stock drops each day, there's no way to make a profit from selling it. Hence, the maximum profit is 0.
     *
     * For prices = [3, 100, 1, 97], the output should be buyAndSellStock(prices) = 97.
     *
     * It would be most profitable to buy the stock on day 0 and sell it on day 1. Thus, the maximum profit is prices[1] - prices[0] = 100 - 3 = 97.
     *
     * Input/Output
     *
     * [execution time limit] 3 seconds (java)
     *
     * [input] array.integer prices
     *
     * Guaranteed constraints:
     * 1 ≤ prices.length ≤ 105,
     * 1 ≤ prices[i] ≤ 106.
     *
     * [output] integer
     *
     * The maximum possible profit.
     * [Java] Syntax Tips
     *
     * // Prints help message to the console
     * // Returns a string
     * //
     * // Globals declared here will cause a compilation error,
     * // declare variables inside the function instead!
     * String helloWorld(String name) {
     *     System.out.println("This prints to the console when you Run Tests");
     *     return "Hello, " + name;
     * }
     *
     * main.java
     *
     * Java
     * Dark
     * Sublime
     * int buyAndSellStock(int[] prices) {
     * ​
     * }
     * ​
     * TESTS
     * CUSTOM TESTS
     * Test 1
     * Input:
     * prices: [6, 3, 1, 2, 5, 4]
     * Expected Output:
     * 4
     * Click the "Run Tests" button to see output and console logs.
     * Test 2
     * Test 3
     * Test 4
     * Test 5
     * Test 6
     * Test 7
     * Test 8
     * Test 9
     * Test 10
     * Test 11
     * Test 12
     * Test 13
     * Formatting
     * Editor Mode
     * Sublime
     * Theme
     * Dark
     * Tab Size
     * Auto
     * Font Size
     * 14px
     * Code Completion
     * Auto-brackets
     * Hotkeys
     * CTRL + Enter
     * Submit
     * CTRL + R
     * Run
     * CTRL + S
     * Save
     * 0/300
     *
     *
     *
     * surveyQuestion
     * (
     * 0:31:17
     * )
     * Bugfix
     *
     * There is a bug in one line of the code. Find it, fix it, and submit.
     * This code doesn't compile, your task is to add only ONE symbol and make it compilable.
     *
     * Input/Output
     *
     * [execution time limit] 20 seconds (swift)
     *
     * [output] string
     *
     * String of the survey "Do you like cheese?"
     * [Swift4] Syntax Tips
     *
     * // Prints help message to the console
     * // Returns a string
     * func helloWorld(name: String) -> String {
     *     print("This prints to the console when you Run Tests");
     *     return "Hello, " + name;
     * }
     *
     * main.swift
     *
     * Swift4
     * Dark
     * Sublime
     * import Foundation
     * ​
     * class SurveyQuestion {
     *     let text: String
     *     var response: String
     * ​
     *     init(text: String) {
     *           self.text = text
     *     }
     * ​
     *     func ask() -> String {
     *         return text
     *     }
     * }
     * ​
     * func surveyQuestion() -> String {
     *     let cheeseQuestion = SurveyQuestion(text: "Do you like cheese?")
     *     return cheeseQuestion.ask()
     * }
     * ​
     * TESTS
     * CUSTOM TESTS
     * Test 1
     * Input:
     * Expected Output:
     * "Do you like cheese?"
     * Click the "Run Tests" button to see output and console logs.
     * Formatting
     * Editor Mode
     * Sublime
     * Theme
     * Dark
     * Tab Size
     * Auto
     * Font Size
     * 14px
     * Code Completion
     * Auto-brackets
     * Hotkeys
     * CTRL + Enter
     * Submit
     * CTRL + R
     * Run
     * CTRL + S
     * Save
     * 0/150
     *
     * capitalOfFrance
     * (
     * 0:29:21
     * )
     * Recovery
     *
     * Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
     * Add missing code in a way that the function will return "Paris".
     *
     * Input/Output
     *
     * [execution time limit] 20 seconds (swift)
     *
     * [output] string
     *
     * String "Paris"
     * [Swift4] Syntax Tips
     *
     * // Prints help message to the console
     * // Returns a string
     * func helloWorld(name: String) -> String {
     *     print("This prints to the console when you Run Tests");
     *     return "Hello, " + name;
     * }
     *
     * main.swift
     *
     * Swift4
     * Dark
     * Sublime
     * func capitalOfFrance() -> String {
     *     let city = "London"
     * ​
     *     ... city != "London" else {
     *         return "Paris"
     *     }
     *     return city
     * }
     * ​
     * ​
     * TESTS
     * CUSTOM TESTS
     * Test 1
     * Input:
     * Expected Output:
     * "Paris"
     * Click the "Run Tests" button to see output and console logs.
     * Formatting
     * Editor Mode
     * Sublime
     * Theme
     * Dark
     * Tab Size
     * Auto
     * Font Size
     * 14px
     * Code Completion
     * Auto-brackets
     * Hotkeys
     * CTRL + Enter
     * Submit
     * CTRL + R
     * Run
     * CTRL + S
     * Save
     * 0/150
     *
     *
     * handlerDeinitialization
     * (
     * 0:24:22
     * )
     * Bugfix
     *
     * There is a bug in one line of the code. Find it, fix it, and submit.
     * In the given code deinit is not being called and as a result, the variable answer has the value Hello, World!. Your task is to change one line in a way that deinit will be called, and the variable answer will have the value Hello, World! Handler is being deinitialized.
     *
     * Input/Output
     *
     * [execution time limit] 20 seconds (swift)
     *
     * [output] string
     *
     * It should be the string Hello, World! Handler is being deinitialized..
     * [Swift4] Syntax Tips
     *
     * // Prints help message to the console
     * // Returns a string
     * func helloWorld(name: String) -> String {
     *     print("This prints to the console when you Run Tests");
     *     return "Hello, " + name;
     * }
     *
     * main.swift
     *
     * Swift4
     * Dark
     * Sublime
     * class MyClass {
     *     func greeting() {
     *         answer += "Hello, World!"
     *     }
     * }
     * ​
     * class Handler {
     *     var closure: (() -> Void)?
     *     let obj = MyClass()
     * ​
     *     func setupClosure() {
     *         closure = {
     *             self.obj.greeting()
     *         }
     *     }
     * ​
     *     deinit {
     *         answer += " Handler is being deinitialized."
     *     }
     * }
     * ​
     * var answer: String = ""
     * func handlerDeinitialization() -> String {
     *     var handler: Handler? = Handler()
     *     handler!.setupClosure()
     *     handler!.closure!()
     *     handler = nil
     *     return answer
     * }
     * ​
     * TESTS
     * CUSTOM TESTS
     * Test 1
     * Input:
     * Expected Output:
     * "Hello, World! Handler is being deinitialized."
     * Click the "Run Tests" button to see output and console logs.
     * Formatting
     * Editor Mode
     * Sublime
     * Theme
     * Dark
     * Tab Size
     * Auto
     * Font Size
     * 14px
     * Code Completion
     * Auto-brackets
     * Hotkeys
     * CTRL + Enter
     * Submit
     * CTRL + R
     * Run
     * CTRL + S
     * Save
     * 0/150
     *
     * class MyClass {
     *     func greeting() {
     *         answer += "Hello, World!"
     *     }
     * }
     *
     * class Handler {
     *     var closure: (() -> Void)?
     *     let obj = MyClass()
     *
     *     func setupClosure() {
     *         closure = {
     *             self.obj.greeting()
     *         }
     *     }
     *
     *     deinit {
     *         answer += " Handler is being deinitialized."
     *     }
     * }
     *
     * var answer: String = ""
     * func handlerDeinitialization() -> String {
     *     var handler: Handler? = Handler()
     *     handler!.setupClosure()
     *     handler!.closure!()
     *     handler = nil
     *     return answer
     * }
     *
     * */
    public static void main(String[] args) {

    }
}
