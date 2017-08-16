/*
 * MIT License
 *
 * Copyright (c) 2017 JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.jcalvopinam.game.service;

import java.util.Random;

/**
 * Created by juanca on 8/15/17.
 */
public final class MartianSingleton {

    private static int totalMartians = 0;
    private static Random rand = new Random();

    private MartianSingleton() {
        totalMartians = rand.nextInt((15 - 5) + 1) + 5;
        System.out.println(String.format("\nWe have found %d Martian, kill them!\n", totalMartians));
    }

    public static MartianSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    static void killMartian() {
        if (totalMartians > 0) {
            totalMartians -= 1;
            System.out.print("\t*");
        }
    }

    static void createMartian() {
        if (totalMartians > 0) {
            int newMartians = rand.nextInt((5 - 1) + 1) + 5;
            totalMartians += newMartians;
            System.out.print(String.format("\nThe computer has created %d Martian XD, now ", newMartians));
        }
    }

    public static int getSurvivorsMartian(boolean isFirstTime) {
        if (totalMartians > 0 && !isFirstTime) {
            System.out.println(String.format("there are %d living Martians", totalMartians));
        }
        return totalMartians;
    }

    private static class SingletonHelper {
        private static final MartianSingleton INSTANCE = new MartianSingleton();
    }

}
