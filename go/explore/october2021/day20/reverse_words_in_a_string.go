package main

import "strings"

func main() {
	println(reverseWords("the sky is blue"))
	println(reverseWords("  hello world  "))
	println(reverseWords("a good   example"))
	println(reverseWords("  Bob    Loves  Alice   "))
	println(reverseWords("Alice does not even like bob"))
}

func reverseWords(s string) string {
	st := -1
	words := []string{}
	for i, c := range s {
		if c == ' ' {
			if st != -1 {
				words = append(words, s[st:i])
				st = -1
			}
		} else {
			if st == -1 {
				st = i
			}
		}
	}
	if st != -1 {
		words = append(words, s[st:])
	}

	for i, j := 0, len(words)-1; i < j; i, j = i+1, j-1 {
		words[i], words[j] = words[j], words[i]
	}

	return strings.Join(words, " ")
}
