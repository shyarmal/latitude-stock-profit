package com.stock.price.analytics;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProfitAnalyzerTest {


    private ProfitAnalyzer profitAnalyzer = new ProfitAnalyzer();

    @Test
    public void shouldCalculateHighestProfit() {
        assertEquals(6.0, profitAnalyzer.getMaxProfit(new double[]{10, 7, 5, 8, 11, 9}), 0.00000001);
        assertEquals(13.0, profitAnalyzer.getMaxProfit(new double[]{1, 8, 5, 3, 14, 11}), 0.00000001);
        assertEquals(7.3, profitAnalyzer.getMaxProfit(new double[]{12.4, 7.3, 2.5, 4.8, 6.6, 9.8, 2}), 0.00000001);
        assertEquals(5.3, profitAnalyzer.getMaxProfit(new double[]{4.4, 3.2, 8.5, 2.4, 2.1, 3.8}), 0.00000001);
        assertEquals(4.1, profitAnalyzer.getMaxProfit(new double[]{11.4, 5.3, 7.4, 9.4, 2.1, 3.5}), 0.00000001);
        assertEquals(10, profitAnalyzer.getMaxProfit(new double[]{1, 6, 11, 9}), 0.00000001);
        assertEquals(9, profitAnalyzer.getMaxProfit(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 0.00000001);
        assertEquals(0, profitAnalyzer.getMaxProfit(new double[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}), 0.00000001);

    }

    @Test
    public void shouldBeZeroForNullOrEmptyOrSingle() {
        assertEquals(0, profitAnalyzer.getMaxProfit(null), 0.00000001);
        assertEquals(0, profitAnalyzer.getMaxProfit(new double[]{}), 0.00000001);
        assertEquals(0, profitAnalyzer.getMaxProfit(new double[]{1}), 0.00000001);
        assertEquals(0, profitAnalyzer.getMaxProfit(new double[]{1.0}), 0.00000001);
    }
}
