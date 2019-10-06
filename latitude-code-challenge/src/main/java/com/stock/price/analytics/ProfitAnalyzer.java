package com.stock.price.analytics;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static java.util.Objects.nonNull;

public class ProfitAnalyzer {


    /**
     * Returns the maximum profit that would have been obtained by trading stock prices yesterday
     * This doesn't indicate losses in case shares keep dropping - but would say the profit is zero.
     *
     * @param stockPricesYesterday Yesterdays's stock prices (Indices relate to time in minutes)
     * @return maximum profit
     */
    public double getMaxProfit(double[] stockPricesYesterday) {
        double profit = 0.0;
        if(nonNull(stockPricesYesterday) && stockPricesYesterday.length > 0) {
            List<Double> stockPrices = DoubleStream.of(stockPricesYesterday).boxed().collect(Collectors.toList());

            // minimum stock price of the list excluding the last element or first element if the list size is 1
            Double minStockPrice = getMinimum(stockPrices.subList(0, stockPrices.size() - 1)).orElse(stockPrices.get(0));
            int splitIndex = stockPrices.indexOf(minStockPrice);
            // maximum that occurs after the minimum stock price
            Double maxStockPriceAfterMinimum = getMaximum(stockPrices.subList(splitIndex, stockPrices.size())).orElse(stockPrices.get(0));

            double profit1 = maxStockPriceAfterMinimum - minStockPrice;

            // maximum stock price of the list excluding the first element or first element if the list size is 1
            Double maxStockPrice = getMaximum(stockPrices.subList(1, stockPrices.size())).orElse(stockPrices.get(0));
            splitIndex = stockPrices.indexOf(maxStockPrice);
            // minimum that occurs after the maximum stock price
            Double minStockPriceBeforeMaximum = getMinimum(stockPrices.subList(0, splitIndex + 1)).orElse(stockPrices.get(0));

            double profit2 = maxStockPrice - minStockPriceBeforeMaximum;

            profit = (profit1 > profit2)? profit1 : profit2;
        }
        return profit;
    }

    /**
     * Gets the optional minimum of the list
     *
     * @param list
     * @return optional minimum of the given list
     */
    private Optional<Double> getMinimum(List<Double> list) {
        return list
                .stream()
                .min(Comparator.comparingDouble(Double::doubleValue));
    }

    /**
     * Gets the optional maximum of the list
     *
     * @param list
     * @return optional maximum of the given list
     */
    private Optional<Double> getMaximum(List<Double> list) {
        return list
                .stream()
                .max(Comparator.comparingDouble(Double::doubleValue));
    }
}
