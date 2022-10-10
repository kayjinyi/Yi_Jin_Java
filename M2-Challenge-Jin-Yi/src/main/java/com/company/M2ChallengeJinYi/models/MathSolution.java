package com.company.M2ChallengeJinYi.models;

public class MathSolution {
    private int operand1;
    private int operand2;
    private String operations;
//    operation (one of add, subtract, multiply, and divide)
    //could use enum
    private int answer;

    public MathSolution() {
    }

    public MathSolution(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public int add() {
        return answer = operand1 + operand2;
    }


    public int subtract() {
        return answer = operand1 - operand2;
    }


    public int multiply() {
        return answer = operand1 * operand2;
    }


    public int divide() {
        return answer = operand1 / operand2;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
