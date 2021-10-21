package main

import (
	"math/rand"
	"time"
)

type RandomizedSet struct {
	s    map[int]struct{}
	keys []int
}

func Constructor() RandomizedSet {
	rand.Seed(time.Now().UnixNano())
	return RandomizedSet{map[int]struct{}{}, []int{}}
}

func (this *RandomizedSet) Insert(val int) bool {
	_, ok := this.s[val]
	if ok {
		return false
	}
	this.s[val] = struct{}{}
	this.keys = append(this.keys, val)
	return true
}

func (this *RandomizedSet) Remove(val int) bool {
	_, ok := this.s[val]
	if ok {
		delete(this.s, val)
		return true
	}
	return false
}

func (this *RandomizedSet) GetRandom() int {
	for {
		rnd := rand.Intn(len(this.keys))
		v := this.keys[rnd]
		if _, ok := this.s[v]; ok {
			return v
		} else {
			this.keys = append(this.keys[:rnd], this.keys[rnd+1:]...)
		}
	}
}
