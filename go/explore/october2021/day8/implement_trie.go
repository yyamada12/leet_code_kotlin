package main

func main() {

	obj := Constructor()
	obj.Insert("app")
	obj.Insert("apple")
	obj.Insert("beer")
	obj.Insert("add")
	obj.Insert("jam")
	println(obj.Search("apps"))
	println(obj.Search("app"))

}

type Trie struct {
	m map[byte]Trie
}

func Constructor() Trie {
	m := map[byte]Trie{}
	return Trie{m}
}

func (this *Trie) Insert(word string) {
	if len(word) == 0 {
		_, ok := this.m['\x00']
		if !ok {
			this.m['\x00'] = Constructor()
		}
	} else {
		next, ok := this.m[word[0]]
		if !ok {
			next = Constructor()
			this.m[word[0]] = next
		}
		next.Insert(word[1:])
	}
}

func (this *Trie) Search(word string) bool {
	if len(word) == 0 {
		_, ok := this.m['\x00']
		return ok
	} else {
		next, ok := this.m[word[0]]
		return ok && next.Search(word[1:])
	}
}

func (this *Trie) StartsWith(prefix string) bool {
	if len(prefix) == 0 {
		return true
	} else {
		next, ok := this.m[prefix[0]]
		return ok && next.StartsWith(prefix[1:])
	}
}
