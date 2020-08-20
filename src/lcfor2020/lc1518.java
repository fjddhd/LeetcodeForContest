package lcfor2020;

public class lc1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int nbNew=numBottles/numExchange;
        int emp=numBottles%numExchange;
        return numBottles+nbNew+exc(nbNew+emp,numExchange);
    }
    public int exc(int empty, int numExchange) {
        int nbNew=(empty)/numExchange;
        int emp=(empty)%numExchange;
        if (nbNew+emp>=numExchange)
            return nbNew+exc(nbNew+emp,numExchange);
        else
            return nbNew;
    }
}
