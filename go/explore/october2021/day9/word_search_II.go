package main

import "fmt"

func main() {
	fmt.Println(
		findWords(
			[][]byte{
				{'o', 'a', 'a', 'n'},
				{'e', 't', 'a', 'e'},
				{'i', 'h', 'k', 'r'},
				{'i', 'f', 'l', 'v'},
			},
			[]string{"oath", "pea", "eat", "rain"},
		),
	)
	fmt.Println(
		findWords(
			[][]byte{
				{'a'},
			},
			[]string{"a"},
		),
	)
}

var used [][]bool
var board_ [][]byte
var m, n int
var trie Trie

func findWords(board [][]byte, words []string) []string {
	m = len(board)
	n = len(board[0])
	used = make([][]bool, m)
	for i := 0; i < m; i++ {
		used[i] = make([]bool, n)
	}
	board_ = board
	trie = Constructor()
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			dfs(0, i, j, "")
		}
	}

	res := []string{}
	for _, word := range words {
		if trie.Contains(word) {
			res = append(res, word)
		}
	}
	return res
}

func dfs(i int, r int, c int, str string) bool {
	if r < 0 || r >= m || c < 0 || c >= n || used[r][c] {
		return true
	}
	nstr := str + string(board_[r][c])
	if len(nstr) == 10 {
		trie.Insert(nstr)
		return true
	}
	used[r][c] = true
	if dfs(i+1, r+1, c, nstr) &&
		dfs(i+1, r, c+1, nstr) &&
		dfs(i+1, r-1, c, nstr) &&
		dfs(i+1, r, c-1, nstr) {
		trie.Insert(nstr)
	}

	used[r][c] = false
	return true
}

type Trie struct {
	c [26]*Trie
}

func Constructor() Trie {
	c := [26]*Trie{}
	return Trie{c}
}

func (this *Trie) Insert(word string) {
	if len(word) == 0 {
		return
	}
	next := this.c[word[0]-'a']
	if next == nil {
		t := Constructor()
		this.c[word[0]-'a'] = &t
		next = &t
	}
	next.Insert(word[1:])
}

func (this *Trie) Contains(prefix string) bool {
	if len(prefix) == 0 {
		return true
	} else {
		next := this.c[prefix[0]-'a']
		return next != nil && next.Contains(prefix[1:])
	}
}
