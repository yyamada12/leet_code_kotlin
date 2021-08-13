package main

import "sort"

func groupAnagrams(strs []string) [][]string {
	m := map[string][]string{}
	for _, str := range strs {
		add(m, sorted(str), str)
	}
	res := [][]string{}
	for _, list := range m {
		res = append(res, list)
	}
	return res
}

func add(m map[string][]string, key string, val string) map[string][]string {
	list, ok := m[key]
	if ok {
		list = append(list, val)
	} else {
		list = []string{val}
	}
	m[key] = list
	return m
}

type RuneSlice []rune

func (p RuneSlice) Len() int           { return len(p) }
func (p RuneSlice) Less(i, j int) bool { return p[i] < p[j] }
func (p RuneSlice) Swap(i, j int)      { p[i], p[j] = p[j], p[i] }

func sorted(s string) string {
	runes := []rune(s)
	sort.Sort(RuneSlice(runes))
	return string(runes)
}
