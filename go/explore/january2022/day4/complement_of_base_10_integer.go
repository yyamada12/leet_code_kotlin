package main

func bitwiseComplement(n int) int {
	if n == 0 {
		return 1
	}
	res := 0
	n_ := 1
	for n_ < n {
		if n&n_ == 0 {
			res += n_
		}
		n_ <<= 1
	}
	return res
}
