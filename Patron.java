package com.ejemplo.biblioteca;

public class Patron {

    private int cardNum;
    private String name;
    private int memberYear;
    private double totalFine;

    public Patron() {
    }

    public Patron(int cardNum, String name, int memberYear, double totalFine) {
        this.cardNum = cardNum;
        this.name = name;
        this.memberYear = memberYear;
        this.totalFine = totalFine;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberYear() {
        return memberYear;
    }

    public void setMemberYear(int memberYear) {
        this.memberYear = memberYear;
    }

    public double getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(double totalFine) {
        this.totalFine = totalFine;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "cardNum=" + cardNum +
                ", name='" + name + '\'' +
                ", memberYear=" + memberYear +
                ", totalFine=" + totalFine +
                '}';
    }
}
