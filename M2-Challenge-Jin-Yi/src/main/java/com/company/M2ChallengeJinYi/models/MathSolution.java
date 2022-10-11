package com.company.M2ChallengeJinYi.models;

import java.util.Objects;

public class MathSolution {
    private Integer operand1;
    private Integer operand2;
    private String operations;
//    operation (one of add, subtract, multiply, and divide)
    //could use enum
    private Integer answer;

    public MathSolution() {
    }

    public MathSolution(Integer operand1, Integer operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public Integer add() {
        return answer = operand1 + operand2;
    }


    public Integer subtract() {
        return answer = operand1 - operand2;
    }


    public Integer multiply() {
        return answer = operand1 * operand2;
    }


    public Integer divide() {
        return answer = operand1 / operand2;
    }

    public Integer getOperand1() {
        return operand1;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operations='" + operations + '\'' +
                ", answer=" + answer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathSolution that = (MathSolution) o;
        return Objects.equals(operand1, that.operand1) && Objects.equals(operand2, that.operand2) && Objects.equals(operations, that.operations) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operations, answer);
    }
}
