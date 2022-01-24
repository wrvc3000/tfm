/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfm.probability;

import java.util.Random;

/**
 *
 * @author casa
 *
 * ref:
 * http://www.javamex.com/tutorials/random_numbers/gaussian_distribution_2.shtml
 */
public class NormalDistribution implements ProbDistribution{

    private double mean;
    private double deviation;
    private Random random;

    public NormalDistribution(double mean, double deviation) {
        this.mean = mean;
        this.deviation = deviation;
        random = new Random();
    }

    @Override
    public double getNext() {
        return Math.abs((random.nextGaussian() * deviation) + mean);
    }

}
