package com.epam.service;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class NumbersGenerator {

	public Set<Integer> createRandomNumbers() {
		Set<Integer> randomNumbers = new TreeSet<Integer>();
		Random rand = new Random();

		do {
			int n = rand.nextInt(32);
			n++;
			randomNumbers.add(n);
		} while (randomNumbers.size() < 20);
		
		return randomNumbers;
	}
//	public static void main(String[] args) {
//		System.out.println(new NumbersGenerator().createRandomNumbers());
//	}
}
