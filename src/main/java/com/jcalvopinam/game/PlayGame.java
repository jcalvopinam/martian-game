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

package com.jcalvopinam.game;

import com.jcalvopinam.game.service.*;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by juanca on 8/15/17.
 */
public class PlayGame {

    private static final String titleGame = "\n   _____                 __  .__                         ________                       \n" +
                                            "  /     \\ _____ ________/  |_|__|____    ____   ______  /  _____/_____    _____   ____  \n" +
                                            " /  \\ /  \\\\__  \\\\_  __ \\   __\\  \\__  \\  /    \\ /  ___/ /   \\  ___\\__  \\  /     \\_/ __ \\ \n" +
                                            "/    Y    \\/ __ \\|  | \\/|  | |  |/ __ \\|   |  \\\\___ \\  \\    \\_\\  \\/ __ \\|  Y Y  \\  ___/ \n" +
                                            "\\____|__  (____  /__|   |__| |__(____  /___|  /____  >  \\______  (____  /__|_|  /\\___  >\n" +
                                            "        \\/     \\/                    \\/     \\/     \\/          \\/     \\/      \\/     \\/ ";

    public static void main(String[] args) {

        buildTitle(titleGame + "\n\n(to exit press 0)\n\n", 6);

        MartianSingleton martian = MartianSingleton.getInstance();
        PlayerService playerService = new PlayerServiceImpl();
        ComputerService computer = new ComputerServiceImpl();
        Scanner sc = new Scanner(System.in);

        int shots;
        int survivors;
        boolean isFirstTime = true;

        do {
            survivors = martian.getSurvivorsMartian(isFirstTime);

            if (survivors > 0) {
                System.out.print("\n\nEnter the number of shots: ");
                shots = sc.nextInt();
                killMartians(playerService, shots);
                computer.createMartian();
            } else {
                System.out.println(String.format("You have won the game !"));
                shots = 0;
            }
            isFirstTime = false;
        } while (shots != 0);

    }

    private static void killMartians(PlayerService playerService, int shots) {
        for (int i = 0; i < shots; i++) {
            playerService.killMartians();
        }
        System.out.println(String.format("\n\tYou killed %d Martian ;)", shots));
    }

    private static void buildTitle(String message, int numLines) {
        IntStream.range(0, (message.length() / numLines)).mapToObj(lower -> "_").forEach(System.out::print);
        System.out.println(message);
        IntStream.range(0, message.length() / numLines).mapToObj(upper -> "¯").forEach(System.out::print);
    }

}