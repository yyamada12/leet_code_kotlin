package main

type MapSum struct {
	m  map[string]int
	sm map[string]int
}

/** Initialize your data structure here. */
func Constructor() MapSum {
	m := map[string]int{}
	sm := map[string]int{}
	return MapSum{m, sm}
}

func (this *MapSum) Insert(key string, val int) {
	oldVal, ok := this.m[key]
	if ok {
		for i := 1; i <= len(key); i++ {
			this.sm[key[0:i]] += val - oldVal
		}
	} else {
		for i := 1; i <= len(key); i++ {
			this.sm[key[0:i]] += val
		}
	}
	this.m[key] = val
}

func (this *MapSum) Sum(prefix string) int {
	return this.sm[prefix]
}
