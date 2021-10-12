package main

func main() {
	pick = 6
	println(guessNumber(10))
}

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * func guess(num int) int;
 */

var pick int

func guess(num int) int {
	if pick < num {
		return -1
	} else if pick > num {
		return 1
	} else {
		return 0
	}
}

func guessNumber(n int) int {
	l := 0
	r := n + 1
	for {
		m := (l + r) / 2
		switch guess(m) {
		case 0:
			return m
		case 1:
			l = m
		case -1:
			r = m
		}
	}
}
